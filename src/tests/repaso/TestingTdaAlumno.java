/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.repaso;
import repaso.TdaAlumno;

/**
 *
 * @author user-
 */
public class TestingTdaAlumno {
    public static void main(String[] args){
        /**Test de la clase TdaAlumno**/
        TdaAlumno alumno, alumno2, alumno3;
                
        System.out.println("/////INICIO/////");
        
        alumno = new TdaAlumno('a',40,"Juan","Pedro");
        System.out.println("-----");
        System.out.println("/////TO STRING/////");
        System.out.println(alumno.toString());
        System.out.println("-----");
        System.out.println("/////CASO MODIFICACION/////");
        System.out.println(alumno.cambiarClaveSiu(String.valueOf(alumno.getNumeroDocumento()), "laClAveDeLsIu"));
        System.out.println(alumno.cambiarCiudad("Neuquen", "laClAveDeLsIu"));
        System.out.println(alumno.cambiarCalleYNumeroCalle("CallePlana", 666, "laClAveDeLsIu"));
        System.out.println(alumno.cambiarDocumentoYTipo('b', 41000000, "laClAveDeLsIu"));
        System.out.println(alumno.cambiarNombreYApellido("pepe", "dolan", "laClAveDeLsIu"));
        System.out.println(alumno.cambiarNumeroTelefono(51978997, "laClAveDeLsIu"));
        System.out.println(alumno.cambiarUsuario("xXxElCapoMasterxXx", "laClAveDeLsIu"));
        System.out.println(alumno.toString());
        System.out.println("-----");
        System.out.println("/////CASO MODIFICACION CON CLAVE ERRONEA/////");
        System.out.println(alumno.cambiarClaveSiu(String.valueOf(alumno.getNumeroDocumento()), String.valueOf(alumno.getNumeroDocumento())));
        System.out.println(alumno.cambiarCiudad("0", String.valueOf(alumno.getNumeroDocumento())));
        System.out.println(alumno.cambiarCalleYNumeroCalle("0", 0, String.valueOf(alumno.getNumeroDocumento())));
        System.out.println(alumno.cambiarDocumentoYTipo('x', 0, String.valueOf(alumno.getNumeroDocumento())));
        System.out.println(alumno.cambiarNombreYApellido("0", "0", String.valueOf(alumno.getNumeroDocumento())));
        System.out.println(alumno.cambiarNumeroTelefono(0, String.valueOf(alumno.getNumeroDocumento())));
        System.out.println(alumno.cambiarUsuario("0", String.valueOf(alumno.getNumeroDocumento())));
        System.out.println(alumno.toString());
        System.out.println("-----");
        System.out.println("/////EQUALS/////");
        alumno2 = new TdaAlumno('a',40,"Juan","Pedro");
        alumno = new TdaAlumno('A',40,"JuAn           ","PeDrO");
        alumno.setLegajo(alumno2.getLegajo());
        System.out.println(alumno.toString());
        System.out.println(alumno2.toString());
        System.out.println(alumno.equals(alumno2));
        alumno2 = new TdaAlumno('a',50,"Juan","Domingo");
        System.out.println(alumno.toString());
        System.out.println(alumno2.toString());
        System.out.println(alumno.equals(alumno2));
        
    }
    
}
