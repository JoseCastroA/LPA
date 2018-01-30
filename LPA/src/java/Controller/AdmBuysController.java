/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.ValidateUser2;
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
public class AdmBuysController {

    //PARA BD
    private JdbcTemplate jdbcTemplate;
    //--------------
    
    //Constructor de clase con la conexion
    public AdmBuysController() {
        Conexion conn = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());;
    }
    
    //Metodo para enlazar el home.htm con la clase home.jsp
    @RequestMapping("admBuys.htm")
    public ModelAndView homeBD(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/admBuys");
        String sql = "select * from novedades order by id asc;";
        List response;
        response = this.jdbcTemplate.queryForList(sql);
        mav.addObject("Datos", response);
        return mav;
    } 


    
}
