public class Main {
    public static void main(String args[]) throws Exception {

       //Testes
        Lista l = new Lista();

		System.out.println("Testes inserindo");
        l.inserirNoFinal(10);
		l.inserirNoFinal(20);
		l.inserirNoFinal(30);
		l.inserirAposAtual(70);
		l.inserirNoComeco(60);
		l.inserirNoComeco(50);
		l.inserirNoComeco(40);
        l.inserirAntesDoAtual(35);
		l.inserirNaPosicao(5,5);

		l.imprimeLista();
		System.out.println("Testes buscando");
		System.out.println("Existe o 60? " + l.buscar(60));
		System.out.println("Existe o 55? " + l.buscar(55));
		System.out.println("Existe o 20? " + l.buscarAprimorado(20));

		l.imprimeLista();
		System.out.println("Testes excluindo");
		l.excluirAtual();
		l.excluirPrimeiro();
		l.excluirUltimo();

		l.imprimeLista();

    }
}
