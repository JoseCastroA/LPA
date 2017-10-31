/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 */
public class Eventos {
    private int Id;
    private String Nombre;
    private String Fecha;
    private String Foto;

    public Eventos() {
    }

    public Eventos(int Id, String Nombre, String Fecha, String Foto) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Fecha = Fecha;
        this.Foto = Foto;
    }
    
    public Eventos(String Nombre, String Fecha, String Foto) {
        this.Nombre = Nombre;
        this.Fecha = Fecha;
        this.Foto = Foto;
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

    /**
     * @return the Fecha
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the Foto
     */
    public String getFoto() {
        return Foto;
    }

    /**
     * @param Foto the Foto to set
     */
    public void setFoto(String Foto) {
        this.Foto = Foto;
    }
}
