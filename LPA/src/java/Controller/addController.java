/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.Eventos;
import Models.validarEventos;
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
 */
@Controller
public class addController {

    private validarEventos validarEventos;
    private JdbcTemplate jdbcTemplateUser;

    public addController() {
        Conexion conn = new Conexion();
        this.validarEventos = new validarEventos();
        this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
    }

    //@ModelAttribute("Eventos") Eventos p, BindingResult result, SessionStatus status
    //this.validarEventos.validate(p, result);
    @RequestMapping(value = "add.htm", method = RequestMethod.GET)
    public ModelAndView add() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/add");
        mav.addObject("Eventos", new Eventos());
        return mav;
    }
    
    @RequestMapping(value = "add.htm", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("Eventos") Eventos u, BindingResult result, SessionStatus status) {
        this.validarEventos.validate(u, result);
        //System.out.println(u.getNombre());
        //mav.setViewName("BD/add");
        String consulta="insert into eventos (informacion, fecha, foto) values ( '"+ u.getNombre()+"' , '"+u.getFecha()+"' , '"+u.getFoto()+"')";
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("BD/add");
            mav.addObject("Eventos", u);
            return mav;
        } else {
            this.jdbcTemplateUser.update(consulta);
            return new ModelAndView("redirect:/home.htm");
        }
    }

}
