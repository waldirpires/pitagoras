package br.edu.pit.oda.sisarq;

public interface DispositivoDeArmazenamento {

	public boolean criarRecurso(String pai, String nome, 
			boolean ehArquivo);
	
	public void listarArquivos(String raiz);
}
