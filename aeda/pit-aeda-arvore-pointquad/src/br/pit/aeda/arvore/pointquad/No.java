package br.pit.aeda.arvore.pointquad;

public class No
{
  public Ponto p;
  public String k;
  public No(Ponto p, String k)
  {
    this.p = p;
    this.k = k;
  }
  public No(int x, int y, String k)
  {
    this.p = new Ponto(x, y);
    this.k = k;
  }
  public String toString()
  {
    return String.format("%s-%s", k, p);
  }
}