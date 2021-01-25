
package Modelo;

import Util.logCarritoCompras;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author stive
 */
public class Conexion {
    
    Connection conn;
    
    public Conexion(){
        
        logCarritoCompras log= new  logCarritoCompras();
        try {
           Class.forName("com.mysql.jdbc.Driver");
           conn= DriverManager.getConnection("jdbc:mysql://servidormysqlstiven.mysql.database.azure.com:3306/carrocompras","adminstiven@servidormysqlstiven","stiven.12345");
           log.setLogError("conexión a base de datos exitosa");
        } catch (Exception e) {
            log.setLogError("Error al conectarse a la base de datos: " +  e.getMessage() + e);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    
}
