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
package br.edu.pit.aeda.ordenacao.interna.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LeitorDeArquivo
{

    public static int[] lerDeArquivo(String nome) throws IOException
    {
        int[] a = null;
        System.out.println("Lendo dados de arquivo: " + nome);
        DataInputStream dis = new DataInputStream(new FileInputStream(nome));

        int tamanho = dis.readInt();
        System.out.println("Tamanho: " + tamanho);
        a = new int[tamanho];
        for (int i = 0; i < tamanho; i++)
        {
            a[i] = dis.readInt();
        }
        dis.close();
        System.out.println("\nDados lidos: " + tamanho * 4 + " bytes");
        return a;
    }
}
