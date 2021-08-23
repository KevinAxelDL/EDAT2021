
package tests.conjuntistas;
import conjuntistas.ArbolHeap;
/**
 *
 * @author user-
 */
public class testArbolHeap {
    public static void main(String[]args){
        //Test de arbol heap minimo
        //El testo funciona correctamente con un arbol de 11 posiciones
        ArbolHeap arbol1 = new ArbolHeap(), arbol2;
        int elemento;
        
        System.out.println("/////TEST ARBOL HEAP MINIMO/////");
        elemento = 7;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = 8;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = 9;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = 10;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = 5;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = 4;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = 1;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = 0;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = 2;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = 8;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        elemento = -1;
        System.out.println("Inserta "+ elemento +": "+ arbol1.insertar(elemento));
        System.out.println(arbol1.toString());
        
        System.out.println("**Se clona el arbol**\n");
        arbol2 = arbol1.clone();
        System.out.println(arbol2.toString());
        
        System.out.println("Se elimina la cima: "+ arbol2.eliminarCima());
        System.out.println("Cima del arbol: "+ arbol2.recuperarCima());
        System.out.println(arbol2.toString());
        
        System.out.println("Se elimina la cima: "+ arbol2.eliminarCima());
        System.out.println("Cima del arbol: "+ arbol2.recuperarCima());
        System.out.println(arbol2.toString());
        
        System.out.println("Se elimina la cima: "+ arbol2.eliminarCima());
        System.out.println("Cima del arbol: "+ arbol2.recuperarCima());
        System.out.println(arbol2.toString());
        
        System.out.println("Se vacia el arbol\n");
        arbol2.vaciar();
        System.out.println(arbol2.toString());
        System.out.println("Se elimina la cima: "+ arbol2.eliminarCima());
    }
    
}
