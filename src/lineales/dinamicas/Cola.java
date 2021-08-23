
package lineales.dinamicas;

/**
 *  @author 
 */

public class Cola {
    //TDA de cola dinamica
    
    private Nodo frente, fin;
    
    //Constructor
    
    public Cola(){
        this.fin = null;
        this.frente = null;
    }
    
    //Operaciones
    
    public boolean poner(Object elemento){
        //Crea un nodo con el elemento y lo pone en la cola
        Nodo newNodo;
        boolean exito = false;
        
        if(this.fin == null && this.frente == null){
            //Cola vacia
            newNodo = new Nodo(elemento, null);
            this.fin = newNodo;
            this.frente = newNodo;
            exito = true;
        }else{
            newNodo = new Nodo(elemento, null);
            this.fin.setEnlace(newNodo);
            this.fin = newNodo;
            exito = true;
        }
        return exito;
    }
    
    public boolean sacar(){
        //Saca un nodo de la cola por el frente
        boolean exito;
        
        if(this.frente == null){
            //Cola vacia
            exito = false;
        }else{
            this.frente = this.frente.getEnlace();
            if(this.frente == null){
                //Cola vacia
                this.fin = null;
            }
            exito = true;
        }
        return exito;
    }
    
    public boolean esVacia(){
        //Retorna si la cola esta vacia o no
        return (this.fin == null && this.frente == null);
    }
    
    public Object obtenerFrente(){
        //Retorna el elemento en el frente de la cola
        Object elemento;
        
        if(this.fin == null && this.frente == null){
            //Cola vacia
            elemento = null;
        }else{
            elemento = this.frente.getElemento();
        }
        return elemento;
    }
    
    public boolean vaciar(){
        //Vacia la cola
        this.fin = null;
        this.frente = null;
        return true;
    }
    
    public String toString(){
        //Retorna un string con los elementos de la cola
        //[Frente ... Final]
        String cadena = "[";
        Nodo aux;
        
        aux = this.frente;
        while(aux != null){
            cadena = cadena + aux.getElemento().toString() + ", ";
            aux = aux.getEnlace();
        }
        cadena = cadena + "] Din";
        return cadena;
    }
    
    public Cola clone(){
        //Retorna un clon de la cola original
        Cola colaClon = new Cola();
        
        cloneAux(colaClon, this.frente);
        return colaClon;
    }
    
    //Auxiliares
    
    private void cloneAux(Cola colaClon, Nodo nodoOriginal){
        /**Recorre hasta el final la cola original y copia los elementos
         * a una nueva cola
         */
        //[Frente ... Final]
        if(nodoOriginal != null){
            Nodo newNodo = new Nodo(nodoOriginal.getElemento(), null);
            if(nodoOriginal.getEnlace() == null){
                //Ultimo caso, se asigna el final de la cola clon
                colaClon.fin = newNodo;
            }else{
                //Caso contrario pasa al siguiente nodo
                cloneAux(colaClon, nodoOriginal.getEnlace());
            }
            newNodo.setEnlace(colaClon.frente);
            colaClon.frente = newNodo;
        }
    }
}
