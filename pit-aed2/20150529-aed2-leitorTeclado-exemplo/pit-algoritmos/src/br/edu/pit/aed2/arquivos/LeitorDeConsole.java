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

import java.util.Scanner;

public class LeitorDeConsole {

	public String lerStringDoTeclado(String msg){
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();		
	}
	
	public String lerFraseDoTeclado(String msg){
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();		
	}
}
