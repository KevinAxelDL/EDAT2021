
package jerarquicas;

/**
 *  @author 
 */

public class NodoArbol {
    //Nodo utilizado por arbol binario dinamico
    
    private Object elemento;
    private NodoArbol hijoIzq, hijoDer;
    
    public NodoArbol(Object elemento, NodoArbol hijoIzq, NodoArbol hijoDer){
        this.elemento = elemento;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }
    
    public Object getElemento(){
        return this.elemento;
    }
    
    public NodoArbol getIzquierdo(){
        return this.hijoIzq;
    }
    
    public NodoArbol getDerecho(){
        return this.hijoDer;
    }
    //
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    
    public void setIzquierdo(NodoArbol nodo){
        this.hijoIzq = nodo;
    }
    
    public void setDerecho(NodoArbol nodo){
        this.hijoDer = nodo;
    }
}
