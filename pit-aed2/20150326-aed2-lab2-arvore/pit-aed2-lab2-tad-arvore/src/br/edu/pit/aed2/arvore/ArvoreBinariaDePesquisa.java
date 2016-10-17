package br.edu.pit.aed2.arvore;

public class ArvoreBinariaDePesquisa {

	No raiz;
	
	public void central(){
		System.out.println("Exibindo o conteudo da arvore:");
		if (raiz != null){
			raiz.central(raiz);
		}
	}
	
	public No inserir(int chave){
		System.out.println("Inserindo a chave " + chave);
		if (raiz == null){
			raiz = new No(chave);
			return raiz;
		} else {
			return raiz.inserir(raiz, chave);
		}
	}
}
