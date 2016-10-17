package br.pit.aed2.arvoredigital;

import java.util.HashMap;
import java.util.Map;

public class No {
  
  char caractere; // o caractere do no  
  Map<Character, No> subnos; // o conjunto de subnos  
  boolean ehTerminal = false;
  boolean ehRaiz = false;
  int contPalavras = 0;
  
  // construtor: criar o objeto
  public No(char caractere){ // parametro caractere
	  this.caractere = caractere;
	  // HashMap: tabela hash (char: No)
	  this.subnos = new HashMap<Character, No>();
  }
  
  @Override
	public String toString() {
	                     // operador ternário
	  return caractere + (ehRaiz?"["+contPalavras+"]":"")+ 
			  "->" + subnos.values().toString().
			  replace('[', ' ').replace(']', ' '); 
			  //+ " -> [" + subnos + "]";
	}
  
  // inserir palavra
  public boolean inserirPalavra(String palavra){
	  if (possuiPalavra(palavra)){
		  System.out.println("Palavra jah existe na arvore!");
		  return false;
	  }
	  if (palavra.length() == 0){ 		// se a palavra estiver vazia
		  this.ehTerminal = true;
	    return true; }					//   retornar true (palavra inserida)
	  char letra = palavra.charAt(0); 	// obter a primeira letra
	  if (palavra.length() > 1){ 	// se o tamanho do restante da palavra for > 1
	    palavra = palavra.substring(1);}//   atualizar a palavra (restante dos caracteres)
	  else { palavra = "";}			// senao deixar a palavra vazia
	  No no = subnos.get(letra); 	// obter o no a partir da letra
	  if (no == null){				// se o nó não existir
	    no = new No(letra);			//   criar um novo nó
	    subnos.put(letra, no);//   adicionar o novo nó na lista de subnos do no corrente	    
	  }	  
      boolean res = no.inserirPalavra(palavra);//   inserir o restante da palavra dentro do novo no
      if (ehRaiz){
    	  contPalavras++;
      }
      return res;
	  
  }
  
  // obter no

  // existe palavra 
  public boolean possuiPalavra(String palavra){
	  if (palavra.length() == 0){// se a palavra tiver tamanho zero (ACHOU!)
        return (this.ehTerminal);// retorna se o no eh terminal ou nao
	  }
	  char letra = palavra.charAt(0);// obter o primeiro caractere
	  if (palavra.length() > 1){// se a palavra tiver tamanho superior a 1
	    palavra = palavra.substring(1);//   remover a letra lida da palavra
	  } else { 
		  palavra = "";}// senao atualizar a palavra para vazio
	  No no = subnos.get(letra);// obter o no a partir do caractere
	  if (no == null){ return false;}// se o no nao existir retornar falso
	  else { 
		return no.possuiPalavra(palavra);}// senao verificar a palavra a partir do no encontrado
  }
  
  
}
