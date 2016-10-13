void imprimeVetor(int *a, int tam) {
  int i;
  for (i = 0; i < tam; i++) {
    printf("%5d   ", a[i]);
  }
  printf("\n\n");

}

int gerarNumeroAleatorio(int max) {
  return rand() % max;
}

void trocarValores(int *a, int i, int j) {
  int aux;
  aux = a[i];
  a[i] = a[j];
  a[j] = aux;
}

void exibirPorcentagem(int i, int tam) {
  if (i % (tam / 100) == 0)
    printf("%d %\n", i);
}

void merge(int pivot, int low,
    int length, int high, int* a) {
  int merge1, merge2, i, *working;

  merge1 = 0;
  merge2 = pivot - low + 1;
  working = (int*) malloc(length * sizeof(int));

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

long mergesort(int *a, int low, int high) {
  int i = 0;
  int length = high - low + 1;
  int pivot = 0;
  int * working;
  unsigned long trocas;

  if (low == high) // caso base: vetor de tamanho 1
    return;
  pivot = (low + high) / 2; // cálculo do ponto médio

  mergesort(a, low, pivot); // dividir a esquerda
  mergesort(a, pivot + 1, high); // dividir a direita

  merge(pivot, low, length, high, trocas, a); // junção das soluções
  return trocas;
}

long quicksort(int *a, int tam, int left, int right) {
  int i, j, p;
  unsigned long trocas = 0;
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
      trocas++;
      i++;
      j--;
    }
    exibirPorcentagem(i, tam);
  } while (i <= j);
  if (left < j)
    trocas += quicksort(a, tam, left, j);
  if (i < right)
    trocas += quicksort(a, tam, i, right);
  return trocas;
}

long bubbleSort(int *a, int tam) {
  int i, j;
  unsigned long trocas = 0;

  for (i = 0; i < tam; i++) {
    for (j = 0; j < tam - 1; j++) {
      if (a[j] > a[j + 1]) {
        trocarValores(a, j, j + 1);
        trocas++;
      }
    }
    exibirPorcentagem(i, tam);
  }
  return trocas;
}

long insertionSort(int *a, int tam) {
  int i, iHole, item;
  unsigned long trocas = 0;

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
      trocas++;
    }
    // put item in the hole
    a[iHole] = item;
    exibirPorcentagem(i, tam);
  }
  return trocas;
}

long selectionSort(int * a, int tam) {
  int i, j, menor; // declaração de variáveis
  unsigned long trocas = 0;

  // percorrer todas as posições do vetor, um a um
  for (i = 0; i < tam; i++) {
    menor = i; // assumir que o primeiro no intervalo é menor
    // percorrer o vetor para buscar alguem menor, caso exista
    for (j = i + 1; j < tam; j++) { // se for menor que o menor encontrado
      if (a[j] < a[menor]) {   // anote-o
        menor = j;
      }
    }   // se alguem menor que o menor for encontrado
    if (menor != i) {   // trocar as posições dos dois
      trocarValores(a, menor, i);
      trocas++;
    }
    exibirPorcentagem(i, tam);
  }
  return trocas;
}

void copy(int *b, int *a, int tam) {
  int i = 0;
  for (i = 0; i < tam; i++) {
    a[i] = b[i];
  }

}
