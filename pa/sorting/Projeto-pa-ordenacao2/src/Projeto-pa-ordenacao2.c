/*
 ============================================================================
 Name        : Projeto-pa-ordenacao2.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "ordenacao.h"

int main(void) {

	int *a, *b, tam, i, num, lim;
	time_t seconds, start, end;
	double duration;
	unsigned long trocas = 0;


	tam = 1000000000;
	lim = 100000;
	time(&seconds);
	srand((unsigned int) seconds);

	//printf("Digite o tamanho do vetor:");
	//scanf("\n%d", &tam);

	a = (int*) malloc(tam*sizeof(int));
	b = (int*) malloc(tam*sizeof(int));

	for (i = 0; i < tam; i++)
	{
		num = gerarNumeroAleatorio(lim);
		a[i] = num;
		b[i] = num;
	}

//	time(&start);
//	trocas = selectionSort(a, tam);
//	time(&end);
//	duration = difftime(end, start);
//	printf("\nDuration: %f seconds \tTrocas: %u\n", duration, trocas);
//	system("PAUSE");
//	copy(b, a, tam);
//	time(&start);
//	trocas = insertionSort(a, tam);
//	time(&end);
//	duration = difftime(end, start);
//	printf("\nDuration: %f seconds \tTrocas: %u\n", duration, trocas);
//	system("PAUSE");
//	copy(b, a, tam);
//	time(&start);
//	trocas = bubbleSort(a, tam);
//	time(&end);
//	duration = difftime(end, start);
//	printf("\nDuration: %f seconds \tTrocas: %u\n", duration, trocas);
//	system("PAUSE");
//	copy(b, a, tam);
	time(&start);
	trocas = quicksort(a, tam, 0, tam-1);
	time(&end);
	duration = difftime(end, start);
	printf("\nDuration: %f seconds \tTrocas: %u\n", duration, trocas);
	system("PAUSE");
	copy(b, a, tam);
	time(&start);
	trocas = mergesort(a, 0, tam-1);
	time(&end);
	duration = difftime(end, start);
	printf("\nDuration: %f seconds \tTrocas: %u\n", duration, trocas);
	system("PAUSE");
	return EXIT_SUCCESS;
}
