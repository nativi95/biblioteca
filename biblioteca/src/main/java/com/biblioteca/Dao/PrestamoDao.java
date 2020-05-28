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
public class PrestamoDao {

    Conexion conn = new Conexion();
    CallableStatement sp;
    ResultSet rs;
    PreparedStatement ps;

    public Prestamos prestar(int i_e, String fecha, int i_u, int i_ej) {
        Prestamos p = new Prestamos();
        String sql = "{CALL SP_prestar(?,?,?,?)}";
        try {
            sp = conn.conectar().prepareCall(sql);
            sp.setInt(1, i_e);
            sp.setString(2, fecha);
            sp.setInt(3, i_u);
            sp.setInt(4, i_ej);
            sp.execute();
            rs = sp.getResultSet();
            while (rs.next()) {
                Estudiantes es = new Estudiantes();
                Grados g = new Grados();
                Turnos t = new Turnos();
                p = new Prestamos();
                Usuarios u = new Usuarios();
                Ejemplares ej = new Ejemplares();
                Libros l = new Libros();
                es.setIdEstudiante(rs.getInt(1));
                es.setNombres(rs.getString(2));
                es.setApellidos(rs.getString(3));
                g.setIdGrado(rs.getInt(5));
                g.setGrado(rs.getString(6));
                t.setIdTurno(rs.getInt(8));
                t.setTurno(rs.getString(9));
                p.setIdPrestamo(rs.getInt(10));
                p.setInicio(rs.getDate(12));
                p.setDevolucion(rs.getDate(13));
                p.setRetorno(rs.getBoolean(14));
                ej.setIdEjemplar(rs.getInt(16));
                ej.setEdicion(rs.getString(18));
                l.setIdLibro(rs.getInt(19));
                ej.setIdLibro(l);
                g.setIdTurno(t);
                es.setIdGrado(g);
                p.setIdEstudiante(es);
                p.setIdUsuario(u);
                p.setIdEjemplar(ej);
            }
            return p;
        } catch (Exception e) {
            System.out.println("carcth" + e);
            return null;
        }
    }

    public List<Prestamos> verPrestamo(int id) {
        List<Prestamos> lsPrestamo = new ArrayList<>();
        String sql = "SELECT DISTINCT * FROM estudiantes as e "
                + "                JOIN grados as g on g.id_grado= e.id_grado "
                + "                JOIN turnos as t on t.id_turno=g.id_turno "
                + "                JOIN prestamos as p on p.id_estudiante=e.id_estudiante "
                + "                JOIN ejemplares as ej on ej.id_ejemplar=p.id_ejemplar "
                + "                JOIN libros as l on ej.id_libro=l.id_libro"
                + "                JOIN usuarios as u on u.id_usuario=p.id_usuario"
                + "                WHERE "
                + "                p.id_prestamo=" + id;
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            LibroDao eDao= new LibroDao(conn); 
            while (rs.next()) {
                Estudiantes es = new Estudiantes();
                
                Grados g = new Grados();
                Turnos t = new Turnos();
                Prestamos p = new Prestamos();
                Usuarios u = new Usuarios();
                Ejemplares ej = new Ejemplares();
                Libros l = new Libros();
                es.setIdEstudiante(rs.getInt(1));
                es.setNombres(rs.getString(2));
                es.setApellidos(rs.getString(3));
                g.setIdGrado(rs.getInt(5));
                g.setGrado(rs.getString(6));
                t.setIdTurno(rs.getInt(8));
                t.setTurno(rs.getString(9));
                p.setIdPrestamo(rs.getInt(10));
                p.setInicio(rs.getDate(12));
                p.setDevolucion(rs.getDate(13));
                p.setRetorno(rs.getBoolean(14));
                ej.setIdEjemplar(rs.getInt(16));
                ej.setEdicion(rs.getString(18));
                l=eDao.verLibro(rs.getInt(19));
                u.setIdUsuario(rs.getInt(25));
                u.setUsuario(rs.getString(26));
                ej.setIdLibro(l);
                g.setIdTurno(t);
                es.setIdGrado(g);
                p.setIdEstudiante(es);
                p.setIdUsuario(u);
                p.setIdEjemplar(ej);
                lsPrestamo.add(p);
            }
            return lsPrestamo;
        } catch (Exception e) {
            System.out.println("carcth" + e);
            return null;
        }
    }

    public void retornar(int id) {
        Prestamos p = new Prestamos();
        String sql = "{CALL SP_devolver(" + id + ")}";
         System.out.println("la sql"+ps);
        try {
            sp=conn.conectar().prepareCall(sql);
            sp.executeUpdate();
           
        } catch (Exception e) {
            System.out.println("carcth" + e);
        }
    }

}
