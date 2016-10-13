#include <stdio.h>
#include <stdlib.h>

int main(void) {
	FILE *fp, *fp2;
    int c;

	puts("Hello World!"); /* prints !!!Hello World!!! */
	if ((fp = fopen ("teste.txt", "r")) == NULL)
	    return -1;
	if ((fp2 = fopen ("teste2.txt", "w")) == NULL)
	    return -1;

	while ((c = fgetc(fp)) != EOF){
		printf("%c", c);
		fprintf(stdout, "%c", c);
		fprintf(fp2, "%c", c);
	}

	fclose(fp);
	fclose(fp2);

	return EXIT_SUCCESS;
}
