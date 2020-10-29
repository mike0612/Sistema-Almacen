package com.almacen.model;

public class Producto {

    private int idProducto;
    private int idSucursal;
    private String Nombre;
    private String Codigo;
    private Double Precio;
    private int Stock;
    private int idProveedor;
    private boolean status;

    public Producto() {
    }

    public Producto(String Codigo, String Nombre, Double Precio, int Stock, int idProveedor) {
        this.Codigo = Codigo;    
        this.Nombre = Nombre;        
        this.Precio = Precio;
        this.Stock = Stock;
        this.idProveedor = idProveedor;        
        
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
