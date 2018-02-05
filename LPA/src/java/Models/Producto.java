/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Camilo
 */
public class Producto {
    private JdbcTemplate jdbcTemplateUser;
    private int Id;
    private String Nombre;
    private String Informacion;
    private String Imagen;
    private int Precio;
    private int Disponibles;
    private int Cantidad;
    

    public Producto() {
        
    }

    public Producto(int Id, String Nombre, int Precio,String Informacion,String Imagen,int Disponibles,int Cantidad) {
        Conexion conn = new Conexion();
        this.jdbcTemplateUser = new JdbcTemplate(conn.conectar());
        this.Id = Id;
        this.Nombre = Nombre;
        this.Informacion = Informacion;
        this.Imagen = Imagen;
        this.Precio = Precio;
        this.Disponibles=Disponibles;
        this.Cantidad = Cantidad;
    }
    
    public Producto(String Nombre) {
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
         public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    /**
     * @return the Disponibles
     */
    public int getDisponibles() {
        return Disponibles;
    }

    /**
     * @param Disponibles the Disponibles to set
     */
    public void setDisponibles(int Disponibles) {
        this.Disponibles = Disponibles;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void agregarCompraProducto (int Id,String Nombre,int Precio,int Cantidad)
    {
         
          this.jdbcTemplateUser.update("insert into compra_temporal ( id, nombre,precio,cantidad,total) values (?,?,?,?,?)", Id,Nombre,Precio,Cantidad,(Precio*Cantidad));
    }
    
     public void sumarCompraProducto (int Id,String Nombre,int Precio,int Cantidad)
    {
           this.jdbcTemplateUser.update("update compra_temporal set cantidad=cantidad+? where id=?",Cantidad,Id);
    }
    
    public void editarCompraProducto (int Id,String Nombre,int Precio,int Cantidad)
    {
          this.jdbcTemplateUser.update("update compra_temporal set cantidad=? where id=?",Cantidad,Id);
    }
    
     public void eliminarCompraProducto (int Id)
    {
          this.jdbcTemplateUser.update("delete from compra_temporal where id=?",Id);
    }
     
    public void liquidarCompra()
    {
        this.jdbcTemplateUser.update("insert into trampa values (1);");
        
    }
}
