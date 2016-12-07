package br.pit.acca.lab4.grafos;

public class ProgramaPrincipal
{

    public static void main(String[] args)
    {

        Grafo grafo = new GrafoImpl();
        grafo.adicionarVertice("A");
        grafo.adicionarVertice("B");
        grafo.adicionarArestaAoVertice("A", "a1", "B", 0);

        System.out.println(grafo);
    }

}
