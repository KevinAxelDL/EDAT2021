
package tests.conjuntistas;
import conjuntistas.ArbolAVL;

/**
 *
 * @author user-
 */
public class testArbolAVL {
    public static void main(String[]args){
        //Test de arbol AVL
        ArbolAVL arbol2, arbol1 = new ArbolAVL();
        System.out.println("/////TEST AVL/////");
        int x, y;
        x= 10;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 9;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 8;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 1;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 1;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 2;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 3;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 6;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 4;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 7;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 5;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 13;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 11;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        x= 12;System.out.println("Se inserta "+ x +":"+arbol1.insertar(x));
        System.out.println("Lista ordenada: "+ arbol1.listar());
        System.out.println("El arbol esta vacio: "+ arbol1.esVacio());
        System.out.println("Lista de altura de los elementos: "+ arbol1.listarAlturaNodos());
        System.out.println(arbol1.toString());
        System.out.println("Se clona el arbol");
        arbol2 = arbol1.clone();
        //
        System.out.println("");
        x= 9;System.out.println("Se ELIMINA "+ x +":"+arbol2.eliminar(x));
        x= 2;System.out.println("Se ELIMINA "+ x +":"+arbol2.eliminar(x));
        x= 8;System.out.println("Se ELIMINA "+ x +":"+arbol2.eliminar(x));
        x= 6;System.out.println("Se ELIMINA "+ x +":"+arbol2.eliminar(x));
        System.out.println("Lista ordenada: "+ arbol2.listar());
        System.out.println("El arbol esta vacio: "+ arbol2.esVacio());
        System.out.println("Lista de altura de los elementos: "+ arbol2.listarAlturaNodos());
        System.out.println(arbol2.toString());
        System.out.println("");
        System.out.println("Se vacia el arbol");
        arbol2.vaciar();
        x= 10;System.out.println("Se inserta "+ x +":"+arbol2.insertar(x));
        x= 10;System.out.println("Se ELIMINA "+ x +":"+arbol2.eliminar(x));
        System.out.println("Lista ordenada: "+ arbol2.listar());
        System.out.println("El arbol esta vacio: "+ arbol2.esVacio());
        System.out.println("Lista de altura de los elementos: "+ arbol2.listarAlturaNodos());
        System.out.println(arbol2.toString());
        System.out.println("");
        System.out.println("Se recupera el arbol original");
        arbol2 = arbol1;
        System.out.println("Lista ordenada: "+ arbol2.listar());
        System.out.println("Minimo elemento: "+ arbol2.minimoElemento());
        System.out.println("Maximo elemento: "+ arbol2.maximoElemento());
        x = 2; y = 10;System.out.println("Elementos entre "+ x +" y "+ y +": "+ arbol2.listarRango(x, y).toString());
        
    }
    
}
