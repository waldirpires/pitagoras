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
package br.com.pit.aeda.arquivos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscritorDeArquivo
{

    public boolean escreverEmArquivo(int[] a, String nome) throws IOException
    {
        boolean sucesso = false;

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(nome));

        // escrevendo o tamanho do vetor no arquivo
        dos.writeInt(a.length);
        for (int i = 0; i < a.length; i++)
        {
            dos.writeInt(a[i]);
        }

        dos.close();
        File arquivo = new File(nome);
        long tamanho = arquivo.length();
        System.out.println("\nArquivo escrito: " + tamanho + " bytes");
        System.out.println("Local: " + arquivo.getAbsolutePath());
        sucesso = true;
        return sucesso;
    }
}
