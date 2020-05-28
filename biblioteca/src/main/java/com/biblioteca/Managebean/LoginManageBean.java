/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Managebean;

import com.biblioteca.controller.UsuarioLogin;
import com.biblioteca.entities.Usuarios;
import com.biblioteca.utils.Mensaje;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author juana
 */
@ManagedBean
@SessionScoped
public class LoginManageBean extends Mensaje implements Serializable {

    private UsuarioLogin loginController;

    private String usuario = "";

    private String pass = "";

    private String rol = "";
    private int idUsuario = 0;

    private int idRol = 0;

    private Usuarios u = new Usuarios();

    @PostConstruct
    public void init() {
pass = "";
rol = "";
idUsuario = 0;
idRol = 0;
u = new Usuarios();
        loginController = new UsuarioLogin();
        System.out.println("++init++");
    }

    public UsuarioLogin getLoginController() {
        return loginController;
    }

    public void setLoginController(UsuarioLogin loginController) {
        this.loginController = loginController;
    }

    public void login() {
        if (usuario.equals("") || pass.equals("") || usuario == null || pass == null) {
            this.msj("Complete todos los campos.");
        } else {
            try {
                u = loginController.Login(usuario, pass);

                if (u == null) {
                    this.msj("Credenciales incorrectas.");
                    u = new Usuarios();
                } else {
                    this.msj("Bienvenido " + u.getUsuario() + ".");
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", u);
                    if (u.getIdRol().getIdRol() == 1) {
                        u = new Usuarios();
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/biblioteca/faces/bibliotecario/bLibro.xhtml");

                    } else {

                    }
                }

            } catch (Exception e) {

            }
        }
    }

    public void validarUsuario(int perfil) {
        try {
            u = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

            if (u == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/biblioteca/faces/index.xhtml");
            } else {
                if (u.getIdRol().getIdRol() != perfil) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/biblioteca/faces/index.xhtml");
                }
            }

        } catch (Exception e) {
            System.out.println("en el catch ");

        }

    }

    public void salir() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/biblioteca/faces/index.xhtml");
            u = new Usuarios();
            usuario = "";

            pass = "";

            rol = "";
            idUsuario = 0;

            idRol = 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

}
