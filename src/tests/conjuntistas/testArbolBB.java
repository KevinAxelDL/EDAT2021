
package tests.conjuntistas;
import conjuntistas.ArbolBB;
import lineales.dinamicas.Lista;

/**
 *
 * @author user-
 */
public class testArbolBB {
    public static void main(String[]args){
        //Test de TDA arbol binario
        int x,y;
        ArbolBB arbol1 = new ArbolBB(), arbol2;
        System.out.println("/////TEST ABB /////");
        x = 5; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 5; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 4; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 0; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 3; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 8; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 6; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 9; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 7; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 10; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 8; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 6; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        x = 9; System.out.println("Se inserta "+ x +":"+ arbol1.insertar(x));
        System.out.println(arbol1.toString());
        x = 10; System.out.println(x +" pertenece?: "+ arbol1.pertenece(x));
        x = 5; System.out.println(x +" pertenece?: "+ arbol1.pertenece(x));
        x = -1; System.out.println(x +" pertenece?: "+ arbol1.pertenece(x));
        x = 8; System.out.println(x +" pertenece?: "+ arbol1.pertenece(x));
        x = 7; System.out.println(x +" pertenece?: "+ arbol1.pertenece(x));
        x = 6; System.out.println(x +" pertenece?: "+ arbol1.pertenece(x));
        System.out.println("El menor elemento es: "+ arbol1.minimoElemento());
        System.out.println("El mayor elemento es: "+ arbol1.maximoElemento());
        System.out.println("Lista ordernada: "+ arbol1.listar().toString());
        
        x = 0; y = 9; System.out.println("Lista con rango de " + x + " a " + y +": "+ arbol1.listarRango(x, y));
        x = 3; y = 4; System.out.println("Lista con rango de " + x + " a " + y +": "+ arbol1.listarRango(x, y));
        x = 7; y = 9; System.out.println("Lista con rango de " + x + " a " + y +": "+ arbol1.listarRango(x, y));
        x = 10; y = 0; System.out.println("Lista con rango de " + x + " a " + y +": "+ arbol1.listarRango(x, y));
        
        System.out.println("Se clona el arbol actual");
        arbol2 = arbol1.clone();
        System.out.println(arbol2.toString());
        
        System.out.println("/////Test Eliminar/////");
        x = -1; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        x = 4; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        x = 3; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        x = 8; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        x = 9; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        x = 6; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        x = 5; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        x = 0; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        x = 7; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        System.out.println("El menor elemento es: "+ arbol2.minimoElemento());
        System.out.println("El mayor elemento es: "+ arbol2.maximoElemento());
        x = 10; System.out.println("Se elimina "+ x +": "+ arbol2.eliminar(x));
        
        System.out.println(arbol2.toString());
        
        System.out.println("///// EXTRAS /////");
        System.out.println("Se recupera el arbol");
        arbol2 = arbol1.clone();
        System.out.println("METODO: eliminarMinimo");
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println(arbol2.listar());
        System.out.println("Se elimina el minimo elemento: "+ arbol2.eliminarMinimo());
        System.out.println("Se recupera el arbol");
        arbol2 = arbol1.clone();
        System.out.println("METODO: listarMayorIgual");
        y = 5;
        System.out.println("Elemento "+ y +": "+arbol2.listarMayorIgual(y));
        System.out.println(arbol2.toString());
        System.out.println("");
        y = 3;
        System.out.println("Elemento "+ y +": "+arbol2.listarMayorIgual(y));
        System.out.println(arbol2.toString());
        System.out.println("");
        y = 9;
        System.out.println("Elemento "+ y +": "+arbol2.listarMayorIgual(y));
        System.out.println(arbol2.toString());
        System.out.println("");
        y = 10;
        System.out.println("Elemento "+ y +": "+arbol2.listarMayorIgual(y));
        System.out.println(arbol2.toString());
        y = -1;
        System.out.println("Elemento "+ y +": "+arbol2.listarMayorIgual(y));
    }
    
}
