/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

import java.util.Objects;

/**
 *
 * @author user-
 */
public class TdaAlumno {
    
    private String legajo, nombre, apellido, calle, ciudad, usuario, claveSiu;
    private int numeroDocumento, numeroCalle, telefono;
    private char tipoDocumento;
    
    //Constructores
    
    public TdaAlumno(char tipoDocumento, int numDocumento, String nombre, String apellido){
        this.numeroDocumento = numDocumento;
        this.nombre = nombre.toUpperCase().trim();
        this.apellido = apellido.toUpperCase().trim();
        this.tipoDocumento = Character.toUpperCase(tipoDocumento);
        this.legajo = generarLegajo();//Generado por el TDA
        this.usuario = String.valueOf(numDocumento);//Inicialmente el usuario es el numero de documento
        this.claveSiu = String.valueOf(numDocumento);//Inicialmente la clave es el numero de documento
        this.calle = "n/a";
        this.numeroCalle = -1;
        this.telefono = -1;
        this.ciudad = "n/a";
        
    }
    
    //Observadoras

    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public int getTelefono() {
        return telefono;
    }

    public char getTipoDocumento() {
        return tipoDocumento;
    }

    @Override
    public boolean equals(Object obj) {
        //Metodo hecho por Java
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TdaAlumno other = (TdaAlumno) obj;
        if (this.numeroDocumento != other.numeroDocumento) {
            return false;
        }
        if (this.numeroCalle != other.numeroCalle) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (this.tipoDocumento != other.tipoDocumento) {
            return false;
        }
        if (!Objects.equals(this.legajo, other.legajo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.claveSiu, other.claveSiu)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //Metodo hecho por Java, editado
        return "\nTdaAlumno{" + "\nlegajo=" + legajo + "\nnombre=" + nombre + "\napellido=" + apellido + "\ncalle=" + calle + "\nciudad=" + ciudad + "\nusuario=" + usuario + "\nclaveSiu=" + claveSiu + "\nnumeroDocumento=" + numeroDocumento + "\nnumeroCalle=" + numeroCalle + "\ntelefono=" + telefono + "\ntipoDocumento=" + tipoDocumento + '}';
    }
    
    //Modificadores

    //(Los atributos solo deberian poder cambiarse si se verifica la clave)

    public void setLegajo(String legajo) {
        this.legajo = legajo; //DEBUG
    }

    //Propios del tipo
    
    private String generarLegajo(){
        //Genera un legajo aleatoriamente y lo retorna
        String legajo;
        int numero = (int)(Math.random()*1000);
        
        legajo = "FAI-"+String.valueOf(numero);
        return legajo;
    }
    
    public boolean cambiarClaveSiu(String claveSiuOld,String claveSiuNew){
        /**Cambia la clave si se demuestra que se conoce la clave actual,
         * retorna true si el cambio es exitoso, false en caso contrario
         */
        boolean cambio = false;
        
        if(this.claveSiu.equals(claveSiuOld)){
            this.claveSiu = claveSiuNew;
            cambio = true;
        }
        return cambio;
    }
    
    public boolean cambiarNombreYApellido(String nombre, String apellido, String claveSiu){
        /**Cambia nombre y apellido si se demuestra que se conoce la clave actual,
         * retorna true si el cambio es exitoso, false en caso contrario
         */
        boolean cambio = false;
        
        if(this.claveSiu.equals(claveSiu)){
            this.nombre = nombre.toUpperCase().trim();
            this.apellido = apellido.toUpperCase().trim();
            cambio = true;
        }
        return cambio;
    }
    
    public boolean cambiarUsuario(String usuario,String claveSiu){
        /**Cambia la clave si se demuestra que se conoce la clave actual,
         * retorna true si el cambio es exitoso, false en caso contrario
         */
        boolean cambio = false;
        
        if(this.claveSiu.equals(claveSiu)){
            this.usuario = usuario.trim();
            cambio = true;
        }
        return cambio;
    }
    
    public boolean cambiarCalleYNumeroCalle(String calle, int numCalle, String claveSiu){
        /**Cambia la calle y numero de calle si se demuestra que se conoce la clave actual,
         * retorna true si el cambio es exitoso, false en caso contrario
         */
        boolean cambio = false;
        
        if(this.claveSiu.equals(claveSiu)){
            this.calle = calle.toUpperCase().trim();
            this.numeroCalle = numCalle;
            cambio = true;
        }
        return cambio;
    }
    
    public boolean cambiarCiudad(String ciudad,String claveSiu){
        /**Cambia la ciudad si se demuestra que se conoce la clave actual,
         * retorna true si el cambio es exitoso, false en caso contrario
         */
        boolean cambio = false;
        
        if(this.claveSiu.equals(claveSiu)){
            this.ciudad = ciudad.toUpperCase().trim();
            cambio = true;
        }
        return cambio;
    }
    
    public boolean cambiarDocumentoYTipo(char tipoDoc,int numDocumento, String claveSiu){
        /**Cambia el documento y su tipo si se demuestra que se conoce la clave actual,
         * retorna true si el cambio es exitoso, false en caso contrario
         */
        boolean cambio = false;
        
        if(this.claveSiu.equals(claveSiu)){
            this.numeroDocumento = numDocumento;
            this.tipoDocumento = Character.toUpperCase(tipoDoc);
            cambio = true;
        }
        return cambio;
    }
    
    public boolean cambiarNumeroTelefono(int numTelefono, String claveSiu){
        /**Cambia el numero de telefono si se demuestra que se conoce la clave actual,
         * retorna true si el cambio es exitoso, false en caso contrario
         */
        boolean cambio = false;
        
        if(this.claveSiu.equals(claveSiu)){
            this.telefono = numTelefono;
            cambio = true;
        }
        return cambio;
    }
    

    
    
    

    
    
    
    
}
