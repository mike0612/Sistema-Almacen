package com.almacen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlSingleton {

    
    
    /**
     * Clase para establecer la conexion a la base de datos MySql  
     */
    
    public Connection conection;
    public Statement statement;
    public static MySqlSingleton db;

    private MySqlSingleton() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String server = "jdbc:mysql://localhost/almacen";
            String userName = "root";
            String password = "";

            conection = (com.mysql.jdbc.Connection) DriverManager.getConnection(server, userName, password);

        } catch (SQLException ex) {
            System.out.println("SQL Error" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Drive not found" + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("New instance error" + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("Illegal Access" + ex.getMessage());
        }
    }

    public static MySqlSingleton getInstance() {
        if (db == null) {
            db = new MySqlSingleton();
        }
        return db;
    }

    public static ResultSet executeStatement(PreparedStatement statement) {
        ResultSet result = null;
        try {
            result = statement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public static int getRows(PreparedStatement statement) {
        int rows = 0;
        try {
            rows = statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rows;
    }

    private static class MySqlSingletonHolder {
        private static final MySqlSingleton INSTANCE = new MySqlSingleton();
    }
}
