/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Dao;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Autores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nativi
 */
public class AutorDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;

    public List<Autores> autores(int idLibro) {
        String sql = "SELECT a.id_autor, a.nombre, a.apellido from autores as a"
                + " JOIN autores_libros as al on a.id_autor=al.id_autor"
                + " WHERE al.id_libro=" + idLibro;
        List<Autores> lsAutor = new LinkedList<>();
        try {
            conn = new Conexion();
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            Autores a;
            while (rs.next()) {
                a = new Autores();
                a.setIdAutor(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                lsAutor.add(a);
            }
            conn.desconectar();
        } catch (Exception e) {

        }
        return lsAutor;
    }

}
