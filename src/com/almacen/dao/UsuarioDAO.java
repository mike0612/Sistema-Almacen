package com.almacen.dao;

import com.almacen.model.Usuario;
import java.util.ArrayList;

public interface UsuarioDAO {

    String addUsuario(Usuario newUsuario);

    String updateUsuario(Usuario usuario);

    String delUsuario(int idUsuario);

    ArrayList<Usuario> getUsuario();
}
