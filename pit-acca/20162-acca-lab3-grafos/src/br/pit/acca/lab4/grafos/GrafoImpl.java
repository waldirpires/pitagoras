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
package br.pit.acca.lab4.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GrafoImpl implements Grafo
{

    // Criando um mapa associativo de nós e conjunto de arestas
    private final Map<String, List<Aresta>> mapa = new HashMap<String, List<Aresta>>();

    @Override
    public void adicionarVertice(String n)
    {
        if (mapa.get(n) != null)
        {
            System.out.println("ERRO: o nó " + n + " já existe!");
            return;
        }
        mapa.put(n, new ArrayList<Aresta>());
    }

    @Override
    public void adicionarArestaAoVertice(String vertice, String nome, String n2, int peso)
    {
        Aresta a = new Aresta(nome, vertice, n2, peso);
        mapa.get(vertice).add(a);
        mapa.get(n2).add(a);
        System.out.println(String.format("INFO: Aresta %s adicionada aos vértices %s e %s", nome, vertice, n2));
    }

    @Override
    public Set<String> obterVertices()
    {
        return mapa.keySet();
    }

    @Override
    public int obterNumVertices()
    {
        // TODO Auto-generated method stub
        return obterVertices().size();
    }

    @Override
    public Set<Aresta> obterArestas()
    {
        // TODO Auto-generated method stub
        Set<Aresta> arestas = new HashSet<Aresta>();
        for (String s : mapa.keySet())
        {
            arestas.addAll(mapa.get(s));
        }
        return arestas;
    }

    @Override
    public int obterNumArestas()
    {
        return obterArestas().size();
    }

    @Override
    public int obterGrauVertice(String n)
    {
        return mapa.get(n).size();
    }

    @Override
    public String obterVertice(String n)
    {
        // TODO Auto-generated method stub

        return n;
    }

    @Override
    public Set<String> obterVerticesAdjacentes(String n)
    {
        List<Aresta> arestas = mapa.get(n);
        Set<String> adjacentes = new HashSet<String>();
        for (Aresta a : arestas)
        {
            adjacentes.add(a.lado1);
            adjacentes.add(a.lado2);
        }
        return adjacentes;
    }

    @Override
    public String toString()
    {
        return mapa.toString();
    }
}
