package br.pit.aeda.recursao.ex1;

import java.util.Scanner;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
		// Algoritmo FATORIAL
		// Entrada: um n�mero inteiro digitado pelo usu�rio (N)
		// Sa�da: calcular o fatorial de N
		
		// VARI�VEIS
		int n, f = 1;
		System.out.println("Ben-vindo ao Programa FATORIAL\n");
		System.out.println("Digite um n�mero inteiro");
		// 1) Ler o numero do usu�rio (N)
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		// 2) Validar a entrada do usu�rio (positivo)
		if (n < 0){
			System.out.println("ERRO: valor fora do intervalo permitido!");
			System.exit(1); // encerrar o programa
		}
		// 3) Para cada n�mero de 2 at� N
		//f = calcularFatorialIterativo(n);
		f = calcularFatorialRecursivo(n);
		// 4) exibir o resultado do fatorial
		System.out.println("Resultado do fatorial de " 
		  + n + " = " + f);
		sc.close();
		
		
	}

	static int calcularFatorialRecursivo(int n){
		System.out.println("Calculando o fatorial de " + n);
		// caso base
		if (n == 1){ return 1;}
		// passo recursivo
		return n * calcularFatorialRecursivo(n-1);
	}
	
	private static int calcularFatorialIterativo(int n) {
		int f = 1;
		for (int i = 2; i <=n; i++){
			// 3.1) Acumular a multiplica��o do n�mero corrente
			f = f * i;
			System.out.println("F = " + f);
		}
		return f;
	}

}
