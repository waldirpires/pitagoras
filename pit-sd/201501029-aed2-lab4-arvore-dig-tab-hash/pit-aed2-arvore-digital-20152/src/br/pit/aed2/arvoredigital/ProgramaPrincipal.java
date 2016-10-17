package br.pit.aed2.arvoredigital;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		// link No: http://pastebin.com/4cKNbn1q
		// Criar uma lista de palavras para ser inserido
		String [] palavras = {"casa", "coisa", "caderno", "porta"};
		// criar o nó raiz da arvore digital
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
		// a) adicionar um contador de palavras na árvore
		// b) criar um metodo para verificar se um prefixo existe na arvore
		// c) criar um metodo para listar todas as palavras que contem um prefixo
		// d) criar um método para excluir uma palavra da árvore
		// e) criar um método para listar todas as palavras da árvore
		// f) criar um metodo para encontrar a maior e menor palavras
		// g) criar um método para encontrar o nó com a maior quantidade de descendentes
		// h) criar um método para exibir a quantidade total de letras
		// i) criar um método para exibir as palavras da árvore de forma invertida (ex. casa -> asac)
	}

}
