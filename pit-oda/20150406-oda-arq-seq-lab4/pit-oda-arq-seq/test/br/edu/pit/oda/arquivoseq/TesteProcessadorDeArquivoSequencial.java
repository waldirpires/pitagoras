package br.edu.pit.oda.arquivoseq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TesteProcessadorDeArquivoSequencial {

	// entrada: arquivo vazio
	// saida: zero registros na listagem
	@Test
	public void testListarVazio() throws IOException {
		// 1) criar o arquivo de dados vazio
		String nomeArquivo = "dados.txt";
		new File(nomeArquivo).createNewFile();		
		// 2) criar o processador de arquivos
		//    utilizando o arquivo criado acima
		ProcessadorDeArquivoSequencial pas = 
				new ProcessadorDeArquivoSequencial(
						nomeArquivo);
		// 3) solicitar a listagem dos registros
		//    do processador
		List<Registro> lista = pas.listar();
		// 4) verificar tamanho zero dos registros
		Assert.assertTrue(lista.isEmpty());
		// 5) excluir o arquivo criado
		new File(nomeArquivo).delete();
	}
	
	// entrada: arquivo de dados com registro
	// saida: um registro existente
	@Test
	public void testListarArquivoComRegistro() throws IOException
	{
		// 1) criar um arquivo de dados com 1 registro
		String nomeArquivo = "dados.txt";
		new File(nomeArquivo).createNewFile();
		FileOutputStream fos = 
				new FileOutputStream(nomeArquivo);
		fos.write(
			"001;José das Couves;BH;MG;2500\n".getBytes());
		fos.close();
		// 2) criar o processador de arq. seq.
		ProcessadorDeArquivoSequencial pas = 
			new ProcessadorDeArquivoSequencial(nomeArquivo);
		// 3) listar os registros do arquivo
		List<Registro> lista = pas.listar();
		// 4) verificar quantidade de registros
		Assert.assertEquals(1, lista.size());
		// 5) excluir o arquivo criado
		new File(nomeArquivo).delete();
		
	}
	

}
