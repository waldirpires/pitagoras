package br.pit.aeda.arvore.pointquad;

public class Ponto
{
  float x, y;

  public Ponto(float x, float y)
  {
    this.x = x;
    this.y = y;
  }
  
  public String toString()
  {
    return String.format("[%3.2f, %3.2f]", x, y);
  }

@Override
	public boolean equals(Object obj) {
		
		return obj != null && obj instanceof Ponto && ((Ponto)obj).x == this.x && ((Ponto)obj).y == this.y;
	}
  
}