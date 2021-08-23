/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import repaso.TdaFecha;
//import lineales.estaticas.Cola;//Para evaluar cola estatica
import lineales.dinamicas.Cola;//Para evaluar cola dinamica
/**
 *
 * @author user-
 */
public class TestCola {
    public static void main(String[]args){
        //Evalua la clase Pila
        Cola cola = new Cola(), colaClon;
        boolean aux = true;
        int contador;
        
        System.out.println("/////INCIO TEST/////");
        System.out.println("Estado de cola: []");
        System.out.println("toString: "+cola.toString());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("vaciar: "+cola.vaciar());
        System.out.println("toString: "+cola.toString());
        System.out.println("----------");
        System.out.println("Estado de cola: []");
        System.out.println("poner(1): "+cola.poner(1));
        System.out.println("poner(2): "+cola.poner(2));
        System.out.println("poner(3): "+cola.poner(3));
        System.out.println("poner(4): "+cola.poner(4));
        System.out.println("poner(5): "+cola.poner(5));
        System.out.println("poner(6): "+cola.poner(6));
        System.out.println("poner(7): "+cola.poner(7));
        System.out.println("poner(8): "+cola.poner(8));
        System.out.println("poner(9): "+cola.poner(9));
        System.out.println("poner(10): "+cola.poner(10));
        System.out.println("poner(11): "+cola.poner(11));
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println("poner(1): "+cola.poner(1));
        System.out.println("poner(2): "+cola.poner(2));
        System.out.println("poner(3): "+cola.poner(3));
        System.out.println("poner(4): "+cola.poner(4));
        System.out.println("poner(5): "+cola.poner(5));
        System.out.println("toString: "+cola.toString());
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("/////CLONE/////");
        colaClon = cola.clone();
        System.out.println("colaClon toString: "+colaClon.toString());
        System.out.println("cola toString: "+cola.toString());
        System.out.println("cola vaciar: "+cola.vaciar());
        System.out.println("colaClon toString: "+colaClon.toString());
        System.out.println("cola toString: "+cola.toString());
        System.out.println("colaClon obtenerFrente: "+colaClon.obtenerFrente());
        System.out.println("cola obtenerFrente: "+cola.obtenerFrente());
        System.out.println("colaClon sacar: "+colaClon.sacar());
        System.out.println("colaClon sacar: "+colaClon.sacar());
        System.out.println("colaClon sacar: "+colaClon.sacar());
        System.out.println("colaClon poner: "+colaClon.poner(1));
        System.out.println("colaClon poner: "+colaClon.poner(1));
        System.out.println("colaClon poner: "+colaClon.poner(1));
        System.out.println("colaClon toString: "+colaClon.toString());
        System.out.println("colaClon obtenerFrente: "+colaClon.obtenerFrente());
        System.out.println("Clona cola vacia:");
        colaClon = cola.clone();
        System.out.println("colaClon toString: "+colaClon.toString());
        System.out.println("cola toString: "+cola.toString());
        System.out.println("/////FIN TEST/////");
        //----------------------------------------------------------------------
        System.out.println("cola vaciar: "+cola.vaciar());
        System.out.println("cola toString: "+cola.toString());
        System.out.println("/////INCIO TEST PILA con String/////");
        System.out.println("poner(pe): "+cola.poner("pe"));
        System.out.println("poner(pi): "+cola.poner("pi"));
        System.out.println("poner(po): "+cola.poner("po"));
        System.out.println("poner(pu): "+cola.poner("pu"));
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("toString: "+cola.toString());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println("/////FIN TEST/////");
        //----------------------------------------------------------------------
        System.out.println("cola vaciar: "+cola.vaciar());
        System.out.println("cola toString: "+cola.toString());
        System.out.println("/////INCIO TEST PILA con TdaFecha/////");
        int dia, mes, anio;
        TdaFecha fecha;
        
        dia = 1;
        mes = 1;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        
        dia = 31;
        mes = 12;
        anio = 9999;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        
        
        dia = 29;
        mes = 2;
        anio = 2024;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        
        
        System.out.println("-----CASOS NO VALIDOS-----");
        
        dia = 0;
        mes = 1;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        
        
        dia = 1;
        mes = 0;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        
        
        dia = 1;
        mes = 1;
        anio = 0;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        
        
        dia = 31;
        mes = 4;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        
        
        dia = 30;
        mes = 2;
        anio = 1;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        
        
        dia = 29;
        mes = 2;
        anio = 2021;
        
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        
        System.out.println("----------");
        
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("sacar: "+cola.sacar());
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        dia = 123;
        mes = 123;
        anio = 123;
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        dia = 12;
        mes = 12;
        anio = 12;
        fecha = new TdaFecha(dia, mes, anio);
        System.out.println("poner ("+dia+"/"+mes+"/"+anio+"): "+cola.poner(fecha));
        System.out.println("toString: "+cola.toString());
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
    }
}