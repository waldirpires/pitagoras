package br.pit.aed2.ordenacao.util;

import java.util.Random;

public class OrdenacaoUtil {

	// método para gerar números aleatorios
	public static int[] gerarVetor(int tam, int max){
		int []v = new int[tam];
		
		// 1) inicializar um gerador de numeros aleatorios
		Random rnd = new Random(System.currentTimeMillis());
		// 2) para cada indice do vetor
		int num = -1;
		for (int i = 0; i < tam; i++){
		// 2.1) gerar o numero aleatorio
			num = rnd.nextInt() % max;
		// 2.2) armazenar o numero no vetor
			v[i] = num;
		}
		// 3) retornar o vetor gerado
		System.out.println("Números gerados com sucesso: " + v.length);
		return v;
	}
	
	// método para escrever numeros aleatorios em arquivo
	
	// método para ler numeros de um arquivo
	
	
}
