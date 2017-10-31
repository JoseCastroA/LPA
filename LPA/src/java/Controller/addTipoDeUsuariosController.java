package Controller;

import Models.Conexion;
import Models.FileModel;
import Models.tipoUsuario;
import Models.validarTipoUsuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Camilo
 */
@Controller
public class addTipoDeUsuariosController {

    private validarTipoUsuario validar;
    private JdbcTemplate jdbcTemplateUser;
    
 


        //Constructor de clase con la conexion y validar que los datos no esten vacios o espacios
    public addTipoDeUsuariosController() {
        Conexion conn = new Conexion();
        this.validar = new validarTipoUsuario();
        this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
    }
    
    @RequestMapping(value = "addTipoDeUsuarios.htm", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("tipoUsuario") tipoUsuario u, BindingResult result, SessionStatus status) {
        this.validar.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("TiposUsuarios/addTipoDeUsuarios");
            mav.addObject("TipoUsuario", u);
            return mav;
        } else {
            this.jdbcTemplateUser.update("insert into tipos_usuarios (nombre_tipo_usuario, descripcion_tipo_usuario,id) values (?,?,default)", u.getNombre(),u.getDescripcion());
            return new ModelAndView("redirect:/homeTipoDeUsuarios.htm");
        }
    }
    
    @RequestMapping(value = "addTipoDeUsuarios.htm", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("TiposUsuarios/addTipoDeUsuarios");
        mav.addObject("tipoUsuario", new tipoUsuario());
        return mav;
    }
    
    
}
