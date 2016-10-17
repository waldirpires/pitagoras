package br.pit.aed2.ordenacao.util;

import java.util.Random;

public class OrdenacaoUtil {

	// m�todo para gerar n�meros aleatorios
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
		System.out.println("N�meros gerados com sucesso: " + v.length);
		return v;
	}
	
	// m�todo para escrever numeros aleatorios em arquivo
	
	// m�todo para ler numeros de um arquivo
	
	
}
