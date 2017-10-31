package br.pit.aeda.lab3.arvoredigital;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		String []palavras = {"casa", "coisa", "caderno", "porta"};
		No raiz = new No('*');
		System.out.println(raiz);
		for (int i = 0; i < palavras.length; i++){
			raiz.inserirPalavra(palavras[i]);
			System.out.println(raiz);
		}
		
		System.out.println(raiz.possuiPalavra("cas"));
		System.out.println(raiz.possuiPalavra("casa"));
		System.out.println(raiz.possuiPrefixo("cas"));
		System.out.println(raiz.possuiPrefixo("cat"));
		
	}
	
}
