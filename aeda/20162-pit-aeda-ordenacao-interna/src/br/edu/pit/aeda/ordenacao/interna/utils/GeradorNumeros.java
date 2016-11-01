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
package br.edu.pit.aeda.ordenacao.interna.utils;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

import br.edu.pit.aeda.ordenacao.interna.io.EscritorDeArquivo;

public class GeradorNumeros
{

  public static void gerarNumeros(String nomeArquivo, int tam, boolean gerarSeArquivoExistir) throws IOException, NoSuchAlgorithmException{
    int a[] = GeradorNumeros.gerarNumeros(0, tam, tam, true);
    if (!new File(nomeArquivo).exists() || (new File(nomeArquivo).exists() && gerarSeArquivoExistir)){
      EscritorDeArquivo.escreverEmArquivo(a, "dados-"+tam);
      System.out.println("Antes da ordenação: " + tam);
      System.out.println(SegurancaUtil.gerarHashMd5(Arrays.toString(a)));
      System.out.println();    
    } else {
      System.out.println("Arquivo nao gerado");
    }
  }
  

  
    public static int[] gerarNumeros(int min, int max, int quant, boolean positivo)
    {
        int[] a = new int[quant];

        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < quant; i++)
        {
            int num = rnd.nextInt(max - min) + min;
            if (positivo)
            {
                num = Math.abs(num);
            }
            a[i] = num;
        }

        return a;
    }
}
