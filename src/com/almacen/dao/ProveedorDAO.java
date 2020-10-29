package com.almacen.dao;

import com.almacen.model.Proveedor;
import java.util.ArrayList;

public interface ProveedorDAO {

    String addProveedor(Proveedor newProveedor);

    String updateProveedor(Proveedor proveedor);

    String delProveedor(int idProveedor);

    ArrayList<Proveedor> getProveedor();

}
