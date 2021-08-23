/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.repaso;
import repaso.TdaFecha;

/**
 *
 * @author user-
 */
public class TestingTdaFecha {
    public static void main(String[] arg){
        /**Test de la clase TdaFecha**/
        int dia, mes, anio;
        TdaFecha fecha;
        
        dia = 1;
        mes = 1;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println(fecha.toString());
        System.out.println(fecha.getFecha());
        System.out.println("Ingresado:");
        System.out.println("Dia:"+dia+" Mes:"+mes+" Anio:"+anio);
        System.out.println("----------");
        
        dia = 31;
        mes = 12;
        anio = 9999;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println(fecha.toString());
        System.out.println(fecha.getFecha());
        System.out.println("Ingresado:");
        System.out.println("Dia:"+dia+" Mes:"+mes+" Anio:"+anio);
        System.out.println("----------");
        
        dia = 29;
        mes = 2;
        anio = 2024;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println(fecha.toString());
        System.out.println(fecha.getFecha());
        System.out.println("Ingresado:");
        System.out.println("Dia:"+dia+" Mes:"+mes+" Anio:"+anio);
        System.out.println("----------");
        
        System.out.println("-----CASOS NO VALIDOS-----");
        
        dia = 0;
        mes = 1;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println(fecha.toString());
        System.out.println(fecha.getFecha());
        System.out.println("Ingresado:");
        System.out.println("Dia:"+dia+" Mes:"+mes+" Anio:"+anio);
        System.out.println("----------");
        
        dia = 1;
        mes = 0;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println(fecha.toString());
        System.out.println(fecha.getFecha());
        System.out.println("Ingresado:");
        System.out.println("Dia:"+dia+" Mes:"+mes+" Anio:"+anio);
        System.out.println("----------");
        
        dia = 1;
        mes = 1;
        anio = 0;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println(fecha.toString());
        System.out.println(fecha.getFecha());
        System.out.println("Ingresado:");
        System.out.println("Dia:"+dia+" Mes:"+mes+" Anio:"+anio);
        System.out.println("----------");
        
        dia = 31;
        mes = 4;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println(fecha.toString());
        System.out.println(fecha.getFecha());
        System.out.println("Ingresado:");
        System.out.println("Dia:"+dia+" Mes:"+mes+" Anio:"+anio);
        System.out.println("----------");
        
        dia = 30;
        mes = 2;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println(fecha.toString());
        System.out.println(fecha.getFecha());
        System.out.println("Ingresado:");
        System.out.println("Dia:"+dia+" Mes:"+mes+" Anio:"+anio);
        System.out.println("----------");
        
        dia = 29;
        mes = 2;
        anio = 2021;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println(fecha.toString());
        System.out.println(fecha.getFecha());
        System.out.println("Ingresado:");
        System.out.println("Dia:"+dia+" Mes:"+mes+" Anio:"+anio);
        System.out.println("----------");
        
    }
}
