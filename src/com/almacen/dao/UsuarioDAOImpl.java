package com.almacen.dao;

import com.almacen.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAOImpl implements UsuarioDAO{

    private String serverAnswer = "";
    private PreparedStatement ps;
    
    @Override
    public String addUsuario(Usuario newUsuario) {
        try {

            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "INSERT INTO usuario ("
                    + "nombre, usuario, contrasena, idSucursal, idTipo)"
                    + "VALUES (?, ?, ?, ?, ?)");

            ps.setString(1, newUsuario.getNombre());
            ps.setString(2, newUsuario.getUsuario());
            ps.setString(3, newUsuario.getContrasena());
            ps.setInt(4, newUsuario.getIdSucursal());
            ps.setInt(5, newUsuario.getIdTipo());

            int numAffectedRows = ps.executeUpdate();

            if (numAffectedRows > 0) {
                serverAnswer = "Usuario registrado correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al registrar el usuario";
        }
        return serverAnswer;
    }

    @Override
    public String updateUsuario(Usuario usuario) {
        try {
            
            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE usuario SET "
                    + "nombre, usuario, contrasena, idSucursal, idTipo)"
                    + "WHERE idUsuario = ?");

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, usuario.getIdSucursal());
            ps.setInt(5, usuario.getIdTipo());

            int numAffectedRows = MySqlSingleton.getRows(ps);

            if (numAffectedRows > 0) {
                serverAnswer = "El usuario se actualizó correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al actualizar el usuario";
        }

        return serverAnswer;
    }

    @Override
    public String delUsuario(int idUsuario) {
        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(
                    "UPDATE usuario SETu "
                    + "estado = ? WHERE idUsuario = ?");

            ps.setBoolean(1, false);
            ps.setInt(2, idUsuario);

            int numAffectedRows = MySqlSingleton.getRows(ps);

            if (numAffectedRows > 0) {
                serverAnswer = "La usuario ha sido eliminado correctamente";
            }

        } catch (Exception e) {
            System.out.println("SQL Error; " + e.getMessage());
            return serverAnswer = "Ocurrió un error al eliminar el usuario";
        }

        return serverAnswer;
    }

    @Override
    public ArrayList<Usuario> getUsuario() {
        ArrayList<Usuario> listOfUsuario = new ArrayList<>();

        try {
            ps = MySqlSingleton.getInstance().conection.prepareStatement(""
                    + "SELECT * FROM usuario");
            
            ResultSet rs = MySqlSingleton.executeStatement(ps);
            Usuario u;
            while (rs.next()) {
                u = new Usuario();
                u.setNombre(rs.getString(1));
                u.setUsuario(rs.getString(2));
                u.setIdTipo(rs.getInt(3));
                u.setIdSucursal(rs.getInt(4));
                u.setStatus(rs.getBoolean(5));
                
                listOfUsuario.add(u);
            }

        } catch (Exception e) {
            System.out.println("SQL Error " + e.getMessage());
        }

        return listOfUsuario;
    }
    
}
