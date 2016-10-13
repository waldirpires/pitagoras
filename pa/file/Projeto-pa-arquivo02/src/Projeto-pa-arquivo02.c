#include <stdio.h>
int main() {
	FILE *pf;
	float pi = 3.1415;
	float pilido;
	if ((pf = fopen("arquivo.bin", "wb")) == NULL ) /* Abre arquivo bin�rio para escrita */
	{
		printf("Erro na abertura do arquivo");
		exit(1);
	}
	if (fwrite(&pi, sizeof(float), 1, pf) != 1) /* Escreve a vari�vel pi */
		printf("Erro na escrita do arquivo");
	fclose(pf); /* Fecha o arquivo */
	if ((pf = fopen("arquivo.bin", "rb")) == NULL ) /* Abre o arquivo novamente para leitura */
	{
		printf("Erro na abertura do arquivo");
		exit(1);
	}
	if (fread(&pilido, sizeof(float), 1, pf) != 1) /* Le em pilido o valor da vari�vel armazenada anteriormente */
		printf("Erro na leitura do arquivo");
	printf("\nO valor de PI, lido do arquivo e': %f", pilido);
	fclose(pf);
	return (0);
}
