/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Dao;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Roles;
import com.biblioteca.entities.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author juana
 */
public class UsuarioDao {
    Conexion conn= new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public UsuarioDao(Conexion conn) {
    }
    
    public List<Usuarios> listar(){
    String sql="SELECT * FROM usuarios as u join roles as r on r.id_rol=u.id_rol";
    List<Usuarios> lista= new LinkedList<>();
        try {
            ps=conn.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            Usuarios u= new Usuarios();
            u.setIdUsuario(rs.getInt(1));
            u.setUsuario(rs.getString(2));
            u.setPass(rs.getString(3));
            Roles r= new Roles();
            r.setIdRol(rs.getInt(5));
            r.setRol(rs.getString(6));
            u.setIdRol(r);
            lista.add(u);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("el sql es "+ps);
            System.out.println("erro listar usuario "+e);
            return null;
        }
        
    }
            
    
}
