package conjuntistas;

import lineales.dinamicas.Lista;

/**
 *
 * @author user-
 */
public class ArbolBB {

    private NodoArbol raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        /*
        Recibe un elemento y lo agrega en el árbol de manera ordenada. Si el 
        elemento ya se encuentra en el árbol no se realiza la inserción
         */
        NodoArbol newElemento;
        boolean exito = false;

        if (this.raiz == null) {
            //Arbol vacio, se inserta como raiz
            newElemento = new NodoArbol(elemento, null, null);
            this.raiz = newElemento;
            exito = true;
        } else {
            exito = insertarAux(elemento, this.raiz);
        }
        return exito;
    }

    public boolean eliminar(Comparable elemento) {
        /*
        Recibe el elemento que se desea eliminar y se procede a removerlo del 
        árbol. Si no se encuentra el elemento no se puede realizar la eliminación
         */
        boolean exito = false;
        NodoArbol referencia;
        if (this.raiz.getElemento().compareTo(elemento) == 0) {
            //El elemento esta en la raiz
            determinarCasoEliminacion(null, this.raiz);
            exito = true;
        } else {
            //El elemento no esta en la raiz
            referencia = eliminarAux(elemento, this.raiz);
            if (referencia != null) {
                exito = true;
            }
        }
        return exito;
    }

    public boolean pertenece(Comparable elemento) {
        /*
        Retorna verdadero si el elemento recibido por parámetro está en el árbol
        y falso en caso contrario
         */
        boolean pertenece = false;
        pertenece = perteneceAux(elemento, this.raiz);
        return pertenece;
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    public Lista listar() {
        /*
        Recorre el árbol completo y devuelve una lista ordenada con los elementos que se encuentran
        almacenados en él
         */
        Lista lista = new Lista();
        listarAux(lista, this.raiz);
        return lista;
    }

    public Comparable minimoElemento() {
        /*
        Recorre la rama correspondiente y devuelve el elemento más pequeño almacenado en el árbol
         */
        NodoArbol padre = this.raiz;
        while (padre.getHijoIzquierdo() != null) {
            padre = padre.getHijoIzquierdo();
        }
        return padre.getElemento();
    }

    public Comparable maximoElemento() {
        /*
        Recorre la rama correspondiente y devuelve el elemento más grande almacenado en el árbol
         */
        NodoArbol padre = this.raiz;
        while (padre.getHijoDerecho() != null) {
            padre = padre.getHijoDerecho();
        }
        return padre.getElemento();
    }

    public Lista listarRango(Comparable elemMin, Comparable elemMax) {
        /*
        Recorre parte del árbol (sólo lo necesario) y devuelve una lista 
        ordenada con los elementos que se encuentran en el intervalo
         */
        Lista lista = new Lista();
        listarRangoAux(lista, elemMin, elemMax, this.raiz);
        return lista;
    }

    //Utiles
    
    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        //Retorna un string representando al arbol
        String cadena = "";
        cadena = toStringAux(this.raiz, cadena);
        cadena = "{" + cadena;
        cadena = cadena + "\n}ArbolBB";
        return cadena;
    }

    public ArbolBB clone() {
        //Retorna un clon del arbol binario actual
        ArbolBB arbolClon = new ArbolBB();
        if (!this.esVacio()) {
            arbolClon.raiz = cloneAux(this.raiz);
        }
        return arbolClon;
    }
    
    //Extras
    
    public Lista listarMayorIgual(Comparable elem){
        /*
        Dado un elemento devuelve una lista con los elementos mayores o iguales 
        que elem ordenados de mayor a menor. El método debe recorrer lo mínimo 
        indispensable del árbol.
        */
        Lista lista = new Lista();
        listarMayorIgualAux(elem, lista, this.raiz);
        return lista;
    }
    
    public Comparable eliminarMinimo(){
        /*
        Elimina el elemento más pequeño del árbol en un sólo recorrido y 
        visitando lo mínimo indispensable
        */
        NodoArbol nodoActual = this.raiz, padre = this.raiz;
        Comparable elemento = null;
        while(nodoActual != null){
            if(nodoActual.getHijoIzquierdo() == null){
                //Elemento minimo encontrado
                elemento = nodoActual.getElemento();
                determinarCasoEliminacion(padre, nodoActual);
            }
            padre = nodoActual;
            nodoActual = nodoActual.getHijoIzquierdo();
        }
        return elemento;
    }
    
    public ArbolBB clonarParteInvertida(Comparable elemento){
        return null;
    }

    //Auxiliares
    
    private void listarMayorIgualAux(Comparable elem, Lista lista, NodoArbol padre){
        /*
        Recorre el arbol en inorden modificado, esto es, empieza el recorrido en
        inorden una vez encuentra el elemento
        */
        if(padre != null){
            if(padre.getElemento().compareTo(elem) == 0){
                //Elemento encontrado
                lista.insertar(padre.getElemento(), 1);
                listarMayorIgualAux(elem, lista, padre.getHijoDerecho());
            }else{
                listarMayorIgualAux(elem, lista, padre.getHijoIzquierdo());
                if(lista.esVacia() == false){
                    lista.insertar(padre.getElemento(), lista.longitud() + 1);
                }
                listarMayorIgualAux(elem, lista, padre.getHijoDerecho());
            }
        }
    }
    
    private NodoArbol cloneAux(NodoArbol padre) {
        /*
        Recorre el arbol en preorden clonando los nodos del arbol original
        Retorna la referencia al nodo actual
         */
        NodoArbol enlace = null, hijo;
        if (padre != null) {
            enlace = new NodoArbol(padre.getElemento(), null, null);
            hijo = cloneAux(padre.getHijoIzquierdo());//Llama con HI
            enlace.setHijoIzquierdo(hijo);
            hijo = cloneAux(padre.getHijoDerecho());//Llama con HD
            enlace.setHijoDerecho(hijo);
        }
        return enlace;
    }

    private String toStringAux(NodoArbol padre, String cadena) {
        /*
        Recorre el arbol en preorden y concatena los elemento del arbol en un
        string
         */
        if (padre != null) {
            cadena = cadena + "\nPadre: " + padre.getElemento();
            if (padre.getHijoIzquierdo() != null) {
                //HI
                cadena = cadena + "\nHI: " + padre.getHijoIzquierdo().getElemento();
            } else {
                cadena = cadena + "\nHI: null";
            }
            //------------
            if (padre.getHijoDerecho() != null) {
                //HD
                cadena = cadena + "\nHD: " + padre.getHijoDerecho().getElemento();
            } else {
                cadena = cadena + "\nHD: null";
            }
            cadena = cadena + "\n---";
            cadena = toStringAux(padre.getHijoIzquierdo(), cadena);
            cadena = toStringAux(padre.getHijoDerecho(), cadena);
        }

        return cadena;
    }

    private void listarRangoAux(Lista lista, Comparable elemMin, Comparable elemMax, NodoArbol padre) {
        if (padre != null) {
            if (padre.getElemento().compareTo(elemMin) >= 0 && padre.getElemento().compareTo(elemMax) <= 0) {
                //El padre esta en el rango, se agrega a la lista
                lista.insertar(padre.getElemento(), lista.longitud() + 1);
                listarRangoAux(lista, elemMin, elemMax, padre.getHijoIzquierdo());
                listarRangoAux(lista, elemMin, elemMax, padre.getHijoDerecho());
            } else {
                //El padre no esta en el rango, se revisan sus hijos
                if (padre.getElemento().compareTo(elemMin) < 0) {
                    //Padre menor que el minimo elemento del rango, busca por HD
                    listarRangoAux(lista, elemMin, elemMax, padre.getHijoDerecho());
                } else {
                    //Padre mayor que el maximo elemento del rango, busca por HI
                    listarRangoAux(lista, elemMin, elemMax, padre.getHijoIzquierdo());
                }
            }
        }
    }

    private void listarAux(Lista lista, NodoArbol padre) {
        /*
        Recorre el arbol en inorden agregando los elementos a una lista
         */
        if (padre != null) {
            listarAux(lista, padre.getHijoIzquierdo());
            lista.insertar(padre.getElemento(), lista.longitud() + 1);
            listarAux(lista, padre.getHijoDerecho());
        }
    }

    private boolean perteneceAux(Comparable elemento, NodoArbol padre) {
        /*
        Recorre el arbol y busca el elemento
         */
        boolean encontrado = false;
        if (padre != null) {
            if (padre.getElemento().compareTo(elemento) == 0) {
                //Elemento encontrado
                encontrado = true;
            } else {
                if (padre.getElemento().compareTo(elemento) > 0) {
                    //Busca por HI
                    encontrado = perteneceAux(elemento, padre.getHijoIzquierdo());
                } else {
                    //Busca por HD
                    encontrado = perteneceAux(elemento, padre.getHijoDerecho());
                }
            }
        }
        return encontrado;
    }

    private NodoArbol eliminarAux(Comparable elemento, NodoArbol padre) {
        /*
        Recorre el arbol hasta encontrar el elemento, evalua que caso de
        eliminacion se aplica
         */
        NodoArbol referencia = null;

        if (padre != null) {
            if (padre.getHijoIzquierdo() != null && padre.getHijoIzquierdo().getElemento().compareTo(elemento) == 0) {
                //El elemento es el HI
                referencia = padre.getHijoIzquierdo();
                determinarCasoEliminacion(padre, referencia);
            } else {
                if (padre.getHijoDerecho() != null && padre.getHijoDerecho().getElemento().compareTo(elemento) == 0) {
                    //El elemento es el HD
                    referencia = padre.getHijoDerecho();
                    determinarCasoEliminacion(padre, referencia);
                } else {
                    //No encontrado, llama a un hijo dependiendo del elemento
                    if (padre.getElemento().compareTo(elemento) > 0) {
                        //Elemento menor que el padre
                        referencia = eliminarAux(elemento, padre.getHijoIzquierdo());
                    } else {
                        if (padre.getElemento().compareTo(elemento) < 0) {
                            //Elemento mayor que el padre
                            referencia = eliminarAux(elemento, padre.getHijoDerecho());
                        }
                    }
                }
            }
        }
        return referencia;
    }

    private void determinarCasoEliminacion(NodoArbol padre, NodoArbol referencia) {
        /*
        Determina que caso de eliminacion es el correcto para la referencia
         */
        if (referencia.getHijoIzquierdo() == null && referencia.getHijoDerecho() == null) {
            //Caso 1
            eliminarCaso1(padre, referencia);
        } else {
            if (referencia.getHijoIzquierdo() != null && referencia.getHijoDerecho() == null || referencia.getHijoIzquierdo() == null && referencia.getHijoDerecho() != null) {
                //Caso 2
                eliminarCaso2(padre, referencia);
            } else {
                if (referencia.getHijoIzquierdo() != null && referencia.getHijoDerecho() != null) {
                    //Caso 3
                    eliminarCaso3(referencia);
                }
            }
        }
    }

    private void eliminarCaso3(NodoArbol nodo) {
        /*
        El elemento tiene dos hijos, se busca el mayor decendiente
        del subarbol izquierdo para remplazar el elemento hijo
         */
        if (nodo.getHijoIzquierdo().getHijoDerecho() == null) {
            /*
            El HI del nodo no tiene HD, el HI es el mayor del subarbol izquierdo
            */
            nodo.setElemento(nodo.getHijoIzquierdo().getElemento());
            nodo.setHijoIzquierdo(null);
            System.out.println("CASO 3 ESPECIAL");
        } else {
            /* 
            El HI del nodo tiene HD, se busca el mayor elemento del subarbol izquierdo
            */
            NodoArbol abueloAux = nodo.getHijoIzquierdo();
            NodoArbol padreAux = abueloAux.getHijoDerecho();
            NodoArbol hijoAux = padreAux.getHijoDerecho();
            while (hijoAux != null) {
                abueloAux = padreAux;
                padreAux = hijoAux;
                hijoAux = padreAux.getHijoDerecho();
            }
            nodo.setElemento(padreAux.getElemento());
            abueloAux.setHijoDerecho(null);
            System.out.println("CASO 3");
        }
    }

    private void eliminarCaso2(NodoArbol padre, NodoArbol hijo) {
        /*
        El elemento tiene un hijo
         */
        if (hijo.getElemento().compareTo(this.raiz.getElemento()) != 0) {
            if (padre.getElemento().compareTo(hijo.getElemento()) > 0) {
                //Se remplaza HI 
                if (hijo.getHijoIzquierdo() != null) {
                    padre.setHijoIzquierdo(hijo.getHijoIzquierdo());
                } else {
                    padre.setHijoIzquierdo(hijo.getHijoDerecho());
                }
            } else {
                //Se remplaza HD
                if (hijo.getHijoIzquierdo() != null) {
                    padre.setHijoDerecho(hijo.getHijoIzquierdo());
                } else {
                    padre.setHijoDerecho(hijo.getHijoDerecho());
                }
            }
            System.out.println("CASO 2");
        } else {
            //El elemento es la raiz
            if (this.raiz.getHijoIzquierdo() != null) {
                this.raiz = this.raiz.getHijoIzquierdo();
            } else {
                this.raiz = this.raiz.getHijoDerecho();
            }
            System.out.println("CASO 2 ESPECIAL");
        }
    }

    private void eliminarCaso1(NodoArbol padre, NodoArbol hijo) {
        /*
        El elemento es hoja
         */
        if (hijo.getElemento().compareTo(this.raiz.getElemento()) != 0) {
            if (padre.getElemento().compareTo(hijo.getElemento()) > 0) {
                //Se elimina HI
                padre.setHijoIzquierdo(null);
            } else {
                //Se elimina HD
                padre.setHijoDerecho(null);
            }
            System.out.println("CASO 1 ");
        } else {
            //El elemento es la raiz
            this.raiz = null;
            System.out.println("CASO 1 ESPECIAL");
        }
    }

    private boolean insertarAux(Comparable elemento, NodoArbol padre) {
        /*
        Reccorre el arbol hasta encontrar la posicion correcta con respecto al 
        elemento en el parametro, se inserta si el elemento no esta repetido
         */
        NodoArbol newElemento;
        boolean exito = false;

        if (padre != null) {
            if (padre.getElemento().compareTo(elemento) > 0) {
                /*
                El padre es mayor que el elemento, se recorre el subarbol
                izquierdo
                 */
                if (padre.getHijoIzquierdo() == null) {
                    /*
                    El padre no pose HI, se inserta el elemento como nuevo HI
                     */
                    newElemento = new NodoArbol(elemento, null, null);
                    padre.setHijoIzquierdo(newElemento);
                    exito = true;
                } else {
                    exito = insertarAux(elemento, padre.getHijoIzquierdo());
                }
            } else {
                if (padre.getElemento().compareTo(elemento) < 0) {
                    /*
                    El padre es menor que el elemento, se recorre el subarbol
                    derecho
                     */
                    if (padre.getHijoDerecho() == null) {
                        /*
                        El padre no pose HD, se inserta el elemento como nuevo HD
                         */
                        newElemento = new NodoArbol(elemento, null, null);
                        padre.setHijoDerecho(newElemento);
                        exito = true;
                    } else {
                        exito = insertarAux(elemento, padre.getHijoDerecho());
                    }
                }
            }
        }
        return exito;
    }
}
