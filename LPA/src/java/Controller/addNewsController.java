package Controller;

import Models.Conexion;
import Models.FileModel;
import Models.Novedad;
import Models.ValidateUser2;
import com.beingjavaguys.model.UploadedFile;
import com.beingjavaguys.validator.FileValidator;
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
public class addNewsController {

    private ValidateUser2 validarusuario;
    private JdbcTemplate jdbcTemplateUser;
    
    @Autowired
    FileValidator fileValidator;


        //Constructor de clase con la conexion y validar que los datos no esten vacios o espacios
    public addNewsController() {
        Conexion conn = new Conexion();
        this.validarusuario = new ValidateUser2();
        this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
    }

    
    @RequestMapping(value = "addNovedades.htm", method = RequestMethod.GET)
    public ModelAndView add() {
        FileModel file = new FileModel();
        ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("BD/addNovedades");
        mav.addObject("Novedad", new Novedad());
        return mav;
    }


	@RequestMapping("/fileUploadForm")
	public ModelAndView getUploadForm(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			BindingResult result) {
		return new ModelAndView("uploadForm");
	}

	@RequestMapping("/fileUpload")
	public ModelAndView fileUploaded(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		MultipartFile file = uploadedFile.getFile();
		fileValidator.validate(uploadedFile, result);

		String fileName = file.getOriginalFilename();

		if (result.hasErrors()) {
			return new ModelAndView("uploadForm");
		}

		try {
			inputStream = file.getInputStream();

			File newFile = new File("C:/mytemp/" + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("showFile", "message", fileName);
	}
    
    @RequestMapping(value = "addNovedades.htm", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("Novedad") Novedad u, BindingResult result, SessionStatus status) {
        this.validarusuario.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("BD/addNovedades");
            mav.addObject("Novedad", u);
            return mav;
        } else {
            this.jdbcTemplateUser.update("insert into novedades ( id, nombre, informacion, imagen, fecha) values (default,?,?,'default.jpg',now())", u.getNombre(),u.getInformacion());
            return new ModelAndView("redirect:/admNovedades.htm");
        }
    }
    
    
}
