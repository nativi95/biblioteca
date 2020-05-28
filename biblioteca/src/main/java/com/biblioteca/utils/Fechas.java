/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juana
 */
public class Fechas {

    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    public String fechaToString(Date fecha) {
        return formato.format(fecha);
    }

    public Date stringToFecha(String fecha) {
        try {
            return formato.parse(fecha);
        } catch (Exception e) {
            return null;
        }

    }

    public String formateoString(String fecha) {
        try {
            fecha = formato.format(formato.parse(fecha));
        } catch (Exception e) {
        }

        return fecha;
    }

    public Date formateoDate(Date fecha) {
        try {
            fecha = formato.parse(formato.format(fecha));
        } catch (Exception e) {
        }

        return fecha;
    }

    public String agregarDias(String fecha, int i) {
        try {
            if (i != 0) {
                i = Integer.parseInt(fecha.substring(8, 10)) + i;
                fecha = fecha.substring(0, 8) + i;
            }
        } catch (Exception e) {
        }
        return fecha;
    }
}
