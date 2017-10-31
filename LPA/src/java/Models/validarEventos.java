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
 */
public class validarEventos implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Eventos.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Eventos persona = (Eventos) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nombre", "required.Nombre", "Los campos son obligatorios");
      }
}
