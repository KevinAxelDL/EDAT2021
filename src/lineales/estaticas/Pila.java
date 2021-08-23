
package lineales.estaticas;

public class Pila {
    //TDA de pila estatica
    
    private int TAMANIO; //Celdas del arreglo desde 0 hasta TAMANIO - 1
    private Object[] arreglo; 
    private int tope; //Marca la celda del ultimo elemento ingresado
    
    //Constructor
    
    public Pila(){
          this.TAMANIO = 10; 
          this.arreglo = new Object[this.TAMANIO];
          this.tope = -1;
    }
    
    //Operaciones
    
    public boolean apilar(Object elemento){
        //Apila un elemento en la pila
        boolean exito;
        
        if(this.tope+1 > this.TAMANIO-1){
            //Si el proximo tope es mayor al tamanio del arreglo retorna false
            exito = false;
        }else{
            this.tope ++;
            this.arreglo[this.tope] = elemento;
            exito = true;
        }
        return exito;
    }
    
    public boolean desapilar(){
        //Desapila un elemento de la pila (se sobreescriben los elementos viejos una vez se apilen nuevos)
        boolean exito;
        if(this.tope == -1){
            exito = false;
        }else{
            this.arreglo[this.tope] = null;
            tope--;
            exito = true;
        }
        return exito;
    }
    
    public Object obtenerTope(){
        //Retorna el elemento mas arriba en la pila
        Object elemento;
        if(this.tope == -1){
            elemento = null;
        }else{
            elemento = this.arreglo[this.tope];
        }
        return elemento;
    }
    
    public boolean esVacia(){
        return this.tope == -1;
    }
    
    public boolean vaciar(){
        //Vacia la pila completamente 
        
        while(this.tope != -1){
            this.arreglo[this.tope] = null;
            this.tope--;
        }
        
        return true;
    }
    
    public Pila clone(){
        //Recorre el arreglo original y copia los elementos en uno nuevo identico
        Pila clon = new Pila();
        int i;
        
        clon.tope = this.tope;
        for(i=0;i<=clon.tope;i++){
            clon.arreglo[i] = this.arreglo[i];
        }
        
        return clon;
    }
    
    public String toString(){
        //Retorna la pila actual en forma de String
        //[Fondo ... Tope]
        String cadena;
        int i;
        
        cadena = "[";
        for(i=0;i<=this.tope;i++){
            //[Primer elemento, ... , Ultimo elemento]
            cadena = cadena + this.arreglo[i].toString() + ", ";
        }
        cadena = cadena + "]Est";
        
        return cadena;
    }
}

//Operaciones auxiliares
