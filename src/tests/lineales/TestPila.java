/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import lineales.estaticas.Pila;//Para evaluar Pila Estatica
//import lineales.dinamicas.Pila;//Para evaluar Pila Dinamica
import repaso.TdaAlumno;
/**
 *
 * @author user-
 */
public class TestPila {
    public static void main(String[]args){
        //Evalua la clase Pila
        Pila pila = new Pila(), pilaClon;
        boolean aux = true;
        int contador;
        
        System.out.println("/////INCIO TEST/////");
        System.out.println("Estado de pila: []");
        System.out.println("toString: "+pila.toString());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("esVacia: "+pila.esVacia());
        System.out.println("obtenerTope: "+pila.obtenerTope());
        System.out.println("vaciar: "+pila.vaciar());
        System.out.println("toString: "+pila.toString());
        System.out.println("----------");
        System.out.println("Estado de pila: []");
        System.out.println("apilar(1): "+pila.apilar(1));
        System.out.println("apilar(2): "+pila.apilar(2));
        System.out.println("apilar(3): "+pila.apilar(3));
        System.out.println("apilar(4): "+pila.apilar(4));
        System.out.println("apilar(5): "+pila.apilar(5));
        System.out.println("apilar(6): "+pila.apilar(6));
        System.out.println("apilar(7): "+pila.apilar(7));
        System.out.println("apilar(8): "+pila.apilar(8));
        System.out.println("apilar(9): "+pila.apilar(9));
        System.out.println("apilar(10): "+pila.apilar(10));
        System.out.println("apilar(11): "+pila.apilar(11));
        System.out.println("obtenerTope: "+pila.obtenerTope());
        System.out.println("esVacia: "+pila.esVacia());
        System.out.println("toString: "+pila.toString());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("obtenerTope: "+pila.obtenerTope());
        System.out.println("esVacia: "+pila.esVacia());
        System.out.println("toString: "+pila.toString());
        System.out.println("apilar(6): "+pila.apilar(6));
        System.out.println("apilar(7): "+pila.apilar(7));
        System.out.println("apilar(8): "+pila.apilar(8));
        System.out.println("apilar(9): "+pila.apilar(9));
        System.out.println("apilar(10): "+pila.apilar(10));
        System.out.println("toString: "+pila.toString());
        System.out.println("/////CLONE/////");
        pilaClon = pila.clone();
        System.out.println("pilaClon toString: "+pilaClon.toString());
        System.out.println("pila toString: "+pila.toString());
        System.out.println("pila vaciar: "+pila.vaciar());
        System.out.println("pilaClon toString: "+pilaClon.toString());
        System.out.println("pila toString: "+pila.toString());
        System.out.println("pilaClon obtenerTope: "+pilaClon.obtenerTope());
        System.out.println("pila obtenerTope: "+pila.obtenerTope());
        System.out.println("Clona pila vacia:");
        pilaClon = pila.clone();
        System.out.println("pilaClon toString: "+pilaClon.toString());
        System.out.println("pila toString: "+pila.toString());
        System.out.println("/////FIN TEST/////");
        //----------------------------------------------------------------------
        System.out.println("pila vaciar: "+pila.vaciar());
        System.out.println("pila toString: "+pila.toString());
        System.out.println("/////TEST esCapicua/////");
        System.out.println("apilar(1): "+pila.apilar(1));
        System.out.println("apilar(2): "+pila.apilar(2));
        System.out.println("apilar(3): "+pila.apilar(3));
        System.out.println("apilar(2): "+pila.apilar(2));
        System.out.println("apilar(1): "+pila.apilar(1));
        System.out.println("toString: "+pila.toString());
        System.out.println("Es capicua, debe retorar TRUE. Resultado: "+esCapicua(pila));
        System.out.println("vaciar: "+pila.vaciar());
        System.out.println("toString: "+pila.toString());
        System.out.println("apilar(1): "+pila.apilar(1));
        System.out.println("apilar(2): "+pila.apilar(2));
        System.out.println("apilar(2): "+pila.apilar(2));
        System.out.println("apilar(1): "+pila.apilar(1));
        System.out.println("toString: "+pila.toString());
        System.out.println("Es capicua, debe retorar TRUE. Resultado: "+esCapicua(pila));
        System.out.println("vaciar: "+pila.vaciar());
        System.out.println("toString: "+pila.toString());
        System.out.println("Es capicua, debe retorar TRUE. Resultado: "+esCapicua(pila));
        System.out.println("apilar(1): "+pila.apilar(1));
        System.out.println("apilar(2): "+pila.apilar(2));
        System.out.println("apilar(3): "+pila.apilar(3));
        System.out.println("apilar(2): "+pila.apilar(4));
        System.out.println("apilar(1): "+pila.apilar(5));
        System.out.println("toString: "+pila.toString());
        System.out.println("Es capicua, debe retorar FALSE. Resultado: "+esCapicua(pila));
        System.out.println("/////FIN TEST/////");
        //----------------------------------------------------------------------
        System.out.println("pila vaciar: "+pila.vaciar());
        System.out.println("pila toString: "+pila.toString());
        System.out.println("/////INCIO TEST PILA con String/////");
        System.out.println("apilar(pe): "+pila.apilar("pe"));
        System.out.println("apilar(pi): "+pila.apilar("pi"));
        System.out.println("apilar(po): "+pila.apilar("po"));
        System.out.println("apilar(pu): "+pila.apilar("pu"));
        System.out.println("obtenerTope: "+pila.obtenerTope());
        System.out.println("esVacia: "+pila.esVacia());
        System.out.println("toString: "+pila.toString());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("obtenerTope: "+pila.obtenerTope());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("esVacia: "+pila.esVacia());
        System.out.println("toString: "+pila.toString());
        System.out.println("/////FIN TEST/////");
        //----------------------------------------------------------------------
        System.out.println("pila vaciar: "+pila.vaciar());
        System.out.println("pila toString: "+pila.toString());
        System.out.println("/////TEST esCapicua/////");
        System.out.println("apilar(pe): "+pila.apilar("pe"));
        System.out.println("apilar(pi): "+pila.apilar("pi"));
        System.out.println("apilar(po): "+pila.apilar("po"));
        System.out.println("apilar(pi): "+pila.apilar("pi"));
        System.out.println("apilar(pe): "+pila.apilar("pe"));
        System.out.println("toString: "+pila.toString());
        System.out.println("Es capicua, debe retorar TRUE. Resultado: "+esCapicua(pila));
        System.out.println("vaciar: "+pila.vaciar());
        System.out.println("toString: "+pila.toString());
        System.out.println("apilar(pe): "+pila.apilar("pe"));
        System.out.println("apilar(pi): "+pila.apilar("pi"));
        System.out.println("apilar(pi): "+pila.apilar("pi"));
        System.out.println("apilar(pe): "+pila.apilar("pe"));
        System.out.println("toString: "+pila.toString());
        System.out.println("Es capicua, debe retorar TRUE. Resultado: "+esCapicua(pila));
        System.out.println("vaciar: "+pila.vaciar());
        System.out.println("toString: "+pila.toString());
        System.out.println("Es capicua, debe retorar TRUE. Resultado: "+esCapicua(pila));
        System.out.println("apilar(pe): "+pila.apilar("pe"));
        System.out.println("apilar(pi): "+pila.apilar("pi"));
        System.out.println("apilar(po): "+pila.apilar("po"));
        System.out.println("toString: "+pila.toString());
        System.out.println("Es capicua, debe retorar FALSE. Resultado: "+esCapicua(pila));
        System.out.println("/////FIN TEST/////");
        //----------------------------------------------------------------------
        System.out.println("pila vaciar: "+pila.vaciar());
        System.out.println("pila toString: "+pila.toString());
        System.out.println("/////INCIO TEST PILA con TdaAlumno/////");
        System.out.println("Estado de pila: []");
        System.out.println("apilar(TdaAlumno('a',4000,\"Julian\",\"Perez\")");pila.apilar(new TdaAlumno('a',4000,"Julian","Perez"));
        System.out.println("apilar(TdaAlumno('a',5000,\"Martin\",\"Doe\")");pila.apilar(new TdaAlumno('a',5000,"Martin","Doe"));
        System.out.println("apilar(TdaAlumno('B',6000,\"Dolan\",\"Domingo\")");pila.apilar(new TdaAlumno('B',6000,"Dolan","Domingo"));
        System.out.println("toString: "+pila.toString());
        System.out.println("desapilar: "+pila.desapilar());
        System.out.println("esVacia: "+pila.esVacia());
        System.out.println("");
        System.out.println("obtenerTope: "+pila.obtenerTope());
        System.out.println("vaciar: "+pila.vaciar());
        System.out.println("toString: "+pila.toString());
    }
    
    public static boolean esCapicua(Pila pila){
        /**Retorna true si los elementos de una pila estan ubicados de forma tal
         * que esta es capicua, retorna false en caso contrario
         */
        Pila pilaAux = new Pila(), pilaClon = pila.clone(), pilaClon2 = pila.clone();
        boolean esCapicua = true;
        
        while(!pilaClon.esVacia()){
            //Se llena la pilaAux con los elementos de pilaClon de forma inversa
            pilaAux.apilar(pilaClon.obtenerTope());
            pilaClon.desapilar();
        }
        
        while(!pilaAux.esVacia() && !pilaClon2.esVacia() && esCapicua){
            /**Mientras pilaAux y pilaClon2 no esten vacias y esCapicua == true
             * se compararan sus elementos y se desapilan
             */
            if(!pilaAux.obtenerTope().equals(pilaClon2.obtenerTope())){
                esCapicua = false;
            }else{
                pilaAux.desapilar();
                pilaClon2.desapilar();
            }
        }
        return esCapicua;
    }
    
}
