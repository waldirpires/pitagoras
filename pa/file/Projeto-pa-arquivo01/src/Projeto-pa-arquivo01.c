/*
 ============================================================================
 Name        : Projeto-pa-arquivo01.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

#define MAX_BUFFER = 100;

void abrirArquivo(FILE *f, char *nome, char *modo){
	f = fopen(nome, modo);
	if (f == NULL){
		perror("ERRO: abertura de arquivo - \"nome\"");
		exit(EXIT_FAILURE);
	}
}

void printBuffer(char *buffer, int tam)
{
	int i = 0;
	for (i = 0; i < tam; i++){
		printf("%c ", buffer[i]);
	}
	printf("\n");
}

int main(void) {
	FILE *fp = NULL;
	char buffer[100] = {0};
	int i, rc, tam;

	fp = fopen("teste.txt", "rb");

	rc = fgetc(fp);
    for (i = 0; rc != EOF; i++) {
    	buffer[i] = rc;
    	tam++;
    	rc = fgetc(fp);
    }

    fclose(fp);

    if (i > 0) {
        puts("The bytes read were...");
        //printf("%c %x %x %x %x\n", buffer[0], buffer[1], buffer[2], buffer[3], buffer[4]);
        printBuffer(buffer, tam);
    }
    else
        fputs("An error occurred while reading the file.\n", stderr);

    return EXIT_SUCCESS;


	puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */
	return EXIT_SUCCESS;
}
