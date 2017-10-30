/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.ValidarTipoLinea;
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
 * @author Camilo
 */
@Controller
public class TipoLineaHomeController {

    //PARA BD
    private JdbcTemplate jdbcTemplate;
    //--------------
    
    //-------CRUD---------
    private ValidarTipoLinea validarusuario;
    private JdbcTemplate jdbcTemplateUser;

    public TipoLineaHomeController() {
        
       // this.personaValidar = new validatePerson();
        Conexion conn = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());
        //----------CRUD------------
       // this.validarusuario = new ValidarTipoLinea();
      //  this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
    }

    //-------------Base de Datos------------------- 
    
    @RequestMapping("TipoLineaHome.htm")
    public ModelAndView homeBD(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/TipoLineaHome");
        String sql = "select * from tipo_linea order by id asc;";
        List response;
        response = this.jdbcTemplate.queryForList(sql);
        mav.addObject("Datos", response);
        return mav;
    } 
    
    //------------------CRUD-----------------------
    
    @RequestMapping("TipoLineaAdd.htm")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/TipoLineaAdd");
        return mav;
    }
    
}
