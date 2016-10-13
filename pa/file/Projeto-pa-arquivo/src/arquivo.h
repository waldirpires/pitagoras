#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

int ArquivoExiste(char *nome)
{
	FILE * f;
    if ( (f = fopen(nome, "rb")) == NULL)
    {
    	return FALSE;
    } else {
    	return TRUE;
    }
}

void ArquivoImprimeConsoantes(char * nome)
{

	FILE * f;
	char c;
    if ( (f = fopen(nome, "r")) == NULL)
    {
    	return;
    }
    while ((c=fgetc(f)) != EOF){
      if (c != 'a' && c != 'e' && c != 'i' &&
    		  c != 'o' && c != 'u')
    	  printf("%c", c) ;
    }

}

void ArquivoImprimeInvertido(char * nome)
{

	FILE * f;
	int i;
	char c;
	char d[100];
	int tam = 0;
    if ( (f = fopen(nome, "r")) == NULL)
    {
    	return;
    }
    while ((c=fgetc(f)) != EOF){
    	d[tam] = c;
    	tam++;
    }
    for (i = tam-1; i >=0; i--){
    	printf("%c", d[i]);
    }

}
