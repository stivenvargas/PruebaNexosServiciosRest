/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author stive
 */
public class ClienteDto {
    
    private int idCleinte;
    private String dni;
    private String nombres;
    private String direccion;
    private String email;
    private String password;
    
    public ClienteDto(){
        
    }

    public ClienteDto(int idCleinte, String dni, String nombres, String direccion, String email, String password) {
        this.idCleinte = idCleinte;
        this.dni = dni;
        this.nombres = nombres;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
    }

    public int getIdCleinte() {
        return idCleinte;
    }

    public void setIdCleinte(int idCleinte) {
        this.idCleinte = idCleinte;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
