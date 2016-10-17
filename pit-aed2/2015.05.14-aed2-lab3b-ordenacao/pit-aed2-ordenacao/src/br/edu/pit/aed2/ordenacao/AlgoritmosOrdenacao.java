package br.edu.pit.aed2.ordenacao;

public class AlgoritmosOrdenacao {

	// http://pastebin.com/P2yzDwJK
	// ordenação por seleção

	public static void selecao(int[] a) {
		int i, j, menor; // declaração de variáveis

		// percorrer todas as posições do vetor, um a um
		for (i = 0; i < a.length; i++) {
			menor = i; // assumir que o primeiro no intervalo é menor
			// percorrer o vetor para buscar alguem menor, caso exista
			for (j = i + 1; j < a.length; j++) { // se for menor que o menor
													// encontrado
				if (a[j] < a[menor]) { // anote-o
					menor = j;
				}
			} // se alguem menor que o menor for encontrado
			if (menor != i) { // trocar as posições dos dois
				trocarValores(a, menor, i);
			}
		}
	}

	public static void trocarValores(int[] a, int i, int j) {
		int aux;
		aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

	// http://pastebin.com/xq2hrqFj
	public static void bubbleSort(int[] a) {
		int i, j;

		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					trocarValores(a, j, j + 1);
				}
			}
		}
	}
	
	// http://pastebin.com/J9dsE8pw
	public static void insertionSort(int []a) {
		  int i, iHole, item;

		  for (i = 1; i < a.length; i++) {
		    item = a[i];
		    iHole = i;
		    while (iHole > 0 && a[iHole - 1] > item) {
		      a[iHole] = a[iHole - 1];
		      iHole = iHole - 1;
		    }
		    a[iHole] = item;
		  }
		}
	
	public static void shellSort(int[] nums) {
	    int h = 1;
	    int n = nums.length;
	    while(h < n)
	            h = h * 3 + 1;
	    h = h / 3;
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

}
