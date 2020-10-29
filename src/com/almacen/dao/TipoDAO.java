package com.almacen.dao;

import com.almacen.model.Tipo;
import java.util.ArrayList;

public interface TipoDAO {

    String addTipo(Tipo newTipo);

    String updateTipo(Tipo tipo);

    String delTipo(int idTipo);

    ArrayList<Tipo> getTipo();
}
