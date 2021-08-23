
package lineales.dinamicas;

/**
 *  @author 
 */

public class Pila {
    //TDA de pila dinamica

    private Nodo tope;
    
    //Constructor
    
    public Pila(){
        this.tope = null;
    }
    
    //Operaciones
    
    public boolean apilar(Object elemento){
        //Crea un Nodo con el elemento ingresado y lo apila
        Nodo nodo = new Nodo(elemento, null);
        
        if(this.tope == null){
            //Si la pila esta vacia
            this.tope = nodo;
        }else{
            nodo.setEnlace(this.tope);
            this.tope = nodo;
        }
        return true;
    }
    
    public boolean desapilar(){
        //Desapila el nodo en el tope de la pila
        boolean exito;
        
        if(this.tope == null){
            //Si la pila esta vacia
            exito = false;
        }else{
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;
    }
    
    public Object obtenerTope(){
        Object elemento;
        
        if(this.tope == null){
            elemento = null;
        }else{
            elemento = this.tope.getElemento();
        }
        return elemento;
    }
    
    public boolean esVacia(){
        return this.tope == null;
    }
    
    public boolean vaciar(){
        this.tope = null;
        return true;
    }
    
    public String toString(){
        //Retorna la pila actual en forma de String
        String cadena ="";

        cadena = toStringAux(cadena, this.tope);
        cadena =  "["+ cadena + "]Din";
        
        return cadena;
    }

    public Pila clone(){
        //Retorna un clon de la pila actual
        Pila clon = new Pila();
        
        cloneAux(clon, this.tope);
        return clon;
    }
    
    /**
    public Pila clone() {
        //CLONE ITERATIVO, CODIGO PARA EXAMINAR DE OTRO AUTOR
        Pila pilaClon = new Pila();
        if(this.tope != null){ //AGREGADO
            //1er paso
            pilaClon.tope = new Nodo(this.tope.getElemento(),null);//Apila prier elemento
            Nodo nodoClon = pilaClon.tope;
            Nodo nodoOriginal = this.tope.getEnlace();//Recorre pila original
            Nodo nodoNuevo;
            //2do paso
            while (nodoOriginal != null) {
                nodoNuevo = new Nodo(nodoOriginal.getElemento(),null);
                nodoClon.setEnlace(nodoNuevo);
                nodoClon = nodoNuevo;  //AGREGADO
                nodoOriginal = nodoOriginal.getEnlace(); 
            }
        }
        return pilaClon;
    }
    **/

    //Auxiliares
    
    private String toStringAux(String cadena, Nodo nodo){
        //Concatena los elementos de una pila
        //[Primer elemento ingresado, ... , Ultimo elemento ingresado]
        if(nodo != null){
            cadena = ", " +nodo.getElemento().toString() + cadena;
            if(nodo.getEnlace() != null){
                //Caso 1
                cadena = toStringAux(cadena, nodo.getEnlace());
            }
        }
        return cadena;
    }
    
    private Pila cloneAux(Pila pilaClon, Nodo nodoOriginal){
        /**Recorre la pila original hasta el final 
         * y copia sus elementos a la pila nueva
         * */
        Nodo newNodo;
        
        if(nodoOriginal != null){
            newNodo = new Nodo(nodoOriginal.getElemento(), null);//Crea el nodo nuevo
            pilaClon = cloneAux(pilaClon, nodoOriginal.getEnlace());
            newNodo.setEnlace(pilaClon.tope);//Asigna el enlace del nodo nuevo
            pilaClon.tope = newNodo;//El nodo nuevo se asigna al tope de la pila
        }
        return pilaClon;
    }
    
}
