package br.pit.aeda.lab5.compressao.de;

public class CodificadorDelta {

	public static int [] decode (int a[]){
	    int delta = -1;
		int b[] = new int[a.length];
		b[0] = a[0];
	    for (int i = 1; i < a.length; i++) {
		  delta = a[i];
	      b[i] = b[i-1] + delta;
	    }
		return b;
	 }
	
	public static void imprimir(int a[]){
	    System.out.println("Tamanho: " + a.length);
	    for (int i = 0; i < a.length; i++){
	      System.out.print(a[i]+ "  ");
	    } 
		System.out.println();
	  }  

	  
	  public static int[] encode(int a[])  {

	    int delta = -1; 
		int b[] = new int[a.length]; 
		b[0] = a[0];
	    for (int i =  1; i < a.length; i++){
	      delta = a[i] - a[i-1]; b[i] = delta;
	    } 
		return b;
	  } 	
	  
	  public static int obterMaiorValor(int a[]){

		  return -1;
		  
	  }
	  
	  public static int obterNumeroDeBits(int valor){
		  return Integer.toBinaryString(valor).length();
	  }
	
	  
}
