/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Dao;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Libros;
import com.biblioteca.entities.TiposLibros;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author juana
 */
public class LibroDao implements Serializable{

    Conexion conn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public LibroDao(Conexion conn) {
    }

    public List<Libros> buscarTitulo(String titulo, int tipo, String nombre, String apellido) {
        String sql = "SELECT DISTINCT l.id_libro, l.titulo, l.url, t.tipo "
                + "FROM libros as l "
                + "JOIN ejemplares as e on l.id_libro = e.id_libro "
                + "JOIN tipos_libros as t on l.id_tipo=t.id_tipo "
                + "JOIN autores_libros as al on l.id_libro=al.id_libro "
                + "JOIN autores as a on a.id_autor=al.id_autor "
                + "WHERE e.id_libro is not null and e.id_estado=1 " ;
        
        if (titulo != null) {
            sql = sql + "and l.titulo like '%" + titulo + "%' ";
        }
        if(tipo!=0){
        sql = sql + "and l.id_tipo="+tipo+" ";
        }
        if(nombre!=null){
        sql = sql + "or a.nombre like '%"+nombre+"%' ";
        }
        if(nombre!=null){
        sql = sql + "or a.apellido like '%"+apellido+"%' ";
        }
        List<Libros> lsLibro= new LinkedList<>();
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            Libros l= new Libros();
            TiposLibros tl= new TiposLibros();
            l.setIdLibro(rs.getInt(1));
            l.setTitulo(rs.getString(2));
            tl.setTipo(rs.getString(4));
            l.setIdTipo(tl);
            lsLibro.add(l);
            }
            if(lsLibro.isEmpty()){
             System.out.println("el sql es "+ps);}
        } catch (Exception e) {
       
        }
        return lsLibro;
    }

}
