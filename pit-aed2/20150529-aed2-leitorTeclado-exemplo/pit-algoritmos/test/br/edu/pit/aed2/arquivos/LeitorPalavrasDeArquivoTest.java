/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2015
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package br.edu.pit.aed2.arquivos;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

public class LeitorPalavrasDeArquivoTest {

	@Test
	public void testLerPalavrasDeArquivo() throws IOException{
		
		String frase = "The book is on the table";
		
		String nomeArquivo = "test.txt";
		File f = new File(nomeArquivo);
		FileUtils.writeStringToFile(f, frase);
		
		LeitorPalavrasDeArquivo lpa = new LeitorPalavrasDeArquivo();
		List<String> lista = lpa.lerPalavrasDeArquivo(nomeArquivo);
		Assert.assertEquals(6, lista.size());
		System.out.println(lista);
		f.delete();
	}
}
