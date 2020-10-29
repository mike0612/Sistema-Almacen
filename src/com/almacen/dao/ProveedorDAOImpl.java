package com.almacen.dao;

import com.almacen.model.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProveedorDAOImpl implements ProveedorDAO {

    private String serverAnswer = "";
    private PreparedStatement ps;

    @Override
    public String addProveedor(Proveedor newProveedor) {
        try {

            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "INSERT INTO proveedor ("
                    + "nombre, telefono, correo)"
                    + "VALUES (?,?,?)");

            ps.setString(1, newProveedor.getNombre());
            ps.setString(2, newProveedor.getTelefono());
            ps.setString(3, newProveedor.getCorreoelectronico());

            int numAffectedRows = ps.executeUpdate();

            if (numAffectedRows > 0) {
                serverAnswer = "Proveedor registrado correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al registrar el proveedor";
        }
        return serverAnswer;
    }

    @Override
    public String updateProveedor(Proveedor proveedor) {
        try {

            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE producto SET "
                    + "nombre = ?, telefono = ?, correo = ?"
                    + "WHERE idProveedor = ?");

            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getTelefono());
            ps.setString(3, proveedor.getCorreoelectronico());
            ps.setInt(4, proveedor.getIdProveedor());

            int numAffectedRows = MySqlSingleton.getRows(ps);

            if (numAffectedRows > 0) {
                serverAnswer = "El proveedor se actualizó correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al actualizar el producto";
        }

        return serverAnswer;
    }

    @Override
    public String delProveedor(int idProveedor) {
        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE proveedor SET "
                    + "estado = ? WHERE idProveedor = ?");

            ps.setBoolean(1, false);
            ps.setInt(2, idProveedor);

            int numAffectedRows = MySqlSingleton.getRows(ps);

            if (numAffectedRows > 0) {
                serverAnswer = "El proveedor ha sido eliminado correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al eliminar el proveedor";
        }

        return serverAnswer;
    }

    @Override
    public ArrayList<Proveedor> getProveedor() {
        
        ArrayList<Proveedor> listOfProveedor = new ArrayList<>();

        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(""
                    + "SELECT * FROM proveedor");
            
            ResultSet rs = MySqlSingleton.executeStatement(ps);
            Proveedor p;
            while (rs.next()) {
                p = new Proveedor();
                p.setIdProveedor(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setTelefono(rs.getString(3));
                p.setCorreoelectronico(rs.getString(4));
                p.setStatus(rs.getBoolean(5));
                
                listOfProveedor.add(p);
            }

        } catch (Exception e) {
            System.out.println("SQL Error " + e.getMessage());
        }

        return listOfProveedor;
    }

}
