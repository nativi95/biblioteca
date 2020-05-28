/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.entities;


import java.util.List;


/**
 *
 * @author juana
 */

public class Ejemplares{


    private Integer idEjemplar;
   
    private String edicion;
  
    private Libros idLibro;
    
    private Estados idEstado;

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public Libros getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Libros idLibro) {
        this.idLibro = idLibro;
    }

    public Estados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estados idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        return "Ejemplares{" + "idEjemplar=" + idEjemplar + ", edicion=" + edicion + ", idLibro=" + idLibro + ", idEstado=" + idEstado + '}';
    }
   

    
}
