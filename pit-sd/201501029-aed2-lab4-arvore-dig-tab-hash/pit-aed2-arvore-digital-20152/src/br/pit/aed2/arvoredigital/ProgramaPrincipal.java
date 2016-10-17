package br.pit.aed2.arvoredigital;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		// link No: http://pastebin.com/4cKNbn1q
		// Criar uma lista de palavras para ser inserido
		String [] palavras = {"casa", "coisa", "caderno", "porta"};
		// criar o n� raiz da arvore digital
		No raiz = new No('*'); raiz.ehRaiz = true;
		System.out.println("Exibindo a AD criada: ");
		System.out.println(raiz);// exibir a arvore
		// inserir uma palavra de teste
		System.out.println("Inserindo uma palavra: book");
		raiz.inserirPalavra("book");
		System.out.println(raiz);// exibir a arvore
		// inserir outra palavra de teste
		System.out.println("Inserindo uma palavra: table");
		raiz.inserirPalavra("table");
		System.out.println(raiz);// exibir a arvore
		// para cada uma das palavras na lista
		System.out.println("Inserindo a lista de palavras: " + palavras);
		for (String p: palavras){
		  raiz.inserirPalavra(p);//   inserir a palavra
		  System.out.println(raiz);//   exibir a arvore
		}
		// exibir a arvore final
		
		// parte 2:
		// a) adicionar um contador de palavras na �rvore
		// b) criar um metodo para verificar se um prefixo existe na arvore
		// c) criar um metodo para listar todas as palavras que contem um prefixo
		// d) criar um m�todo para excluir uma palavra da �rvore
		// e) criar um m�todo para listar todas as palavras da �rvore
		// f) criar um metodo para encontrar a maior e menor palavras
		// g) criar um m�todo para encontrar o n� com a maior quantidade de descendentes
		// h) criar um m�todo para exibir a quantidade total de letras
		// i) criar um m�todo para exibir as palavras da �rvore de forma invertida (ex. casa -> asac)
	}

}
