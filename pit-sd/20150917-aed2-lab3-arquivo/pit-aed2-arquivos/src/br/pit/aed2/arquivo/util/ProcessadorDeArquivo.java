package br.pit.aed2.arquivo.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProcessadorDeArquivo {
	
	// escrever um vetor de numeros em arquivo
	public int escreverVetorEmArquivo(int v[], 
			String nomeArquivo) throws IOException{
		int resultado = -1; // sem sucesso
		
		File f = new File(nomeArquivo);
		// se o arquivo nao existir -> criar
		if (!f.exists()) f.createNewFile();
		// 1) Criar um escritor de arquivo
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);				
		// 2) Escrever o tamanho do vetor
		dos.writeInt(v.length);
		// 3) Para cada número no vetor
		for (int i = 0; i < v.length; i++){
		// 3.1) escrever o número no arquivo
			dos.writeInt(v[i]);
		}
		// 4) Encerrar o escritor
		dos.close();
		// 5) Informar detalhes do arquivo (metadados)
		System.out.println("Arquivo escrito com sucesso: " + 
				f.length() + " bytes.");
		System.out.println("Caminho: " + f.getAbsolutePath());
		// 6) Retornar a quantidade de números escrita
		resultado = v.length; 
		return resultado;
	}
	
	
	// ler de um arquivo um vetor de numeros
	public int [] lerVetorDeArquivo(String nomeArquivo) throws IOException{
		int v[] = null; int tam;
		File f = new File(nomeArquivo);
		// se o arquivo nao existir -> exibir erro e sair
		if (!f.exists()){
			System.out.println("ERRO: o arquivo não existe!");
			return null;
		}
		// 1) criar o leitor de arquivo
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		// 2) ler o tamanho do vetor
		tam = dis.readInt(); 
		// 3) declarar o vetor de leitura
		v = new int[tam];
		// 4) para cada numero no arquivo
		for (int i = 0; i < tam; i++){
		// 4.1) ler do arquivo e armazenar no vetor
		  v[i] = dis.readInt();
		}
		// 5) fechar o arquivo
		dis.close();
		// 6) exibir detalhes de leitura do arquivo
		System.out.println("Arquivo lido com sucesso: " + 
				f.getAbsolutePath());
		System.out.println("Números lidos do arquivo: " + tam);
		// 7) retornar o vetor lido do arquivo
		return v;	
		
	}

}
