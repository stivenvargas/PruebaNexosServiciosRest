/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author stive
 */
public class logCarritoCompras {
    
    private static final String RUTA_ARCHIVO= "./compras.log";
    
    public void setLogError(String mensajeError){
        try {
            Logger log= Logger.getLogger("MyLog");
            FileHandler fileHandler;
            
            fileHandler= new FileHandler(RUTA_ARCHIVO, true);
            log.addHandler(fileHandler);
            
            SimpleFormatter formt = new SimpleFormatter();
            fileHandler.setFormatter(formt);
            
            log.info(mensajeError);
            fileHandler.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
}
