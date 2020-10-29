package com.almacen.model;

public class Proveedor {

    private int idProveedor;
    private String Nombre;
    private String Telefono;
    private String Correoelectronico;
    private boolean status;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String Nombre, String Telefono, String Correoelectronico, boolean status) {
        this.idProveedor = idProveedor;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correoelectronico = Correoelectronico;
        this.status = status;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreoelectronico() {
        return Correoelectronico;
    }

    public void setCorreoelectronico(String Correoelectronico) {
        this.Correoelectronico = Correoelectronico;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
