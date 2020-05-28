/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author juana
 */
public class Mensaje {
    private String mensaje = "";
    public void mensajes () {
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(this.mensaje, msg);
    }
    public void msj (String x) {
        this.mensaje = x;
        this.mensajes();
    }

}
