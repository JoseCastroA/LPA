/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.TipoLinea;
import Models.ValidarTipoLinea;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author Camilo
 */
@Controller
public class TipoLineaEditController {

    private ValidarTipoLinea validar;
    private JdbcTemplate jdbcTemplate;

    public TipoLineaEditController() {
        this.validar = new ValidarTipoLinea();
        Conexion conn = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping(value = "TipoLineaEdit.htm", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/TipoLineaEdit");
        int id = Integer.parseInt(request.getParameter("id"));
        TipoLinea u = this.selectLinea(id);
        mav.addObject("Linea", new TipoLinea(id, u.getNombre()));
        return mav;
    }
    
    @RequestMapping(value = "TipoLineaEdit.htm", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("Linea") TipoLinea u, BindingResult result, SessionStatus status, HttpServletRequest request){
        this.validar.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            int id= Integer.parseInt(request.getParameter("id"));
            TipoLinea datos = this.selectLinea(id);
            mav.setViewName("BD/TipoLineaEdit");
            mav.addObject("Linea",u);
            return mav;
        }else{
            int id = Integer.parseInt(request.getParameter("id"));
            this.jdbcTemplate.update("update tipo_linea set tipo_linea=? where id=?;",u.getNombre(),id);
            return new ModelAndView("redirect:/TipoLineaHome.htm");
        }
    }

    public TipoLinea selectLinea(int id) {
        final TipoLinea u = new TipoLinea();
        String query = "select * from tipo_linea where id='" + id + "';";
        return (TipoLinea) jdbcTemplate.query(query, new ResultSetExtractor<TipoLinea>() {
            @Override
            public TipoLinea extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    u.setNombre(rs.getString("tipo_linea"));
                }
                return u;
            }
        });
    }
}
