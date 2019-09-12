package ListaDuplamenteEncadeada;

import java.util.EmptyStackException;

public class Lista {
    private Caixa ponteiro,primeiro,ultimo;
    private int contador;

    public Lista() {
        contador = 0;
        ponteiro = null;
        primeiro = null;
        ultimo = null;
    }
    //publicas
    public void imprimeLista(){
        int i = 1;
        Caixa cursor = primeiro;
        do {
            System.out.println(i +"| "+ cursor.getElemento().toString());
            cursor = cursor.getProximo();
            i++;
        }while(cursor != primeiro);
    }

    /**
     * insere elemento antes do que esta sendo apontado
     * @param elemento elemento a ser inserido
     */
    public void inserirAntesDoAtual(Object elemento){
        if (ponteiro != null && ponteiro != primeiro){
            Caixa ponteiroAux = ponteiro.getAnterior();
            ponteiroAux.setProximo(new Caixa(ponteiroAux,ponteiro,elemento));
            ponteiro.setAnterior(ponteiroAux.getProximo());
            contador++;
        }else
            inserirNoComeco(elemento);

    }
    /**
     * insere elemento apos o que esta sendo apontado
     * @param elemento a ser inserido
     */
    public void inserirAposAtual(Object elemento){
        if (contador > 1){
            Caixa ponteiroAux = ponteiro.getProximo();
            ponteiroAux.setAnterior(new Caixa(ponteiro,ponteiroAux,elemento));
            ponteiro.setProximo(ponteiroAux.getAnterior());
        }else
            inserirNoFinal(elemento);
        contador++;
    }
    /**
     * Adiciona elemento na primeira posicao da fila
     * @param elemento objeto a ser inserido
     */
    public void inserirNoComeco(Object elemento){
        if(primeiro != null) {
            ponteiro = new Caixa(ultimo,primeiro,elemento);
            ultimo.setProximo(ponteiro);
            primeiro.setAnterior(ponteiro);
            primeiro = ponteiro;
            contador++;
        }else{
            ponteiro = new Caixa(null,null,elemento);
            primeiro = ponteiro;
            ultimo = ponteiro;
            contador = 1;
        }
    }
    /**
     * insere elemento no final da lista
     * @param elemento a ser inserido
     */
    public void inserirNoFinal(Object elemento){
        if(ultimo != null){
            ultimo.setProximo(new Caixa(ultimo,primeiro,elemento));
            ponteiro = ultimo.getProximo();
            ultimo = ponteiro;
            primeiro.setAnterior(ultimo);
            contador++;
        }else
            inserirNoComeco(elemento);

    }
    /**
     * insere elemntos em uma posicao indicada
     * @param elemento a ser inserido
     * @param posicao a ser inserido
     * @throws IndexOutOfBoundsException caso posicao nao exista
     */
    public void inserirNaPosicao(Object elemento, int posicao)throws IndexOutOfBoundsException{
        if (posicao <= contador){
            irParaPrimeiro();
            for(int i = 1; i < posicao; i++)
                ponteiro = ponteiro.getProximo();
            inserirAntesDoAtual(elemento);
        }else
            throw new IndexOutOfBoundsException("Posicao Invalida");
    }
    /**
     * exclui primeiro item da lita
     * @throws EmptyStackException se lista estiver vazia
     */
    public void excluirPrimeiro()throws Exception{
        if(primeiro != null) {
            if (contador == 1)
                esvaziou();
            else{
                primeiro = primeiro.getProximo();
                irParaUltimo();
                ponteiro.setProximo(primeiro);
                primeiro.setAnterior(ponteiro);
                irParaPrimeiro();
                contador--;
            }
        }else
            throw new Exception("Lista está vazia");
    }
    /**
     * exclui ultimo item da lista
     * @throws EmptyStackException se lista estiver vazia
     */
    public void excluirUltimo()throws Exception{
        if(contador > 0) {
            if (contador == 1)
                esvaziou();
            else{
                ultimo = ultimo.getAnterior();
                irParaPrimeiro();
                ponteiro.setAnterior(ultimo);
                ultimo.setProximo(primeiro);
                irParaUltimo();
                contador--;
            }
        }else
            throw new Exception("Lista está vazia");
    }
    /**
     *  exclui lista que esta sendo apontado
     * @throws Exception se lista estiver vazia
     */
    public void excluirAtual() throws Exception {
        if(ponteiro != null){
            if (contador == 1)
                esvaziou();
            else{
                if (ponteiro == ultimo)
                    ultimo = ultimo.getAnterior();
                else if (ponteiro == primeiro)
                    primeiro = primeiro.getProximo();

                ponteiro.getAnterior().setProximo(ponteiro.getProximo());
                ponteiro.getProximo().setAnterior(ponteiro.getAnterior());
                contador--;
                ponteiro = ponteiro.getAnterior();
            }
        }else
            throw new Exception("Lista está vazia");
    }
    /**
     *
     * @param elemento a ser encontrado
     * @return true se encontrar e false caso nao encontre
     */
    public boolean buscar(Object elemento){                         //melhorar
        if(contador > 0) {
            int contadorTemporario = contador;
            irParaPrimeiro();
            while(contadorTemporario > 0) {
                if (ponteiro.getElemento() == elemento)
                    return true;
                else
                    ponteiro = ponteiro.getProximo();
                contadorTemporario--;
            }
        }

        return false;
    }
    /**
     * @return elemento que está sendo apontado atualmente
     */
    public Object getElementoAtual(){
        return ponteiro.getElemento();
    }

    //privadas

    /**
     * @param k numero de posicoes a ser avancados
     * @return Elemento atual
     */
    private Object avancaKPosicoes(int k)throws Exception{
        if (contador > 1)
            while(k > 0) {
                ponteiro = ponteiro.getProximo();
                k--;
            }
        else
            throw new Exception("Posicao Invalida");

        return ponteiro.getElemento();
    }
    /**
     * @param k numero de posicoes a ser retocedidas
     * @return Elemento atual
     */
    private Object retrocedeKPosicoes(int k)throws Exception{
        if (contador > 1)
            while(k > 0) {
                ponteiro = ponteiro.getAnterior();
                k--;
            }
        else
            throw new Exception("Posicao Invalida");

        return ponteiro.getElemento();
    }
    /**
     * seta o ponteiro para primeira caixa
     */
    private void irParaPrimeiro(){
        ponteiro = primeiro;
    }
    /**
     * seta o ponteiro para ultima caixa
     */
    private void irParaUltimo()throws ArrayIndexOutOfBoundsException{
        ponteiro = ultimo;
    }
    /**
     * zera todos valores para indicar lista vazia
     */
    private void esvaziou(){
        contador = 0;
        ponteiro = null;
        primeiro = null;
        ultimo = null;
    }

    //gets
    public int getTamanho(){
        return contador;
    }
    public Caixa getPrimeiro(){
        return primeiro;
    }
    public Caixa getUltimo() {
        return ultimo;
    }
    public Caixa getPonteiro() {
        return ponteiro;
    }

}
