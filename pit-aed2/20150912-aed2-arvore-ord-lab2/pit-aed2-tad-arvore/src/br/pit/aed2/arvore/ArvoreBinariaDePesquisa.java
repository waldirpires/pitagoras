package br.pit.aed2.arvore;

public class ArvoreBinariaDePesquisa {
	
	No raiz; // raiz da arvore
	
	// insercao em ABP
	public No inserir(No no, int chave){		
		// 1) Se o nó corrente for nulo
		if (no == null){
		// 1.1) Criar um novo nó neste ponto
			no = new No();
		// 1.2) Associar este nó com a chave informada
			no.chave = chave; no.dir = null; no.esq = null;
		// 1.3) retornar o nó criado
			return no;
		}// 2) Senao Se a chave for menor que a chave do nó corrente
		else if (chave < no.chave){
		// 2.1) chamar a inserção pela esquerda (recursao)
			no.esq = inserir(no.esq, chave);
		}// 3) Senao Se a chave for maior que a chave do nó corrente
		else if (chave > no.chave){
		// 3.1) chamar a inserção pela direita (recursao)
			no.dir = inserir(no.dir, chave);
		} else {// 4) Senao
		// 4.1) exibir uma mensagem de aviso - nó já existe
			System.out.println("ERRO: Nó já existe: " + chave);
		}
		return no;
	}
	
	// caminhamento central em ABP
	public void inOrdem(No no){
		// -> E, I, D
		// 1) Se o nó não for nulo
		if (no != null){
		// 1.1) Ir para a esquerda
			inOrdem(no.esq);
		// 1.2) Imprimir a chave do nó corrente
			System.out.print(" " + no + " ");
		// 1.3) Ir para a direita
			inOrdem(no.dir);
		}
	}
	
	
}
