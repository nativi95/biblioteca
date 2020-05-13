/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.entities;

public class Grados{
  
    private Integer idGrado;
  
    private String grado;
   
    private Turnos idTurno;

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public Turnos getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Turnos idTurno) {
        this.idTurno = idTurno;
    }
   
    
}
