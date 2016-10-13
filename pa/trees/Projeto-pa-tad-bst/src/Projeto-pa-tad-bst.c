/*
 ============================================================================
 Name        : Projeto-pa-tad-bst.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "tad-arvore.h"

int main(void) {
	puts("Hello World"); /* prints Hello World */

	  TipoApontador A;
	  Inicializa(&A);

//	  Insere(5, &A);
//	  Insere(2, &A);
//	  Insere(3, &A);
//	  Insere(9, &A);
//	  Insere(7, &A);

	  int chaves[] = {5, 2, 9, 1, 4, 3, 7};
	  int tam = 7;
	  int i = 0;
	  for (i = 0; i < tam; i++){
		  Insere(chaves[i], &A);
	  }

	  TipoChave chave = 1;
//	  printf("%d: %d\n", chave, Pesquisa(chave, A));
//	  chave = 9;
//	  printf("%d: %d\n", chave, Pesquisa(chave, A));

	  Central(A);
	  printf("Retirando uma chave\n");
	  chave = 5;
	  Retira(chave, &A);
	  Central(A);

	return EXIT_SUCCESS;
}
