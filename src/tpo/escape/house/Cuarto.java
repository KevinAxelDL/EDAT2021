/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo.escape.house;

import java.util.Objects;

/**
 *
 * @author user-
 */
public class Cuarto {
    private String codigo, nombre;
    private int planta, metrosCuadrados;
    private boolean salidaExterior;
    
    private Cuarto(){
        this.nombre = null;
        this.planta = 0;
        this.metrosCuadrados = 0;
        this.salidaExterior = false;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getPlanta() {
        return planta;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public boolean isSalidaExterior() {
        return salidaExterior;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public void setSalidaExterior(boolean salidaExterior) {
        this.salidaExterior = salidaExterior;
    }
    /*
    //EL CODIGO NO SE CAMBIA
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    */

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
        final Cuarto other = (Cuarto) obj;
        if (this.planta != other.planta) {
            return false;
        }
        if (this.metrosCuadrados != other.metrosCuadrados) {
            return false;
        }
        if (this.salidaExterior != other.salidaExterior) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
