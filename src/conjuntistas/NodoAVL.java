package conjuntistas;

/**
 *
 * @author user-
 */
public class NodoAVL {

    private Comparable elemento;
    private int altura;
    private NodoAVL hijoIzq, hijoDer;

    public NodoAVL(Comparable elemento, NodoAVL hijoIzq, NodoAVL hijoDer) {
        this.altura = 0;
        this.elemento = elemento;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }

    public Comparable getElemento() {
        return elemento;
    }

    public int getAltura() {
        return altura;
    }

    public NodoAVL getHijoIzq() {
        return hijoIzq;
    }

    public NodoAVL getHijoDer() {
        return hijoDer;
    }

    //
    public void setElemento(Comparable elemento) {
        this.elemento = elemento;
    }

    public void recalcularAltura() {
        int alturaIzq = -1, alturaDer = -1;
        if (this.hijoIzq != null) {
            alturaIzq = this.hijoIzq.getAltura();
        }
        if (this.hijoDer != null) {
            alturaDer = this.hijoDer.getAltura();
        }
        if (alturaIzq > alturaDer) {
            this.altura = alturaIzq + 1;
        } else {
            this.altura = alturaDer + 1;
        }
    }

    public void setHijoIzq(NodoAVL hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(NodoAVL hijoDer) {
        this.hijoDer = hijoDer;
    }

}
