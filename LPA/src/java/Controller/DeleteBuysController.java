package Controller;

import Models.Conexion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Camilo
 */

@Controller
public class DeleteBuysController {

    private JdbcTemplate jdbc;

    public DeleteBuysController() {
        Conexion conn = new Conexion();
        this.jdbc = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping("deleteBuys.htm")
    public ModelAndView delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbc.update("delete from novedades where id=?", id);
        return new ModelAndView("redirect:/admBuys.htm");
    }
}
