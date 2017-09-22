package Controller;

import Models.Conexion;
import Models.Usuario;
import Models.validateUser;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class addController {

    private validateUser validarusuario;
    private JdbcTemplate jdbcTemplateUser;

        //Constructor de clase con la conexion y validar que los datos no esten vacios o espacios
    public addController() {
        Conexion conn = new Conexion();
        this.validarusuario = new validateUser();
        this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
    }

    
    @RequestMapping(value = "add.htm", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/add");
        mav.addObject("Usuario", new Usuario());
        return mav;
    }
    
    @RequestMapping(value = "add.htm", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("Usuario") Usuario u, BindingResult result, SessionStatus status) {
        this.validarusuario.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("BD/add");
            mav.addObject("Usuario", u);
            return mav;
        } else {
            this.jdbcTemplateUser.update("insert into ejemplo (nombre) values (?)", u.getNombre());
            return new ModelAndView("redirect:/home.htm");
        }
    }

}
