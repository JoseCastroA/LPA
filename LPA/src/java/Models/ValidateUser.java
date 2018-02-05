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
public class ValidateUser2 implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Producto.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
       Producto novedad =(Producto) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nombre", "required.Nombre", "Error: El campo 'Nombre novedad' es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Informacion", "required.Informacion", "Error: El campo 'Informacion' es obligatorio");
    }
}
