
package tests.lineales;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public class PruebaLista {
    public static void main (String[]args){
        test1();
    }
    
    public static Lista invertir(Lista lista){
        /*
        Recibe una lista L y devuelve una lista nueva con los elementos de L invertidos. Ej: si
        L1=[2,4,6] debe devolver [6,4,2]
        */
        Lista listaClon = lista, newLista = new Lista();
        Cola colaAux = new Cola();
        
        if(!listaClon.esVacia()){
            while(!listaClon.esVacia()){
                //Pone los elementos de la lista en una cola
                colaAux.poner(listaClon.recuperar(1));
                listaClon.eliminar(1);
            }
            while(!colaAux.esVacia()){
                //Pone los elementos de la cola en una lista
                newLista.insertar(colaAux.obtenerFrente(), 1);
                colaAux.sacar();
            }
        }
        return newLista;
    }
    
    public static Lista concatenar(Lista lista1, Lista lista2){
        /*Recibe dos listas L1 y L2 y devuelve una lista nueva con los elementos de L1 y L2 
        *concatenados. Ej: si L1=[2,4,6] y L2=[5,1,6,7] debe devolver [2,4,6,5,1,6,7]
        */
        Lista listaCadena = new Lista(), lista1Clon, lista2Clon;
        int i = 1;
        
        lista1Clon = lista1.clone();
        lista2Clon = lista2.clone();
        while(!lista1Clon.esVacia()){
            listaCadena.insertar(lista1Clon.recuperar(1), i);
            lista1Clon.eliminar(1);
            i++;
        }
        while(!lista2Clon.esVacia()){
            listaCadena.insertar(lista2Clon.recuperar(1), i);
            lista2Clon.eliminar(1);
            i++;
        }
        return listaCadena;
    }
    
    public static boolean comprobar(Lista lista1){
        /*
        Recibe una lista L1 cargada con dígitos enteros (de 0 a 9) y verica si los elementos
        que contiene tienen la forma cadena0cadena0cadena' (donde cadena' es cadena invertida). Ej: si
        L1=[9,6,5,0,9,6,5,0,5,6,9], cadena=965 y cadena'=569, entonces la lista L1 cumple con la condición
        deseada.
        Atención: la longitud de cadena no se conoce de antemano, hay que identicarla por la primera
        posición de 0 en la lista.
        Nota: Utilizar una Pila y una Cola como estructuras auxiliares
        */
        //MEJORAR CON COMENTARIOS DE LAS CLASE
        Lista clonLista1 = lista1.clone();
        Cola colaAux = new Cola();
        Pila pilaAux = new Pila();
        boolean listaValida = true;
        
        while(!clonLista1.esVacia() && (int)clonLista1.recuperar(1) != 0 ){
            //Se ponen los elementos de la lista en la cola hasta cumplir la condicion
            colaAux.poner(clonLista1.recuperar(1));
            clonLista1.eliminar(1);
        }
        clonLista1.eliminar(1);//Elimina el 0
        if(!clonLista1.esVacia()){
            while(!clonLista1.esVacia() && (int)clonLista1.recuperar(1) != 0 && listaValida){
                /*
                Se ponen los elementos de la lista en la pila y se comparan los 
                elementos de la lista con los de la cola hasta cumplir la condicion
                */
                if(clonLista1.recuperar(1).equals(colaAux.obtenerFrente())){
                    //Si el elemento de la lista y la cola son iguales
                    pilaAux.apilar(colaAux.obtenerFrente());
                    clonLista1.eliminar(1);
                    colaAux.sacar();
                }else{
                    listaValida = false;
                }
            }
            clonLista1.eliminar(1);//Elimina el 0
            if(!clonLista1.esVacia() && listaValida){
                while(!clonLista1.esVacia() && listaValida){
                    /*
                    Compara los elementos de la lista con los de la pila 
                    hasta que se vacie la lista o los elementos sean diferentes
                    */
                    if(clonLista1.recuperar(1).equals(pilaAux.obtenerTope())){
                        //Mismos elementos
                        clonLista1.eliminar(1);
                        pilaAux.desapilar();
                    }else{
                        listaValida = false;
                    }
                }
                if(clonLista1.esVacia() != pilaAux.esVacia() && !listaValida){
                    //La lista ingresada NO es valida
                    listaValida = false;
                }
            }else{
                listaValida = false;
            }
        }else{
            listaValida = false;
        }
        return listaValida;
    }
    
    public static void test1(){
        //Test de modulos de la clase
        Lista lista1, lista2, listaClon1, listaClon2;
        int i;
        
        System.out.println("/////MODULO CONCATENAR/////");
        lista1 = new Lista();
        lista2 = new Lista();
        for(i = 1; i <= 5; i++){
            System.out.println("Insertar en L1 "+ i +": "+ lista1.insertar(i, i));
            System.out.println("Insertar en L2 "+ i*2 +": "+ lista2.insertar(i*2, i));
        }
        listaClon1 = lista1.clone();
        listaClon2 = lista2.clone();
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("L2 toString: "+ listaClon2.toString());
        System.out.println("Concatenar L1 y L2: "+concatenar(listaClon1, listaClon2).toString());
        System.out.println("Vaciar L2");
        listaClon2.vaciar();
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("L2 toString: "+ listaClon2.toString());
        System.out.println("Concatenar L1 y L2: "+concatenar(listaClon1, listaClon2).toString());
        System.out.println("Vaciar L1");
        listaClon1.vaciar();
        System.out.println("Recuperar L2");
        listaClon2 = lista2.clone();
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("L2 toString: "+ listaClon2.toString());
        System.out.println("Vaciar L1");
        listaClon1.vaciar();
        System.out.println("Vaciar L2");
        listaClon2.vaciar();
        System.out.println("Concatenar L1 y L2: "+concatenar(listaClon1, listaClon2).toString());
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("L2 toString: "+ listaClon2.toString());
        System.out.println("Concatenar L1 y L2: "+concatenar(listaClon1, listaClon2).toString());
        System.out.println("/////FIN MODULO CONCATENAR/////");
        System.out.println("/////MODULO COMPROBAR/////");
        System.out.println("Vaciar L1");
        lista1.vaciar();
        System.out.println("Insertar en L1 1: "+ lista1.insertar(1, 1));
        System.out.println("Insertar en L1 2: "+ lista1.insertar(2, 2));
        System.out.println("Insertar en L1 3: "+ lista1.insertar(3, 3));
        System.out.println("Insertar en L1 4: "+ lista1.insertar(4, 4));
        System.out.println("Insertar en L1 0: "+ lista1.insertar(0, 5));
        System.out.println("Insertar en L1 1: "+ lista1.insertar(1, 6));
        System.out.println("Insertar en L1 2: "+ lista1.insertar(2, 7));
        System.out.println("Insertar en L1 3: "+ lista1.insertar(3, 8));
        System.out.println("Insertar en L1 4: "+ lista1.insertar(4, 9));
        System.out.println("Insertar en L1 0: "+ lista1.insertar(0, 10));
        System.out.println("Insertar en L1 4: "+ lista1.insertar(4, 11));
        System.out.println("Insertar en L1 3: "+ lista1.insertar(3, 12));
        System.out.println("Insertar en L1 2: "+ lista1.insertar(2, 13));
        System.out.println("Insertar en L1 1: "+ lista1.insertar(1, 14));
        listaClon1 = lista1.clone();
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("Es L1 valida?: "+comprobar(listaClon1));
        System.out.println("Vaciar L1");
        listaClon1.vaciar();
        System.out.println("Insertar en L1 1: "+ listaClon1.insertar(1, 1));
        System.out.println("Insertar en L1 2: "+ listaClon1.insertar(2, 2));
        System.out.println("Insertar en L1 3: "+ listaClon1.insertar(3, 3));
        System.out.println("Insertar en L1 4: "+ listaClon1.insertar(4, 4));
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("Es L1 valida?: "+comprobar(listaClon1));
        System.out.println("Vaciar L1");
        listaClon1.vaciar();
        System.out.println("Insertar en L1 1: "+ listaClon1.insertar(1, 1));
        System.out.println("Insertar en L1 2: "+ listaClon1.insertar(2, 2));
        System.out.println("Insertar en L1 3: "+ listaClon1.insertar(3, 3));
        System.out.println("Insertar en L1 4: "+ listaClon1.insertar(4, 4));
        System.out.println("Insertar en L1 0: "+ listaClon1.insertar(0, 5));
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("Es L1 valida?: "+comprobar(listaClon1));
        System.out.println("Vaciar L1");
        listaClon1.vaciar();
        System.out.println("Insertar en L1 1: "+ listaClon1.insertar(1, 1));
        System.out.println("Insertar en L1 2: "+ listaClon1.insertar(2, 2));
        System.out.println("Insertar en L1 3: "+ listaClon1.insertar(3, 3));
        System.out.println("Insertar en L1 4: "+ listaClon1.insertar(4, 4));
        System.out.println("Insertar en L1 0: "+ listaClon1.insertar(0, 5));
        System.out.println("Insertar en L1 1: "+ listaClon1.insertar(1, 6));
        System.out.println("Insertar en L1 2: "+ listaClon1.insertar(2, 7));
        System.out.println("Insertar en L1 3: "+ listaClon1.insertar(3, 8));
        System.out.println("Insertar en L1 4: "+ listaClon1.insertar(4, 9));
        System.out.println("Insertar en L1 0: "+ listaClon1.insertar(0, 10));
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("Es L1 valida?: "+comprobar(listaClon1));
        System.out.println("Vaciar L1");
        listaClon1.vaciar();
        System.out.println("Insertar en L1 1: "+ listaClon1.insertar(1, 1));
        System.out.println("Insertar en L1 2: "+ listaClon1.insertar(2, 2));
        System.out.println("Insertar en L1 3: "+ listaClon1.insertar(3, 3));
        System.out.println("Insertar en L1 4: "+ listaClon1.insertar(4, 4));
        System.out.println("Insertar en L1 0: "+ listaClon1.insertar(0, 5));
        System.out.println("Insertar en L1 4: "+ listaClon1.insertar(4, 6));
        System.out.println("Insertar en L1 3: "+ listaClon1.insertar(3, 7));
        System.out.println("Insertar en L1 2: "+ listaClon1.insertar(2, 8));
        System.out.println("Insertar en L1 1: "+ listaClon1.insertar(1, 9));
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("Es L1 valida?: "+comprobar(listaClon1));
        System.out.println("Vaciar L1");
        listaClon1.vaciar();
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("Es L1 valida?: "+comprobar(listaClon1));
        System.out.println("Vaciar L1");
        listaClon1.vaciar();
        System.out.println("Insertar en L1 0: "+ listaClon1.insertar(0, 1));
        System.out.println("Insertar en L1 0: "+ listaClon1.insertar(0, 2));
        System.out.println("L1 toString: "+ listaClon1.toString());
        System.out.println("Es L1 valida?: "+comprobar(listaClon1));
        System.out.println("Vaciar L1");
        listaClon1.vaciar();
        lista1.vaciar();
        System.out.println("/////FIN MODULO COMPROBAR/////");
        System.out.println("/////MODULO INVERTIR/////");
        System.out.println("Insertar en L1 1: "+ lista1.insertar(1, 1));
        System.out.println("Insertar en L1 2: "+ lista1.insertar(2, 2));
        System.out.println("Insertar en L1 3: "+ lista1.insertar(3, 3));
        System.out.println("Insertar en L1 4: "+ lista1.insertar(4, 4));
        System.out.println("L1 toString: "+ lista1.toString());
        System.out.println("L1 Inversa: "+invertir(lista1).toString());
        System.out.println("Vaciar L1");
        System.out.println("/////DIN MODULO INVERTIR/////");
        
    }
    
}
