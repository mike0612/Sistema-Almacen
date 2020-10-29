
package com.almacen.dao;

import com.almacen.model.Sucursal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SucursalDAOImpl implements SucursalDAO{

    private String serverAnswer = "";
    private PreparedStatement ps;
    
    @Override
    public String addSucursal(Sucursal newSucursal) {
        try {

            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "INSERT INTO sucursal ("
                    + "nombre)"
                    + "VALUES (?)");

            ps.setString(1, newSucursal.getNombre());            

            int numAffectedRows = ps.executeUpdate();

            if (numAffectedRows > 0) {
                serverAnswer = "Sucursal registrada correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al registrar la sucursal";
        }
        return serverAnswer;
    }

    @Override
    public String updateSucursal(Sucursal sucursal) {
        try {

            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE suscursal SET "
                    + "nombre = ?"
                    + "WHERE idSucursal = ?");

            ps.setString(1, sucursal.getNombre());
            ps.setInt(2, sucursal.getIdSucursal());

            int numAffectedRows = MySqlSingleton.getRows(ps);

            if (numAffectedRows > 0) {
                serverAnswer = "La sucursal se actualizó correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al actualizar la sucursal";
        }

        return serverAnswer;
    }

    @Override
    public String delSucursal(int idSucursal) {
        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE sucursal SET "
                    + "estado = ? WHERE idProveedor = ?");

            ps.setBoolean(1, false);
            ps.setInt(2, idSucursal);

            int numAffectedRows = MySqlSingleton.getRows(ps);

            if (numAffectedRows > 0) {
                serverAnswer = "La sucursal ha sido eliminada correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al eliminar la sucursal";
        }

        return serverAnswer;
    }

    @Override
    public ArrayList<Sucursal> getSucursal() {

        ArrayList<Sucursal> listOfSucursal = new ArrayList<>();

        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(""
                    + "SELECT * FROM sucursal");
            
            ResultSet rs = MySqlSingleton.executeStatement(ps);
            Sucursal s;
            while (rs.next()) {
                s = new Sucursal();
                s.setNombre(rs.getString(1));                
                
                listOfSucursal.add(s);
            }

        } catch (Exception e) {
            System.out.println("SQL Error " + e.getMessage());
        }

        return listOfSucursal;
    }
    
}
