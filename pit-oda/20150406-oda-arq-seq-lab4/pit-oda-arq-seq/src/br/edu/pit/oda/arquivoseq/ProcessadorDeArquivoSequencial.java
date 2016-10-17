package br.edu.pit.oda.arquivoseq;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorDeArquivoSequencial {

	String nomeDoArquivo;
	List<Registro> registros;
	
	public ProcessadorDeArquivoSequencial(
			String nomeDoArquivo){
		this.nomeDoArquivo = nomeDoArquivo;
		this.registros = new ArrayList<Registro>();
		try {
			carregarDadosDoArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void carregarDadosDoArquivo() 
			throws IOException {
		// abrir um fluxo de bytes de leitura
		InputStream is = new FileInputStream(
				this.nomeDoArquivo);
		// abrir um fluxo de caracteres de leitura
		InputStreamReader isr = new 
				InputStreamReader(is);
		// abrir um fluxo de cadeia de chars de
		// de leitura
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		// para cada linha lida do arquivo
		while (line != null){
		//   criar um novo registro com a linha
			Registro r = new Registro(line);
		//   adicionar no novo registro na lista
		//     de registros
			this.registros.add(r);
			line = br.readLine(); //lendo a prox.linha
		}
		// fechar o fluxo de leitura
		br.close();		
	}
	
	public List<Registro> listar(){
		// para cada registro no buffer
		for (Registro r: this.registros){
		//   exibir o registro na tela
			System.out.println(r);
		}
		System.out.println(this.registros.size() + 
				" registros encontrados.");
		return this.registros;		
	}
	
	
	
	
	
	
}
