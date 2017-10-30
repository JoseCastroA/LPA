/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *
 * @author trisb
 */
public class ValidarTipoProducto implements Validator{
    @Override
    public boolean supports(Class<?> type) {
        return TipoProducto.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TipoProducto persona = (TipoProducto) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nombre", "required.Nombre", "Todos los campos son obligatorios obligatorios");
      }
}
