/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Camilo
 */
public class ValidarTipoLinea implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return TipoLinea.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TipoLinea persona = (TipoLinea) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nombre", "required.Nombre", "El campo tipo de linea es obligatorio");
      }
}
