package Controller;

import Models.Conexion;
import Models.FileModel;
import Models.Producto;
import Models.ValidateUser2;
import com.beingjavaguys.model.UploadedFile;
import com.beingjavaguys.validator.FileValidator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.tools.DocumentationTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Node;

/**
 *
 * @author Camilo
 */
@Controller
public class AddBuyController {
    private ValidateUser2 validarusuario;
    private JdbcTemplate jdbcTemplateUser;
    
 
        //Constructor de clase con la conexion y validar que los datos no esten vacios o espacios
    public AddBuyController() {
        Conexion conn = new Conexion();
        this.validarusuario = new ValidateUser2();
        this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
    }
    
    
    @RequestMapping(value = "addBuy.htm", method = RequestMethod.GET)
    public ModelAndView viewBD(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        mav.setViewName("BD/addBuy");
        String sql = "select * from productos where id='" + id + "';";
        List response;
        response = this.jdbcTemplateUser.queryForList(sql);
//        mav.addObject("Usuario", newProductod(id, u.getNombre(),u.getInformacion(),u.getImagen(),u.getPrecio()));
        mav.addObject("Datos", response);
        return mav;
    } 
    
    
       @RequestMapping(value = "/COMPRA_add.htm", method = RequestMethod.POST)
    public  ModelAndView agregarCompra(@RequestParam("Cantidad") int cantidad,@RequestParam("Id") int id,@RequestParam("Nombre") String nombre,@RequestParam("Precio") int precio) {
          String sql = "select * from compra_temporal where id='" + id + "';";
          List response;
          response = this.jdbcTemplateUser.queryForList(sql);
           System.out.println("La respuesta es: "+ response);
          if (response.isEmpty()) {
              Producto compra = new Producto(id, nombre, precio,"No", "No",0, cantidad);
           compra.agregarCompraProducto(id, nombre, precio, cantidad);
          return new ModelAndView("redirect:/admBuys.htm");
          }
          else {
              Producto compra = new Producto(id, nombre, precio,"No", "No",0, cantidad);
           compra.sumarCompraProducto(id, nombre, precio, cantidad);
          return new ModelAndView("redirect:/admBuys.htm");
          }
    }
    
        @RequestMapping(value = "/COMPRA_liquidar.htm",method = {RequestMethod.POST, RequestMethod.GET})
        public  ModelAndView liquidarCompra() {
         Producto compra = new Producto();
         compra.liquidarCompra();
          
          return new ModelAndView("redirect:/addBuy.htm?id=1");
    }
    
}
