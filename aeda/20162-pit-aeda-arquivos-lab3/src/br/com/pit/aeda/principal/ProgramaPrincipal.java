//**********************************************************************
// Copyright (c) 2016 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package br.com.pit.aeda.principal;

import java.io.IOException;

import br.com.pit.aeda.arquivos.ArranjoUtil;
import br.com.pit.aeda.arquivos.EscritorDeArquivo;
import br.com.pit.aeda.arquivos.GeradorNumeros;
import br.com.pit.aeda.arquivos.LeitorDeArquivo;

public class ProgramaPrincipal
{

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        int quant = 1000;
        int min = 100;
        int max = 200;
        GeradorNumeros gn = new GeradorNumeros();
        System.out.println("Gerando números pseudo-aleatórios: " + quant);
        int[] a = gn.gerarNumeros(min, max, quant, true);
        ArranjoUtil.imprimirVetor(a);

        String nome = "dados.dat";
        EscritorDeArquivo eda = new EscritorDeArquivo();
        eda.escreverEmArquivo(a, nome);

        LeitorDeArquivo lda = new LeitorDeArquivo();
        a = lda.lerDeArquivo(nome);
        ArranjoUtil.imprimirVetor(a);

    }

}
