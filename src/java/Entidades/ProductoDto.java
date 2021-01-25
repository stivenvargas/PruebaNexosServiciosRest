/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author stive
 */
public class ProductoDto {
    private ArrayList<ProductDto1> productos;

    public ProductoDto(ArrayList<ProductDto1> productos) {
        this.productos = productos;
    }

    public ProductoDto() {
    }

    public ArrayList<ProductDto1> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductDto1> productos) {
        this.productos = productos;
    }
    
    
    
}
