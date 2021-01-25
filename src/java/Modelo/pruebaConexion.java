/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;

/**
 *
 * @author stive
 */
public class pruebaConexion {
    
    public static void main(String[] args) {
        Connection con;
        Conexion conexion = new Conexion();
        con=  conexion.getConnection();
    }
}
