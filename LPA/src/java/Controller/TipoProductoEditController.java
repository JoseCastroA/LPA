/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.TipoLinea;
import Models.TipoProducto;
import Models.ValidarTipoLinea;
import Models.ValidarTipoProducto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author trisb
 */
@Controller
public class TipoProductoEditController {

    private ValidarTipoProducto validar;
    private JdbcTemplate jdbcTemplate;

    public TipoProductoEditController() {
        this.validar = new ValidarTipoProducto();
        Conexion conn = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping(value = "TipoProductoEdit.htm", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/TipoProductoEdit");
        int id = Integer.parseInt(request.getParameter("id"));
        TipoProducto u = this.selectProducto(id);
        mav.addObject("Producto", new TipoProducto(id, u.getNombre(), u.getId_tipo_linea()));
        return mav;
    }
    @ModelAttribute("id_tipo_linea")
    public Map<String, String> ListCond() {
        Map<String, String> ListCond = new LinkedHashMap<>();
        String SQL = "SELECT id,tipo_linea FROM tipo_linea;";
        List<Map<String, Object>> l;
        l = this.jdbcTemplate.queryForList(SQL);

        if ((l != null) && (l.size() > 0)) {
            for (Map<String, Object> tempRow : l) {
                ListCond.put( ""+tempRow.get("id"), ""+tempRow.get("tipo_linea"));
            }
        }
        return ListCond;
    }
    @RequestMapping(value = "TipoProductoEdit.htm", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("Producto") TipoProducto u, BindingResult result, SessionStatus status, HttpServletRequest request){
        this.validar.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            int id= Integer.parseInt(request.getParameter("id"));
            TipoProducto datos = this.selectProducto(id);
            mav.setViewName("BD/TipoProductoEdit");
            mav.addObject("Producto",u);
            return mav;
        }else{
            int id = Integer.parseInt(request.getParameter("id"));
            this.jdbcTemplate.update("update tipo_producto set tipo_producto=?, id_tipo_linea=? where id=?;",u.getNombre(), Integer.parseInt(u.getId_tipo_linea()),id);
            return new ModelAndView("redirect:/TipoProductoHome.htm");
        }
    }

    public TipoProducto selectProducto(int id) {
        final TipoProducto u = new TipoProducto();
        String query = "select * from tipo_producto where id='" + id + "';";
        return (TipoProducto) jdbcTemplate.query(query, new ResultSetExtractor<TipoProducto>() {
            @Override
            public TipoProducto extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    u.setNombre(rs.getString("tipo_producto"));
                    u.setId_tipo_linea(rs.getString("id_tipo_linea"));
                }
                return u;
            }
        });
    }
}

