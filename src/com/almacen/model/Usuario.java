package com.almacen.model;


public class Usuario {
    private int idUsuario;
    private int idSucursal;
    private int idTipo;
    private String Nombre;
    private String Usuario;
    private String Contrasena;
    private boolean status; 
    
    public Usuario(){        
    }

    public Usuario(int idUsuario, int idSucursal, int idTipo, String Nombre, String Usuario, String Contrasena, boolean status) {
        this.idUsuario = idUsuario;
        this.idSucursal = idSucursal;
        this.idTipo = idTipo;
        this.Nombre = Nombre;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
        this.status = status;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
