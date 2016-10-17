package br.pit.aed2.arvore;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		// 1) Criar uma arvore binaria de pesquisa
		ArvoreBinariaDePesquisa abp = 
				new ArvoreBinariaDePesquisa();
		// 2) Imprimir a arvore
		System.out.println("Imprimindo a árvore: ");
		abp.inOrdem(abp.raiz);
		System.out.println("\n=====");
		// 3) inserir uma chave
		int chave = 20;
		System.out.println("Inserindo uma chave: " + chave);
		abp.raiz = abp.inserir(abp.raiz, chave);
		System.out.println("====");		
		// 4) Imprimir a arvore
		System.out.println("Imprimindo a árvore: ");
		abp.inOrdem(abp.raiz);		
		// 5) inserir um conjunto de chaves
		System.out.println("\nInserindo chaves na árvore");
		int n[] = {15, 10, 31, 25, 40, 2, 7, 20, 18, 37, 22, 5};
		for (int i = 0; i < n.length; i++){
			abp.inserir(abp.raiz, n[i]); // inserindo cada chave
			abp.inOrdem(abp.raiz);
			System.out.println("");
		}
		// 6) Imprimir a arvore
		System.out.println("Imprimindo a árvore: ");
		abp.inOrdem(abp.raiz);
		
		
	}

}
