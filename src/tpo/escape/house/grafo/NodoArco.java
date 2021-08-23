/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpo.escape.house.grafo;

/**
 *
 * @author user-
 */
public class NodoArco {
    //TDA de nodo arco (nodo adyacente), representa un arco etiquetado entre dos vertices 
    
    private NodoVertCuarto cuarto;//Arco hacia cuarto
    private NodoArco sigArco;//Siguiente arco enlazado
    private int puntaje; //Etiqueta

    public NodoVertCuarto getCuarto() {
        return cuarto;
    }

    public NodoArco getSigAdy() {
        return sigArco;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setCuarto(NodoVertCuarto cuarto) {
        this.cuarto = cuarto;
    }

    public void setSigAdy(NodoArco sigAdy) {
        this.sigArco = sigAdy;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    
    
}
