/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.TipoLinea;
import Models.ValidarTipoLinea;
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
 * @author Camilo
 */
@Controller
public class TipoLineaAddController {

    private ValidarTipoLinea validarlinea;
    private JdbcTemplate jdbcTemplateUser;

    public TipoLineaAddController() {
        Conexion conn = new Conexion();
        this.validarlinea = new ValidarTipoLinea();
        this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
    }

    //@ModelAttribute("TipoLinea") TipoLinea p, BindingResult result, SessionStatus status
    //this.validarlinea.validate(p, result);
    @RequestMapping(value = "TipoLineaAdd.htm", method = RequestMethod.GET)
    public ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/TipoLineaAdd");
        mav.addObject("Linea", new TipoLinea());
        return mav;
    }
    
    @RequestMapping(value = "TipoLineaAdd.htm", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("Linea") TipoLinea u, BindingResult result, SessionStatus status) {
        this.validarlinea.validate(u, result);
        //System.out.println(u.getNombre());
        //mav.setViewName("BD/add");
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("BD/TipoLineaAdd");
            mav.addObject("Linea", u);
            return mav;
        } else {
            this.jdbcTemplateUser.update("insert into tipo_linea (tipo_linea) values (?)", u.getNombre());
            return new ModelAndView("redirect:/TipoLineaHome.htm");
        }
    }

}
