/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.entities;

import java.util.Date;


public class Prestamos{

   
    private Integer idPrestamo;
   
    private Date inicio;
   
    private Date devolucion;
   
    private boolean retorno;
  
    private Estudiantes idEstudiante;
   
    private Ejemplares idEjemplar;
   
    private Usuarios idUsuario;

    public Prestamos() {
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Date devolucion) {
        this.devolucion = devolucion;
    }

    public boolean isRetorno() {
        return retorno;
    }

    public void setRetorno(boolean retorno) {
        this.retorno = retorno;
    }

    public Estudiantes getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiantes idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Ejemplares getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Ejemplares idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Prestamos{" + "idPrestamo=" + idPrestamo + ", inicio=" + inicio + ", devolucion=" + devolucion + ", retorno=" + retorno + ", ++Estudiante++=" + idEstudiante.toString() + ", idEjemplar=" + idEjemplar.toString() + ", idUsuario=" + idUsuario.toString() + '}';
    }

    
    
}
