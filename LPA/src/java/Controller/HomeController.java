/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.validarEventos;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class HomeController {

    //PARA BD
    private JdbcTemplate jdbcTemplate;
    //--------------
    
    //-------CRUD---------
    private validarEventos validarusuario;
    private JdbcTemplate jdbcTemplateUser;

    public HomeController() {
        
       // this.personaValidar = new validatePerson();
        Conexion conn = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());
        //----------CRUD------------
       // this.validarusuario = new validarEventos();
      //  this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
    }

    //-------------Base de Datos------------------- 
    
    @RequestMapping("home.htm")
    public ModelAndView homeBD(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/home");
        String sql = "select * from eventos order by id asc;";
        List response;
        response = this.jdbcTemplate.queryForList(sql);
        mav.addObject("Datos", response);
        return mav;
    } 
    
    //------------------CRUD-----------------------
    
    @RequestMapping("add.htm")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/add");
        return mav;
    }
    
}
