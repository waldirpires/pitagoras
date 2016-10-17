package br.pit.acca.lab1.recursividade;

import java.util.Arrays;

public class ProgramaPrincipal {

	static int fatorialRecursivo(int n){
		if (n == 1){
			return n;
		}
		return n* fatorialRecursivo(n-1);
	}
	
	static int fatorialIterativo(int n) {
		int produto = 1;
		for (int j = 1; j <= n; j++)
			produto *= j;
		return produto;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bom dia!");
		System.out.println("Boa noite!");

		int n = 8;
		System.out.println("Fatorial iterativo:");
		System.out.println("Fatorial de " + n + ": " + fatorialIterativo(n));

		System.out.println("Fatorial recursivo:");
		System.out.println("Fatorial de " + n + ": " + fatorialRecursivo(n));

		int tam = 1000000;
		int a[] = new int[tam];
		Arrays.fill(a, (int)Math.random()*tam);
		
		System.out.println("Ordenação por MergeSort: ");
		long t = System.currentTimeMillis();
		OrdenacaoRecursivo.mergesort(a, 0, a.length-1);
		System.out.println("Tempo: " + (System.currentTimeMillis()-t) + " ms");
	}
}

