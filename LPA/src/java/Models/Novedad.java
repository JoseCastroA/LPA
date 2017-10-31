/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Camilo
 */
public class Novedad {
    private int Id;
    private String Nombre;
    private String Informacion;
    private String Imagen;

    public Novedad() {
    }

    public Novedad(int Id, String Nombre,String Informacion,String Imagen) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Informacion = Informacion;
        this.Imagen = Imagen;
    }
    
    public Novedad(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getInformacion() {
        return Informacion;
    }

    public void setInformacion(String Informacion) {
        this.Informacion = Informacion;
    }
     public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }
}
