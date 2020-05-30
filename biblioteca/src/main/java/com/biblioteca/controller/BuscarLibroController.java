/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.controller;

import com.biblioteca.Dao.AutorDao;
import com.biblioteca.Dao.EjemplarDao;
import com.biblioteca.Dao.GradoDao;
import com.biblioteca.Dao.LibroDao;
import com.biblioteca.Dao.TipoLibroDao;
import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Autores;
import com.biblioteca.entities.Ejemplares;
import com.biblioteca.entities.Libros;
import com.biblioteca.entities.TiposLibros;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nativi
 */
public class BuscarLibroController implements Serializable {

    
    private LibroDao libroDao = new LibroDao();
    private TipoLibroDao tipoLibroDao = new TipoLibroDao();
    private AutorDao autorDao = new AutorDao();
    private EjemplarDao ejemplarDao=new EjemplarDao();
   

    private Libros libro = new Libros();
    private List<Libros> lsLibro;

    private Autores autor = new Autores();
    private List<Autores> lsAutor;

    private TiposLibros tipoLibro = new TiposLibros();
    private List<TiposLibros> lsTipoLibros;
    
    private Ejemplares ejemplar= new Ejemplares();
    
    private List<Ejemplares> lsEjemplar= new ArrayList<>();

    public Ejemplares getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplares ejemplar) {
        this.ejemplar = ejemplar;
    }

    
    
    public List<Ejemplares> getLsEjemplar() {
        return lsEjemplar;
    }

    public void setLsEjemplar(List<Ejemplares> lsEjemplar) {
        this.lsEjemplar = lsEjemplar;
    }

    
    public Libros getLibro() {

        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public List<Libros> getLsLibro() {

        return this.lsLibro;

    }

    public void setLsLibro(List<Libros> lsLibro) {
        this.lsLibro = lsLibro;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public List<Autores> getLsAutor() {
        return lsAutor;
    }

    public void setLsAutor(List<Autores> lsAutor) {
        this.lsAutor = lsAutor;
    }

    public TiposLibros getTipoLibro() {
         
        return tipoLibro;
    }

    public void setTipoLibro(TiposLibros tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    public List<TiposLibros> getLsTipoLibros() {
        this.lsTipoLibros = this.tipoLibroDao.mostrar();
        return lsTipoLibros;
    }

    public void setLsTipoLibros(List<TiposLibros> lsTipoLibros) {
        this.lsTipoLibros = lsTipoLibros;
    }

    public void buscarLibro(String titulo, String nombre, String apellido, int tipo) {
        try {
           

             lsLibro= this.libroDao.buscarTitulo(titulo, tipo, nombre, apellido);

        } catch (Exception e) {
         

            throw e;
        }

    }
    
    public void verLibro(int id){
    
        try {
            this.libro=libroDao.verLibro(id);
        } catch (Exception e) {
            throw e;
        }
            
    }
    
    public void ListaEjemplares(int id){
    
     try {
            lsEjemplar= this.ejemplarDao.listarEjemplar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
     public List<Libros> top(){
    
        try {
            return libroDao.top();
        } catch (Exception e) {
            return null;
        }
            
    }
     
     public void verEjemplares(int id){
    
     try {
           this.ejemplar= this.ejemplarDao.verEjemplar(id);
        } catch (Exception e) {
            throw e;
        }
    }

}
