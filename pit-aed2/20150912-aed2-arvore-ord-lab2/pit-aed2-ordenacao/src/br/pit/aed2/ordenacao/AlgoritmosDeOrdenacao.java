package br.pit.aed2.ordenacao;

import java.util.Arrays;

import br.pit.aed2.ordenacao.util.OrdenacaoUtil;

public class AlgoritmosDeOrdenacao {

	// ordenacao por selecao
	static void selecao(int []v){
		// declaracao de variaveis
		int menor = -1;
		// 1) para cada elemento no vetor (i)
		for (int i = 0; i < v.length; i++){
		// 1.1) assumir que o indice do corrente é o menor
			menor = i;
		// 1.2) para cada numero restante no vetor (j)
			for (int j = i + 1; j < v.length; j++){
		// 1.2.1) se o elemento em (j) for menor que o em (i)
				if (v[j] < v[menor]){
					// 1.2.1.1) assumir que o (j) é menor
					menor = j;
				}// http://tinyurl.com/20152-aed2
			}
		// 1.3) se o elemento menor for diferente de (i)
			if (menor != i){
		// 1.3.1) trocar posicoes do menor e do (i)
				trocar(v, menor, i);
			}
		}
	}
	
	private static void trocar(int[] v, int menor, int i) {
		int aux = v[menor];
		v[menor] = v[i];
		v[i] = aux;
	}

	public static void main(String[] args) {
		// declaracao de variaveis
		int tam = 1000000, max = 1000000; long time;
		// ordenacao por selecao
		// 1) iniciar o tempo
		time = System.currentTimeMillis();
		// 2) gerar os numeros aleatorios
		int []v = OrdenacaoUtil.gerarVetor(tam, max);
		// 3) exibir o tempo gasto
		System.out.println("Tempo 1: " + 
				(System.currentTimeMillis() - time) + " ms");
		// 3.1) imprimir o vetor
		System.out.println("Vetor gerado: ");
		System.out.println(Arrays.toString(v));
		// 4) iniciar o tempo
		time = System.currentTimeMillis();
		// 5) executar a ordenacao por selecao
		selecao(v);
		// 6) exibir o tempo gasto
		System.out.println("Tempo 2: " + 
				(System.currentTimeMillis() - time) + " ms");		
		// 6.1) imprimir o vetor
		System.out.println("Vetor ordenado: ");
		System.out.println(Arrays.toString(v));
	}

}
