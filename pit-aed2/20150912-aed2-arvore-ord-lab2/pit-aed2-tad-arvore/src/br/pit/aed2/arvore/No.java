package br.pit.aed2.arvore;

public class No {
	int chave;
	No esq, dir;
	
	// camel case
	public String toString() {
		return "["+chave+"]";
	}
}
