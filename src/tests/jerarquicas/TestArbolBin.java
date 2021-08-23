/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;
import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;

/**
 *
 * @author user-
 */
public class TestArbolBin {
    public static void main(String[]args){
        //Test de TDA arbol binario
        ArbolBin arbol1 = new ArbolBin(), arbol2;
        int x, y;
        System.out.println("/////INICIO TEST/////");
        x = 10; y = -1;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        
        x = -1; y = -1;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        
        x = 1; y = 10;System.out.println("Insertar "+ x +" en "+ y +" como HI: "+ arbol1.insertar(x, y, 'I'));
        x = 2; y = 10;System.out.println("Insertar "+ x +" en "+ y +" como HI: "+ arbol1.insertar(x, y, 'D'));
        
        x = 21; y = 1;System.out.println("Insertar "+ x +" en "+ y +" como HI: "+ arbol1.insertar(x, y, 'I'));
        x = 22; y = 1;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        
        x = 23; y = 2;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        
        x = 11; y = 23;System.out.println("Insertar "+ x +" en "+ y +" como HI: "+ arbol1.insertar(x, y, 'I'));
        
        x = -1; y = -1;System.out.println("Insertar "+ x +" en "+ y +" como HI: "+ arbol1.insertar(x, y, 'I'));
        
        System.out.println(arbol1.toString());
        
        System.out.println("");
        System.out.println("Se realiza una copia del arbol");
        arbol2 = arbol1.clone();
        System.out.println("Se vacia el arbol original");
        arbol1.vaciar();
        System.out.println("");
        
        System.out.println("ORIGINAL:");
        System.out.println(arbol1.toString());
        System.out.println("CLON:");
        System.out.println(arbol2.toString());
        
        System.out.println("");
        System.out.println("Se recupera el arbol original");
        arbol1 = arbol2.clone();
        System.out.println("");
        
        x = 10;System.out.println("Padre de "+ x +": "+arbol1.padre(x));
        x = 11;System.out.println("Padre de "+ x +": "+arbol1.padre(x));
        
        System.out.println("/////verificarPatron/////");
        arbol1.vaciar();
        Lista lista = new Lista();
        
        x = 1; y = 0;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        x = 2; y = 1;System.out.println("Insertar "+ x +" en "+ y +" como HI: "+ arbol1.insertar(x, y, 'I'));
        x = 3; y = 1;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        x = 4; y = 3;System.out.println("Insertar "+ x +" en "+ y +" como HI: "+ arbol1.insertar(x, y, 'I'));
        x = 5; y = 3;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        System.out.println(arbol1.toString());
        x = 1; y = 1;System.out.println("Insertar "+ x +" en "+ y +": "+ lista.insertar(x, y));
        x = 3; y = 2;System.out.println("Insertar "+ x +" en "+ y +": "+ lista.insertar(x, y));
        x = 5; y = 3;System.out.println("Insertar "+ x +" en "+ y +": "+ lista.insertar(x, y));
        System.out.println(lista.toString());
        System.out.println(arbol1.verificarPatron(lista));
        
        arbol1.vaciar();;
        
        x = 1; y = 0;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        x = 2; y = 1;System.out.println("Insertar "+ x +" en "+ y +" como HI: "+ arbol1.insertar(x, y, 'I'));
        x = 3; y = 1;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        x = 4; y = 3;System.out.println("Insertar "+ x +" en "+ y +" como HI: "+ arbol1.insertar(x, y, 'I'));
        x = 5; y = 3;System.out.println("Insertar "+ x +" en "+ y +" como HD: "+ arbol1.insertar(x, y, 'D'));
        System.out.println(arbol1.toString());
        x = 1; y = 1;System.out.println("Insertar "+ x +" en "+ y +": "+ lista.insertar(x, y));
        x = 3; y = 2;System.out.println("Insertar "+ x +" en "+ y +": "+ lista.insertar(x, y));
        x = 5; y = 3;System.out.println("Insertar "+ x +" en "+ y +": "+ lista.insertar(x, y));
        System.out.println(lista.toString());
        System.out.println(arbol1.verificarPatron(lista));
        
        
        
        
        

    }
    
}
