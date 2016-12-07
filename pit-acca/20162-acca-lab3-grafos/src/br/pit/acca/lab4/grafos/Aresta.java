package br.pit.acca.lab4.grafos;

public class Aresta
{

    public String nome;
    public String lado1;
    public String lado2;
    public int peso;

    public Aresta(String nome, String lado1, String lado2, int peso)
    {
        super();
        this.nome = nome;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.peso = peso;
    }

    @Override
    public String toString()
    {
        // TODO Auto-generated method stub
        return String.format("%s: %d - %d [%d]", nome, lado1, lado2, peso);
    }

    @Override
    public int hashCode()
    {
        return toString().hashCode();
    }
}
