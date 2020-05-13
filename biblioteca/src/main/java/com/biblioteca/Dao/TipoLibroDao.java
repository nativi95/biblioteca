/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Dao;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.TiposLibros;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nativi
 */
public class TipoLibroDao {
    Conexion conn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public TipoLibroDao(Conexion conn) {
    }
    
    public List<TiposLibros> mostrar(){
    String sql="SELECT * FROM tipos_libros";
    List<TiposLibros> lsTipoLibro= new LinkedList<>();
        try {
            ps=conn.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            TiposLibros tl = new TiposLibros();
            tl.setIdTipo(rs.getInt(1));
            tl.setTipo(rs.getString(2));
            lsTipoLibro.add(tl);
            }
        } catch (Exception e) {
            System.out.println("la sql "+ps);
        }
        return lsTipoLibro;
    }
}
