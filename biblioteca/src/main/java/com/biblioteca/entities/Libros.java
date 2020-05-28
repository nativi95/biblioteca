/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author juana
 */

public class Libros{

   
    private Integer idLibro;
  
    private String titulo;
    
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
   
    private TiposLibros idTipo;
    
    private List<Autores> lsAutor;

    public List<Autores> getLsAutor() {
        return lsAutor;
    }

    public void setLsAutor(List<Autores> lsAutor) {
        this.lsAutor = lsAutor;
    }
    
    
 
    public Libros() {
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TiposLibros getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TiposLibros idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public String toString() {
        return "Libros{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", idTipo=" + idTipo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idLibro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libros other = (Libros) obj;
        if (!Objects.equals(this.idLibro, other.idLibro)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
