/*
 ============================================================================
 Name        : Projeto-pa-arquivo.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include "arquivo.h"

int main(void) {
	puts("Hello World"); /* prints Hello World */


	char * nome = "teste.txt";
	printf("Resposta: %d\n\n", ArquivoExiste(nome));

	printf("\n");
	ArquivoImprimeConsoantes(nome);
	printf("\n");
	ArquivoImprimeInvertido(nome);
	return EXIT_SUCCESS;
}
