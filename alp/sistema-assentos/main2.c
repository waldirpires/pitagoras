#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>

const int LINHAS = 6; // numero de cadeiras por fila
const int COLUNAS = 25; // numero de filas

void exibir_menu(){ // http://pastebin.com/AwJFAPD1
  system("cls"); // limpar a tela
  printf("Bem-vindo ao Sistema de Reservas ATP\n");
  printf("====================================\n\n");
  printf("Selecione uma opção:\n\n");
  printf("(1) Efetuar reserva de assento\n");
  printf("(2) Cancelar reserva de assento efetuada\n");
  printf("(3) Exibir status de reservas\n");
  printf("(4) Exibir mapa de reservas\n");
  printf("(5) Sair do programa\n\n");
}
 
int confirmar_sair_programa(){ // confirmar a saida do programa
    char c;
    fflush(stdin);
    printf("Deseja realmente sair (s/n)?");
    scanf("%c", &c);
    if (c == 's' || c == 'S'){return 1;} // se o usuario decidir sair
    else {return 0;} // caso contrario continuar no programa        
}
 
void exibir_mapa(char assentos[][COLUNAS]){ // exibir o mapa
  int i, j;
  printf("    ");
  for (j = 0; j < COLUNAS; j++){ // exibindo o numero das colunas
       printf("%3d", j);
  }
  printf("\n");  
  for (i = 0 ; i < LINHAS; i++){ // exibindo a matriz
    printf("%d: ", i); // exibindo o numero da linha
    for (j = 0; j < COLUNAS; j++){
       printf("%3c", assentos[i][j]); // exibindo o status do assento
    }
    printf("\n");
  }
}
 
void inicializar_mapa(char assentos[][COLUNAS]){ // inicializar o mapa
  int i, j;
  for (i = 0 ; i < LINHAS; i++){
    for (j = 0; j < COLUNAS; j++){ assentos[i][j] = 'L';}
  }    
}
 
int efetuar_reserva(char assentos[][COLUNAS]){
    int i, j;
    // 0) exibir o mapa de assento
    exibir_mapa(assentos);
    // 1) solicitar ao usuario a linha e coluna da reserva
    fflush(stdin);
    printf("Digite o assento desejado: (linha coluna)\n\n");
    scanf("%d %d", &i,&j);
    if (i >=LINHAS || j >= COLUNAS){// validar assento desejado
      printf("Acento inválido para reserva: (%d,%d)\n", i,j);
      return 0;
    }
    // 2) verificar se o assento está disponivel
    // 3) se sim: atualizar o mapa de assentos
    if (assentos[i][j] == 'L'){assentos[i][j] = 'X'; return 1;}
    // 4) se nao: informar que o assento está ocupado
    else {
      printf("O assento (%d,%d) está ocupado!\n\n", i, j);return 0;};
}
 
int main(int argc, char *argv[]){
  // problema: implementar um sistema de reservas de assentos
  setlocale(LC_ALL, "portuguese");
  // partes do sistema:
  // 0) declaracao dos tipos de dados
  char assentos[LINHAS][COLUNAS];  
  inicializar_mapa(assentos);
  int op = -1; // opção escolhida
  while (op != 5){
    exibir_menu();     // 1) menu de opcoes
    fflush(stdin);
    scanf("%d", &op);
    switch (op){ // executando as opcoes
      case 1: // 2) efetuar reserva
        op = efetuar_reserva(assentos);
        if (op){exibir_mapa(assentos);
                printf("Reserva efetuada com sucesso!\n\n");}
        else {printf("Reserva não foi efetuada.\n\n");}
        system("pause");
        break;
      case 2: // 3) cancelar reserva
        break;
      case 3: // 4) exibir status (taxa de ocupação, num. assentos livres)            
        break;
      case 4: // 5) exibir mapa de assentos (' ' para vazio, 'X' para ocupado)
        exibir_mapa(assentos);
        system("PAUSE");
        break;
      case 5: // 6) sair do programa
        if (confirmar_sair_programa() != 1){op = -1;}
        break;
      default:
        printf("Opção inválida: %d.\nTente novamente.", op);              
        system("PAUSE");
    }
  }  
  printf("Obrigado por utilizar o sistema!\nVolte sempre!\n");
  system("PAUSE");     
  return 0;
}
