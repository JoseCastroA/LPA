/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.Producto;
import Models.ValidateUser2;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView viewBD(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        mav.setViewName("BD/editBuys");
        String sql = "select p.*,c.cantidad from productos p inner join compra_temporal c on p.id = c.id where c.id='" + id + "';";
        List response;
        response = this.jdbcTemplate.queryForList(sql);
//        mav.addObject("Usuario", newProductod(id, u.getNombre(),u.getInformacion(),u.getImagen(),u.getPrecio()));
        mav.addObject("Datos", response);
        String sql2 = "select cantidad from compra_temporal where id='" + id + "';";
        List response2;
        response2 = this.jdbcTemplate.queryForList(sql);
        mav.addObject("Datos", response2);
        return mav;
    } 

       @RequestMapping(value = "/COMPRA_edit.htm", method = RequestMethod.POST)
    public  ModelAndView agregarCompra(@RequestParam("Cantidad") int cantidad,@RequestParam("Id") int id) {
         Producto compra = new Producto(id, "No",0,"No", "No",0, cantidad);
           compra.editarCompraProducto(id, "No",0, cantidad);
          return new ModelAndView("redirect:/admBuys.htm");
    }

}
