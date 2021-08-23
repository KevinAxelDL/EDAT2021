
package tests.jerarquicas;
import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;
/**
 *
 * @author user-
 */
public class TestArbolGen {
    public static void main(String[]args){
        //Test de arbol generico
        ArbolGen arbol1 = new ArbolGen(), arbol2;
        System.out.println("/////TEST ARBOL GENERICO/////");
        System.out.println("El arbol debe ser:");
        System.out.println("PADRE: 1; HIJOS: 2,3,6\nPADRE: 2; HIJOS: 5\nPADRE: 5; HIJOS: null\nPADRE: 3; HIJOS: null\n"
                + "PADRE: 6; HIJOS: 7\nPADRE: 7; HIJOS: 10,11\nPADRE: 10; HIJOS: null\nPADRE: 11; HIJOS: null");
        System.out.println("-----------");
        int elemento = 1, padre = -1;
        System.out.println("Insertar: "+ elemento +" en padre: "+ padre + " --> "+ arbol1.insertar(elemento, padre) );
        elemento = 6; padre = 1;
        System.out.println("Insertar: "+ elemento +" en padre: "+ padre + " --> "+ arbol1.insertar(elemento, padre) );
        elemento = 3; padre = 1;
        System.out.println("Insertar: "+ elemento +" en padre: "+ padre + " --> "+ arbol1.insertar(elemento, padre) );
        elemento = 2; padre = 1;
        System.out.println("Insertar: "+ elemento +" en padre: "+ padre + " --> "+ arbol1.insertar(elemento, padre) );
        elemento = 5; padre = 2;
        System.out.println("Insertar: "+ elemento +" en padre: "+ padre + " --> "+ arbol1.insertar(elemento, padre) );
        elemento = 7; padre = 6;
        System.out.println("Insertar: "+ elemento +" en padre: "+ padre + " --> "+ arbol1.insertar(elemento, padre) );
        elemento = 11; padre = 7;
        System.out.println("Insertar: "+ elemento +" en padre: "+ padre + " --> "+ arbol1.insertar(elemento, padre) );
        elemento = 10; padre = 7;
        System.out.println("Insertar: "+ elemento +" en padre: "+ padre + " --> "+ arbol1.insertar(elemento, padre) );
        elemento = -1; padre = 0;
        System.out.println("Insertar: "+ elemento +" en padre: "+ padre + " --> "+ arbol1.insertar(elemento, padre) );
        System.out.println("Arbol resultante:\n"+arbol1.toString());
        //
        elemento = 1;
        System.out.println(elemento+" pertenece al arbol: "+ arbol1.pertenece(elemento));
        elemento = 11;
        System.out.println(elemento+" pertenece al arbol: "+ arbol1.pertenece(elemento));
        elemento = 7;
        System.out.println(elemento+" pertenece al arbol: "+ arbol1.pertenece(elemento));
        elemento = -1;
        System.out.println(elemento+" pertenece al arbol: "+ arbol1.pertenece(elemento));
        System.out.println("Es vacio?: "+arbol1.esVacio());
        System.out.println("");//
        elemento = 5;
        System.out.println(elemento+" es hijo de: "+arbol1.padre(elemento));
        elemento = 10;
        System.out.println(elemento+" es hijo de: "+arbol1.padre(elemento));
        elemento = 11;
        System.out.println(elemento+" es hijo de: "+arbol1.padre(elemento));
        elemento = -1;
        System.out.println(elemento+" es hijo de: "+arbol1.padre(elemento));
        System.out.println("");//
        System.out.println("Altura del arbol: "+arbol1.altura());
        System.out.println("Realiza CLON de arbol: ");
        arbol2 = arbol1.clone();
        System.out.println("Arbol CLON: "+arbol2.toString());
        System.out.println("Vacia CLON");
        arbol2.vaciar();
        System.out.println("Es CLON vacio?: "+arbol2.esVacio());
        System.out.println("Altura del CLON: "+arbol2.altura());
        System.out.println("");//
        elemento = -1;
        System.out.println("Ancestros de "+elemento+": "+arbol1.ancestros(elemento));
        elemento = 1;
        System.out.println("Ancestros de "+elemento+": "+arbol1.ancestros(elemento));
        elemento = 11;
        System.out.println("Ancestros de "+elemento+": "+arbol1.ancestros(elemento));
        elemento = 7;
        System.out.println("Ancestros de "+elemento+": "+arbol1.ancestros(elemento));
        System.out.println("");
        elemento = 1;
        System.out.println("Padre de "+elemento+": "+arbol1.padre(elemento));
        elemento = 11;
        System.out.println("Padre de "+elemento+": "+arbol1.padre(elemento));
        elemento = 5;
        System.out.println("Padre de "+elemento+": "+arbol1.padre(elemento));
        System.out.println("");
        System.out.println("Listado en Preorden: "+arbol1.listarPreorden());
        System.out.println("Listado en Inorden: "+arbol1.listarInorden());
        System.out.println("Listado en Posorden: "+arbol1.listarPosorden());
        System.out.println("Listado por Niveles: "+arbol1.listarPorNiveles());
        System.out.println("///// EXTRAS /////");
        Lista camino = new Lista();
        camino.insertar(0,1);
        camino.insertar(2,2);
        camino.insertar(5,3);
        System.out.println("Camino : "+ camino.toString());
        System.out.println("Pertenece al arbol?: "+ arbol1.verificarCamino(camino));
        camino.vaciar();
        
        camino.insertar(1,1);
        camino.insertar(6,2);
        camino.insertar(7,3);
        camino.insertar(11,4);
        System.out.println("Camino : "+ camino.toString());
        System.out.println("Pertenece al arbol?: "+ arbol1.verificarCamino(camino));
        camino.vaciar();
        
        camino.insertar(1,1);
        camino.insertar(6,2);
        camino.insertar(2,3);
        camino.insertar(11,4);
        System.out.println("Camino : "+ camino.toString());
        System.out.println("Pertenece al arbol?: "+ arbol1.verificarCamino(camino));
        camino.vaciar();
  
        
    }
    
}
