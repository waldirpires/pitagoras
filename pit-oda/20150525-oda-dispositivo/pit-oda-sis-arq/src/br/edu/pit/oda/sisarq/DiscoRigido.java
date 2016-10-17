package br.edu.pit.oda.sisarq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscoRigido implements DispositivoDeArmazenamento {

	Map<String, List<String>> tabelaDeArquivos;
	Map<String, List<String>> tabelaDeAlocacaoDeArquivos; 

	public DiscoRigido(){
		tabelaDeArquivos = new HashMap<String, List<String>>();
		tabelaDeArquivos.put("/", new ArrayList<String>());
	}
	
	@Override
	public boolean criarRecurso(String pai, String nome, 
			boolean ehArquivo) {
		boolean sucesso = false;
		
		// ex: adicionar o arquivo texto.txt no diretorio /home
		
		// 1) obter o diretorio pai da tabela
		List<String> dir = tabelaDeArquivos.get(pai);
		// 2) se ele nao existir
		if (dir == null){
		// 2.1) ERRO: diretorio nao existe
			System.out.println("ERRO: diretorio nao existe!");
		} else {// 3) Senão:
		// 3.1) verificar se o recurso jah existe no diretorio
			if (dir.contains(nome)){		// 3.2) se existir:
		// 3.2.1) ERRO: recurso jah existe com este nome
				System.out.println("ERRO: arquivo jah existe no diretorio!");
			} else {// 3.3) Senao:
		// 3.3.1) adicionar o novo recurso na lista de arquivos do
				dir.add(nome);		//        diretorio
		// 3.3.2) Se o recurso for um diretorio
				if (!ehArquivo){
		// 3.3.2.1) adicionar o diretorio na tabela de arquivos
					tabelaDeArquivos.put(nome, new ArrayList<String>());
				}
			}
		}
		return sucesso;
	}

	@Override
	public void listarArquivos(String raiz) {
		// 1) obter o diretorio da tabela de arquivos 
		// a partir da raiz
		List<String> dir = tabelaDeArquivos.get(raiz);
		System.out.println("====");
		System.out.println("Diretorio: " + raiz + "(" + dir.size()+")");		
		for (String s: dir){ // 2) para cada entrada no diretorio
			// 2.1) se o recurso existir na chave da tabela de arquivos
			if (tabelaDeArquivos.containsKey(s)){
			// 2.1.1) listar os arquivos deste diretorio (recursao)
				System.out.println(raiz + ":D - " + s);
				listarArquivos(s);
			} else {// 2.2) senao
			// 2.2.1) exibir o nome do arquivo^
				System.out.println(raiz + "- " + s);
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 1) criar um dispositivo de armazenamento
		DispositivoDeArmazenamento hd = new DiscoRigido();
		
		// 2) criar o diretorio raiz
		hd.criarRecurso("/", "home", false);
		hd.criarRecurso("/", "user", false);
		hd.criarRecurso("/", "opt", false);
		hd.criarRecurso("/", "var", false);
		hd.criarRecurso("home", "teste.txt", true);
		hd.criarRecurso("opt", "test", false);
		hd.criarRecurso("test", "a.dat", true);
		// 3) criar a estrutura conforme no quadro
		// 4) listar os diretorios 
		hd.listarArquivos("/");
	}

}
