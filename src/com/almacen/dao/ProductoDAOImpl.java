package com.almacen.dao;

import com.almacen.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAOImpl implements ProductoDAO {

    private String serverAnswer = "";
    private PreparedStatement ps;

    @Override
    public String addProducto(Producto newProducto) {
        try {

            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "INSERT INTO producto ("
                    + "codigo, nombre, precio, stock, idProveedor, idSucursal)"
                    + "VALUES (?,?,?,?,?,?)");

            ps.setString(1, newProducto.getCodigo());
            ps.setString(2, newProducto.getNombre());
            ps.setDouble(3, newProducto.getPrecio());
            ps.setInt(4, newProducto.getStock());
            ps.setInt(5, newProducto.getIdProveedor());
            ps.setInt(6, 1);

            int numAffectedRows = ps.executeUpdate();

            if (numAffectedRows > 0) {
                serverAnswer = "Producto registrado correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al registrar el producto";
        }
        return serverAnswer;
    }

    @Override
    public String updateProducto(Producto producto) {
        try {

            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE producto SET "
                    + "codigo = ?, nombre = ?, precio = ?, stock = ?, proveedor = ?, sucursal= ?"
                    + "WHERE idProducto = ?");

            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getIdProveedor());
            ps.setInt(6, producto.getIdSucursal());
            ps.setInt(7, producto.getIdProducto());

            int numAffectedRows = MySqlSingleton.getRows(ps);

            if (numAffectedRows > 0) {
                serverAnswer = "El producto se actualizó correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al actualizar el producto";
        }

        return serverAnswer;
    }

    @Override
    public String delProducto(int idProducto) {

        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE producto SET "
                    + "estado = ? WHERE idProducto = ?");

            ps.setBoolean(1, false);
            ps.setInt(2, idProducto);

            int numAffectedRows = MySqlSingleton.getRows(ps);

            if (numAffectedRows > 0) {
                serverAnswer = "El producto ha sido eliminado correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al eliminar el producto";
        }

        return serverAnswer;
    }

    @Override
    public ArrayList<Producto> getProducto() {

        ArrayList<Producto> listOfProducto = new ArrayList<>();

        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(""
                    + "SELECT * FROM producto WHERE idSucursal = 1 AND status = 1");
            ResultSet rs = MySqlSingleton.executeStatement(ps);
            Producto p;
            while (rs.next()) {
                p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setCodigo(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setIdProveedor(rs.getInt(6));
                p.setIdSucursal(rs.getInt(7));
                p.setIdProducto(rs.getInt(8));

                listOfProducto.add(p);
            }

        } catch (Exception e) {
            System.out.println("SQL Error " + e.getMessage());
        }

        return listOfProducto;
    }

}
