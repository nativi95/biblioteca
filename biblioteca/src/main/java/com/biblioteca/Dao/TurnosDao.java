/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Dao;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Turnos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juana
 */
public class TurnosDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;

    public List<Turnos> listarTurnos() {
        List<Turnos> lsTurnos = new ArrayList<>();
        String sql = "SELECT * FROM turnos";
        try {
            conn = new Conexion();
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            Turnos  t;
            while (rs.next()) {
                t = new Turnos();
                t.setIdTurno(rs.getInt(1));
                t.setTurno(rs.getString(2));
                lsTurnos.add(t);
            }
            conn.desconectar();
            return lsTurnos;
        } catch (Exception e) {
            System.out.println("+++ el error es "+e);
            return null;
        }

    }

}
