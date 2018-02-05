package Controller;

import Models.Conexion;
import Models.Producto;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "/COMPRA_delete.htm", method = RequestMethod.GET)
    public  ModelAndView eliminarCompra(@RequestParam("id") int id) {
          Producto compra = new Producto(id, "No",0,"No", "No",0, 0);
           compra.eliminarCompraProducto(id);
          return new ModelAndView("redirect:/admBuys.htm");
    }
}
