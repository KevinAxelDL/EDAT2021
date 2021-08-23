
package conjuntistas;

/**
 *
 * @author user-
 */
public class NodoArbol {
    private NodoArbol hijoDerecho, hijoIzquierdo;
    private Comparable elemento;
    
    public NodoArbol(Comparable elemento, NodoArbol hi, NodoArbol hd){
        this.elemento = elemento;
        this.hijoIzquierdo = hi;
        this.hijoDerecho = hd;
    }
    //
    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public Comparable getElemento() {
        return elemento;
    }
    //
    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setElemento(Comparable elemento) {
        this.elemento = elemento;
    }
}
