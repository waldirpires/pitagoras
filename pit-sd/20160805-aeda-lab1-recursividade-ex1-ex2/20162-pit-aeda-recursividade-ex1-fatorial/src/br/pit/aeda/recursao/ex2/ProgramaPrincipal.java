package br.pit.aeda.recursao.ex2;

public class ProgramaPrincipal {

	static int FibIterativo(int n) {
		int f = 0;
		int f0 = 0; // caso base
		int f1 = 1; // caso base
		long time = System.currentTimeMillis();
		// laço de repetição
		for (int i = 1; i < n; i++) {
			f = f1 + f0; // calculo do numero da série
			//System.out.println(i + " -> " + f + "=" + f1 + "+" + f0);
			f0 = f1;
			f1 = f;
		}
		time = System.currentTimeMillis() - time;
		System.out.println("Time Iterativo: " + time + " ms");
		return f;
	}

	static int FibRecursivo(int n){
		// caso base
		if (n <= 1){return n;}
		// passo recursivo
		int f = FibRecursivo(n-1) + FibRecursivo(n-2);
		//System.out.println(f);
		return f;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 42;
		long time = System.currentTimeMillis();
		int r = FibRecursivo(n);
		time = System.currentTimeMillis() - time;
		System.out.println("Time Recursivo: " + time + " ms");
				//FibIterativo(n);
		System.out.println("Resultado recursivo: " + r);
		r = FibIterativo(n);
		//FibIterativo(n);
		System.out.println("Resultado iterativo: " + r);
	}

}
