/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.Managebean;

import com.biblioteca.controller.BuscarLibroController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;


/**
 *
 * @author nativi
 */
@SessionScoped
@ManagedBean

public class BuscarManageBean implements Serializable{
    
    private BuscarLibroController buscarLibroController;
  
    

    public BuscarLibroController getBuscarLibroController() {
        return buscarLibroController;
    }

    public void setBuscarLibroController(BuscarLibroController buscarLibroController) {
        this.buscarLibroController = buscarLibroController;
    }
       
    @PostConstruct
    public void init(){
    buscarLibroController = new BuscarLibroController();
   
    }
    
}
