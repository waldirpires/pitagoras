#include <stdlib.h>
#include <stdio.h>

#define MAX  10

typedef struct TipoNo * TipoApontador;
typedef long TipoChave;
typedef struct TipoNo {
  TipoChave chave;
  TipoApontador Esq, Dir;
} TipoNo;

int Pesquisa(TipoChave chave, TipoApontador p)
{ if (p == NULL) 
  { printf("Erro: Registro nao esta presente na arvore\n");
    return -1;
  }
  if (chave < p->chave) { 
    return Pesquisa(chave, p->Esq);
  } else if (chave > p->chave){
    return Pesquisa(chave, p->Dir);
  } else {
    return chave;
  }
} 

void Inicializa(TipoApontador *A)
{ *A = NULL; }

void Central(TipoApontador p)
{ if (p == NULL) return;
  Central(p->Esq);
  printf("%ld\n", p->chave);
  Central(p->Dir);
} 

void PreOrdem(TipoApontador p)
{ if (p == NULL) return;
  printf("%ld\n", p->chave);
  Central(p->Esq);
  Central(p->Dir);
} 

void PosOrdem(TipoApontador p)
{ if (p == NULL) return;
  Central(p->Esq);
  Central(p->Dir);
  printf("%ld\n", p->chave);
} 

void Insere(long chave, TipoApontador *p)
{ if (*p == NULL) 
  { *p = (TipoApontador)malloc(sizeof(TipoNo));
    (*p)->chave = chave; 
    (*p)->Esq = NULL; 
    (*p)->Dir = NULL;
    return;
  }
  if (chave < (*p)->chave) 
  { Insere(chave, &(*p)->Esq); 
    return; 
  }
  if (chave > (*p)->chave)
  Insere(chave, &(*p)->Dir);
  else printf("Erro : Registro ja existe na arvore\n");
} 

void Antecessor(TipoApontador q, TipoApontador *r)
{ if ((*r)->Dir != NULL) 
  { Antecessor(q, &(*r)->Dir);
    return;
  }
  q->chave = (*r)->chave;
  q = *r; 
  *r = (*r)->Esq;
  free(q);
} 

void Retira(TipoChave x, TipoApontador *p)
{  TipoApontador Aux;
  if (*p == NULL) 
  { printf("Erro : Registro nao esta na arvore\n");
    return;
  }
  if (x < (*p)->chave) { Retira(x, &(*p)->Esq); return; }
  if (x > (*p)->chave) { Retira(x, &(*p)->Dir); return; }
  if ((*p)->Dir == NULL) 
  { Aux = *p;  *p = (*p)->Esq;
    free(Aux);
    return;
  }
  if ((*p)->Esq == NULL) 
  { Aux = *p;  *p = (*p)->Dir;
    free(Aux);
    return;
  }
  Antecessor(*p, &(*p)->Esq);
}  


int main(int argc, char *argv[])
{
  TipoApontador A;
  Inicializa(&A);

  Insere(5, &A);
  Insere(2, &A);
  Insere(3, &A);
  Insere(9, &A);
  Insere(7, &A);

  TipoChave chave = 1;
  printf("%d: %d\n", chave, Pesquisa(chave, A));
  chave = 9;
  printf("%d: %d\n", chave, Pesquisa(chave, A));

  Central(A);
  printf("Retirando uma chave\n");
  Retira(chave, &A);
  Central(A);
  
  system("PAUSE");
  return 0;
} 
