package com.almacen.model;

public class Tipo {

    private int idTipo;
    private String Tipo;
    private boolean status;

    public Tipo() {
    }

    public Tipo(int idTipo, String Tipo, boolean status) {
        this.idTipo = idTipo;
        this.Tipo = Tipo;
        this.status = status;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
