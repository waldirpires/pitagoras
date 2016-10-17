package br.edu.pit.aed2.arvoredigital;

public class ArvoreDigital {

	// criando a raiz da arvore
	static NoArvore criarArvore(){
		return new NoArvore('\0', false);
	}
	
	// insere um nova palavra na arvore
	public void inserirNo(NoArvore pai, String c){
		// 1) converter a palavra em cadeia de caracteres
		// 2) para cada letra na palavra
		// 2.1) se o no pai nao possuir o caractere
		// 2.1.1) criar um novo nó filho com o caractere
		// 2.1.2) adicionar o novo no dentro do nó pai
		// 2.1.3) definir o novo nó como sendo o pai
		// 2.2) Senao (o nó filho existe)
		// 2.2.1) definir o nó filho como o nó pai
		// 3) definir o ultimo nó criado como terminal
		
		char t[] = c.toCharArray(); 
		for (int i = 0; i < t.length; i++){
			NoArvore filho = pai.links.get(t[i]);
			if (filho == null){
				filho = new NoArvore(t[i], false);
				pai.links.put(t[i], filho);
				pai = filho;
			} else {
				pai = filho;
			}			
		}
		pai.terminal = true;		
	}
	
	public boolean buscar(NoArvore pai, String palavra){
		boolean resultado = false;
		
		// 1) converter a palavra em cadeia de caracteres
		// 2) para cada letra existente na palavra
		// 2.1) se o nó pai possui o caractere existente
		// 2.1.1) atualizar o pai para o filho 
		// 2.2) senão
		// 2.2.1) a palavra não existe
		// 3) se o ultimo nó pai for terminal
		// 3.1) encontrado!		
		
		char []t = palavra.toCharArray();
		NoArvore filho = null;
		for (int i = 0; i < t.length; i++){
			filho = pai.links.get(t[i]);
			if (filho != null){
				pai = filho;
			} else {
				break;
			}
		}
		if (filho != null && filho.terminal){
			resultado = true;
		}
		return resultado;
	}
	
	public void imprimirArvore(NoArvore pai, String prefixo){
		
		// 1) se o nó pai for nulo: sair
		// 2) imprimir o caractere do no
		// 3) para cada nó filho existente no pai
		// 3.1) imprimir a sub-árvore do nó filho recursivamente
		
		if (pai == null){
			return;
		}
		prefixo = prefixo + pai.letra;
		System.out.println(prefixo + (pai.terminal?"*":""));
		for (NoArvore no: pai.links.values()){
			imprimirArvore(no, prefixo);
		}
		
	}
	
}
