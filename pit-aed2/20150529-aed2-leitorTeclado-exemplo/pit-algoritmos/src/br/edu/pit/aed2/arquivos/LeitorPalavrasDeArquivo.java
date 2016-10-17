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
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorPalavrasDeArquivo {

	public List<String> lerPalavrasDeArquivo(String nomeArquivo) throws FileNotFoundException{
		File tekstFil = new File (nomeArquivo);
		Scanner lesFil = new Scanner(tekstFil);
		int i=0;
		int totalOrd=0;
		int antUnikeOrd=0;

		ArrayList<String> lista = new ArrayList<String>();
		while (lesFil.hasNext()){
		  lista.add(lesFil.next());
		}		
		return lista;
	}
}
