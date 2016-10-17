package br.edu.pitagoras.oda.arquivo;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class TesteProgramaExercicio1 {

	@Test
	public void testArquivoNaoExiste() {
		
		// caso de teste 1: arquivo nao existe
		char c  = 'a';
		String nomeArquivo = "blah.txt";
		ProgramaExercicio1 ex1 = new ProgramaExercicio1();
		try {
			ex1.contarCharEmArquivo(c, nomeArquivo);
			fail("Erro nao ocorreu");
		} catch (FileNotFoundException e) {
			System.out.println("Erro esperado");
		} catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} 
	}
	
	@Test
	public void testArquivoVazio(){
		
	}

	@Test
	public void testArquivoComDados(){
		
	}
}
