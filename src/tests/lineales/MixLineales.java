
package tests.lineales;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
import lineales.dinamicas.Lista;
//import lineales.estaticas.Cola;
//import lineales.estaticas.Pila;

public class MixLineales {
    public static void main(String [] args){
        testGenerarOtraCola();
    }
    
    public static Cola generarOtraCola(Cola colaParametro){
        /** Recibe por parámetro una estructura de tipo Cola con elementos de tipo char que tiene el
        *   siguiente formato: a1$a2$a3$. . . .$an, donde cada ai en una sucesión de letras mayúsculas y a partir de c1
        *   debe generar como salida otra Cola de la forma: a1a1'$a2a2'$ . . . .$anan donde cada ai' es la secuencia de
        *   letras de ai invertida.
        *   Los elementos se almacenan como [A,B,C,$,D,E,$,X,Y,Z].
        *   Los elementos se deben almacenar como [A,B,C,C,B,A,$,D,E,E,D,$,X,Y,Z,Z,Y,X].
        **/
        Cola colaClon = colaParametro.clone();
        Cola newCola = new Cola();
        
        generarOtraColaAux(colaClon, newCola);
        
        return newCola;
    }
    
    
    private static Cola generarOtraColaAux(Cola cola, Cola newCola){
        /**Recorre la cola validando y sacando elementos y realiza la operacion con newCola y
         * una pila auxiliar
         */
        Pila pilaAux = new Pila();
        boolean colaValida = true;
        Object frenteCola;
        
        while(!cola.esVacia() && colaValida){
            frenteCola = cola.obtenerFrente();
            //Recorre la cola hasta que este vacia y mientras que los elementos sean validos
            while(!cola.esVacia() && (char)frenteCola != '$' && colaValida){
                //Recorre una fraccion de la cola
                //NOTA: obtenerFrente puede asignarse a una variable 
                if(((char)frenteCola >= (int)'a' && (char)frenteCola <= (int)'z') || (((char)frenteCola >= (int)'A' && (char)frenteCola <= (int)'Z'))){
                    //Si el elemento es valido
                    newCola.poner(Character.toUpperCase((char)frenteCola));
                    pilaAux.apilar(Character.toUpperCase((char)frenteCola));
                    cola.sacar();
                    frenteCola = cola.obtenerFrente();

                }else{
                    //Elemento no valido
                    colaValida = false;
                    newCola.vaciar();
                }
            }
            if(colaValida){
                while(!pilaAux.esVacia()){
                    //Pone los elementos de la pila en la cola
                    newCola.poner(pilaAux.obtenerTope());
                    pilaAux.desapilar();
                }
                cola.sacar();//Saca el char '$'
                newCola.poner('$');
            }
        } 
        return newCola;
    }
    
    public static Cola generarCola(Cola c1){
        /*
        Recibe por parámetro una estructura cola c1 que tiene el siguiente 
        formato: a1#a2#a3#….#an, donde cada ai en una sucesión de letras 
        mayúsculas y a partir de c1 debe generar como salida otra Cola de la 
        forma: a1a1´a1#a2a2´a2#….#anan´an donde cada ai´ es la 
        secuencia de letras mayúsculas ai pero invertida. Ejemplo.: Si c1 es : 
        AB#C#DEF , entonces la operación generar devolverá una Cola con el 
        siguiente formato: ABBAAB#CCC#DEFFEDDEF
        */
        
        int pos = 0, pos2 = 0;
        Cola c2 = c1.clone(), colaFin = new Cola();
        Lista listaAux = new Lista();
        Pila pilaAux = new Pila();
        
        while(!c2.esVacia()){
            pos2 = 0;
            pos = 0;
            while(!c2.esVacia() && (char)c2.obtenerFrente() != '#'){
                pilaAux.apilar(c2.obtenerFrente());
                pos ++;
                listaAux.insertar(c2.obtenerFrente(), pos);
                c2.sacar();
            }
            while(!pilaAux.esVacia()){
                listaAux.insertar(pilaAux.obtenerTope(), listaAux.longitud()+1);
                pilaAux.desapilar();
            }
            while(pos2 != pos){
                pos2 ++;
                listaAux.insertar(listaAux.recuperar(pos2), listaAux.longitud()+1);
            }
            while(!listaAux.esVacia()){
                colaFin.poner(listaAux.recuperar(1));
                listaAux.eliminar(1);
            }
            colaFin.poner('#');
            c2.sacar();
            
        }
        return colaFin;
    }
    
    public static void testGenerarOtraCola(){
        //Test de el modulo generarOtraCola
        Cola cola = new Cola(), colaClon;
        
        System.out.println("/////generarOtraCola /////");
        //--------------
        System.out.println("Estado de cola: []");
        System.out.println("poner(A): "+cola.poner('A'));
        System.out.println("poner(B): "+cola.poner('B'));
        System.out.println("poner(C): "+cola.poner('C'));
        System.out.println("poner($): "+cola.poner('$'));
        System.out.println("poner(4): "+cola.poner('4'));
        System.out.println("poner(5): "+cola.poner('5'));
        System.out.println("poner(6): "+cola.poner('6'));
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println(generarOtraCola(cola).toString());
        cola.vaciar();
        System.out.println("------------------");
        //--------------
        System.out.println("Estado de cola: []");
        System.out.println("poner(A): "+cola.poner('A'));
        System.out.println("poner(B): "+cola.poner('B'));
        System.out.println("poner(C): "+cola.poner('C'));
        System.out.println("poner($): "+cola.poner('$'));
        System.out.println("poner(X): "+cola.poner('X'));
        System.out.println("poner(Y): "+cola.poner('Y'));
        System.out.println("poner(Z): "+cola.poner('Z'));
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println(generarOtraCola(cola).toString());
        cola.vaciar();
        System.out.println("------------------");
        //--------------
        System.out.println("Estado de cola: []");
        System.out.println("poner(a): "+cola.poner('a'));
        System.out.println("poner(b): "+cola.poner('b'));
        System.out.println("poner(c): "+cola.poner('c'));
        System.out.println("poner($): "+cola.poner('$'));
        System.out.println("poner(x): "+cola.poner('x'));
        System.out.println("poner(y): "+cola.poner('y'));
        System.out.println("poner(z): "+cola.poner('z'));
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println(generarOtraCola(cola).toString());
        cola.vaciar();
        System.out.println("------------------");
        //--------------
        System.out.println("Estado de cola: []");
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println(generarOtraCola(cola).toString());
        cola.vaciar();
        System.out.println("------------------");
        //--------------
        System.out.println("Estado de cola: []");
        System.out.println("poner(a): "+cola.poner('A'));
        System.out.println("poner(b): "+cola.poner('B'));
        System.out.println("poner(c): "+cola.poner('C'));
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println(generarOtraCola(cola).toString());
        cola.vaciar();
        System.out.println("------------------");
        //--------------
        System.out.println("/////generarCola/////");
        System.out.println("Estado de cola: []");
        System.out.println("poner(A): "+cola.poner('A'));
        System.out.println("poner(B): "+cola.poner('B'));
        System.out.println("poner(C): "+cola.poner('C'));
        System.out.println("poner($): "+cola.poner('#'));
        System.out.println("poner(4): "+cola.poner('C'));
        System.out.println("poner(5): "+cola.poner('C'));
        System.out.println("poner(6): "+cola.poner('C'));
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println(generarCola(cola).toString());
        cola.vaciar();
        System.out.println("------------------");
        System.out.println("Estado de cola: []");
        System.out.println("poner(A): "+cola.poner('A'));
        System.out.println("poner(B): "+cola.poner('B'));
        System.out.println("poner(B): "+cola.poner('B'));
        System.out.println("poner(C): "+cola.poner('C'));
        System.out.println("poner($): "+cola.poner('#'));
        System.out.println("poner(4): "+cola.poner('C'));
        System.out.println("poner(5): "+cola.poner('C'));
        System.out.println("poner(6): "+cola.poner('X'));
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println(generarCola(cola).toString());
        cola.vaciar();
        System.out.println("------------------");
        System.out.println("Estado de cola: []");
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println(generarCola(cola).toString());
        cola.vaciar();
        System.out.println("------------------");
        System.out.println("Estado de cola: []");
        System.out.println("poner(A): "+cola.poner('A'));
        System.out.println("poner(B): "+cola.poner('B'));
        System.out.println("poner($): "+cola.poner('#'));
        System.out.println("poner(4): "+cola.poner('C'));
        System.out.println("poner(5): "+cola.poner('C'));
        System.out.println("poner(6): "+cola.poner('X'));
        System.out.println("obtenerFrente: "+cola.obtenerFrente());
        System.out.println("esVacia: "+cola.esVacia());
        System.out.println("toString: "+cola.toString());
        System.out.println(generarCola(cola).toString());
        cola.vaciar();
        System.out.println("------------------");
    }
}
