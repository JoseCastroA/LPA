package Controller;

import Models.Conexion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Oscar
 */
@Controller
public class TipoLineaDeleteController {

    private JdbcTemplate jdbc;

    public TipoLineaDeleteController() {
        Conexion conn = new Conexion();
        this.jdbc = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping("TipoLineaDelete.htm")
    public ModelAndView delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbc.update("delete from tipo_linea where id=?", id);
        return new ModelAndView("redirect:/TipoLineaHome.htm");
    }
}
