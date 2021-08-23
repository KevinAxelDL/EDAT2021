
package jerarquicas;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

/**
 *  @author
 */

public class ArbolBin {
    //TDA de arbol binario dinamico
    
    private NodoArbol raiz;
    
    public ArbolBin(){
        this.raiz = null;
    }
    
    public boolean insertar(Object elemento, Object padre, char hijo){
        /*
        Inserta el elemento (parametro) como hijo del primer elemento padre
        (parametro) encontrado en recorrido en preorden, hijo derecho (D) o 
        izquiedo(I) depende del parametro char
        */
        boolean exito = false;
        NodoArbol nodoBuscado = null;
        
        if(this.raiz == null){
            //Se inserta el elemento como raiz
            NodoArbol newNodo = new NodoArbol(elemento, null, null);
            this.raiz = newNodo;
            exito = true;
        }else{
            nodoBuscado = obtenerNodo(this.raiz, padre);
            if(nodoBuscado != null){
                //Elemento padre encontrado
                NodoArbol newNodo = new NodoArbol(elemento, null, null);
                switch(hijo){
                    case 'I': 
                        if(nodoBuscado.getIzquierdo() == null){
                            nodoBuscado.setIzquierdo(newNodo);
                            exito = true;
                        }
                        break;
                    case 'D':
                        if(nodoBuscado.getDerecho() == null){
                            nodoBuscado.setDerecho(newNodo);
                            exito = true;
                        }
                        break;
                }
            }
        }
        return exito;
    }
    
    public boolean esVacio(){
        return this.raiz == null;
    }
    
    public Object padre(Object hijo){
        //Retorna el elemento padre del elemento ingresado
        NodoArbol nodoPadre = padreAux(this.raiz, hijo);
        Object elementoPadre;
        if(nodoPadre != null){
            elementoPadre = nodoPadre.getElemento();
        }else{
            elementoPadre = null;
        }
        return elementoPadre;
    }
    
    public int altura(){
        /*
        Retorna la altura del arbol (camino mas largo desde la raiz hasta un nodo)
        Un arbol vacio tiene altura = -1
        */
        int contadorFinal = -1;
        return alturaAux(this.raiz, contadorFinal);   
    }
    
    public int nivel(Object elemento){
        /*
         Devuelve el nivel de un elemento en el árbol. Si el elemento no existe 
        en el árbol devuelve -1
        */
        int nivel = -1;
        nivel = nivelAux(this.raiz, elemento);
        return nivel;
    }
    
    //Metodos comunes
    
    public void vaciar(){
        //Vacia el arbol completo
        this.raiz = null;
    }
    
    public String toString(){
        //Retorna un string representando al arbol
        String cadena = "";
        cadena = toStringAux(this.raiz, cadena);
        cadena = "{" + cadena;
        cadena = cadena +"\n}ArbolBin";
        return cadena;
    }
    
    public ArbolBin clone(){
        //Retorna un clon del arbol binario actual
        ArbolBin arbolClon = new ArbolBin();
        if(!this.esVacio()){
            arbolClon.raiz = cloneAux(this.raiz);
        }
        return arbolClon;
    }
    
    public Lista frontera(){
        /*
        Devuelve una lista con todos los elementos del árbol que sean hoja, de 
        izquierda a derecha
        */
        Lista listaFrontera = new Lista();
        fronteraAux(this.raiz, listaFrontera);
        return listaFrontera;
    }
    
    //Metodos de listado
    
    public Lista listarPreorden(){
        /*
        Inserta en una lista los elemmentos del arbol en preorden
        */
        Lista listaArbol = new Lista();
        listarPreordenAux(this.raiz, listaArbol);
        return listaArbol;
    }
    
    public Lista listarPosorden(){
        /*
        Inserta en una lista los elemmentos del arbol en posorden
        */
        Lista listaArbol = new Lista();
        listarPosordenAux(this.raiz, listaArbol);
        return listaArbol;
    }
    
    public Lista listarInorden(){
        /*
        Inserta en una lista los elemmentos del arbol en inorden
        */
        Lista listaArbol = new Lista();
        listarInordenAux(this.raiz, listaArbol);
        return listaArbol;
    }
    
    public Lista listarPorNiveles(){
        /*
        Inserta en una lista los elemmentos del arbol en orden por niveles
        */
        Lista listaArbol = new Lista();
        listarPorNivelesAux(this.raiz, listaArbol);
        return listaArbol;
    }
    
    
    //Metodos privados
    
    private void fronteraAux(NodoArbol padre, Lista lista){
        /*
        Devuelve una lista con todos los elementos del árbol que sean hoja, de 
        izquierda a derecha en un recorrido en preorden
        */
        if(padre != null){
            if(padre.getIzquierdo() == null && padre.getDerecho() == null){
                //Padre es hoja
                lista.insertar(padre.getElemento(), lista.longitud() + 1);
            }else{
                fronteraAux(padre.getIzquierdo(), lista);
                fronteraAux(padre.getDerecho(), lista);
            }
        }
    }
    
    private int nivelAux(NodoArbol padre, Object elemento){
        /*
        Realiza un recorrido en preorden para encontrar la primera aparicion del
        elemento (parametro), calcula la altura a medida que regresa de la 
        recursion, retorna su altura
        */
        int nivel = -1;
                
        if(padre != null){
            if(padre.getElemento().equals(elemento)){
                //Elemento encontrado
                nivel = 0;
            }else{
                //Recorre hijo izquierdo
                nivel = nivelAux(padre.getIzquierdo(), elemento);
                if(nivel == -1){
                    //Recorre hijo derecho
                    nivel = nivelAux(padre.getDerecho(), elemento);
                }
                if(nivel != -1){
                    nivel++;
                }
            }
        }
        return nivel;
    }
    
    private void listarPorNivelesAux(NodoArbol padre, Lista listaArbol){
        /*
        Inserta en una lista los elemmentos del arbol en orden por niveles
        */
        Cola colaAux = new Cola();
        NodoArbol nodoActual;
        if(padre != null){
            colaAux.poner(padre);//Se almacena un NodoArbol en la cola
            while(!colaAux.esVacia()){
                nodoActual = (NodoArbol)colaAux.obtenerFrente();
                listaArbol.insertar(nodoActual.getElemento(), listaArbol.longitud() + 1);
                colaAux.sacar();
                if(nodoActual.getIzquierdo() != null){
                    colaAux.poner(nodoActual.getIzquierdo());
                }
                if(nodoActual.getDerecho() != null){
                    colaAux.poner(nodoActual.getDerecho());
                }
                
            }
        }
    }
    
    private void listarInordenAux(NodoArbol padre, Lista listaArbol){
        /*
        Inserta en una lista los elemmentos del arbol en inorden
        */
        if(padre != null){
            if(padre.getIzquierdo() != null){
                //HI
                listarInordenAux(padre.getIzquierdo(), listaArbol);
            }
            listaArbol.insertar(padre.getElemento(), listaArbol.longitud() + 1);
            if(padre.getDerecho() != null){
                //HD
                listarInordenAux(padre.getDerecho(), listaArbol);
            }
        }
    }
    
    private void listarPosordenAux(NodoArbol padre, Lista listaArbol){
        /*
        Inserta en una lista los elemmentos del arbol en posorden
        */
        if(padre != null){
            if(padre.getIzquierdo() != null){
                //HI
                listarPosordenAux(padre.getIzquierdo(), listaArbol);
            }
            if(padre.getIzquierdo() != null){
                //HD
                listarPosordenAux(padre.getDerecho(), listaArbol);
            }
            listaArbol.insertar(padre.getElemento(), listaArbol.longitud() + 1);
        }
    }
    
    private void listarPreordenAux(NodoArbol padre, Lista listaArbol){
        /*
        Inserta en una lista los elemmentos del arbol en preorden
        */
        if(padre != null){
            listaArbol.insertar(padre.getElemento(), listaArbol.longitud() + 1);
            if(padre.getIzquierdo() != null){
                //HI
                listarPreordenAux(padre.getIzquierdo(), listaArbol);
            }
            if(padre.getIzquierdo() != null){
                //HD
                listarPreordenAux(padre.getDerecho(), listaArbol);
            }
        }
    }
    
    private NodoArbol cloneAux(NodoArbol padre){
        /*
        Recorre el arbol en preorden clonando los nodos del arbol original
        Retorna la referencia al nodo actual
        */
        NodoArbol enlace = null, hijo;
        if(padre != null){
            enlace = new NodoArbol(padre.getElemento(), null, null);
            hijo = cloneAux(padre.getIzquierdo());//Llama con HI
            enlace.setIzquierdo(hijo);
            hijo = cloneAux(padre.getDerecho());//Llama con HD
            enlace.setDerecho(hijo);
        }
        return enlace;
    }
    
    private String toStringAux(NodoArbol padre, String cadena){
        /*
        Recorre el arbol en preorden y concatena los elemento del arbol en un
        string
        */
        if(padre != null){
            cadena = cadena + "\nPadre: "+ padre.getElemento();
            if(padre.getIzquierdo() != null){
                //HI
                cadena = cadena + "\nHI: "+ padre.getIzquierdo().getElemento();
            }else{
                cadena = cadena + "\nHI: null";
            }
            //------------
            if(padre.getDerecho() != null){
                //HD
                cadena = cadena + "\nHD: "+ padre.getDerecho().getElemento();
            }else{
                cadena = cadena + "\nHD: null";
            }
            cadena = cadena + "\n---";
            cadena = toStringAux(padre.getIzquierdo(), cadena);
            cadena = toStringAux(padre.getDerecho(), cadena);
        }
        
        return cadena;
    }
    
    private int alturaAux(NodoArbol padre, int contadorFinal){
        /*
        Recorre el arbol en preorden y retorna la longitud del camino mas 
        largo desde la raiz
        */
        int alturaIzq, alturaDer;
        if(padre != null){
            contadorFinal ++;
            alturaIzq = alturaAux(padre.getIzquierdo(), contadorFinal);
            alturaDer = alturaAux(padre.getDerecho(), contadorFinal);
            if(alturaIzq > alturaDer){
                contadorFinal = alturaIzq;
            }else{
                contadorFinal = alturaDer;
            }
        }
        return contadorFinal;
    }
    
    private NodoArbol padreAux(NodoArbol padre, Object elemento){
        /*
        Realiza un recorrido en preorden para encontrar la primera aparicion del
        elemento (parametro), retorna el nodo padre
        */
        NodoArbol resultado = null;
        
        if(padre != null && !elemento.equals(this.raiz.getElemento())){
            if(padre.getIzquierdo() != null && padre.getIzquierdo().getElemento().equals(elemento)){
                //Elemento encontrado
                resultado = padre;
            }else{
                if(padre.getDerecho() != null && padre.getDerecho().getElemento().equals(elemento)){
                    //Elemento encontrado
                    resultado = padre;
                }else{
                    //Recorre hijos
                    resultado = padreAux(padre.getIzquierdo(), elemento);
                    if(resultado == null){
                        resultado = padreAux(padre.getDerecho(), elemento);
                    }
                }
            }
            
            
        }
        return resultado;
    }
    
    private NodoArbol obtenerNodo(NodoArbol padre, Object elemento){
        /*
        Realiza un recorrido en preorden para encontrar la primera aparicion del
        elemento (parametro), retorna el nodo contenedor
        */
        NodoArbol resultado = null;
                
        if(padre != null){
            if(padre.getElemento().equals(elemento)){
                //Elemento encontrado
                resultado = padre;
            }else{
                //Recorre hijo izquierdo
                resultado = obtenerNodo(padre.getIzquierdo(), elemento);
                if(resultado == null){
                    //Recorre hijo derecho
                    resultado = obtenerNodo(padre.getDerecho(), elemento);
                }
            }
        }
        return resultado;
    }
    
    //Extras
    
    public boolean verificarPatron(Lista patron){
        /*
        Recibe por parámetro una lista patron y determine si coincide exactamente 
        con al menos un camino del árbol que comience en la raíz y termine en 
        una hoja. El método debe ser eficiente, es decir, recorrer el árbol lo 
        estrictamente necesario.
        */
        int pos = 0;
        return verificarPatronAux(patron, this.raiz, pos);
    }
    
    private boolean verificarPatronAux(Lista patron, NodoArbol padre, int pos){
        boolean exito = false;
        if(padre != null){
            pos ++;
            if(patron.recuperar(pos).equals(padre.getElemento())){
                if(pos == patron.longitud()){
                    if(padre.getDerecho() == null && padre.getIzquierdo() == null){
                        exito = true;
                    }
                }else{
                    exito = verificarPatronAux(patron, padre.getIzquierdo(), pos);
                    if(exito != true){
                        exito = verificarPatronAux(patron, padre.getDerecho(), pos);
                    }
                }
            }
        }
        return exito;
    }
}
