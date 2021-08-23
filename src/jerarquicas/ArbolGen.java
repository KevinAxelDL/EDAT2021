package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

/**
 * @author 
 */
public class ArbolGen {

    //TDA de arbol generico
    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemento, Object padre) {
        /*
        Dado un elemento y un padre ingresados por parametro, agrega el elemento 
        como hijo de la primera aparicion del padre.Recorre el arbol en preorden
         */
        NodoGen newNodo, nodoPadre;
        boolean exito = true;

        if (this.raiz == null) {
            //Se inserta como raiz
            newNodo = new NodoGen(elemento, null, null);
            this.raiz = newNodo;
        } else {
            nodoPadre = obtenerNodo(padre, this.raiz);
            if (nodoPadre != null) {
                //Padre encontrado
                newNodo = new NodoGen(elemento, null, nodoPadre.getHijoIzquierdo());
                nodoPadre.setHijoIzquierdo(newNodo);
            } else {
                exito = false;
            }
        }
        return exito;
    }

    public boolean pertenece(Object elemento) {
        /*
        Retorna verdadero si el elemento pasado por parámetro está en el árbol, 
        y falso en caso contrario
         */
        boolean encontrado = false;
        if (obtenerNodo(elemento, this.raiz) != null) {
            encontrado = true;
        }
        return encontrado;
    }

    public Lista ancestros(Object elemento) {
        /*
        Si el elemento se encuentra en el árbol, devuelve una lista con el 
        camino desde la raíz hasta dicho elemento (es decir, con los ancestros 
        del elemento). Si el elemento no está en el árbol devuelve la lista 
        vacía
         */
        Lista ancestros = new Lista();
        ancestrosAux(elemento, this.raiz, ancestros);
        return ancestros;
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    public int altura() {
        /*
        Retorna la altura del arbol desde la raiz
         */
        return alturaAux(this.raiz);
    }

    public int nivel(Object elemento) {
        /*
        Retorna el nivel de un elemento en el árbol. Si el elemento no existe 
        en el árbol retorna -1.
         */
        int nivelLocal = -1;
        return nivelAux(elemento, this.raiz, nivelLocal);
    }

    public Object padre(Object elemento) {
        /*
        Dado un elemento devuelve el valor almacenado en su nodo padre (busca 
        la primera aparición de elemento)
         */
        Object padre = null;
        if (this.raiz != null) {
            if (!this.raiz.getElemento().equals(elemento)) {
                //Caso raiz distinta del elemento
                padre = padreAux(elemento, this.raiz);
            }
        }
        return padre;
    }

    //Utiles
    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        /*
        Retorna un string representando el arbol
         */
        String string = "[ \n";
        string = toStringAux(string, this.raiz);
        string = string + "]ArbolGenerico\n";
        return string;
    }

    public ArbolGen clone() {
        /*
        Retorna un arbol equivalente al actual
         */
        ArbolGen arbolClon = new ArbolGen();
        arbolClon.raiz = cloneAux(this.raiz);
        return arbolClon;
    }

    //Recorridos
    public Lista listarPreorden() {
        /*
        Inserta los elementos del arbol en preorden en una lista
         */
        Lista lista = new Lista();
        listarPreordenAux(lista, this.raiz);
        return lista;
    }

    public Lista listarInorden() {
        /*
        Inserta los elementos del arbol en inorden en una lista
         */
        Lista lista = new Lista();
        listarInordenAux(lista, this.raiz);
        return lista;
    }

    public Lista listarPosorden() {
        /*
        Inserta los elementos del arbol en posorden en una lista
         */
        Lista lista = new Lista();
        listarPosordenAux(lista, this.raiz);
        return lista;
    }

    public Lista listarPorNiveles() {
        /*
        Inserta los elementos del arbol por niveles en una lista
         */
        Lista lista = new Lista();
        listarPorNivelesAux(lista, this.raiz);
        return lista;
    }

    //Extras
    public int grado() {
        /*
        Retorna la cantidad mayor de hijos que tiene un subarbol desde el nodo de partida
         */
        int grado = -1;
        grado = gradoAux(this.raiz);
        return grado;
    }

    public int gradoSubarbol(Object elemento) {
        /*
        Retorna la cantidad mayor de hijos que tiene un subarbol desde el nodo de partida
         */
        NodoGen elementoBuscado = obtenerNodo(elemento, this.raiz);
        int grado = -1;
        if (elementoBuscado != null) {
            grado = gradoAux(elementoBuscado);
        }
        return grado;
    }

    public boolean verificarCamino(Lista lista) {
        /*
        Verifica si la lista corresponde a un camino desde la raíz hasta algún 
        elemento del árbol. Acepta elementos repetidos
         */
        boolean exito;
        Lista listaClon = lista.clone();
        exito = verificarCaminoAux(listaClon, this.raiz);
        return exito;
    }

    //Auxiliares
    private boolean verificarCaminoAux(Lista lista, NodoGen padre) {
        boolean exito = false;
        NodoGen hijo;
        Object backup;
        if (padre != null) {
            if (padre.getElemento().equals(lista.recuperar(1))) {
                //Elemento encontrado
                backup = lista.recuperar(1);
                lista.eliminar(1);
                if (lista.esVacia()) {
                    //Lista vacia, el camino pertenece al arbol
                    exito = true;
                } else {
                    /*
                    Revisa que hijo sigue en la secuencia. Reinserta el elemento
                    eliminado si resulta que al regresar no se vacio la lista
                    (Considerando que hay elementos repetidos)
                     */
                    hijo = padre.getHijoIzquierdo();
                    while (hijo != null && !exito) {
                        if (hijo.getElemento().equals(lista.recuperar(1))) {
                            exito = verificarCaminoAux(lista, hijo);
                        }
                        hijo = hijo.getHermanoDerecho();
                    }
                }
                if (exito == false) {
                    /*
                    Al regresar, si la lista no se vacio, reinserta el elemento
                    eliminado
                    */
                    lista.insertar(backup, lista.longitud() + 1);
                }
            }
        }
        return exito;
    }

    private int gradoAux(NodoGen padre) {
        /*
        Realiza un recorrido en preorden en busca del subarbol con mayor grado
         */
        int cantHijosMayor = -1, cantHijosRef;
        NodoGen hijo;

        if (padre != null) {
            cantHijosMayor++;
            //Cuenta sus hijos
            hijo = padre.getHijoIzquierdo();
            while (hijo != null) {
                cantHijosMayor++;
                hijo = hijo.getHermanoDerecho();
            }
            //Compara con sus hijos
            hijo = padre.getHijoIzquierdo();
            while (hijo != null) {
                cantHijosRef = gradoAux(hijo);
                if (cantHijosMayor < cantHijosRef) {
                    cantHijosMayor = cantHijosRef;
                }
                hijo = hijo.getHermanoDerecho();
            }
        }
        return cantHijosMayor;
    }

    private void listarPorNivelesAux(Lista lista, NodoGen padre) {
        /*
        Inserta en una lista los elemmentos del arbol por niveles
         */
        Cola colaAux = new Cola();
        NodoGen nodoActual, hijo;
        if (padre != null) {
            colaAux.poner(padre);//Se almacena un NodoArbol en la cola
            while (!colaAux.esVacia()) {
                nodoActual = (NodoGen) colaAux.obtenerFrente();
                lista.insertar(nodoActual.getElemento(), lista.longitud() + 1);
                colaAux.sacar();
                hijo = nodoActual.getHijoIzquierdo();
                while (hijo != null) {
                    colaAux.poner(hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    private void listarPosordenAux(Lista lista, NodoGen padre) {
        /*
        Recorre el arbol en posorden e inserta los elementos del arbol en una 
        lista
         */
        if (padre != null) {
            listarPosordenAux(lista, padre.getHijoIzquierdo());//Visita hijo izquierdo extremo

            if (padre.getHijoIzquierdo() != null) {//Visita hijos restantes
                NodoGen hijo = padre.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarPosordenAux(lista, hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }

            lista.insertar(padre.getElemento(), lista.longitud() + 1);//Visita nodo actual
        }
    }

    private void listarInordenAux(Lista lista, NodoGen padre) {
        /*
        Recorre el arbol en inorden e inserta los elementos del arbol en una 
        lista
         */
        if (padre != null) {
            listarInordenAux(lista, padre.getHijoIzquierdo());//Visita hijo izquierdo extremo

            lista.insertar(padre.getElemento(), lista.longitud() + 1);//Visita nodo actual

            if (padre.getHijoIzquierdo() != null) {//Visita hijos restantes
                NodoGen hijo = padre.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(lista, hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    private void listarPreordenAux(Lista lista, NodoGen padre) {
        /*
        Recorre el arbol en preorden e inserta los elementos del arbol en una 
        lista
         */
        if (padre != null) {
            lista.insertar(padre.getElemento(), lista.longitud() + 1);//Visita nodo actual

            listarPreordenAux(lista, padre.getHijoIzquierdo());//Visita hijo izquierdo extremo

            if (padre.getHijoIzquierdo() != null) {//Visita hijos restantes
                NodoGen hijo = padre.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarPreordenAux(lista, hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    private NodoGen cloneAux(NodoGen padreOriginal) {
        /*
        Recorre el arbol en preorden enlazando copias de los nodos del arbol
        original. Retorna la referencia al nodo actual a su padre o hermano, 
        segun la llamada
         */
        NodoGen newNodo = null;

        if (padreOriginal != null) {
            newNodo = new NodoGen(padreOriginal.getElemento(), null, null);
            newNodo.setHermanoDerecho(cloneAux(padreOriginal.getHermanoDerecho()));//Llama con hermano derecho y lo conecta
            newNodo.setHijoIzquierdo(cloneAux(padreOriginal.getHijoIzquierdo()));//Llama con hijo izquierdo extremo y lo conecta
        }
        return newNodo;
    }

    private String toStringAux(String string, NodoGen padre) {
        /*
        Recorre el arbol en preorden mientras concatena los elementos del mismo
        en un String
         */
        NodoGen hijo;

        if (padre != null) {
            string = string + "PADRE: " + padre.getElemento().toString() + "; HIJOS: ";
            hijo = padre.getHijoIzquierdo();
            while (hijo != null) {
                //Concatena los hijos al String
                string = string + hijo.getElemento().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            string = string + "\n";
            //Recorre los hijos
            hijo = padre.getHijoIzquierdo();
            while (hijo != null) {
                string = toStringAux(string, hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return string;
    }

    private Object padreAux(Object elemento, NodoGen padre) {
        /*
        Recorre el arbol en preorden hasta encontrar el padre del elemento
        pasado por parametro y lo retorna
         */
        Object encontrado = null;
        NodoGen hijo;

        if (padre != null) {
            hijo = padre.getHijoIzquierdo();
            while (hijo != null && encontrado == null) {
                //Revisa sus hijos
                if (hijo.getElemento().equals(elemento)) {
                    //Elemmento encontrado
                    encontrado = padre.getElemento();
                } else {
                    hijo = hijo.getHermanoDerecho();
                }
            }
            hijo = padre.getHijoIzquierdo();
            while (hijo != null && encontrado == null) {
                encontrado = padreAux(elemento, hijo);
                hijo = hijo.getHermanoDerecho();
            }

        }
        return encontrado;
    }

    private int nivelAux(Object elemento, NodoGen padre, int nivelLocal) {
        /*
        Recorre el arbol en preorden buscando el elemento, si es encontrado
        se suman los niveles al regresar de la recursion
         */
        NodoGen hijo;

        if (padre != null) {
            if (padre.getElemento().equals(elemento)) {
                //Encontrado
                nivelLocal++;
            } else {
                //No encontrado, busca en hijos 
                hijo = padre.getHijoIzquierdo();
                while (hijo != null && nivelLocal == -1) {
                    nivelLocal = nivelAux(elemento, hijo, nivelLocal);
                    hijo = hijo.getHermanoDerecho();
                }
                if (nivelLocal != -1) {
                    nivelLocal++;
                }
            }
        }
        return nivelLocal;
    }

    private int alturaAux(NodoGen padre) {
        /*
        Recorre el arbol en preorden, retorna la altura del subarbol de 
        mayor altura
         */
        int alturaMayor = -1, alturaHijo;
        NodoGen hijo;

        if (padre != null) {
            hijo = padre.getHijoIzquierdo();
            while (hijo != null) {
                alturaHijo = alturaAux(hijo);
                if (alturaHijo > alturaMayor) {
                    alturaMayor = alturaHijo;
                }
                hijo = hijo.getHermanoDerecho();
            }
            alturaMayor++; //Altura del subarbol mas alto + nodo actual
        }
        return alturaMayor;
    }

    private boolean ancestrosAux(Object elemento, NodoGen padre, Lista ancestros) {
        /*
        Recorre el arbol en preorden, una vez encontrado el elemento se insertan
        los elementos en la lista al regresar de la recursion
         */
        boolean encontrado = false;
        NodoGen hijo;

        if (padre != null) {
            if (padre != null) {
                if (padre.getElemento().equals(elemento)) {
                    //Encontrado
                    encontrado = true;
                } else {
                    //No encontrado, busca en hijos 
                    hijo = padre.getHijoIzquierdo();
                    while (hijo != null && encontrado == false) {
                        encontrado = ancestrosAux(elemento, hijo, ancestros);
                        hijo = hijo.getHermanoDerecho();
                    }
                    if (encontrado == true) {
                        ancestros.insertar(padre.getElemento(), ancestros.longitud() + 1);
                    }
                }
            }
        }
        return encontrado;
    }

    private NodoGen obtenerNodo(Object elementoBuscado, NodoGen padre) {
        /*
        Recorre el arbol en preorden buscando al elemento ingresado por parametro
         */
        NodoGen encontrado = null, hijo;

        if (padre != null) {
            if (padre.getElemento().equals(elementoBuscado)) {
                //Encontrado
                encontrado = padre;
            } else {
                //No encontrado, busca en hijos 
                hijo = padre.getHijoIzquierdo();
                while (hijo != null && encontrado == null) {
                    encontrado = obtenerNodo(elementoBuscado, hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return encontrado;
    }

}
