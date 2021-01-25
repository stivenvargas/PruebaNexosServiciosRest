/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.ProductDto1;
import Entidades.ProductoDto;
import Interfaz.ProductoInterfaz;
import Util.logCarritoCompras;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stive
 */
public class ProductoDao implements ProductoInterfaz{
    Connection con;
    Conexion conexion= new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    logCarritoCompras log = new logCarritoCompras();
    
    @Override
    public ProductDto1 listarPorId(int id) {
        String consultaSql= "select * from producto where idProducto=" + id;
        ProductDto1 productDto1= new ProductDto1();
        try {
            con= conexion.getConnection();
            ps= con.prepareStatement(consultaSql);
            rs= ps.executeQuery();
            while(rs.next()){
                productDto1.setIdProducto(rs.getInt(1));
                productDto1.setNombres(rs.getString(2));
                productDto1.setFoto(rs.getBinaryStream(3));
                productDto1.setDescripcion(rs.getString(4));
                productDto1.setPrecio(rs.getDouble(5));
                productDto1.setStock(rs.getInt(6));
            }           
        } catch (Exception e) {
            log.setLogError("error al lista producto: " + e.getMessage() + e);
        }
        return productDto1;
    }
    
    @Override
    public ProductoDto listar() {
        ProductoDto listaProductos = new ProductoDto();
        ArrayList<ProductDto1> list = new ArrayList();
        String consultaSql= "select * from producto";
        try {
            con= conexion.getConnection();
            ps= con.prepareStatement(consultaSql);
            rs= ps.executeQuery();
            while(rs.next()){
                ProductDto1 pro= new ProductDto1();
                pro.setIdProducto(rs.getInt(1));
                pro.setNombres(rs.getString(2));
                pro.setFoto(rs.getBinaryStream(3));
                pro.setDescripcion(rs.getString(4));
                pro.setPrecio(rs.getDouble(5));
                pro.setStock(rs.getInt(6));
                list.add(pro);
            }
            listaProductos.setProductos(list);
        } catch (Exception e) {
            log.setLogError("error al listar productos: " + e.getMessage() + e);
        }  
        return listaProductos;
    }
    
    public void listarImg(int id, HttpServletResponse response){
        String consultaSql= "select * from producto where idProducto=" + id;
        
        try {
            InputStream inputStream= null;
            OutputStream os= null;
            BufferedInputStream bufferedInputStream= null;
            BufferedOutputStream bufferedOutputStream= null;
            
            os= response.getOutputStream();
            con= conexion.getConnection();
            ps= con.prepareStatement(consultaSql);
            rs= ps.executeQuery();
            if(rs.next()){
                inputStream= rs.getBinaryStream("Foto");
            }
            bufferedInputStream= new BufferedInputStream(inputStream);
            bufferedOutputStream= new BufferedOutputStream(os);
            int i=0;
            while((i= bufferedInputStream.read()) != -1){
              bufferedOutputStream.write(i);
        }
        } catch (Exception e) {
          log.setLogError("Error al listar las imagenes: " + e.getMessage());
         
        }
    }
    
}
