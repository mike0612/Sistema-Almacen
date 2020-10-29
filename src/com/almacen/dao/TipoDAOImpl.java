package com.almacen.dao;

import com.almacen.model.Tipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TipoDAOImpl implements TipoDAO {

    private String serverAnswer = "";
    private PreparedStatement ps;

    @Override
    public String addTipo(Tipo newTipo) {
        try {

            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "INSERT INTO tipo ("
                    + "tipo)"
                    + "VALUES (?)");

            ps.setString(1, newTipo.getTipo());

            int numAffectedRows = ps.executeUpdate();

            if (numAffectedRows > 0) {
                serverAnswer = "Tipo registrado correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al registrar el tipo";
        }
        return serverAnswer;
    }

    @Override
    public String updateTipo(Tipo tipo) {
        try {
            
            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE tipo SET "
                    + "tipo = ?"
                    + "WHERE idtipo = ?");

            ps.setString(1, tipo.getTipo());            

            int numAffectedRows = MySqlSingleton.getRows(ps);

            if (numAffectedRows > 0) {
                serverAnswer = "El tipo se actualizó correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al actualizar el tipo";
        }

        return serverAnswer;
    }

    @Override
    public String delTipo(int idTipo) {
        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE tipo SET "
                    + "estado = ? WHERE idtipo = ?");

            ps.setBoolean(1, false);
            ps.setInt(2, idTipo);

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
    public ArrayList<Tipo> getTipo() {
        ArrayList<Tipo> listOfTipo = new ArrayList<>();

        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(""
                    + "SELECT * FROM tipo");
            
            ResultSet rs = MySqlSingleton.executeStatement(ps);
            Tipo t;
            while (rs.next()) {
                t = new Tipo();
                t.setTipo(rs.getString(1));                
                
                listOfTipo.add(t);
            }

        } catch (Exception e) {
            System.out.println("SQL Error " + e.getMessage());
        }

        return listOfTipo;
    }

}
