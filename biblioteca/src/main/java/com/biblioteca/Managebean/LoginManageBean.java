/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Managebean;

import com.biblioteca.controller.UsuarioLogin;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author juana
 */
@ManagedBean
@SessionScoped
public class LoginManageBean implements Serializable{
    
    private UsuarioLogin loginController;
    
    
    
    @PostConstruct
    public void init(){
    loginController= new UsuarioLogin();
    }

    public UsuarioLogin getLoginController() {
        return loginController;
    }

    public void setLoginController(UsuarioLogin loginController) {
        this.loginController = loginController;
    }
}
