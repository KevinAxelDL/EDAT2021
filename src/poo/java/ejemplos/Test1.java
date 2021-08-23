/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.java.ejemplos;

/**
 *
 * @author user-
 */
public class Test1 {
    public static  void main(String[]args){
        //Testeo de estructuras de POO en Java para comparar
        System.out.println(piramide());
    }
    
    public static String piramide(){
        //Retorna un string con una piramide
        int x,y;
        String cadena = "";
        
        for(x = 1; x <= 3; x++){
            for(y = 1; y <= x; y++){
                cadena = cadena + "3";
            }
            cadena = cadena + System.lineSeparator();
        }
        for(x = 2; x >= 1; x--){
            for(y = 1; y <= x; y++){
                cadena = cadena + "3";
            }
            cadena = cadena + System.lineSeparator();
        }
        return cadena;
    }
    
}
