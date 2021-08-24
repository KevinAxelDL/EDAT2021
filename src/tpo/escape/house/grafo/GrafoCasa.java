/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo.escape.house.grafo;

import tpo.escape.house.Cuarto;
/**
 *
 * @author user-
 */
public class GrafoCasa {
    // TDA de grafo etiquetado no dirigido implementado como lista de adyacencia
    
    private NodoVertCuarto inicio;
    
    public GrafoCasa(){
        this.inicio = null;
    }
    
    public boolean insertarVertice(Cuarto newCuarto){
        /*Inserta un nuevo nodo en la estructura con un nuevo elemento
        si este no se repite
        */
        NodoVertCuarto nodoBus;
        boolean exito = false;
            //SFKNMASdfjohnasdfujiobased
            //adfadasdasdasdasdasdasd
        if(inicio == null){
            //Grafo vacio
            NodoVertCuarto newNodo = new NodoVertCuarto();
            newNodo.setClaveCuarto(newCuarto);
            this.inicio = newNodo;
            exito = true;
        }else{
            //Grafo no vacio, buscan repetidos
            nodoBus = obtenerNodo(this.inicio, newCuarto);
            if(nodoBus != null){
                //Elemento inexistente, se inserta
                insertarAux(this.inicio, newCuarto);
                exito = true;
            }
        }
        return exito;
    }
    
    public boolean eliminarVertice(Cuarto cuarto){
        /*
        Elimina el vertice enviado por parametro y sus arcos si es que existe
        */
        NodoVertCuarto nodoBus;
        boolean exito = false;
        
        if(this.inicio != null){
            nodoBus = obtenerNodo(this.inicio, cuarto);
            if(nodoBus != null){
                //Vertice encontrado
                eliminarVerticeAux(nodoBus.getCodigoCuarto());
                exito = true;
            }
        }
        return exito;
    }
    
    //Auxiliares
    
    private NodoVertCuarto obtenerNodo(NodoVertCuarto nodo ,Cuarto newCuarto){
        /*
        Revisa si el elemento enviado por parametro esta en la estructura
        */
        NodoVertCuarto encontrado = null;
        
        if( nodo != null){
            if(nodo.getElemento().equals(newCuarto)){
                //Encontrado
                encontrado = nodo;
            }else{
                encontrado = obtenerNodo(nodo, newCuarto);
            }
        }
        return encontrado;
    }
    
    private void insertarAux(NodoVertCuarto nodo, Cuarto newCuarto){
        /*
        Inserta el nuevo elemento al final de la cadena de nodos
        */
        if(nodo != null){
            if(nodo.getSigVertice() == null){
                //Se inserta como ultimo
                NodoVertCuarto newN = new NodoVertCuarto();
                newN.setElemento(newCuarto);
                nodo.setSigVertice(newN);
            }else{
                insertarAux(nodo.getSigVertice(), newCuarto);
            }
        }
    }
    
    private void eliminarVerticeAux(String elemento){
        /*
        Elimina los arcos del grafo que tienen como destino al elemento mandado 
        por parametro y luego elimina al elemento en si
        */
        NodoVertCuarto nodoSiguiente, nodoActual;
        if(this.inicio != null){
            nodoActual = this.inicio;
            nodoSiguiente = this.inicio.getSigVertice();
            while(nodoActual != null){
                eliminarArcoAux(nodoActual, elemento);
            }
        }
    }
    
    
    
    
}
