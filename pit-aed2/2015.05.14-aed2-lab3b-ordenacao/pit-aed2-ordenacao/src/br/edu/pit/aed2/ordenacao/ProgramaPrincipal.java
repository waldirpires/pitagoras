package br.edu.pit.aed2.ordenacao;

import java.util.Arrays;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
		// 1) criar a entrada de dados (vetor)
		int tamanho = 10000;
		int max = 100000;
		GeradorNumerosAleatorios gna = 
				new GeradorNumerosAleatorios(max, tamanho);
		int a[] = gna.gerarNumeros();
		
		// 2) criar o algoritmo de ordenacao
		long time = System.currentTimeMillis();
		//AlgoritmosOrdenacao.selecao(a);
		//AlgoritmosOrdenacao.shellSort(a);
		Arrays.sort(a);
		time = System.currentTimeMillis() - time;
		System.out.println(tamanho + ": " + time + " ms");
		// 3) criar o cálculo do tempo
		// 4) aplicar a execucao nos algoritmos de ordenacao

	}

}
