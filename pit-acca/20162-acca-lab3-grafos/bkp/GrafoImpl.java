package br.pit.acca.lab4.grafos;

import java.util.ArrayList;
import java.util.List;

public class GrafoImpl implements Grafo
{

    /**
     * lista de n�s do grafo
     */
    public List<No> nos = new ArrayList<>();
    /**
     * lista de arestas do grafo
     */
    public List<Aresta> arestas = new ArrayList<>();

    @Override
    public void adicionarNo(No no)
    {
        if (nos.contains(no))
        {
            System.out.println("ERRO: n� j� existe!");
            return;
        }
        nos.add(no);
        System.out.println("INFO: N� + " + no + " adicionado ao grafo com sucesso.");
    }

    @Override
    public void adicionarAresta(Aresta a)
    {
        if (arestas.contains(a))
        {
            System.out.println("ERRO: aresta j� existe!");
            return;
        }
        arestas.add(a);
        System.out.println("INFO: Aresta + " + a + " adicionada ao grafo com sucesso.");
    }

    @Override
    public No[] obterVertices()
    {
        No[] vetor = new No[nos.size()];
        for (int i = 0; i < nos.size(); i++)
        {
            vetor[i] = nos.get(i);
        }
        return vetor;
    }

    @Override
    public int obterNumVertices()
    {
        return nos.size();
    }

    @Override
    public Aresta[] obterArestas()
    {
        Aresta[] vetor = new Aresta[arestas.size()];
        for (int i = 0; i < nos.size(); i++)
        {
            vetor[i] = arestas.get(i);
        }
        return vetor;
    }

    @Override
    public int obterNumArestas()
    {
        return arestas.size();
    }

    @Override
    public int obterGrauVertice(int v)
    {
        No n = obterNo(v);
        return n.obterGrauVertice();
    }

    @Override
    public No obterNo(int v)
    {
        for (No n : nos)
        {
            if (n.valor == v)
            {
                return n;
            }
        }
        return null;
    }

    @Override
    public No[] obterVerticesAdjacentes(int v)
    {
        return null;
    }
}
