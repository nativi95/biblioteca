/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juana
 */
public class Conexion {

    private static String user = "root";
    private static String password = "root";
    private static String db = "db_biblioteca";
    private static String url = "jdbc:mysql://localhost:3306/db_biblioteca?useSSL=false";

    private Connection conn;

    public Conexion() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (Exception e) {
            System.out.println("Error de conexion ===" + e);
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() throws Exception {
        conn.close();
    }

}
