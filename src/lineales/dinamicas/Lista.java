 
package lineales.dinamicas;

/**
 *  @author 
 */

public class Lista {
    //TDA de la clase Lista
    private Nodo cabecera;
    
    public Lista(){
        this.cabecera = null;
    }
    
    //Operaciones
    
    public boolean insertar(Object elemento, int pos){
        //Inserta un elemento en la lista en la posicion indicada
        boolean exito;
        int i;
        Nodo nodoPrevio, nodoActual, newNodo;
        
        if(pos == 1){
            //Caso posicion 1
            newNodo = new Nodo(elemento, this.cabecera);
            this.cabecera = newNodo;
            exito = true;
        }else{
            //Caso posicion != 1
            nodoPrevio = this.cabecera;
            nodoActual = this.cabecera;
            i = 1;
            while(i < pos && i > 0 && nodoActual != null){
                /*Recorre la lista hasta que encuentra la posicion correcta
                o la posicion sea invalida
                */ 
                nodoPrevio = nodoActual;
                nodoActual = nodoActual.getEnlace(); //Elemento en posicion i + 1
                i++;
            }
            if( i == pos){
                //Posicion valida
                newNodo = new Nodo(elemento, nodoActual);
                nodoPrevio.setEnlace(newNodo);
                exito = true;
            }else{
                //Posicion no valida
                exito = false;
            }
        }
        return exito;
    }
    
    public boolean eliminar(int pos){
        //Elimina un elemento de la lista en la posicion indicada
        boolean exito;
        int i;
        Nodo nodoPrevio, nodoActual;
        
        if(this.cabecera == null){
            //Caso lista vacia
            exito = false;
        }else{
            //Caso lista no vacia
            if(pos == 1){
                this.cabecera = this.cabecera.getEnlace();
                exito = true;
            }else{
                nodoPrevio = this.cabecera;
                nodoActual = this.cabecera;
                i = 1;
                while(i < pos && i > 0 && nodoActual != null){
                    /*Recorre la lista hasta que encuentra la posicion correcta
                    o la posicion sea invalida
                    */ 
                    nodoPrevio = nodoActual;
                    nodoActual = nodoActual.getEnlace();
                    i++;
                }
                if(i == pos){
                    //Posicion valida
                    nodoPrevio.setEnlace(nodoActual.getEnlace());
                    exito = true;
                }else{
                    //Posicion invalida
                    exito = false;
                }
            }
        }
        return exito;
    }
    //----------------------------------
    public Object recuperar(int pos){
        //Recupera un elemento de la lista en la posicion indicada
        Object elemento;
        int i;
        Nodo nodoActual;
        
        if(this.cabecera == null){
            //Caso lista vacia
            elemento = null;
        }else{
            //Caso lista no vacia
            nodoActual = this.cabecera;
            i = 1;
            while(i < pos && i > 0 && nodoActual != null){
                /*Recorre la lista hasta que encuentra la posicion correcta
                o la posicion sea invalida
                */ 
                nodoActual = nodoActual.getEnlace();
                i++;
            }
            if(i == pos && nodoActual != null){
                //Posicion valida
                //Condicion null necesaria para caso posicion valida + 1
                elemento = nodoActual.getElemento();
            }else{
                //Posicion invalida
                elemento = null;
            }    
        }
        return elemento;
    }
    
    public int localizar(Object elemento){
        //Recupera un elemento de la lista en la posicion indicada
        int i;
        Nodo nodoActual;
        
        if(this.cabecera == null){
            //Caso lista vacia
            i = -1;
        }else{
            //Caso lista no vacia
            nodoActual = this.cabecera;
            i = 1;
            while(nodoActual != null && !nodoActual.getElemento().equals(elemento)){
                /*Recorre la lista hasta que encuentra la posicion correcta
                o la posicion sea invalida
                */ 
                nodoActual = nodoActual.getEnlace();
                i++;
            }
            if(nodoActual == null){
                //El elemento no existe
                i = -1;
            }
        }
        return i;
    }
    
    public int longitud(){
        //Retorna la longitud de la lista
        int i; //Contador de posiciones
        Nodo nodoActual;
        
        nodoActual = this.cabecera;
        i = 0;
        while(nodoActual != null){
            nodoActual = nodoActual.getEnlace();
            i++;
        }
        return i;
    }
    //----------------------------------
    public boolean esVacia(){
        //Retorna si esta vacia la lista
        boolean vacia = false;
        if(this.cabecera == null){
            vacia = true;
        }
        return vacia;
    }
    
    public boolean vaciar(){
        //Vacia la lista
        this.cabecera = null;
        return true;
    }
    
    public String toString(){
        //Retorna un string representando la lista
        String cadena;
        Nodo nodoActual;
        
        nodoActual = this.cabecera;
        cadena = "[";
        while(nodoActual != null){
            /*Recorre la lista y concatena los elementos en un string
            [Frente ... Final]
            */ 
            cadena = cadena + ", " + nodoActual.getElemento();
            nodoActual = nodoActual.getEnlace(); //Elemento de la posicion i + 1
        }
        cadena = cadena + "]";
        return cadena;
    }
    
    public Lista clone(){
        //Retorna un clon de la lista actual
        Lista newLista = new Lista();
        Nodo nodoOriginal = this.cabecera;
        
        cloneAux(newLista, nodoOriginal);
        return newLista;
    }
    
    private void cloneAux(Lista newLista, Nodo nodoOriginal){
        /*Recorre la lista hasta el final, luego copia los elemetnos a la nueva
        lista al regresar
        */
        Nodo newNodo;
        
        if(nodoOriginal != null){
            cloneAux(newLista, nodoOriginal.getEnlace());
            newNodo = new Nodo(nodoOriginal.getElemento(), null);//Crea nuevo nodo
            newNodo.setEnlace(newLista.cabecera);//Asigna el enlace del nuevo nodo
            newLista.cabecera = newNodo;//Se asigna el nodo a la cabecera
        }
    }
    
    //Extras
    
    public Lista obtenerMultiplos(int num){
        /*
        Recibe un número y devuelve una lista nueva que contiene todos los 
        elementos de las posiciones múltiplos de num, en el mismo orden 
        encontrado, haciendo un único recorrido de las estructuras original y 
        copia; y sin usar otras operaciones del TDA.
        Ejemplo: si se invoca con la lista <A,B,C,D,E,F,G,H,I,J> y num=3, el 
        método debe devolver la lista <C,F,I>
        */
        Lista newLista = new Lista();
        
        obtenerMultiplosAux(newLista, this.cabecera, num);
        return newLista;
    }
    
    private int obtenerMultiplosAux(Lista lista, Nodo nodoOriginal, int num){
        int pos = 0;
        if(nodoOriginal != null && num != 0){
            pos = obtenerMultiplosAux(lista, nodoOriginal.getEnlace(), num);
            pos ++;
            if((pos % num) == 0){
                Nodo newNodo = new Nodo(nodoOriginal.getElemento(), null);
                newNodo.setEnlace(lista.cabecera);
                lista.cabecera = newNodo;
            }
        }
        return pos;
    }
}
