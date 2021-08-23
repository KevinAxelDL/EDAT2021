
package jerarquicas;

/**
 *  @author 
 */

public class NodoGen {
    private Object elemento;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    public NodoGen(Object elemento, NodoGen hijoIzquierdo, NodoGen hermanoDerecho){
        this.elemento = elemento;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hermanoDerecho = hermanoDerecho;
    }
    
    public Object getElemento(){
        return this.elemento;
    }
    
    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }
    
    public NodoGen getHermanoDerecho(){
        return this.hermanoDerecho;
    }
    //
    public void setHermanoDerecho(NodoGen hermanoDerecho){
        this.hermanoDerecho = hermanoDerecho;
    }
    
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    
    public void setHijoIzquierdo(NodoGen hijoIzqExtremo){
        this.hijoIzquierdo = hijoIzqExtremo;
    }

    @Override
    public String toString() {
        return "NodoGen{" + "elemento=" + elemento + '}';
    }
    
    
    
}
