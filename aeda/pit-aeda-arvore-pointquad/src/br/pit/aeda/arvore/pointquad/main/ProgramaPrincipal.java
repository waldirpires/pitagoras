package br.pit.aeda.arvore.pointquad.main;

import br.pit.aeda.arvore.pointquad.ArvorePointQuad;
import br.pit.aeda.arvore.pointquad.No;
import br.pit.aeda.arvore.pointquad.Ponto;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		System.out.println("Hello");
	    ArvorePointQuad centro = new ArvorePointQuad("Raiz", new Ponto(0,0), new Ponto(10,10));
	    No n1 = new No(1, 1, "1");
	    No n2 = new No(2, 5, "2");
	    No n3 = new No(7, 6, "3");
	    
	    centro.inserir(n1);
	    centro.inserir(n2);
	    centro.inserir(n3);
	    
	    System.out.println(centro);
	    
	    System.out.println(centro.pesquisar(n1.p));
	    System.out.println(centro.pesquisar(n2.p));
	    System.out.println(centro.pesquisar(n3.p));

	}

}
