package com.almacen.model;

public class Sucursal {

    private int idSucursal;
    private String Nombre;
    private boolean status;

    public Sucursal() {
    }

    public Sucursal(int idSucursal, String Nombre, boolean status) {
        this.idSucursal = idSucursal;
        this.Nombre = Nombre;
        this.status = status;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
