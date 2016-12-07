//**********************************************************************
//
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package br.pit.acca.lab4.grafos;

import java.util.Set;

public interface Grafo
{

    void adicionarVertice(String n);

    Set<String> obterVertices();

    int obterNumVertices();

    Set<Aresta> obterArestas();

    int obterNumArestas();

    int obterGrauVertice(String n);

    String obterVertice(String n);

    Set<String> obterVerticesAdjacentes(String n);

    void adicionarArestaAoVertice(String vertice, String nome, String n2, int peso);

}
