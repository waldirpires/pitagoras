package br.edu.pit.aed2.arvoredigital;

public class ProgramaPrincipal {

	/**
	 * the book is on the table
	 * @param args
	 */
	public static void main(String[] args) {
		// criar a arvore digital
		ArvoreDigital ad = new ArvoreDigital();
		// criar o no raiz
		NoArvore raiz = ArvoreDigital.criarArvore();
		// adicionar uma palavra
		String [] palavras = {"CASA", "CASO", "CESTA", "SEXTA"};
		for (String s: palavras){
			ad.inserirNo(raiz, s);
		}
		
		String teste = "CASA";
		boolean resultado = ad.buscar(raiz, teste);
		System.out.println(teste + ": " + resultado);
		
		teste = "CASI";
		resultado = ad.buscar(raiz, teste);
		System.out.println(teste + ": " + resultado);
		
		ad.imprimirArvore(raiz, "");
	}

}
