/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.controller;

import com.biblioteca.Dao.AutorDao;
import com.biblioteca.Dao.LibroDao;
import com.biblioteca.Dao.TipoLibroDao;
import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Autores;
import com.biblioteca.entities.Libros;
import com.biblioteca.entities.TiposLibros;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nativi
 */
public class BuscarLibroController implements Serializable {

    Conexion conn = new Conexion();
    private LibroDao libroDao = new LibroDao(conn);
    private TipoLibroDao tipoLibroDao = new TipoLibroDao(conn);
    private AutorDao autorDao = new AutorDao(conn);

    private Libros libro = new Libros();
    private List<Libros> lsLibro = new LinkedList<>();

    private Autores autor = new Autores();
    private List<Autores> lsAutor = new LinkedList<>();

    private TiposLibros tipoLibro = new TiposLibros();
    private List<TiposLibros> lsTipoLibros = new LinkedList<>();

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public List<Libros> getLsLibro() {
        return lsLibro;
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

    public void buscarLibro() {
        try {
            List<Libros> lista=this.libroDao.buscarTitulo(this.libro.getTitulo(), this.tipoLibro.getIdTipo(), this.autor.getNombre(), this.autor.getApellido());
            if(!lista.isEmpty())
       {
           System.out.println("+++++++++++++++Listado de busqueda no es vacio+++++++++++++++++");
            System.out.println("+++++++++++++++primer campo es+++++++++++++++++"+lista.get(0).getTitulo());
       }
            
            this.lsLibro = this.libroDao.buscarTitulo(this.libro.getTitulo(), this.tipoLibro.getIdTipo(), this.autor.getNombre(), this.autor.getApellido());
        } catch (Exception e) {
            System.out.println("++error");
            throw e;
        }

    }

}
