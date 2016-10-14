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

public class ArranjoUtil
{

    public static void imprimirVetor(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + "  ");
            if (i > 0 && i % 15 == 0)
            {
                System.out.println();
            }
        }
    }
    
    public static boolean estahOrdenado(int a[]){
      for (int i = 1; i < a.length; i++){
        if (a[i-1] > a[i])
        {
          return false;
        }
      }      
      return true;
    }
}
