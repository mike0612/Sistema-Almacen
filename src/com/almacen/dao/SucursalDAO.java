package com.almacen.dao;

import com.almacen.model.Sucursal;
import java.util.ArrayList;

public interface SucursalDAO {

    String addSucursal(Sucursal newSucursal);

    String updateSucursal(Sucursal sucursal);

    String delSucursal(int idSucursal);

    ArrayList<Sucursal> getSucursal();
}
