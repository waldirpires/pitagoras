package br.edu.pit.aed2.ordenacao;

import java.util.Random;

public class GeradorNumerosAleatorios {

	Random rnd; // gerador de numeros aleatorios 
	int max; // limite superior de geracao
	int tamanho; // quantidade de numeros a ser gerada
	
	public GeradorNumerosAleatorios(int max, int tamanho) {
		super();
		this.rnd = new Random(System.currentTimeMillis());
		this.max = max;
		this.tamanho = tamanho;
		
	}
	
	public int [] gerarNumeros(){
		int a[] = new int[tamanho];
		
		for (int i = 0; i < tamanho; i++){
			int num = rnd.nextInt() % max;
			a[i] = num;
		}
		System.out.println(tamanho + " numeros gerados com sucesso.");
		return a;
	}
	
	
}
