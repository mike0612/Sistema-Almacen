package com.almacen.dao;

import com.almacen.model.Producto;
import java.util.ArrayList;

public interface ProductoDAO {

    String addProducto(Producto newProducto);

    String updateProducto(Producto producto);

    String delProducto(int idProducto);

    ArrayList<Producto> getProducto();

}
