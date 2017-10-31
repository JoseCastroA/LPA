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
public class validarTipoUsuario implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return tipoUsuario.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        tipoUsuario persona = (tipoUsuario) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nombre", "required.Nombre", "El campo nombre es Obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Descripcion", "required.Descripcion", "El campo descripcion es Obligatorio");
      }
}
