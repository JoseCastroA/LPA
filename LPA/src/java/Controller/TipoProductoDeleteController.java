/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Models.Conexion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author trisb
 */
@Controller
public class TipoProductoDeleteController {
    private JdbcTemplate jdbc;

    public TipoProductoDeleteController() {
        Conexion conn = new Conexion();
        this.jdbc = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping("TipoProductoDelete.htm")
    public ModelAndView delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbc.update("delete from tipo_producto where id=?", id);
        return new ModelAndView("redirect:/TipoProductoHome.htm");
    }
}
