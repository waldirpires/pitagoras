package br.pit.aeda.lab3.arvoredigital;

import java.util.HashMap;
import java.util.Map;

public class No {

	char caractere;
	Map<Character, No> subNos;
	boolean ehTerminal;
	boolean ehRaiz;
	int contPalavras = 0;
	
	public No(char caractere)
	{
		this.caractere = caractere;
		this.subNos = new HashMap<Character, No>();
		
	}
	
	@Override
	public String toString() {
		return caractere + (ehRaiz?"["+contPalavras+"]":"") + "->" + subNos.values().toString().replace('[', ' ').replace(']', ' '); 
	}
	
	public boolean inserirPalavra(String palavra)
	{
		if (possuiPalavra(palavra))
		{
			System.out.println("Palavra já existe");
			return false;
		}
		if (palavra.length() == 0){
			this.ehTerminal = true;
			return true;
		}
		char letra = palavra.charAt(0);
		if (palavra.length() > 1)
			palavra = palavra.substring(1);
		else
			palavra = "";
		No no = subNos.get(letra);
		if (no == null)
		{
			no = new No(letra);
			subNos.put(letra, no);
		}
		boolean resposta = no.inserirPalavra(palavra);
		if (ehRaiz)
		{
			contPalavras++;
		}
		return resposta;
	}

	public boolean possuiPalavra(String palavra) {
		if (this.ehTerminal && palavra.length() == 0)
		{
			return true;
		}
		if (palavra.length() == 0){
			return false;
		}
		char letra = palavra.charAt(0);
		if (palavra.length() > 1)
			palavra = palavra.substring(1);
		else
			palavra = "";
		No no = subNos.get(letra);
		if (no == null)
		{
			return false;
		}
		boolean resposta = no.possuiPalavra(palavra);
		return resposta;
	}
		

	public boolean possuiPrefixo(String palavra) {
		if (palavra.length() == 0)
		{
			return true;
		}
		char letra = palavra.charAt(0);
		if (palavra.length() > 1)
			palavra = palavra.substring(1);
		else
			palavra = "";
		No no = subNos.get(letra);
		if (no == null)
		{
			return false;
		}
		boolean resposta = no.possuiPrefixo(palavra);
		return resposta;
	}
	
}
