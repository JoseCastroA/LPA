/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.Eventos;
import Models.validarEventos;
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
 */
@Controller
public class editController {

    private validarEventos validar;
    private JdbcTemplate jdbcTemplate;

    public editController() {
        this.validar = new validarEventos();
        Conexion conn = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping(value = "edit.htm", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/edit");
        int id = Integer.parseInt(request.getParameter("id"));
        Eventos u = this.selectUsuario(id);
        mav.addObject("Eventos", new Eventos(id, u.getNombre(), u.getFecha(), u.getFoto()));
        return mav;
    }
    
    @RequestMapping(value = "edit.htm", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("Eventos") Eventos u, BindingResult result, SessionStatus status, HttpServletRequest request){
        this.validar.validate(u, result);
        
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            int id= Integer.parseInt(request.getParameter("id"));
            Eventos datos = this.selectUsuario(id);
            mav.setViewName("BD/edit");
            mav.addObject("Eventos",u);
            return mav;
        }else{
            int id = Integer.parseInt(request.getParameter("id"));
            String consulta = "update eventos set informacion='"+u.getNombre()+"', fecha='"+u.getFecha()+"', foto='"+u.getFoto()+"' where id="+id;
            this.jdbcTemplate.update(consulta);
            return new ModelAndView("redirect:/home.htm");
        }
    }
    public Eventos selectUsuario(int id) {
        final Eventos u = new Eventos();
        String query = "select * from eventos where id='" + id + "';";
        return (Eventos) jdbcTemplate.query(query, new ResultSetExtractor<Eventos>() {
            @Override
            public Eventos extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    u.setNombre(rs.getString("informacion"));
                    u.setFecha(rs.getString("fecha"));
                    u.setFoto(rs.getString("foto"));
                }
                return u;
            }
        });
    }
}
