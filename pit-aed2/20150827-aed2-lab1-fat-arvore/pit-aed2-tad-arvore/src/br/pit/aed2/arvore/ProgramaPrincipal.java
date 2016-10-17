package br.pit.aed2.arvore;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		// 1) Criar uma arvore binaria de pesquisa
		ArvoreBinariaDePesquisa abp = 
				new ArvoreBinariaDePesquisa();
		No raiz = new No(); // criando um novo nó
		raiz.chave = 10; 
		raiz.esq = null;
		raiz.dir = null;
		abp.raiz = raiz; // colocando o nó como raiz da arvore
		// 2) exibir a arvore na tela
		System.out.println("Exibindo a ABP: ");
		System.out.println(abp.raiz);
		
	}

}
