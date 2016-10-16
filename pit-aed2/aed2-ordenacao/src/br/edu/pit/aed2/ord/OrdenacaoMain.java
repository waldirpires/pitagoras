package br.edu.pit.aed2.ord;

public class OrdenacaoMain {

	private static void trocarValores(int[] v, int i, int menor) {
		int aux = v[i];
		v[i] = v[menor];
		v[menor] = aux;
	}

	// ordenação por seleção
	private static void selecao(int[] v) {
		int menor = -1;
		// para cada posicao i do vetor V
		for (int i = 0; i < v.length; i++) {
			// assumir que o elemento no indice i é o menor
			menor = i;
			// para cada posição subsequente j do vetor V
			for (int j = i + 1; j < v.length; j++) {
				// se o elemento na posicao j for menor que o
				// elemento na posição i
				if (v[j] < v[menor]) {
					// marcar o elemento na posição j como sendo o menor
					menor = j;
				}
			}
			// se o menor elemento encontrado for diferente do
			// elemento na posiçao i
			if (menor != i) {
				// trocar os valores menor e i
				trocarValores(v, i, menor);
			}
		}
	}

	// insercao
	private static void insertionSort(int[] A) {
		int i, j, eleito;
		for (i = 1; i < A.length; i++) {
			eleito = A[i];
			j = i;
			while ((j > 0) && (A[j - 1] > eleito)) {
				A[j] = A[j - 1];
				j = j - 1;
			}
			A[j] = eleito;
		}
	}

	// bolha

	// ordenacao por bolha
	private static void bolha(int[] v) {
		// para cada indice i no vetor v
		for (int i = 0; i < v.length; i++) {
			// para cada indice j no vetor v
			for (int j = 0; j < v.length - 1; j++) {
				// se o elemento na posição j for maior que o da
				// posição j + 1
				if (v[j] > v[j + 1]) {
					// trocar valores j e j+1
					trocarValores(v, j, j + 1);
				}
			}
		}
	}

	// mergesort

	private static void merge(int pivot, int low, int length, int high, int[] a) {
		int merge1, merge2, i;
		int[] working;

		merge1 = 0;
		merge2 = pivot - low + 1;
		working = new int[length];

		for (i = 0; i < length; i++) {
			working[i] = a[low + i];
		}

		for (i = 0; i < length; i++) {
			// iterando dentro de cada subvetor
			if (merge2 <= high - low) {
				if (merge1 <= pivot - low) {
					if (working[merge1] > working[merge2]) {
						a[i + low] = working[merge2++];
					} else {
						a[i + low] = working[merge1++];
					}
				} else {
					a[i + low] = working[merge2++];
				}
			} else {
				a[i + low] = working[merge1++];
			}
		}
	}

	private static void mergesort(int[] a, int low, int high) {
		int length = high - low + 1;
		int pivot = 0;

		if (low == high) // caso base: vetor de tamanho 1
			return;
		pivot = (low + high) / 2; // cálculo do ponto médio

		mergesort(a, low, pivot); // dividir a esquerda
		mergesort(a, pivot + 1, high); // dividir a direita

		merge(pivot, low, length, high, a); // junção das soluções
	}

	private static void quicksort(int[] a, int tam, int left, int right) {
		int i, j, p;
		i = left;
		j = right;

		p = a[(left + right) / 2]; // Elemento intermediário como “pivo”
		do {
			while (a[i] < p && i < right)
				i++;
			while (a[j] > p && j > left)
				j--;
			if (i <= j) {
				trocarValores(a, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (left < j)
			quicksort(a, tam, left, j);
		if (i < right)
			quicksort(a, tam, i, right);
	}

	// shellsort
	public static void shellSort(Integer[] nums) {
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
	
	// heapsort

	public static void heapSort(int[] v)
    {
      buildMaxHeap(v);
      int n = v.length;

      for (int i = v.length - 1; i > 0; i--)
      {
         trocarValores(v, i , 0);
         maxHeapify(v, 0, --n);
      }
    }
    private static void buildMaxHeap(int[] v)
    {
       for (int i = v.length/2 - 1; i >= 0; i--)
          maxHeapify(v, i , v. length );
    }
    private static void maxHeapify(int[] v, int pos, int n)
    {
       int maxi;
       int l = 2 * pos;
       int right = 2 * pos + 1;
       if ( (l < n) && (v[l] > v[pos]) )
       {
          maxi = l;
       }
       else
       {
          maxi = pos;
       }
       if (right < n && v[right] > v[maxi])
       {
          maxi = right;
       }
       if (maxi != pos)
       {
          trocarValores(v, pos, maxi);
          maxHeapify(v, maxi, n);
       }
    }	
}
