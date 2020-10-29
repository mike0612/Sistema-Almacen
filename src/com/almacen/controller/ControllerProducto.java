package com.almacen.controller;

import com.almacen.dao.ProductoDAOImpl;
import com.almacen.dao.ProveedorDAOImpl;
import com.almacen.model.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControllerProducto {

    private String mensaje = "";
    private ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
    private ProveedorDAOImpl proveedorDAOImpl = new ProveedorDAOImpl();

    public String addProducto(String codigo, String nombre, Double precio, 
            int stock, int idProveedor) {
        
        Producto newProducto = new Producto(codigo, nombre, precio, stock, idProveedor);
        mensaje = productoDAOImpl.addProducto(newProducto);
        return mensaje;
    }

    public String updateProducto() {
        return mensaje;
    }

    public void fillTable(JTable tblProducto) {
        DefaultTableModel model = new DefaultTableModel();
        tblProducto.setModel(model);

        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Stock");
        model.addColumn("Proveedor");

        Object[] column = new Object[5];
        ArrayList<Producto> productos = productoDAOImpl.getProducto();

        int numOfRow = productos.size();

        for (int i = 0; i < numOfRow; i++) {
            column[0] = productos.get(i).getCodigo();
            column[1] = productos.get(i).getNombre();
            column[2] = productos.get(i).getPrecio();
            column[3] = productos.get(i).getStock();
            column[4] = productos.get(i).getIdProveedor();

            model.addRow(column);
        }
                
    }
    
    public void viewProveedor(JComboBox cbxProveedor) {
        List<String> proveedor = proveedorDAOImpl.getProveedor()
            .stream()
            .map(p -> String.valueOf(p.getIdProveedor()) + "   " + p.getNombre())
            .collect(Collectors.toList());
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("-- Seleccionar --");
        proveedor.forEach(pl -> model.addElement(pl));
        
        cbxProveedor.setModel(model);
    }
    
    public void searchProveedor(JComboBox cbxProveedor, String elemento){
        for (int i = 0; i < cbxProveedor.getItemCount(); i++) {
            if (String.valueOf(cbxProveedor.getItemAt(i)).contains(elemento)) {
                cbxProveedor.setSelectedIndex(i);
            }
        }
    }

}
