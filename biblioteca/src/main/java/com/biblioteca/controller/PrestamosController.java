/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.controller;

import com.biblioteca.Dao.EjemplarDao;
import com.biblioteca.Dao.EstudianteDao;
import com.biblioteca.Dao.GradoDao;
import com.biblioteca.Dao.PrestamoDao;
import com.biblioteca.Dao.TurnosDao;
import com.biblioteca.entities.Ejemplares;
import com.biblioteca.entities.Estudiantes;
import com.biblioteca.entities.Grados;
import com.biblioteca.entities.Prestamos;
import com.biblioteca.entities.Turnos;
import com.biblioteca.utils.Fechas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juana
 */
public class PrestamosController {

    private Fechas f = new Fechas();

    private Ejemplares ejemplar = new Ejemplares();
    private List<Ejemplares> lsEjemplar = new ArrayList<>();
    private EjemplarDao ejemplaresDao;
    private GradoDao gradoDao = new GradoDao();
    private TurnosDao turnoDao = new TurnosDao();
    private PrestamoDao prestamoDao = new PrestamoDao();

    private Prestamos prestamo = new Prestamos();
    private List<Prestamos> lsPrestamos = new ArrayList<>();
    private EstudianteDao alumnosD = new EstudianteDao();

    private List<Turnos> lsTurno = new ArrayList<>();
    private List<Grados> lsGrados = new ArrayList<>();
    private List<Estudiantes> lsEstudiante = new ArrayList<>();

    public List<Prestamos> getLsPrestamos() {
        return lsPrestamos;
    }

    public void setLsPrestamos(List<Prestamos> lsPrestamos) {
        this.lsPrestamos = lsPrestamos;
    }

    public List<Estudiantes> getLsEstudiante() {
        return lsEstudiante;
    }

    public void setLsEstudiante(List<Estudiantes> lsEstudiante) {
        this.lsEstudiante = lsEstudiante;
    }

    public List<Ejemplares> getLsEjemplar() {
        return lsEjemplar;
    }

    public void setLsEjemplar(List<Ejemplares> lsEjemplar) {
        this.lsEjemplar = lsEjemplar;
    }

    public EjemplarDao getEjemplaresDao() {
        return ejemplaresDao;
    }

    public void setEjemplaresDao(EjemplarDao ejemplaresDao) {
        this.ejemplaresDao = ejemplaresDao;
    }

    public Prestamos getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamos prestamo) {
        this.prestamo = prestamo;
    }

    public List<Prestamos> getLsPrestramos() {
        return lsPrestamos;
    }

    public void setLsPrestramos(List<Prestamos> lsPrestramos) {
        this.lsPrestamos = lsPrestramos;
    }

    public List<Turnos> getLsTurno() {
        try {
            if (lsTurno.isEmpty()) {
                lsTurno = turnoDao.listarTurnos();
            }
        } catch (Exception e) {
        }

        return lsTurno;
    }

    public void setLsTurno(List<Turnos> lsTurno) {
        this.lsTurno = lsTurno;
    }

    public List<Grados> getLsGrados() {
        try {
            if (lsGrados.isEmpty()) {
                lsGrados = gradoDao.listaGrados();
            }
        } catch (Exception e) {
        }

        return lsGrados;
    }

    public void setLsGrados(List<Grados> lsGrados) {
        this.lsGrados = lsGrados;
    }

    public int restringible(Date devolucion, boolean confirmacion) {
        try {
            Date hoy = new Date();
            if (f.formateoDate(devolucion).compareTo(f.formateoDate(hoy)) < 0 && confirmacion == true) {
                return 1;
            } else {
                if (f.formateoDate(devolucion).compareTo(f.formateoDate(hoy)) < 0 && confirmacion == false) {

                    return 2;
                } else {
                    if (f.formateoDate(devolucion).compareTo(f.formateoDate(hoy)) >= 0 && confirmacion == false) {

                        return 2;
                    } else {
                        return 3;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("fue 2 de catch");
            return 2;
        }

    }

    public void buscarAlumno(String nom, String ape, int grado, int turno) {
        try {
            lsEstudiante = alumnosD.buscar(nom, ape, grado, turno);
        } catch (Exception e) {
        }
    }

    public void verEstudiante(int id) {

        try {
            lsPrestamos = alumnosD.verEstudiantes(id);
        } catch (Exception e) {
        }

    }

    public void prestar(int pres, int idEs, int idEj, int idU) {
        try {
            Fechas f = new Fechas();
            Date hoy = new Date();
            prestamo = prestamoDao.prestar(idEs, f.agregarDias(f.fechaToString(hoy), pres), idU, idEj);

        } catch (Exception e) {
        }

    }
    
    public void verPrestamo(int id){
            try { 
                lsPrestamos= prestamoDao.verPrestamo(id);
            } catch (Exception e) {
            }
    }
    
    public void retornar(int id){
    prestamoDao.retornar(id);
    }

}
