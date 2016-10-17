package br.pit.aed2.arquivos.util;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import br.pit.aed2.arquivo.util.ProcessadorDeArquivo;

public class TesteProcessadorDeArquivo {
	// http://pastebin.com/Y19HFqAE
	@Test
	public void testEscreverArquivo(){
		// definir parametros do teste
		int v[] = {2, 3};
		String nomeArquivo = "teste.dat";
		File f = new File(nomeArquivo);
		// criar o processador de arquivo
		ProcessadorDeArquivo pda = new ProcessadorDeArquivo();
		// executar a criacao do arquivo
		try {
			pda.escreverVetorEmArquivo(v, nomeArquivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// verificar se o arquivo foi criado com sucesso
		Assert.assertTrue(f.exists());
		Assert.assertTrue(f.length() == (v.length+1)*4);
		// excluir o arquivo criado
		f.delete();
	}
	
	@Test
	public void testLerArquivoEmVetor(){
		// definir parametros de teste
		int v[] = {3, 4, 1}; int []v2 = null, tam;
		String nomeArquivo = "teste2.dat";
		File f = new File(nomeArquivo);
		// 1) criar um arquivo com dados
		ProcessadorDeArquivo pda = new ProcessadorDeArquivo();
		try {
			pda.escreverVetorEmArquivo(v, nomeArquivo);
			// 2) utilizar o processador para leitura
			v2 = pda.lerVetorDeArquivo(nomeArquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 3) verificar se o vetor foi lido com sucesso
		Assert.assertEquals(v2.length, v.length);
		Assert.assertArrayEquals(v, v2);
		// 4) excluir o arquivo criado
		f.delete();
	}
	
	
	
	
}
