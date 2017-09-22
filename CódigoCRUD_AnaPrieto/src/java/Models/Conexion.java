/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 */
public class Conexion {
    
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/CRUD");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        return dataSource;
    }
}
