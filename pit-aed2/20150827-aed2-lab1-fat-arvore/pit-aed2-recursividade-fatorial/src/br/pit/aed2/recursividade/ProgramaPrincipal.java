package br.pit.aed2.recursividade;

import javax.swing.JOptionPane;

public class ProgramaPrincipal {

	// funcao recursiva do fatorial
	static long fatorial(int n){
		// caso base: encerrar a recursao
		if (n == 1){
			return 1;
		}
		// passo recursivo: empilha um tamanho menor
		// do problema
		long k = n * fatorial(n-1);
		System.out.println(k); // sysout crtl+space
		return k;
	}
	
	public static void main(String[] args) {
		// problema
		// entrada: número inteiro positivo informado 
		//          pelo usuario (N)
		// saida: informar o fatorial de N
		
		// Solucao
		// 1) Solicitar do usuario um numero inteiro positivo
		String entrada = 
			JOptionPane.showInputDialog(
		        null, "Digite um numero inteiro positivo:", 
		        "Fatorial", JOptionPane.INFORMATION_MESSAGE
		    );
		int n = Integer.parseInt(entrada); // converter para int
		// 2) Ler o numero digitado
		// 3) Se o numero informado for menor ou igual a zero
		if (n <= 0){
		// 3.1) informar ao usuario uma mensagem de erro
			String msg = "ERRO: valor inválido: <=0";
			JOptionPane.showMessageDialog(null,
					msg);
			System.out.println(msg);
		// 3.2) encerrar o programa
			System.exit(1);
		}// 4) Senao
		// 4.1) calcular o fatorial de N
		long r = fatorial(n);
		// 4.2) exibir o resultado
		JOptionPane.showMessageDialog(null, "O fatorial de " +
		  n + " é: " + r);
	}

}
