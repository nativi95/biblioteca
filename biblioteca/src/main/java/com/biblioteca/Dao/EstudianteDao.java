/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Dao;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Ejemplares;
import com.biblioteca.entities.Estudiantes;
import com.biblioteca.entities.Grados;
import com.biblioteca.entities.Libros;
import com.biblioteca.entities.Prestamos;
import com.biblioteca.entities.Turnos;
import com.biblioteca.entities.Usuarios;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juana
 */
public class EstudianteDao {

    Conexion conn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    CallableStatement sp;

    public List<Estudiantes> buscar(String nombre, String apellido, int grado, int turno) {
        List<Estudiantes> lsEstudiante = new ArrayList<>();
        String sql = "SELECT DISTINCT * FROM estudiantes as e "
                + " JOIN grados as g on g.id_grado= e.id_grado "
                + " JOIN turnos as t on t.id_turno=g.id_turno "
                + " WHERE ";
        if (!nombre.equals(" ")) {
            sql = sql + " e.nombres like '%" + nombre + "%' ";
        }
        if (!apellido.equals(" ")) {

            if (!nombre.equals(" ")) {
                sql = sql + " AND e.apellidos like '%" + apellido + "%' ";
            } else {
                sql = sql + " e.apellidos like '%" + apellido + "%' ";
            }
        }
        if (turno != 0) {

            if (!nombre.equals(" ") || !apellido.equals(" ")) {

                sql = sql + " AND t.id_turno= " + turno + " ";
            } else {

                sql = sql + " t.id_turno= " + turno + " ";
            }
        }
        if (grado != 0) {
            if (!nombre.equals(" ") || !apellido.equals(" ") || turno != 0) {

                sql = sql + " AND g.id_grado= " + grado;
            } else {
                sql = sql + " g.id_grado= " + grado;

            }
        }
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiantes e = new Estudiantes();
                Grados g = new Grados();
                Turnos t = new Turnos();
                Prestamos p = new Prestamos();
                e.setIdEstudiante(rs.getInt(1));
                e.setNombres(rs.getString(2));
                e.setApellidos(rs.getString(3));
                g.setIdGrado(rs.getInt(5));
                g.setGrado(rs.getString(6));
                t.setIdTurno(rs.getInt(8));
                t.setTurno(rs.getString(9));

                g.setIdTurno(t);
                e.setIdGrado(g);
                lsEstudiante.add(e);
            }

            return lsEstudiante;
        } catch (Exception e) {
            System.out.println("try");
            return null;
        }
    }

    public List<Prestamos> verEstudiantes(int id) {
        List<Prestamos> lsPrestamo = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes as e "
                + " JOIN grados as g on g.id_grado= e.id_grado "
                + " JOIN turnos as t on t.id_turno=g.id_turno "
                + " LEFT JOIN prestamos as p on p.id_estudiante=e.id_estudiante "
                + " LEFT JOIN usuarios as u on p.id_usuario=u.id_usuario "
                + " LEFT JOIN ejemplares as ej on p.id_ejemplar=ej.id_ejemplar "
                + " LEFT JOIN libros as l on l.id_libro=ej.id_libro "
                + " WHERE "
                + " e.id_estudiante=" + id;
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiantes e = new Estudiantes();
                Grados g = new Grados();
                Turnos t = new Turnos();
                Prestamos p = new Prestamos();
                Usuarios u = new Usuarios();
                Ejemplares ej = new Ejemplares();
                Libros l = new Libros();
                e.setIdEstudiante(rs.getInt(1));
                e.setNombres(rs.getString(2));
                e.setApellidos(rs.getString(3));
                g.setIdGrado(rs.getInt(5));
                g.setGrado(rs.getString(6));
                t.setIdTurno(rs.getInt(8));
                t.setTurno(rs.getString(9));
                p.setIdPrestamo(rs.getInt(10));
                p.setInicio(rs.getDate(12));
                p.setDevolucion(rs.getDate(13));
                p.setRetorno(rs.getBoolean(14));
                u.setUsuario(rs.getString(18));
                ej.setIdEjemplar(rs.getInt(21));
                ej.setEdicion(rs.getString(22));
                l.setIdLibro(rs.getInt(23));
                l.setTitulo(rs.getString(26));
                ej.setIdLibro(l);
                g.setIdTurno(t);
                e.setIdGrado(g);
                p.setIdEstudiante(e);
                p.setIdUsuario(u);
                p.setIdEjemplar(ej);
                lsPrestamo.add(p);
            }

            return lsPrestamo;
        } catch (Exception e) {

            return null;
        }
    }

    public List<Prestamos> condicional(int id) {
        List<Prestamos> lsPrestamo = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes as e "
                + " JOIN grados as g on g.id_grado= e.id_grado "
                + " JOIN turnos as t on t.id_turno=g.id_turno "
                + " LEFT JOIN prestamos as p on p.id_estudiante=e.id_estudiante "
                + " LEFT JOIN usuarios as u on p.id_usuario=u.id_usuario "
                + " LEFT JOIN ejemplares as ej on p.id_ejemplar=ej.id_ejemplar "
                + " WHERE "
                + " e.id_estudiante=" + id
                + " AND p.retorno=1";

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiantes e = new Estudiantes();
                Grados g = new Grados();
                Turnos t = new Turnos();
                Prestamos p = new Prestamos();
                Usuarios u = new Usuarios();
                Ejemplares ej = new Ejemplares();
                Libros l = new Libros();
                e.setIdEstudiante(rs.getInt(1));
                e.setNombres(rs.getString(2));
                e.setApellidos(rs.getString(3));
                g.setIdGrado(rs.getInt(5));
                g.setGrado(rs.getString(6));
                t.setIdTurno(rs.getInt(8));
                t.setTurno(rs.getString(9));
                p.setIdPrestamo(rs.getInt(10));
                p.setInicio(rs.getDate(12));
                p.setDevolucion(rs.getDate(13));
                p.setRetorno(rs.getBoolean(14));
                u.setUsuario(rs.getString(18));
                ej.setIdEjemplar(rs.getInt(21));
                ej.setEdicion(rs.getString(22));
                l.setIdLibro(rs.getInt(23));
                ej.setIdLibro(l);
                g.setIdTurno(t);
                e.setIdGrado(g);
                p.setIdEstudiante(e);
                p.setIdUsuario(u);
                lsPrestamo.add(p);
            }

            return lsPrestamo;
        } catch (Exception e) {

            return null;
        }
    }

}
