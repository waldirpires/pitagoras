package br.edu.pit.aeda.ordenacao.interna;

import java.util.LinkedList;

public class OrdenacaoInterna {

	static void trocar(int a[], int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

	public static int[] selecao(int a[]) {

		int i, j, menor;
		for (i = 0; i < a.length; i++) {
			menor = i;
			for (j = i + 1; j < a.length; j++) {
				if (a[j] < a[menor])
					menor = j;
			}
			if (menor != i) {
				trocar(a, menor, i);
			}
		}
		return a;
	}
	
	public static void merge(int pivot, int[] b) {
	  sort(b, 0, b.length-1);
	}
	
	static void merge(int arr[], int l, int m, int r)
  {
      // Find sizes of two subarrays to be merged
      int n1 = m - l + 1;
      int n2 = r - m;

      /* Create temp arrays */
      int L[] = new int [n1];
      int R[] = new int [n2];

      /*Copy data to temp arrays*/
      for (int i=0; i<n1; ++i)
          L[i] = arr[l + i];
      for (int j=0; j<n2; ++j)
          R[j] = arr[m + 1+ j];


      /* Merge the temp arrays */

      // Initial indexes of first and second subarrays
      int i = 0, j = 0;

      // Initial index of merged subarry array
      int k = l;
      while (i < n1 && j < n2)
      {
          if (L[i] <= R[j])
          {
              arr[k] = L[i];
              i++;
          }
          else
          {
              arr[k] = R[j];
              j++;
          }
          k++;
      }

      /* Copy remaining elements of L[] if any */
      while (i < n1)
      {
          arr[k] = L[i];
          i++;
          k++;
      }

      /* Copy remaining elements of L[] if any */
      while (j < n2)
      {
          arr[k] = R[j];
          j++;
          k++;
      }
  }

  // Main function that sorts arr[l..r] using
  // merge()
  static void sort(int arr[], int l, int r)
  {
      if (l < r)
      {
          // Find the middle point
          int m = (l+r)/2;

          // Sort first and second halves
          sort(arr, l, m);
          sort(arr , m+1, r);

          // Merge the sorted halves
          merge(arr, l, m, r);
      }
  }	
	
//	private static void merge(int pivot, int low, int length, int high, int[] a) {
//	  int merge1, merge2, i, working[];
//
//	  merge1 = 0;
//	  merge2 = pivot - low + 1;
//	  working = new int[length];
//
//	  for (i = 0; i < length; i++){
//	    working[i] = a[low + i];
//	  }
//
//	  for (i = 0; i < length; i++) {
//	    // iterando dentro de cada subvetor
//	    if (merge2 <= high - low) {
//	      if (merge1 <= pivot - low) {
//	        if (working[merge1] > working[merge2]) {
//	          a[i + low] = working[merge2++];
//	        } else {
//	          a[i + low] = working[merge1++];
//	        }
//	      } else {
//	        a[i + low] = working[merge2++];
//	      }
//	    } else {
//	      a[i + low] = working[merge1++];
//	    }
//	  }
//	}
//
//	public static void mergesort(int []a, int low, int high) {
//	  int length = high - low + 1;
//	  int pivot = 0;
//
//	  if (low == high) // caso base: vetor de tamanho 1
//	    return;
//	  pivot = (low + high) / 2; // cálculo do ponto médio
//
//	  mergesort(a, low, pivot); // dividir a esquerda
//	  mergesort(a, pivot + 1, high); // dividir a direita
//
//	  merge(pivot, low, length, high, a); // junção das soluções
//	}	
//	
	public static void quicksort(int []a) {
	  quicksort(a, a.length, 0, a.length-1);
	}
	
	private static void quicksort(int []a, int tam, int left, int right) {
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
	      trocar(a, i, j);
	      i++;
	      j--;
	    }
	  } while (i <= j);
	  if (left < j)
	    quicksort(a, tam, left, j);
	  if (i < right)
	    quicksort(a, tam, i, right);
	}

	public static void bubbleSort(int []a, int tam) {
	  int i, j;

	  for (i = 0; i < tam; i++) {
	    for (j = 0; j < tam - 1; j++) {
	      if (a[j] > a[j + 1]) {
	        trocar(a, j, j + 1);
	      }
	    }
	  }
	}

	public static void insertionSort(int []a, int tam) {
	  int i, iHole, item;

	  for (i = 1; i < tam; i++) {
	    // A[ i ] is added in the sorted sequence A[0, .. i-1]
	    // save A[i] to make a hole at index iHole
	    item = a[i];
	    iHole = i;
	    // keep moving the hole to next smaller index until A[iHole - 1] is <= item
	    while (iHole > 0 && a[iHole - 1] > item) {
	      // move hole to next smaller index
	      a[iHole] = a[iHole - 1];
	      iHole = iHole - 1;
	    }
	    // put item in the hole
	    a[iHole] = item;
	  }
	}	
	
	static void heapsort(int a[]) {
	  int n = a.length;
	   int i = n / 2, pai, filho, t;
	   for (;;) {
	      if (i > 0) {
	          i--;
	          t = a[i];
	      } else {
	          n--;
	          if (n == 0) return;
	          t = a[n];
	          a[n] = a[0];
	      }
	      pai = i;
	      filho = i * 2 + 1;
	      while (filho < n) {
	          if ((filho + 1 < n)  &&  (a[filho + 1] > a[filho]))
	              filho++;
	          if (a[filho] > t) {
	             a[pai] = a[filho];
	             pai = filho;
	             filho = pai * 2 + 1;
	          } else {
	             break;
	          }
	      }
	      a[pai] = t;
	   }
	}	

	/*
	* Autor: wilhs
	* Data: 28/04/2011
	* Crédito: Implementação com base neste Artigo.
	*/

	public static void BucketSort(int[] vetor, int maiorValor)
	{
	  int numBaldes = maiorValor/5;

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

	    insertionSort(aux, aux.length);

	    // Devolve os valores ao vetor de entrada:
	    for (int j = 0; j < aux.length; j++, indice++){
	      vetor[indice] = aux[j];
	    }

	  }
	}	
	
	public static void shellSort(int[] a) {
    int h = 1;
    int n = a.length;
    while(h < n)
            h = h * 3 + 1;
    h = h / 3;
    int c, j;
    while (h > 0) {
        for (int i = h; i < n; i++) {
            c = a[i];
            j = i;
            while (j >= h && a[j - h] > c) {
                a[j] = a[j - h];
                j = j - h;
            }
            a[j] = c;
        }
        h = h / 2;
    }
}	
}
