package br.pit.acca.lab1.recursividade;

public class OrdenacaoRecursivo {

	public static void trocarValores(int [] a, int i, int j) {
		  int aux;
		  aux = a[i];
		  a[i] = a[j];
		  a[j] = aux;
		}

	static void merge(int pivot, int low, int length, int high, int [] a) {
		  int merge1, merge2, i;;

		  merge1 = 0;
		  merge2 = pivot - low + 1;
		  int working[] = new int[length];

		  for (i = 0; i < length; i++){
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

		static void mergesort(int []a, int low, int high) {
		  int length = high - low + 1;
		  int pivot = 0;

		  if (low == high) // caso base: vetor de tamanho 1
		    return;
		  pivot = (low + high) / 2; // cálculo do ponto médio

		  mergesort(a, low, pivot); // dividir a esquerda
		  mergesort(a, pivot + 1, high); // dividir a direita

		  merge(pivot, low, length, high, a); // junção das soluções
		}
	
	
}
