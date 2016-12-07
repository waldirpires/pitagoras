package br.pit.acca.lab4.grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No {

	public int valor;	
	public List<Aresta> arestas = new ArrayList<>();
	
	public void adicionarAresta(Aresta a){
		if (arestas.contains(a)){
			System.out.println("ERRO: aresta já existe para no nó " + this);
			return;
		}
		arestas.add(a);
		System.out.println("INFO: aresta " + a + " adicionada ao nó " + this.valor + " com sucesso.");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return valor + ": ["+Arrays.toString(arestas.toArray()) + "]";
	}
	
	public int obterGrauVertice(){
		return arestas.size();
	}
}
