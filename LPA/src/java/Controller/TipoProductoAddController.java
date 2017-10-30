package Controller;

import Models.Conexion;
import Models.TipoLinea;
import Models.ValidarTipoLinea;
import Models.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class TipoProductoAddController {

    private ValidarTipoProducto validarTipoProducto;
    private JdbcTemplate jdbcTemplateUser;
    private JdbcTemplate jdbcTemplate;

    public TipoProductoAddController() {
        Conexion conn = new Conexion();
        this.validarTipoProducto = new ValidarTipoProducto();
        this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());
    }

    //@ModelAttribute("TipoLinea") TipoLinea p, BindingResult result, SessionStatus status
    //this.validarTipoProducto.validate(p, result);
    
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
    @RequestMapping(value = "TipoProductoAdd.htm", method = RequestMethod.GET)
    public ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/TipoProductoAdd");
        mav.addObject("Producto", new TipoProducto());
        return mav;
    }

    @RequestMapping(value = "TipoProductoAdd.htm", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("Producto") TipoProducto u, BindingResult result, SessionStatus status) {
        this.validarTipoProducto.validate(u, result);
        //System.out.println(u.getNombre());
        //mav.setViewName("BD/add");
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("BD/TipoProductoAdd");
            mav.addObject("Producto", u);
            return mav;
        } else {
            this.jdbcTemplateUser.update("insert into tipo_producto (tipo_producto, id_tipo_linea) values (?, ?)", u.getNombre(), Integer.parseInt(u.getId_tipo_linea()));
            return new ModelAndView("redirect:/TipoProductoHome.htm");
        }
    }
}