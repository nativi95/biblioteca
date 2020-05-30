/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Dao;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Roles;
import com.biblioteca.entities.Usuarios;
import com.biblioteca.utils.Encriptacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author juana
 */
public class UsuarioDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    Encriptacion en = new Encriptacion();

    public List<Usuarios> listar() {
        String sql = "SELECT * FROM usuarios as u join roles as r on r.id_rol=u.id_rol";
        List<Usuarios> lista = new LinkedList<>();
        try {
            conn = new Conexion();
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            Usuarios u;
            Roles r;
            while (rs.next()) {
                u = new Usuarios();
                u.setIdUsuario(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setPass(rs.getString(3));
                r = new Roles();
                r.setIdRol(rs.getInt(5));
                r.setRol(rs.getString(6));
                u.setIdRol(r);
                lista.add(u);
            }
            conn.desconectar();
            return lista;
        } catch (Exception e) {
            System.out.println("el sql es " + ps);
            System.out.println("erro listar usuario " + e);
            return null;
        }

    }

    public Usuarios login(String usuario, String contrasena) {
        List<Usuarios> lista = new LinkedList<>();
        String sql = "SELECT * FROM usuarios as u "
                + "JOIN roles as r on r.id_rol=u.id_rol "
                + "WHERE u.usuario='" + usuario + "' "
                + " and u.pass='" + en.encriptar(contrasena) + "'";
        Usuarios u = new Usuarios();
        try {
            conn = new Conexion();
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            Roles r;

            while (rs.next()) {
                u = new Usuarios();
                u.setIdUsuario(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setPass(rs.getString(3));
                r = new Roles();
                r.setIdRol(rs.getInt(5));
                r.setRol(rs.getString(6));
                u.setIdRol(r);
                lista.add(u);
            }
            conn.desconectar();

            if (!lista.isEmpty()) {
                return u;
            } else {

                return null;
            }

        } catch (Exception e) {
            System.out.println("la sql es " + ps);
            return null;
        }
    }

    public Usuarios usuarioById(int id) {

        String sql = "SELECT * FROM usuarios as u "
                + "JOIN roles as r on r.id_rol=u.id_rol "
                + "WHERE u.id_usuario=" + id;
        Usuarios u = new Usuarios();
        try {
            conn = new Conexion();
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            Roles r;
            while (rs.next()) {
                u = new Usuarios();
                u.setIdUsuario(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setPass(rs.getString(3));
                r = new Roles();
                r.setIdRol(rs.getInt(5));
                r.setRol(rs.getString(6));
                u.setIdRol(r);
            }
            conn.desconectar();
            return u;
        } catch (Exception e) {
            System.out.println("la sql es " + ps);
            return null;
        }
    }

}
