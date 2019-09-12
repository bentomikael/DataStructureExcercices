package ListaDuplamenteEncadeada;

public class Caixa {
    private Object elemento;
    private Caixa proximo,anterior;

    public Caixa(Caixa anterior,Caixa proximo,Object elemento) {
        this.anterior = anterior;
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Caixa getAnterior() {
        return anterior;
    }

    public void setAnterior(Caixa anterior) {
        this.anterior = anterior;
    }

    public Caixa getProximo() {
        return proximo;
    }

    public void setProximo(Caixa proximo) {
        this.proximo = proximo;
    }

    public Object getElemento() {
        return elemento;
    }
}
