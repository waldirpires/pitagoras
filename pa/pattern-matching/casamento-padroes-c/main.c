#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "kmp.h"
#include "rk.h"
#include "bm.h"

int subsString(char t[], char p[]){
    int tamT, tamP;
    tamT = strlen(t);
    tamP = strlen(p);
    int j, i;
    for (i = 0; i < (tamT-tamP)+1; i++){
        j = 0;
        while (j < tamP && t[i+j] == p[j]){
          j++;
        }
        if (j == tamP){
          return i;
        }
    }
    return -1;
}

int main(int argc, char *argv[])
{
  // problema
  // entrada: um texto e um padr�o
  // sa�da: apresentar a posi��o da ocorr�ncia do
  //        padr�o no texto, caso ele exista
  
  // Passos
  const int TAM = 100;
  // var T, P: conjunto[1...100]: caracter
  //     POS: inteiro
  //char p[TAM], t[TAM];
  char *t = "abcdefghi";
  char *p = "cf";
  int pos;
  // 1) Ler o texto e o padr�o a ser pesquisado
  //printf("Digite uma frase:");
  //gets(t);
  //printf("Digite um padr�o:");
  //gets(p);
  printf("\nTexto : %s\n", t);
  printf("\nPadr�o: %s\n", p);
  
  // 2) Efetuar a busca do padr�o no texto
  //pos = subsString(t, p);
  //KMPSearch(p, t);
  //KR(p, strlen(p), t, strlen(t));
  char * r = BoyerMoore(t, strlen(t), p, strlen(p));
  printf("%s\n", r);
  // 3) Exibir o resultador
  //printf("Resultado: %d\n", pos);
  
  system("PAUSE");	
  return 0;
}
