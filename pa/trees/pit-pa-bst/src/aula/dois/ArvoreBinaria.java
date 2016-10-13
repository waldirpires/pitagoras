package aula.dois;

public class ArvoreBinaria {

	No raiz;
	
	public static void main(String[] args) {
		ArvoreBinaria a = new ArvoreBinaria();
		a.raiz = new No(2);
		a.raiz.esquerda = new No(1);
		a.raiz.direita = new No(4);
		
		exibirEncaminhamentos(a);
		
		a.inserir(10, a.raiz);
		a.inserir(7, a.raiz);
		a.inserir(12, a.raiz);
		a.inserir(5, a.raiz);
		exibirEncaminhamentos(a);
		a.retirar(10, a.raiz);
		System.out.println("depois de retirar");
		exibirEncaminhamentos(a);
		
	}

	private static void exibirEncaminhamentos(ArvoreBinaria a) {
		System.out.println("Pré-ordem: ");
		a.preordem(a.raiz);
		System.out.println("In-ordem: ");
		a.inordem(a.raiz);
		System.out.println("Pós-ordem: ");
		a.posordem(a.raiz);
	}

//	int valor = 2;		
//	System.out.println(a.pesquisar(valor, a.raiz));
//	
//	valor = 3;
//	System.out.println(a.pesquisar(valor, a.raiz));
	
	
	public boolean pesquisar(int valor, No no){
		if (no == null)
		{
			return false;
		} else if (valor < no.chave)
		{
			return pesquisar(valor, no.esquerda);
		} else if (valor > no.chave)
		{
			return pesquisar(valor, no.direita);
		} else {
			return true;
		}		
	}
	
	public void preordem(No no)	{
		if (no == null){
			return;
		}
		System.out.println(no.chave);
		preordem(no.esquerda);
		preordem(no.direita);
	}

	public void inordem(No no)	{
		if (no == null){
			return;
		}
		preordem(no.esquerda);
		System.out.println(no.chave);
		preordem(no.direita);
	}

	public void posordem(No no)	{
		if (no == null){
			return;
		}
		preordem(no.esquerda);
		preordem(no.direita);
		System.out.println(no.chave);
	}
	
	public No inserir(int valor, No no)
	{
		if (no == null){
			no = new No(valor);
		}else if (valor < no.chave){
			no.esquerda = inserir(valor, no.esquerda);
		}else if (valor > no.chave){
			no.direita = inserir(valor, no.direita);
		}else{
			System.out.println(
				"ERRO: valor já existe na árvore.");
		}
		return no;
	}
	
	public No retirar(int valor, No no)
	{
		if (no == null){
			System.out.println("ERRO: nó não encontrado.");
		} else if (valor < no.chave){
			no.esquerda = retirar(valor, no.esquerda);
		} else if (valor > no.chave){
			no.direita = retirar(valor, no.direita);
		} else
		{
			if (no.direita == null){
				no = no.esquerda;
			} else if (no.esquerda == null){
				no = no.direita;
			} else {
				no.esquerda = antecessor(no, no.esquerda);
			}				
		}
		return no;
	}

	private No antecessor(No no, No esquerda) {
		if (esquerda.direita != null){
			esquerda.direita = antecessor(no, esquerda.direita);
		} else {
			no.chave = esquerda.chave;
			esquerda = esquerda.esquerda;
		}
		return esquerda;
	}

}
