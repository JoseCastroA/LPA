/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.Usuario;
import Models.validateUser;
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

    private validateUser validar;
    private JdbcTemplate jdbcTemplate;

    public editController() {
        this.validar = new validateUser();
        Conexion conn = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping(value = "edit.htm", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/edit");
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario u = this.selectUsuario(id);
        mav.addObject("Usuario", new Usuario(id, u.getNombre()));
        return mav;
    }
    
    @RequestMapping(value = "edit.htm", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("Usuario") Usuario u, BindingResult result, SessionStatus status, HttpServletRequest request){
        this.validar.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            int id= Integer.parseInt(request.getParameter("id"));
            Usuario datos = this.selectUsuario(id);
            mav.setViewName("BD/edit");
            mav.addObject("Usuario",u);
            return mav;
        }else{
            int id = Integer.parseInt(request.getParameter("id"));
            this.jdbcTemplate.update("update eventos set informacion=? where id=?;",u.getNombre(),id);
            return new ModelAndView("redirect:/home.htm");
        }
    }

    public Usuario selectUsuario(int id) {
        final Usuario u = new Usuario();
        String query = "select * from eventos where id='" + id + "';";
        return (Usuario) jdbcTemplate.query(query, new ResultSetExtractor<Usuario>() {
            @Override
            public Usuario extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    u.setNombre(rs.getString("informacion"));
                }
                return u;
            }
        });
    }
}
