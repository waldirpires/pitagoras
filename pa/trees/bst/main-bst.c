#include <stdio.h>
#include <stdlib.h>

struct node{ 
  int chave; 
  struct node *esq, *dir; 
}; 
typedef struct node node; 

int pesquisar(int k, node *x){
    printf("Searching Node %d\n", x->chave);
  if (x == NULL){
    return -1;
  }
  if (k < x->chave){
    return pesquisar(k, x->esq);
  } else if (k > x->chave){
    return pesquisar(k, x->dir);
  } else {
    return k;
  }
}

void criarNo(node *x, int chave){
  x = malloc(sizeof(node));
  x->esq = NULL;
  x->dir = NULL;
  x->chave = chave;
}

int main(int argc, char *argv[])
{
  
  // declarando o nó raiz
  node *raiz, *no2; 
  // criando a árvore - nó raiz
  criarNo(raiz, 2);
  criarNo(no2, 1);
  // ligando os dois nós
  raiz->esq = no2;
  printf("Searching . . .\n");
  int k = 2;
  printf("%d: %d\n", k, pesquisar(k, raiz));
  k = 1;
  printf("%d: %d\n", k, pesquisar(k, raiz));
  k = 3;
  printf("%d: %d\n", k, pesquisar(k, raiz));
  system("PAUSE");	
  return 0;
}
