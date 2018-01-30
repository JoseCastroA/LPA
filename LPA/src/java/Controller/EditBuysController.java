/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.Novedad;
import Models.ValidateUser2;
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
public class EditBuysController {

    private ValidateUser2 validar;
    private JdbcTemplate jdbcTemplate;

    public EditBuysController() {
        this.validar = new ValidateUser2();
        Conexion conn = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping(value = "editBuys.htm", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/editBuys");
        int id = Integer.parseInt(request.getParameter("id"));
        Novedad u = this.selectUsuario(id);
     //   mav.addObject("Usuario", new Novedad(id, u.getNombre(),u.getInformacion(),u.getImagen(),u.getPrecio()));
        return mav;
    }
    
    @RequestMapping(value = "editBuys.htm", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("Usuario") Novedad u, BindingResult result, SessionStatus status, HttpServletRequest request){
        this.validar.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            int id= Integer.parseInt(request.getParameter("id"));
            Novedad datos = this.selectUsuario(id);
            mav.setViewName("BD/editBuys");
            mav.addObject("Usuario",u);
            return mav;
        }else{
            int id = Integer.parseInt(request.getParameter("id"));
            this.jdbcTemplate.update("update novedades set nombre=? ,informacion=? ,fecha=NOW() where id=?;",u.getNombre(),u.getInformacion(),id);
            return new ModelAndView("redirect:/admBuys.htm");
        }
    }

    public Novedad selectUsuario(int id) {
        final Novedad u = new Novedad();
        String query = "select * from novedades where id='" + id + "';";
        return (Novedad) jdbcTemplate.query(query, new ResultSetExtractor<Novedad>() {
            @Override
            public Novedad extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    u.setNombre(rs.getString("nombre"));
                    u.setInformacion(rs.getString("informacion"));
                }
                return u;
            }
        });
    }
}
