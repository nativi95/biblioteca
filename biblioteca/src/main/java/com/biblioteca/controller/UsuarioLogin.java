/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.controller;

import com.biblioteca.Dao.UsuarioDao;
import com.biblioteca.conexion.Conexion;
import com.biblioteca.entities.Usuarios;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author juana
 */
public class UsuarioLogin {
    private Usuarios usuario = new Usuarios();
     Conexion conn= new Conexion();
    private UsuarioDao usuarioDao=new UsuarioDao(conn);
    private List<Usuarios> usuariols;
   

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Usuarios> getUsuariols() {
        usuariols=usuarioDao.listar();
        return usuariols;
    }

    public void setUsuariols(List<Usuarios> usuariols) {
        this.usuariols = usuariols;
    }

    public Usuarios Login(String usuario, String contrasena){
    
        try {
            return usuarioDao.login(usuario, contrasena);
        } catch (Exception e) {
            System.out.println("++erroe n el controller++");
            return null;
        }
        
    }
    
     public Usuarios usuarioById(int id){
    
        try {
            return usuarioDao.usuarioById(id);
        } catch (Exception e) {
            System.out.println("++erroe n el controller++");
            return null;
        }
        
    }
    
}
