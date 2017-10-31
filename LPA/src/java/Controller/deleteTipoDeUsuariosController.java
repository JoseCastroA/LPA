package Controller;

import Models.Conexion;
import Models.tipoUsuario;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Camilo
 */

@Controller
public class deleteTipoDeUsuariosController {

    private JdbcTemplate jdbc;

    public deleteTipoDeUsuariosController() {
        Conexion conn = new Conexion();
        this.jdbc = new JdbcTemplate(conn.conectar());
    }

   @RequestMapping("deleteTipoDeUsuarios.htm")
    public ModelAndView delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbc.update("delete from tipos_usuarios where id=?", id);
        return new ModelAndView("redirect:/homeTipoDeUsuarios.htm");
    }
   /* @RequestMapping("delete.htm")
    public ModelAndView delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbc.update("delete from novedades where id=?", id);
        return new ModelAndView("redirect:/home.htm");
    }
*/
}
