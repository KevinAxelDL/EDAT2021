
package lineales.estaticas;

/**
 *  @author 
 */

public class Cola {
    //TDA de cola estatica
    
    private int TAMANIO;
    /**Para diferenciar entre cola llena y vacia se deja una posicion vacia, 
     * por lo que el arreglo tiene TAMANIO - 1 posiciones disponibles**/
    private Object[] arreglo;//Posiciones desde 0 a TAMANIO -1
    private int frente, fin;
    
    //Constructor
    
    public Cola(){
        this.TAMANIO = 10;
        this.arreglo = new Object[TAMANIO];
        this.frente =0;
        this.fin = 0;
    }
    
    //Operaciones
    
    public boolean poner(Object elemento){
        /*Pone un elemento en la cola, si la cola esta llena retorna false,
        caso contrario retorna true y pone el elemento
        */
        boolean exito;
        
        if((this.fin + 1) % this.TAMANIO == this.frente){
            //Cola llena
            exito = false;
        }else{
            this.arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % this.TAMANIO;
            exito = true;
        }
        return exito;
    }
    
    public boolean sacar(){
        /*Saca un elemento si la cola no esta vacia*/
        boolean exito;
        
        if(this.frente == this.fin){
            //Cola vacia
            exito = false;
        }else{
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
            exito = true;
        }
        return exito;
    }
    
    public Object obtenerFrente(){
        //Retorna el frente de la cola
        Object elemento;
        
        if(this.frente == this.fin){
            //Pila vacia
            elemento = null;
        }else{
            elemento = this.arreglo[this.frente];
        }
        return elemento;
    }
    
    public boolean esVacia(){
        //Retorna true si esta vacia la cola, false en caso contrario
        return this.frente == this.fin;
    }
    
    public boolean vaciar(){
        //Vacia la cola entera
        boolean exito;
        int i;
        for(i = this.frente;i != this.fin; i = (i + 1) % this.TAMANIO){
            this.arreglo[i] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        exito = true;
        return exito;
    }
    
    public String toString(){
        //Retorna un string con los elementos de la cola
        //[Frente ... Final]
        String cadena;
        int i;
        
        cadena ="[";
        for(i = this.frente; i != this.fin; i = (i + 1) % this.TAMANIO){
            if(this.arreglo[i] != null){
                cadena = cadena + " ," + this.arreglo[i].toString();
            }else{
                cadena = cadena + " ," + "( )";
            }
        }
        cadena = cadena + "]Est";
        return cadena;
    }
    
    public Cola clone(){
        //Retorna un clon de la cola auctual
        Cola clon = new Cola();
        int i;
        
        if(this.frente != this.fin){
            for(i = this.frente;i != this.fin; i = (i + 1) % this.TAMANIO){
                clon.arreglo[i] = this.arreglo[i];
            }
            clon.fin = this.fin;
            clon.frente = this.frente;
        }
        return clon;
    }
    
}
