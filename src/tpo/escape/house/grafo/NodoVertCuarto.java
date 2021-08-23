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
public class NodoVertCuarto {
    //TDA de Nodo vertice, representa un cuarto
    
    private String claveCuarto;
    private NodoVertCuarto sigVertice; //Siguiente cuarto enlazado
    private NodoArco primArco; //Arco hacia otro cuarto
    
    public NodoVertCuarto(){
        //Constructor
        
    }

    public String getCodigoCuarto() {
        return claveCuarto;
    }

    public NodoVertCuarto getSigVertice() {
        return sigVertice;
    }

    public NodoArco getPrimArco() {
        return primArco;
    }

    public void setClaveCuarto(String claveCuarto) {
        this.claveCuarto = claveCuarto;
    }

    public void setSigVertice(NodoVertCuarto sigVertice) {
        this.sigVertice = sigVertice;
    }

    public void setPrimArco(NodoArco primArco) {
        this.primArco = primArco;
    }
    
    
    
}
