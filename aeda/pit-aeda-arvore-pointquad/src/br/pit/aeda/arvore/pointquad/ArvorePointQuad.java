package br.pit.aeda.arvore.pointquad;

public class ArvorePointQuad
{
  Ponto tl, br; // top-left, bottom-right
  No n;
  ArvorePointQuad sw, se, nw, ne;
  
  public ArvorePointQuad(String s)
  {
    this(s, new Ponto(0,0), new Ponto(0,0));
  }
  public ArvorePointQuad(String s, int x1, int y1, int x2, int y2)
  {
    this(s, new Ponto(x1,y1), new Ponto(x2,y2));
  }
  public ArvorePointQuad(String s, Ponto tl, Ponto br)
  {
    System.out.println(s + ": Criando nova árvore quad em: " + tl + " x " + br);
    this.tl = tl;
    this.br = br;
    n = null;    sw = null;    se = null;    nw = null;    ne = null;
  }
  
  public void inserir(No no)
  {
    if (no == null) return;
    
    
    // se o no estiver fora do espaco da arvore
    System.out.println("Inserindo: " + no.toString() + " em " + this.toString());
    if (!noEspaco(no.p)){
      System.out.println("No fora do espaço da árvore quad");
      return;
    }
    if (this.n == null)
    {
    	this.n = no; 
    	nw = new ArvorePointQuad("NW", new Ponto(tl.x, tl.y), new Ponto(no.p.x, no.p.y));
    	ne = new ArvorePointQuad("NE",new Ponto(no.p.x, tl.y), new Ponto(br.x, no.p.y));
    	se = new ArvorePointQuad("SE", new Ponto(no.p.x, n.p.y), new Ponto(br.x, br.y));
    	sw = new ArvorePointQuad("SW", new Ponto(tl.x, no.p.y), new Ponto(no.p.x, br.y));
    	return;
    }
    // se não houver unidades de medida disponíveis para receber o novo no
    if (Math.abs(tl.x - br.x) <= 1 && Math.abs(tl.y - br.y) <=1){
      if (n == null) this.n = no;
      return;
    }
    
    if (no.p.x > n.p.x && no.p.y > n.p.y) //ne
    {
    	se.inserir(no);
    }
    else if (no.p.x > n.p.x && no.p.y < n.p.y) //se
    {
    	ne.inserir(no);
    }
    else if (no.p.x < n.p.x && no.p.y < n.p.y) // sw
    {
    	nw.inserir(no);
    }
    else if (no.p.x < n.p.x && no.p.y > n.p.y) //nw
    {
    	sw.inserir(no);
    }
    else if (no.p.equals(n.p))
    {
    	System.out.println("ERRO: nó já existe");
    	return;
    }
        
  }
  
  public No pesquisar(Ponto p)
  {
	    if (p == null) return null;
	    
	    
	    // se o no estiver fora do espaco da arvore
	    System.out.println("Pesquisando: " + p.toString() + " em " + this.toString());
	    if (!noEspaco(p)){
	      System.out.println("No fora do espaço da árvore quad");
	      return null;
	    }
	    if (this.n == null)
	    {
	    	return null;
	    }
	    	    
	    if (p.x > n.p.x && p.y > n.p.y) //ne
	    {
	    	return se.pesquisar(p);
	    }
	    else if (p.x > n.p.x && p.y < n.p.y) //se
	    {
	    	return ne.pesquisar(p);
	    }
	    else if (p.x < n.p.x && p.y < n.p.y) // sw
	    {
	    	return nw.pesquisar(p);
	    }
	    else if (p.x < n.p.x && p.y > n.p.y) //nw
	    {
	    	return sw.pesquisar(p);
	    }
	    else if (p.equals(n.p))
	    {
	    	System.out.println("Encontrado!");
	    	return n;
	    }
	    else return null;
  }
  
  public boolean noEspaco(Ponto p)
  {
    return p.x >= tl.x && p.y >= tl.y && 
       p.x <= br.x && p.y <= br.y;
  }
  
  public String toString()
  {
    String raiz = n!=null?"Raiz: " + n.toString() + "\n":"";
    return 
    "Árvore PointQuad: " + tl + ", " + br + "\n" + 
    raiz;// + 
    //"NE: " + ne!=null?ne.toString():"null" +"\n" +
    //"NW: " + nw!=null?nw.toString():"null" +"\n" +
    //"SE: " + se!=null?se.toString():"null" +"\n" +
    //"SW: " + sw!=null?sw.toString():"null";
  }
}
