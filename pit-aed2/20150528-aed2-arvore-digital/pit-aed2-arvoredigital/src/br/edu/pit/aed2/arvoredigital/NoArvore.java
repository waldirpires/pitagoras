package br.edu.pit.aed2.arvoredigital;

import java.util.HashMap;
import java.util.Map;

public class NoArvore {

	char letra; // o caractere
	Map<Character, NoArvore> links; // os nos filhos
	boolean terminal; // se o n� � terminal
	
	// criar o objeto no arvore
	public NoArvore(char letra, boolean terminal){ 
		this.letra = letra; // letra
		// tabela hash
		this.links = new HashMap<Character, NoArvore>();
		// se � uma palavra
		this.terminal = terminal;
	}
	
	
}
