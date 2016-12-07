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
package br.pit.acca.lab4.grafos2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.pit.acca.lab4.grafos.Aresta;
import br.pit.acca.lab4.grafos.Grafo;
import br.pit.acca.lab4.grafos.No;

public class GrafoImpl2 implements Grafo
{

    public Map<String, List<Aresta>> vertices = new HashMap<String, List<Aresta>>();

    @Override
    public void adicionarNo(No no)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void adicionarAresta(Aresta a)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public No[] obterVertices()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int obterNumVertices()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Aresta[] obterArestas()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int obterNumArestas()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int obterGrauVertice(int v)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public No obterNo(int v)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public No[] obterVerticesAdjacentes(int v)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
