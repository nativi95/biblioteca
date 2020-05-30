/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Dao;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Ejemplares;
import com.biblioteca.entities.Estados;
import com.biblioteca.entities.Libros;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juana
 */
public class EjemplarDao {

    PreparedStatement ps;
    ResultSet rs;

    Conexion conn;
    LibroDao lDao = new LibroDao();

    public List<Ejemplares> listarEjemplar(int id) {
        String sql = "SELECT * FROM ejemplares as e "
                + "JOIN estados as es on es.id_estado=e.id_estado "
                + "WHERE id_libro=" + id;

        try {
            conn = new Conexion();
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            List<Ejemplares> lsEjemplar = new ArrayList<>();
            Ejemplares e;
            Estados es;
            while (rs.next()) {
                es = new Estados();
                e = new Ejemplares();
                e.setIdEjemplar(rs.getInt(1));
                e.setEdicion(rs.getString(2));
                es.setIdEstado(rs.getInt(5));
                es.setEstado(rs.getString(6));
                e.setIdEstado(es);
                lsEjemplar.add(e);
            }
            conn.desconectar();
            return lsEjemplar;
        } catch (Exception e) {

            return null;
        }

    }

    public Ejemplares verEjemplar(int id) {
        String sql = "SELECT * FROM ejemplares as e "
                + "JOIN estados as es on es.id_estado=e.id_estado "
                + "WHERE id_ejemplar=" + id;
        Ejemplares e = null;
        try {
            conn = new Conexion();
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            List<Ejemplares> lsEjemplar = new ArrayList<>();
            Estados es;
            while (rs.next()) {

                es = new Estados();
                e = new Ejemplares();
                e.setIdEjemplar(rs.getInt(1));
                e.setEdicion(rs.getString(2));
                e.setIdLibro(lDao.verLibro(rs.getInt(3)));
                es.setIdEstado(rs.getInt(5));
                es.setEstado(rs.getString(6));
                e.setIdEstado(es);
                lsEjemplar.add(e);
            }
            conn.desconectar();

            if (!lsEjemplar.isEmpty()) {

                e = lsEjemplar.get(0);
            }

            return e;
        } catch (Exception ex) {

            return null;
        }

    }

}
