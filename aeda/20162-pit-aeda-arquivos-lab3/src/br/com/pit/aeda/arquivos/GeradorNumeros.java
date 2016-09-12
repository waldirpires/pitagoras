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

import java.util.Random;

public class GeradorNumeros
{

    public int[] gerarNumeros(int min, int max, int quant, boolean positivo)
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
