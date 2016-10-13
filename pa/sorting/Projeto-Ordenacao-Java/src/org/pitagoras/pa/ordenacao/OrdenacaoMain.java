package org.pitagoras.pa.ordenacao;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class OrdenacaoMain {

	private static void ordena(int a[], int p, int u) {
		int i = p, f = u; // Extremos
		int x = (int) (Math.random() * (u - p + 1)) + p; // Pivô aleatório
		int pivô = a[x]; // evita quadrático

		while (i <= f) { // Não cruzaram

			while (i < u && a[i] < pivô)
				i++; // Organiza 1ª metade

			while (f > p && a[f] > pivô)
				f--; // Organiza 2ª metade

			if (i <= f) { // Se ainda não acabou
				x = a[f]; // troca os elementos
				a[f--] = a[i]; // dos dois lados
				a[i++] = x; // da lista
			}

		}

		if (p < f)
			ordena(a, p, f); // Ordena 1ª metade
		if (i < u)
			ordena(a, i, u); // Ordena 2ª metade
	}

	private static void ordena(List<Integer> a, int p, int u) {
		int i = p, f = u; // Extremos
		int x = (int) (Math.random() * (u - p + 1)) + p; // Pivô aleatório
		int pivô = a.get(x); // evita quadrático

		while (i <= f) { // Não cruzaram

			while (i < u && a.get(i) < pivô)
				i++; // Organiza 1ª metade

			while (f > p && a.get(f) > pivô)
				f--; // Organiza 2ª metade

			if (i <= f) { // Se ainda não acabou
				x = a.get(f); // troca os elementos
				a.set(f--, a.get(i)); // dos dois lados
				a.set(i++, x); // da lista
			}

		}

		if (p < f)
			ordena(a, p, f); // Ordena 1ª metade
		if (i < u)
			ordena(a, i, u); // Ordena 2ª metade
	}

	/*--------------------------------------------------------------*/
	/* Chamada do usuário. */
	/*--------------------------------------------------------------*/
	public static void quicksort(int a[]) {
		ordena(a, 0, a.length - 1);
	}

	public static void quicksort(List<Integer> a) {
		ordena(a, 0, a.size() - 1);
	}

	public static void BucketSort(int[] vetor, int maiorValor)
	{
	        int numBaldes = maiorValor/100;
	 
	        LinkedList[] B = new LinkedList[numBaldes];
	 
	        for (int i = 0; i < numBaldes; i++){
	                B[i] = new LinkedList<Integer>();
	        }
	 
	        //Coloca os valores no balde respectivo:
	        for (int i = 0; i < vetor.length; i++) {
	                int j = numBaldes-1;
	                while (true){
	                        if(j<0){
	                                 break;
	                        }
	                        if(vetor[i] >= (j*5)){
	                                 B[j].add(vetor[i]);
	                                 break;
	                        }
	                        j--;
	                }
	        }
	 
	        //Ordena e atualiza o vetor:
	        int indice = 0;
	        for (int i = 0; i < numBaldes; i++){
	 
	                int[] aux = new int[B[i].size()];
	 
	                //Coloca cada balde num vetor:
	                for (int j = 0; j < aux.length; j++){
	                                aux[j] = (Integer)B[i].get(j);
	                }
	 
	                insertionSort(aux); //algoritmo escolhido para ordenação.
	 
	                // Devolve os valores ao vetor de entrada:
	                for (int j = 0; j < aux.length; j++, indice++){
	                        vetor[indice] = aux[j];
	                }
	 
	        }
		}		
	
	public static void shellSort(int[] nums) {
		int n = nums.length;
		int h = n / 2;
		int c, j;
		while (h > 0) {
			for (int i = h; i < n; i++) {
				c = nums[i];
				j = i;
				while (j >= h && nums[j - h] > c) {
					nums[j] = nums[j - h];
					j = j - h;
				}
				nums[j] = c;
			}
			h = h / 2;
		}
	}

	public static void heapSort(int[] v) {
		buildMaxHeap(v);
		int n = v.length;

		for (int i = v.length - 1; i > 0; i--) {
			swap(v, i, 0);
			maxHeapify(v, 0, --n);
		}
	}

	private static void buildMaxHeap(int[] v) {
		for (int i = v.length / 2 - 1; i >= 0; i--)
			maxHeapify(v, i, v.length);
	}

	private static void maxHeapify(int[] v, int pos, int n) {
		int maxi;
		int l = 2 * pos + 1;
		int right = 2 * pos + 2;
		if ((l < n) && (v[l] > v[pos])) {
			maxi = l;
		} else {
			maxi = pos;
		}
		if (right < n && v[right] > v[maxi]) {
			maxi = right;
		}
		if (maxi != pos) {
			swap(v, pos, maxi);
			maxHeapify(v, maxi, n);
		}
	}

	public static void swap(int[] v, int j, int aposJ) {
		int aux = v[j];
		v[j] = v[aposJ];
		v[aposJ] = aux;
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int a = array[i];
			int j;
			for (j = i - 1; j >= 0 && array[j] > a; j--) {
				array[j + 1] = array[j];
				array[j] = a;
			}
		}
	}

	public static void bubbleSort(int[] vetor) {

		boolean houveTroca = true;

		while (houveTroca) {
			houveTroca = false;
			for (int i = 0; i < (vetor.length) - 1; i++) {
				if (vetor[i] > vetor[i + 1]) {
					int variavelAuxiliar = vetor[i + 1];
					vetor[i + 1] = vetor[i];
					vetor[i] = variavelAuxiliar;
					houveTroca = true;
				}
			}
		}
	}

	public static void quick_sort(int[] v, int ini, int fim) {
		int meio;

		if (ini < fim) {
			meio = partition(v, ini, fim);
			quick_sort(v, ini, meio);
			quick_sort(v, meio + 1, fim);
		}
	}

	public static int partition(int[] v, int ini, int fim) {
		int pivo, topo, i;
		pivo = v[ini];
		topo = ini;

		for (i = ini + 1; i <= fim; i++) {
			if (v[i] < pivo) {
				v[topo] = v[i];
				v[i] = v[topo + 1];
				topo++;
			}
		}
		v[topo] = pivo;
		return topo;
	}

	private static void merge(int[] v, int inicio, int fim) {

		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			merge(v, inicio, meio);
			merge(v, meio + 1, fim);
			mesclar(v, inicio, meio, fim);
		}

	}

	// Ordena dois trechos ordenados e adjacente de vetores e ordena-os
	// conjuntamente

	private static void mesclar(int[] v, int inicio, int meio, int fim) {

		int tamanho = fim - inicio + 1;

		/*
		 * Inicialização de um vetor temporario para auxiliar na ordenação O vetor
		 * temporário é uma cópia do trecho que será ordenado
		 */

		int[] temp = new int[tamanho];

		System.arraycopy(v, inicio, temp, 0, tamanho);

		/*
		 * Laço para ordenação do vetor, utilizando o vetor temporário, usando
		 * índices i e j para cada trecho de vetor da mesclagem
		 */

		int i = 0;
		int j = meio - inicio + 1;

		// A depender das condições, recebe um elemento de um trecho ou outro
		for (int posicao = 0; posicao < tamanho; posicao++) {
			if (j <= tamanho - 1) {
				if (i <= meio - inicio) {
					if (temp[i] < temp[j]) {
						v[inicio + posicao] = temp[i++];
					} else {
						v[inicio + posicao] = temp[j++];
					}
				} else {
					v[inicio + posicao] = temp[j++];
				}
			} else {
				v[inicio + posicao] = temp[i++];
			}
		}
	}

	private static void showStats(int i, int tenth, long start) {
		if (i % tenth == 0) {
			long time = System.currentTimeMillis() - start;
			double numsPerSec = (double) i / (double) time;
			System.out.println(i + ": " + time + " ms - nums/ms: " + numsPerSec);
		}
	}

	public static void SelectionSort(int[] v) {
		int index_min, aux;

		// long start = System.currentTimeMillis();
		// int tenth = v.length / 100;
		for (int i = 0; i < v.length; i++) {
			index_min = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[index_min]) {
					index_min = j;
				}
			}
			if (index_min != i) {
				aux = v[index_min];
				v[index_min] = v[i];
				v[i] = aux;
			}
			// showStats(i, tenth, start);
		}
	}

	private static void imprimirVetor(int[] v) {
		System.out.println("Vetor: tamanho=" + v.length);
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		System.out.println("teste: " + Integer.MAX_VALUE);

		int tam = 250000;
		int maxValue = 100000;
		int[] v = new int[tam];
		int[] aux = new int[tam];
		// List<Integer> v = new ArrayList<Integer>();
		// List<Integer> aux = new ArrayList<Integer>();
		long start, finish;
		Math.random();
		Random r = new Random();
		for (int i = 0; i < tam; i++) {
			int num = r.nextInt() % maxValue;
			if (num < 0)
				num *= -1;
			v[i] = num;
			// v.add(num);
			// aux.add(num);
		}
		System.arraycopy(v, 0, aux, 0, tam);
		start = System.currentTimeMillis();
		SelectionSort(v);
		finish = System.currentTimeMillis();
		System.out.println("Selection Duration: " + (finish - start) + " ms");
		System.arraycopy(aux, 0, v, 0, tam);
		start = System.currentTimeMillis();
		insertionSort(v);
		finish = System.currentTimeMillis();
		System.out.println("Insertion Duration: " + (finish - start) + " ms");
		System.arraycopy(aux, 0, v, 0, tam);
		start = System.currentTimeMillis();
		bubbleSort(v);
		finish = System.currentTimeMillis();
		System.out.println("BubbleSort Duration: " + (finish - start) + " ms");
		System.arraycopy(aux, 0, v, 0, tam);
		start = System.currentTimeMillis();
		quicksort(v);
		finish = System.currentTimeMillis();
		System.out.println("QuickSort Duration: " + (finish - start) + " ms");
		start = System.currentTimeMillis();
		merge(v, 0, v.length - 1);
		finish = System.currentTimeMillis();
		System.out.println("MergeSort Duration: " + (finish - start) + " ms");
		System.arraycopy(aux, 0, v, 0, tam);
		start = System.currentTimeMillis();
		shellSort(v);
		finish = System.currentTimeMillis();
		System.out.println("ShellSort Duration: " + (finish - start) + " ms");
		System.arraycopy(aux, 0, v, 0, tam);
		start = System.currentTimeMillis();
		heapSort(v);
		finish = System.currentTimeMillis();
		System.out.println("HeapSort Duration: " + (finish - start) + " ms");
		System.arraycopy(aux, 0, v, 0, tam);
		start = System.currentTimeMillis();
		BucketSort(v, maxValue);
		finish = System.currentTimeMillis();
		System.out.println("BucketSort Duration: " + (finish - start) + " ms");

	}

}
