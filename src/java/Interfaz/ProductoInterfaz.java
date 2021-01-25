/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Entidades.ProductDto1;
import Entidades.ProductoDto;
import java.util.List;

/**
 *
 * @author stive
 */
public interface ProductoInterfaz {
    
    public ProductoDto listar();
    
    public ProductDto1 listarPorId(int id);
    
}
