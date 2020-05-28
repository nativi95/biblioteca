/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Dao;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Grados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juana
 */
public class GradoDao {
    
    Conexion conn= new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Grados> listaGrados(){
    List<Grados> lsGrados= new ArrayList<>();
    String sql="SELECT * FROM grados";
        try {
            ps=conn.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            Grados g= new Grados();
            g.setIdGrado(rs.getInt(1));
            g.setGrado(rs.getString(2));
            lsGrados.add(g);
            }
            return lsGrados;
        } catch (Exception e) {
            
            System.out.println("++++++++++++++++++++La sql "+ps);
        return null;
        }
    }
}
