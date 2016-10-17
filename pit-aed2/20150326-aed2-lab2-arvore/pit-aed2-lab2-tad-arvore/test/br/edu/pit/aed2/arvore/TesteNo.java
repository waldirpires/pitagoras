package br.edu.pit.aed2.arvore;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteNo {

	@Test
	public void testInsercao() {
		// caso de teste
		// entrada: arvore sem nos
		// operacao: inserindo um primeiro
		// resultado: o no com a chave informada criado na arvore
		
		System.out.println("Executando teste insercao 1");
		// criar a arvore inicial
		ArvoreBinariaDePesquisa abp = new ArvoreBinariaDePesquisa();
		// exibir os nós
		abp.central();
		// inserir um novo no
		abp.inserir(20);
		// exibir os nós
		abp.central();
	}

	@Test
	public void testInsercao2() {
		// caso de teste
		// entrada: arvore sem nos
		// operacao: inserindo tres nos
		// resultado: o no com as chaves informadas inseridos
		// na arvore
		
		System.out.println("Executando teste insercao 2");

		// criar a arvore inicial
		ArvoreBinariaDePesquisa abp = new ArvoreBinariaDePesquisa();
		// exibir os nós
		abp.central();
		// inserir um novo no
		abp.inserir(20);
		// exibir os nós
		abp.central();
		abp.inserir(30); abp.central();
		abp.inserir(10); abp.central();
		abp.inserir(14); abp.central();
		abp.inserir(2); abp.central();
	}
	
}
