package br.edu.pitagoras.oda.arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProgramaExercicio1 {
	// 1) Problema 1 (Fácil)
	// Entrada: um caractere e um arquivo texto (nome)
	// Saída: informar a quantidade de vezes que
	// o caractere ocorre no arquivo

	public static void main(String[] args) {
		
	// solucao
	// 1) definir a entrada de dados: caractere e nome do arquivo
	char c = 'a';
	String nomeArquivo = "teste.txt";
	try {
		contarCharEmArquivo(c, nomeArquivo);
	} catch (FileNotFoundException e) {
		System.out.println("ERRO: arquivo " + nomeArquivo + 
				" não existe!");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("ERRO: erro de leitura do arquivo!");
		e.printStackTrace();
	}
	}
	// casos de teste
	// 1) arquivo informado nao existe -> mensagem de erro
	// 2) arquivo vazio -> sem erros, contador zero
	// 3) arquivo com dados -> sem erros, contador com valor correto
	// 4) arquivo sem permissao para leitura - mensagem de erro

	static void contarCharEmArquivo(char c, String nomeArquivo)
			throws FileNotFoundException, IOException {
		// 2) abrir o arquivo
		InputStream is = new FileInputStream(nomeArquivo);
		// 3) Se o arquivo nao existir
		// 3.1) exibir uma mensagem de erro
		// 4) Senao
		// 4.1) Abrir o arquivo para leitura de caracteres
		InputStreamReader isr = new InputStreamReader(is);
		// 4.2) Ler o primeiro caractere
		int d = isr.read();
		int count = 0;
		// 4.3) Enquanto nao for fim de arquivo
		while (d != -1){
		// 	4.3.1) Se o char lido for igual a char informado
			if (d == c){
				// 	4.3.1.1) incrementar o contador de caracteres
				count++;
			}
		}
		// 4.4) Exibir a quantidade de vezes que o char ocorre
		System.out.println("Buscando pelo caractere " + c + 
				" no arquivo " + nomeArquivo + " ...");
		System.out.println("Quantidade de vezes: " + count);
		// 4.5) fechar o arquivo
		isr.close();
	}
	
	
	
	
	
	
	
	
	
	
}
