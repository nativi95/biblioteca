/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Managebean;

import com.biblioteca.controller.BuscarLibroController;
import com.biblioteca.controller.PrestamosController;
import com.biblioteca.entities.Autores;
import com.biblioteca.entities.Ejemplares;
import com.biblioteca.entities.Estudiantes;
import com.biblioteca.entities.Grados;
import com.biblioteca.entities.Libros;
import com.biblioteca.entities.Prestamos;
import com.biblioteca.entities.Turnos;
import com.biblioteca.entities.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author nativi
 */
@SessionScoped
@ManagedBean

public class BuscarManageBean implements Serializable {

    private BuscarLibroController buscarLibroController;
    private PrestamosController prestamoController;

    private String titulo = "";
    private String nombre = "";
    private String apellido = "";
    private int tipo = 0;
    private String tipoL = "";
    private String url = "";
    private String edicion = "";
    private int idEjemplar = 0;
    private Usuarios u = new Usuarios();
    private int idGrado = 0;
    private int idTurno = 0;
    private String grado = " ";
    private String turno = " ";
    private boolean solvencia;
    private int prestamoT;
    private List<Prestamos> lsPrestamo = new ArrayList<>();
    private List<Grados> lsGrado = new ArrayList<>();
    private List<Turnos> lsTurno = new ArrayList<>();
    private List<Autores> lsAutor = new ArrayList<>();
    private List<Ejemplares> lsEjemplar = new ArrayList<>();
    private List<Libros> lsLibro = new ArrayList<>();
    private Date inicio;
    private Date devolucion;
    private String usuario = "";
    private List<Estudiantes> lsEstudiante = new ArrayList<>();

    @PostConstruct
    public void init() {
        titulo = new String();
        prestamoT = 0;
        nombre = new String();
        apellido = new String();
        tipo = 0;
        tipoL = new String();
        url = new String();
        lsAutor = new ArrayList<>();
        lsEjemplar = new ArrayList<>();
        lsLibro = new ArrayList<>();
        buscarLibroController = new BuscarLibroController();
        prestamoController = new PrestamosController();
        edicion = new String();
        idEjemplar = 0;
        idGrado = 0;
        idTurno = 0;
        lsPrestamo = new ArrayList<>();
        lsGrado = new ArrayList<>();
        lsTurno = new ArrayList<>();
        lsAutor = new ArrayList<>();
        grado = " ";
        turno = " ";
        inicio = new Date();
        devolucion = new Date();
        usuario = "";
        lsEstudiante = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public BuscarLibroController getBuscarLibroController() {
        return buscarLibroController;
    }

    public void setBuscarLibroController(BuscarLibroController buscarLibroController) {
        this.buscarLibroController = buscarLibroController;
    }

    public List<Estudiantes> getLsEstudiant() {
        return lsEstudiante;
    }

    public void setLsEstudiant(List<Estudiantes> lsEstudiante) {
        this.lsEstudiante = lsEstudiante;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isSolvencia() {
        return solvencia;
    }

    public void setSolvencia(boolean solvencia) {
        this.solvencia = solvencia;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Prestamos> getLsPrestamo() {
        lsPrestamo = prestamoController.getLsPrestramos();
        return lsPrestamo;
    }

    public void setLsPrestamo(List<Prestamos> lsPrestamo) {
        this.lsPrestamo = lsPrestamo;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public List<Grados> getLsGrado() {
        try {
            if (lsGrado.isEmpty()) {
                lsGrado = prestamoController.getLsGrados();
            }
        } catch (Exception e) {
        }

        return lsGrado;
    }

    public void setLsGrado(List<Grados> lsGrado) {
        this.lsGrado = lsGrado;
    }

    public List<Turnos> getLsTurno() {
        try {
            if (lsTurno.isEmpty()) {
                lsTurno = prestamoController.getLsTurno();
            }
        } catch (Exception e) {
        }

        return lsTurno;
    }

    public void setLsTurno(List<Turnos> lsTurno) {
        this.lsTurno = lsTurno;
    }

    public String getTipoL() {
        return tipoL;
    }

    public void setTipoL(String tipoL) {
        this.tipoL = tipoL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPrestamoT() {
        return prestamoT;
    }

    public void setPrestamoT(int prestamoT) {
        this.prestamoT = prestamoT;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public List<Ejemplares> getLsEjemplar() {
        return lsEjemplar;
    }

    public void setLsEjemplar(List<Ejemplares> lsEjemplar) {
        this.lsEjemplar = lsEjemplar;
    }

    public List<Autores> getLsAutor() {

        return lsAutor;
    }

    public void setLsAutor(List<Autores> lsAutor) {
        this.lsAutor = lsAutor;
    }

    public List<Libros> getLsLibro() {

        try {
            if (lsLibro.isEmpty()) {
                lsLibro = buscarLibroController.top();
            }
        } catch (Exception e) {
        }

        return lsLibro;
    }

    public void setLsLibro(List<Libros> lsLibro) {
        this.lsLibro = lsLibro;
    }

    public String lsAutorToString(List<Autores> lista) {

        try {
            if (!lista.isEmpty()) {
                String nomApe = "";
                int i = lista.size();
                for (int a = 0; a < i; a++) {
                    nomApe = nomApe + "\n" + lista.get(a).getNombre() + " " + lista.get(a).getApellido();
                }
                return nomApe;
            } else {
                return null;
            }
        } catch (Exception e) {
            return "";
        }

    }

    public void buscarLibros() {
        try {
            this.buscarLibroController.buscarLibro(titulo, nombre, apellido, tipo);
            this.lsLibro = this.buscarLibroController.getLsLibro();
        } catch (Exception e) {

        }

    }

    public String verLibro(int id) {
        try {
            buscarLibroController.ListaEjemplares(id);
            buscarLibroController.verLibro(id);
            this.lsEjemplar = buscarLibroController.getLsEjemplar();
            this.titulo = buscarLibroController.getLibro().getTitulo();
            this.tipoL = buscarLibroController.getLibro().getIdTipo().getTipo();
            this.lsAutor = buscarLibroController.getLibro().getLsAutor();
            this.url = buscarLibroController.getLibro().getUrl();

            u = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

            if (u == null) {
                return "libro.xhtml";
            } else {
                return "/bibliotecario/libro.xhtml";
            }

        } catch (Exception e) {
        }
        return "libro.xhtml";
    }

    public String verEjemplares(int id) {

        try {
            buscarLibroController.verEjemplares(id);
            this.idEjemplar = buscarLibroController.getEjemplar().getIdEjemplar();
            this.titulo = buscarLibroController.getEjemplar().getIdLibro().getTitulo();
            this.edicion = buscarLibroController.getEjemplar().getEdicion();
            this.tipoL = buscarLibroController.getEjemplar().getIdLibro().getIdTipo().getTipo();
            buscarLibroController.verLibro(buscarLibroController.getEjemplar().getIdLibro().getIdLibro());
            lsAutor = buscarLibroController.getLibro().getLsAutor();
            return "/bibliotecario/prestamo.xhtml";

        } catch (Exception e) {
            return null;
        }

    }

    public int restrccion(Date fecha, boolean devolucion) {
        return prestamoController.restringible(fecha, devolucion);
    }

    public void buscarEstudiante() {
        try {
            prestamoController.buscarAlumno(nombre, apellido, idGrado, idTurno);
            lsEstudiante = prestamoController.getLsEstudiante();
        } catch (Exception e) {
        }
    }

    public boolean buscanPrestamo(int id) {

        try {
            prestamoController.verEstudiante(id);
            lsPrestamo = prestamoController.getLsPrestramos();
            if (!lsPrestamo.isEmpty()) {
                List<String> enteros = new ArrayList<>();

                int size = lsPrestamo.size();

                for (int i = 0; i < size; i++) {
                    int elemento = Boolean.valueOf(lsPrestamo.get(i).isRetorno()).compareTo(false);
                    enteros.add(elemento + "");
                }

                if (enteros.contains("1")) {
                    return false;
                } else {
                    return true;
                }

            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }

    }

    public String VerEstudiante(int id) {
        try {
            prestamoController.verEstudiante(id);
            lsPrestamo = prestamoController.getLsPrestramos();
            nombre = lsPrestamo.get(0).getIdEstudiante().getNombres();
            apellido = lsPrestamo.get(0).getIdEstudiante().getApellidos();
            solvencia = buscanPrestamo(id);
            grado = lsPrestamo.get(0).getIdEstudiante().getIdGrado().getGrado();
            turno = lsPrestamo.get(0).getIdEstudiante().getIdGrado().getIdTurno().getTurno();
            return "/bibliotecario/Alumno.xhtml";
        } catch (Exception e) {

            return null;
        }
    }

    public String prestar(int id) {
        String ruta = null;
        try {
            if (!buscanPrestamo(id)) {
                ruta = VerEstudiante(id);

            } else {

                u = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
                prestamoController.prestar(prestamoT, id, idEjemplar, u.getIdUsuario());
                usuario = u.getUsuario();

                nombre = prestamoController.getPrestamo().getIdEstudiante().getNombres();

                apellido = prestamoController.getPrestamo().getIdEstudiante().getApellidos();

                inicio = prestamoController.getPrestamo().getInicio();

                devolucion = prestamoController.getPrestamo().getDevolucion();

                tipo = prestamoController.getPrestamo().getIdPrestamo();

                grado = prestamoController.getPrestamo().getIdEstudiante().getIdGrado().getGrado();

                turno = prestamoController.getPrestamo().getIdEstudiante().getIdGrado().getIdTurno().getTurno();

                ruta = "/bibliotecario/confirmado.xhtml";
            }

        } catch (Exception e) {

        }
        return ruta;
    }

    public String cancelar() {
        try {
            init();
        } catch (Exception e) {
        }
        return "bLibro.xhtml";
    }

    public String retornar(int id) {
        try {
            prestamoController.retornar(id);
            System.out.println("funciono :D");
            return cancelar();
        } catch (Exception e) {
            return null;
        }
    }

    public void verPrestamo() {
        try {
            tipo = Integer.parseInt(grado);

            System.out.println("el tipo es  " + tipo);
            prestamoController.verPrestamo(tipo);
  
            lsPrestamo = prestamoController.getLsPrestamos();
           

        } catch (Exception e) {
            System.out.println("catch++++++");
        }
    }
}
