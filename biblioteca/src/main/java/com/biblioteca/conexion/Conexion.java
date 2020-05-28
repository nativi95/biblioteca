/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author juana
 */
public class Conexion {
    
    static String user="root";
    static String password="root";
    static String db="db_biblioteca";
    static String url="jdbc:mysql://localhost:3306/db_biblioteca?useSSL=false";
    
    private Connection conn;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, password);
            if(conn!=null){
                System.out.println("Conexion exitosa");
            }
        } catch (Exception e) {
            System.out.println("Error de conexion ==="+e);
        }
    }
    
    public Connection conectar(){
    return conn;
    }
    
    public void desconectar() throws Exception{
    conn.close();
    }
    
//    public static void main(String[] args) {
//        Conexion conn = new Conexion();
//    }
}
