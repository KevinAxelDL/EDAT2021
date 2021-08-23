
package conjuntistas;

/**
 *
 * @author user-
 */
public class ArbolHeap {
    //TDA arbol heap MINIMO estatico
    private int TAMANIO;
    private Comparable[] heapArreglo;
    private int ultimo;
    
    public ArbolHeap(){
        this.TAMANIO = 11;
        this.heapArreglo = new Comparable[this.TAMANIO];
        this.ultimo = 0;
    }
    
    public boolean insertar(Comparable elemento){
        /*
        Recibe un elemento, lo inserta en el árbol y lo acomoda. Si la operación 
        termina con éxito devuelve verdadero y falso en caso contrario. 
        Nota: Acepta elementos repetidos.
        */
        boolean exito = false;
        int posElemento;
        
        if(this.ultimo < this.TAMANIO-1){
            if(this.ultimo == 0){
                //Arbol vacio, se inserta como raiz
                this.ultimo++;
                this.heapArreglo[this.ultimo] = elemento;
                exito = true;
            }else{
                //Se inserta como hijo
                this.ultimo++;
                posElemento = this.ultimo;
                this.heapArreglo[this.ultimo] = elemento;
                while(this.heapArreglo[(int)posElemento/2].compareTo(elemento) > 0 && posElemento != 1){
                    /*El elemento insertado es menor que el padre, intercambian
                    posiciones. Se utiliza la posicion 0 como auxiliar
                    */
                    this.heapArreglo[0] = this.heapArreglo[(int)posElemento/2];
                    this.heapArreglo[(int)posElemento/2] = elemento;
                    this.heapArreglo[posElemento] = this.heapArreglo[0];
                    posElemento = (int)posElemento/2;
                }
                exito = true;
            }
        }else{
            //Arbol lleno
            exito = false;
        }
        return exito;
    }
    
    public boolean eliminarCima(){ 
        /*
        Elimina el elemento de la raíz (o cima del montículo) y acomoda los 
        elementos. Si la operación termina con éxito devuelve verdadero y falso 
        si el árbol estaba vacío
        */
        boolean exito;
        if(this.ultimo == 0){
            //Arbol vacio
            exito = false;
        }else{
            //Saca la raiz y pone la ultima hoja en su lugar
            this.heapArreglo[1] = this.heapArreglo[this.ultimo];
            this.ultimo--;
            //Reestablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }
    
    public Comparable recuperarCima(){
        /*
        Retorna el elemento que está en la raíz (cima del montículo). 
        */
        Comparable elemento = null;
        if(this.ultimo != 0){
            elemento = this.heapArreglo[1];
        }
        return elemento;
    }
    
    //Utiles
    
    public String toString(){
        //Retorna un string representando el arbol
        String arbolString;
        int pos;
        
        arbolString = "[\n";
        if(this.ultimo > 0){
            for(pos = 1; pos <= this.ultimo; pos++){
                arbolString = arbolString + "PADRE: "+ this.heapArreglo[pos];
                if(pos*2 <= this.heapArreglo.length -1){
                    arbolString = arbolString +"; HI: "+ this.heapArreglo[pos*2];
                }else{
                    arbolString = arbolString +"; HI: null";
                }
                if((pos*2) + 1 <= this.heapArreglo.length -1){
                    arbolString = arbolString +"; HD: "+ this.heapArreglo[pos*2 + 1];
                }else{
                    arbolString = arbolString +"; HD: null";
                }
                arbolString = arbolString + "\n";
            }
        }
        arbolString = arbolString + "] ArbolHeap\n";
        return arbolString;
    }
    
    public void vaciar(){
        //Vacia todas las posiciones del arreglo
        int pos;
        
        if(this.ultimo > 0){
            for(pos = this.TAMANIO-1; this.heapArreglo[pos] != null; pos--){
                this.heapArreglo[pos] = null;
            }
        }
        this.ultimo = 0;
    }
    
    public ArbolHeap clone(){
        //Retorna un clon del arbol actual
        ArbolHeap clon = new ArbolHeap();
        int pos;
        
        if(this.ultimo > 0){
            for(pos = 1; pos <= this.ultimo; pos++){
                clon.heapArreglo[pos] = this.heapArreglo[pos];
            }
            clon.ultimo = pos - 1;
        }
        return clon;
    }
    
    //Auxiliares
    
    private void hacerBajar(int posPadre){
        int posHijo;
        Comparable temporal = this.heapArreglo[posPadre];
        boolean salir = false;
        
        while(!salir){
            posHijo = posPadre * 2;
            if(posHijo <= this.ultimo){
                //Temporal tiene al menos un hijo (izq) y lo considera menor
                if(posHijo < this.ultimo){
                    //hijoMenor tiene hermano derecho
                    if(this.heapArreglo[posHijo+1].compareTo(this.heapArreglo[posHijo]) < 0){
                        //El hijo derecho es el menor de los dos
                        posHijo++;
                    }
                }
                //Compara al hijo menor con el padre
                if(this.heapArreglo[posHijo].compareTo(temporal) < 0){
                    //El hijo es menor al padre, los intercambia
                    this.heapArreglo[posPadre] = this.heapArreglo[posHijo];
                    this.heapArreglo[posHijo] = temporal;
                    posPadre = posHijo;
                }else{
                    //El padre es menor que sus hijos
                    salir = true;
                }
            }else{
                //El temporal es hoja
                salir = true;
            }
        }
    }
    
}
