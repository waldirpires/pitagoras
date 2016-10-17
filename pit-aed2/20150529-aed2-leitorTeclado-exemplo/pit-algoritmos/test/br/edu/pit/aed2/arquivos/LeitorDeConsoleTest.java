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

import org.junit.Test;

public class LeitorDeConsoleTest {

	@Test
	public void testLerPalavraDoTeclado(){
		LeitorDeConsole lc = new LeitorDeConsole();
		String s = lc.lerStringDoTeclado("Digite uma palavra:");
		System.out.println(s);
	}

	@Test
	public void testLerFraseDoTeclado(){
		LeitorDeConsole lc = new LeitorDeConsole();
		String s = lc.lerFraseDoTeclado("Digite uma frase:");
		System.out.println(s);
	}
}
