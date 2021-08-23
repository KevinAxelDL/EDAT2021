package conjuntistas;

import lineales.dinamicas.Lista;

/**
 *
 * @author user-
 */
public class ArbolAVL {

    //TDA de arbol AVL
    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public boolean eliminar(Comparable elemento) {
        /*
        Recibe el elemento que se desea eliminar y se procede a removerlo del 
        árbol. Si no se encuentra el elemento no se puede realizar la eliminación
         */
        boolean exito = false;
        NodoAVL referencia;
        if (this.raiz.getElemento().compareTo(elemento) == 0) {
            //El elemento esta en la raiz
            determinarCasoEliminacion(null, this.raiz);
            exito = true;
        } else {
            //El elemento no esta en la raiz
            referencia = eliminarAux(elemento, this.raiz, this.raiz);
            if (referencia != null) {
                exito = true;
            }
        }
        return exito;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = false;
        NodoAVL newNodo;
        if (this.raiz == null) {
            //Arbol vacio, se inserta el elemento en la raiz
            newNodo = new NodoAVL(elemento, null, null);
            this.raiz = newNodo;
            exito = true;
        } else {
            exito = insertarAux(elemento, this.raiz, this.raiz);
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
        NodoAVL padre = this.raiz;
        while (padre.getHijoIzq() != null) {
            padre = padre.getHijoIzq();
        }
        return padre.getElemento();
    }

    public Comparable maximoElemento() {
        /*
        Recorre la rama correspondiente y devuelve el elemento más grande almacenado en el árbol
         */
        NodoAVL padre = this.raiz;
        while (padre.getHijoDer() != null) {
            padre = padre.getHijoDer();
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
        cadena = cadena + "\n}ArbolAVL";
        return cadena;
    }

    public ArbolAVL clone() {
        //Retorna un clon del arbol binario actual
        ArbolAVL arbolClon = new ArbolAVL();
        if (!this.esVacio()) {
            arbolClon.raiz = cloneAux(this.raiz);
        }
        return arbolClon;
    }

    //Extras
    public Lista listarAlturaNodos() {
        /*
        Retorna el balance de todos los nodos en una lista
         */
        Lista lista = new Lista();
        listarAlturaNodosAux(this.raiz, lista);
        return lista;
    }

    private void listarAlturaNodosAux(NodoAVL padre, Lista lista) {
        /*
        Recorre el arbol en inorden asignando los elementos a la lista
         */
        if (padre != null) {
            if (padre.getHijoIzq() != null) {
                listarAlturaNodosAux(padre.getHijoIzq(), lista);
            }
            if (padre.getHijoDer() != null) {
                listarAlturaNodosAux(padre.getHijoDer(), lista);
            }
            lista.insertar(padre.getElemento(), lista.longitud() + 1);
            lista.insertar(padre.getAltura(), lista.longitud() + 1);
            lista.insertar(";", lista.longitud() + 1);
        }
    }

    //Auxiliares
    private NodoAVL eliminarAux(Comparable elemento, NodoAVL padre, NodoAVL abuelo) {
        /*
        Recorre el arbol hasta encontrar el elemento, evalua que caso de
        eliminacion se aplica
         */
        NodoAVL referencia = null;

        if (padre != null) {
            if (padre.getHijoIzq() != null && padre.getHijoIzq().getElemento().compareTo(elemento) == 0) {
                //El elemento es el HI
                referencia = padre.getHijoIzq();
                determinarCasoEliminacion(padre, referencia);
            } else {
                if (padre.getHijoDer() != null && padre.getHijoDer().getElemento().compareTo(elemento) == 0) {
                    //El elemento es el HD
                    referencia = padre.getHijoDer();
                    determinarCasoEliminacion(padre, referencia);

                } else {
                    //No encontrado, llama a un hijo dependiendo del elemento
                    if (padre.getElemento().compareTo(elemento) > 0) {
                        //Elemento menor que el padre
                        referencia = eliminarAux(elemento, padre.getHijoIzq(), padre);

                    } else {
                        if (padre.getElemento().compareTo(elemento) < 0) {
                            //Elemento mayor que el padre
                            referencia = eliminarAux(elemento, padre.getHijoDer(), padre);

                        }
                    }
                }
            }
            padre.recalcularAltura();
            balancear(padre, abuelo);

        }
        return referencia;
    }

    private void determinarCasoEliminacion(NodoAVL padre, NodoAVL referencia) {
        /*
        Determina que caso de eliminacion es el correcto para la referencia
         */
        if (referencia.getHijoIzq() == null && referencia.getHijoDer() == null) {
            //Caso 1
            eliminarCaso1(padre, referencia);
        } else {
            if (referencia.getHijoIzq() != null && referencia.getHijoDer() == null || referencia.getHijoIzq() == null && referencia.getHijoDer() != null) {
                //Caso 2
                eliminarCaso2(padre, referencia);
            } else {
                if (referencia.getHijoIzq() != null && referencia.getHijoDer() != null) {
                    //Caso 3
                    eliminarCaso3(referencia);
                }
            }
        }
    }

    private void eliminarCaso3(NodoAVL nodo) {
        /*
        El elemento tiene dos hijos, se busca el mayor decendiente
        del subarbol izquierdo para remplazar el elemento hijo
         */
        if (nodo.getHijoIzq().getHijoDer() == null) {
            /*
            El HI del nodo no tiene HD, el HI es el mayor del subarbol izquierdo
             */
            nodo.setElemento(nodo.getHijoIzq().getElemento());
            nodo.setHijoIzq(null);
            System.out.println("CASO 3 ESPECIAL");
        } else {
            /* 
            El HI del nodo tiene HD, se busca el mayor elemento del subarbol izquierdo
             */
            NodoAVL abueloAux = nodo.getHijoIzq();
            NodoAVL padreAux = abueloAux.getHijoDer();
            NodoAVL hijoAux = padreAux.getHijoDer();
            while (hijoAux != null) {
                abueloAux = padreAux;
                padreAux = hijoAux;
                hijoAux = padreAux.getHijoDer();
            }
            nodo.setElemento(padreAux.getElemento());
            abueloAux.setHijoDer(null);
            System.out.println("CASO 3");
        }

    }

    private void eliminarCaso2(NodoAVL padre, NodoAVL hijo) {
        /*
        El elemento tiene un hijo
         */
        if (hijo.getElemento().compareTo(this.raiz.getElemento()) != 0) {
            if (padre.getElemento().compareTo(hijo.getElemento()) > 0) {
                //Se remplaza HI 
                if (hijo.getHijoIzq() != null) {
                    padre.setHijoIzq(hijo.getHijoIzq());
                } else {
                    padre.setHijoIzq(hijo.getHijoDer());
                }
            } else {
                //Se remplaza HD
                if (hijo.getHijoIzq() != null) {
                    padre.setHijoDer(hijo.getHijoIzq());
                } else {
                    padre.setHijoDer(hijo.getHijoDer());
                }
            }
            System.out.println("CASO 2");
        } else {
            //El elemento es la raiz
            if (this.raiz.getHijoIzq() != null) {
                this.raiz = this.raiz.getHijoIzq();
            } else {
                this.raiz = this.raiz.getHijoDer();
            }
            System.out.println("CASO 2 ESPECIAL");
        }
    }

    private void eliminarCaso1(NodoAVL padre, NodoAVL hijo) {
        /*
        El elemento es hoja
         */
        if (hijo.getElemento().compareTo(this.raiz.getElemento()) != 0) {
            if (padre.getElemento().compareTo(hijo.getElemento()) > 0) {
                //Se elimina HI
                padre.setHijoIzq(null);
            } else {
                //Se elimina HD
                padre.setHijoDer(null);
            }
            System.out.println("CASO 1 ");
        } else {
            //El elemento es la raiz
            this.raiz = null;
            System.out.println("CASO 1 ESPECIAL");
        }

    }

    private boolean insertarAux(Comparable elemento, NodoAVL padre, NodoAVL abuelo) {
        /*
        Reccorre el arbol hasta encontrar la posicion correcta con respecto al 
        elemento en el parametro, se inserta si el elemento no esta repetido
         */
        NodoAVL newElemento;
        boolean exito = false;

        if (padre != null) {
            if (padre.getElemento().compareTo(elemento) > 0) {
                /*
                El padre es mayor que el elemento, se recorre el subarbol
                izquierdo
                 */
                if (padre.getHijoIzq() == null) {
                    /*
                    El padre no pose HI, se inserta el elemento como nuevo HI
                     */
                    newElemento = new NodoAVL(elemento, null, null);
                    padre.setHijoIzq(newElemento);
                    exito = true;
                } else {
                    exito = insertarAux(elemento, padre.getHijoIzq(), padre);
                }
            } else {
                if (padre.getElemento().compareTo(elemento) < 0) {
                    /*
                    El padre es menor que el elemento, se recorre el subarbol
                    derecho
                     */
                    if (padre.getHijoDer() == null) {
                        /*
                        El padre no pose HD, se inserta el elemento como nuevo HD
                         */
                        newElemento = new NodoAVL(elemento, null, null);
                        padre.setHijoDer(newElemento);
                        exito = true;
                    } else {
                        exito = insertarAux(elemento, padre.getHijoDer(), padre);
                    }
                }
            }
            if (exito == true) {
                //Se realizo un cambio en el arbol, se revisa el balance del padre
                padre.recalcularAltura(); //Recalcula luego de ingresar un elemento
                balancear(padre, abuelo);
            }
        }
        return exito;
    }

    private void balancear(NodoAVL padre, NodoAVL abuelo) {
        //Balancea el arbol de ser necesario
        NodoAVL newPadre;
        int balance;
        balance = calcularBalance(padre);
        if (balance == 2 || balance == -2) {
            /*
            Arbol desbalanceado, se balancea
             */
            newPadre = determinarCasoRotacion(padre, balance);
            if (padre.getElemento().compareTo(this.raiz.getElemento()) == 0) {
                //Caso especial, se remplaza la raiz
                this.raiz = newPadre;
            } else {
                if (abuelo.getHijoIzq().getElemento().compareTo(padre.getElemento()) == 0) {
                    //Se remplaza el HI del abuelo
                    abuelo.setHijoIzq(newPadre);
                } else {
                    //Se remplaza el HD del abuelo
                    abuelo.setHijoDer(newPadre);
                }
            }
        }
    }

    private NodoAVL determinarCasoRotacion(NodoAVL padre, int balance) {
        /*
        Determina que caso de rotacion debe aplicarse segun el balance de los
        nodos
         */
        int balanceHijo;
        NodoAVL newPadre;
        if (balance == 2) {
            //Subarbol caido a la izquierda
            balanceHijo = calcularBalance(padre.getHijoIzq());
            if (balanceHijo == -1) {
                //Rotacion doble izquierda-derecha
                newPadre = rotacionIzquierda(padre.getHijoIzq());
                padre.setHijoIzq(newPadre);
                newPadre = rotacionDerecha(padre);
                System.out.println("ROTACION IZQ-DER");
            } else {
                //Rotacion simple derecha
                newPadre = rotacionDerecha(padre);
                System.out.println("ROTACION DER");
            }
        } else {
            //Subarbol caido a la derecha
            balanceHijo = calcularBalance(padre.getHijoDer());
            if (balanceHijo == 1) {
                //Rotacion doble derecha-izquierda
                newPadre = rotacionDerecha(padre.getHijoDer());
                padre.setHijoDer(newPadre);
                newPadre = rotacionIzquierda(padre);
                System.out.println("ROTACION DER-IZQ");
            } else {
                //Rotacion simple izquierda
                newPadre = rotacionIzquierda(padre);
                System.out.println("ROTACION IZQ");
            }
        }
        return newPadre;
    }

    private NodoAVL rotacionIzquierda(NodoAVL padre) {
        //Realiza la operacion de rotacion de elementos hacia la izquierda
        NodoAVL temporal, hijoDer;
        hijoDer = padre.getHijoDer();
        temporal = hijoDer.getHijoIzq();
        hijoDer.setHijoIzq(padre);
        padre.setHijoDer(temporal);
        if (hijoDer.getHijoIzq() != null) {
            hijoDer.getHijoIzq().recalcularAltura(); //Recalcula la altura luego de las rotaciones
        }
        if (hijoDer.getHijoDer() != null) {
            hijoDer.getHijoDer().recalcularAltura();//Recalcula la altura luego de las rotaciones
        }
        hijoDer.recalcularAltura();//Recalcula la altura luego de las rotaciones
        return hijoDer;
    }

    private NodoAVL rotacionDerecha(NodoAVL padre) {
        //Realiza la operacion de rotacion de elementos hacia la derecha
        NodoAVL temporal, hijoIzq;
        hijoIzq = padre.getHijoIzq();
        temporal = hijoIzq.getHijoDer();
        hijoIzq.setHijoDer(padre);
        padre.setHijoIzq(temporal);
        if (hijoIzq.getHijoIzq() != null) {
            hijoIzq.getHijoIzq().recalcularAltura(); //Recalcula la altura luego de las rotaciones
        }
        if (hijoIzq.getHijoDer() != null) {
            hijoIzq.getHijoDer().recalcularAltura();//Recalcula la altura luego de las rotaciones
        }
        hijoIzq.recalcularAltura();//Recalcula la altura luego de las rotaciones
        return hijoIzq;
    }

    private int calcularBalance(NodoAVL padre) {
        //Calcula el balance de un nodo
        int alturaIzq = -1, alturaDer = -1;
        if (padre.getHijoIzq() != null) {
            alturaIzq = padre.getHijoIzq().getAltura();
        }
        if (padre.getHijoDer() != null) {
            alturaDer = padre.getHijoDer().getAltura();
        }
        return (alturaIzq - alturaDer);
    }

    private NodoAVL cloneAux(NodoAVL padre) {
        /*
        Recorre el arbol en preorden clonando los nodos del arbol original
        Retorna la referencia al nodo actual
         */
        NodoAVL enlace = null, hijo;
        if (padre != null) {
            enlace = new NodoAVL(padre.getElemento(), null, null);
            hijo = cloneAux(padre.getHijoIzq());//Llama con HI
            enlace.setHijoIzq(hijo);
            hijo = cloneAux(padre.getHijoDer());//Llama con HD
            enlace.setHijoDer(hijo);
            enlace.recalcularAltura();
        }
        return enlace;
    }

    private String toStringAux(NodoAVL padre, String cadena) {
        /*
        Recorre el arbol en preorden y concatena los elemento del arbol en un
        string
         */
        if (padre != null) {
            cadena = cadena + "\nPadre: " + padre.getElemento();
            if (padre.getHijoIzq() != null) {
                //HI
                cadena = cadena + "\nHI: " + padre.getHijoIzq().getElemento();
            } else {
                cadena = cadena + "\nHI: null";
            }
            //------------
            if (padre.getHijoDer() != null) {
                //HD
                cadena = cadena + "\nHD: " + padre.getHijoDer().getElemento();
            } else {
                cadena = cadena + "\nHD: null";
            }
            cadena = cadena + "\n---";
            cadena = toStringAux(padre.getHijoIzq(), cadena);
            cadena = toStringAux(padre.getHijoDer(), cadena);
        }

        return cadena;
    }

    private void listarRangoAux(Lista lista, Comparable elemMin, Comparable elemMax, NodoAVL padre) {
        if (padre != null) {
            if (padre.getElemento().compareTo(elemMin) >= 0 && padre.getElemento().compareTo(elemMax) <= 0) {
                //El padre esta en el rango, se agrega a la lista
                lista.insertar(padre.getElemento(), lista.longitud() + 1);
                listarRangoAux(lista, elemMin, elemMax, padre.getHijoIzq());
                listarRangoAux(lista, elemMin, elemMax, padre.getHijoDer());
            } else {
                //El padre no esta en el rango, se revisan sus hijos
                if (padre.getElemento().compareTo(elemMin) < 0) {
                    //Padre menor que el minimo elemento del rango, busca por HD
                    listarRangoAux(lista, elemMin, elemMax, padre.getHijoDer());
                } else {
                    //Padre mayor que el maximo elemento del rango, busca por HI
                    listarRangoAux(lista, elemMin, elemMax, padre.getHijoIzq());
                }
            }
        }
    }

    private void listarAux(Lista lista, NodoAVL padre) {
        /*
        Recorre el arbol en inorden agregando los elementos a una lista
         */
        if (padre != null) {
            listarAux(lista, padre.getHijoIzq());
            lista.insertar(padre.getElemento(), lista.longitud() + 1);
            listarAux(lista, padre.getHijoDer());
        }
    }

    private boolean perteneceAux(Comparable elemento, NodoAVL padre) {
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
                    encontrado = perteneceAux(elemento, padre.getHijoIzq());
                } else {
                    //Busca por HD
                    encontrado = perteneceAux(elemento, padre.getHijoDer());
                }
            }
        }
        return encontrado;
    }

}
