package br.edu.pit.aed2.arvore;

public class No {

	int chave;
	No dir, esq;
	
	// construtor
	public No(int chave){
		this.chave = chave;
		this.dir = null;
		this.esq = null;
	}
	
	// definir a impressao dos detalhes do no

	@Override
	public String toString() {
		return " [" + chave + "] ";
	}
	
	// caminhamento central
	public void central(No no){
		if (no == null){ // caso base
			return;
		}
		central(no.esq); // esquerda
		System.out.println(no.chave); // imprime
		central(no.dir); // direita
	}
	
	// insercao
	public No inserir(No no, int chave){
		
		if (no == null){// se o no for nulo
			no = new No(chave);//   criar um novo no		
			return no; //   retornar o no criado
		}
		else if (chave < no.chave){ // senão se a chave for menor que a chave do no 
		  no.esq = inserir(no.esq, chave); //   inserir para a esquerda
		}
		else if (chave > no.chave){// senão se a chave for maior que a chave do no
    	  no.dir = inserir(no.dir, chave);//   inserir para a direita
		} else {// senão
		  //   o no jah existe nao eh possivel inserir
			System.out.println("ERRO: o nó já existe!");
		}
		return no;
	}
	
	// pesquisa
	public No pesquisar(No no, int chave){
		// se o no for nulo
		//   a chave nao existe, retornar nulo
		// senao se a chave for igual a chave procurada
		//   achou! retornar o nó encontrado
		// senão se a chave for menor que a chave do no
		//   pesquisar pela esquerda
		// senao
		//   pesquisar pela direita
		
		if (no == null){
			return null;
		} else if (chave == no.chave){
			return no;
		} else if (chave < no.chave){
			return pesquisar (no.esq, chave);
		} else {
			return pesquisar (no.dir, chave);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// exclusao
}
