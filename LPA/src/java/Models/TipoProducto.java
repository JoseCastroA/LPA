/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author trisb
 */
public class TipoProducto {
    private int Id;
    private String Nombre;
    private String Id_tipo_linea;
    
    public TipoProducto() {
    }

    public TipoProducto(int Id, String Nombre, String Id_tipo_linea) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Id_tipo_linea = Id_tipo_linea;
    }
    
    public TipoProducto(String Nombre, String Id_tipo_linea) {
        this.Nombre = Nombre;
        this.Id_tipo_linea = Id_tipo_linea;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Id_tipo_linea
     */
    public String getId_tipo_linea() {
        return Id_tipo_linea;
    }

    /**
     * @param Id_tipo_linea the Id_tipo_linea to set
     */
    public void setId_tipo_linea(String Id_tipo_linea) {
        this.Id_tipo_linea = Id_tipo_linea;
    }
}
