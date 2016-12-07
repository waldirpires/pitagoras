package br.pit.aeda.lab5.compressao.de;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		String m = JOptionPane.showInputDialog("Digite uma frase:",
				null);
		System.out.println(m);
		
		int a[] = new int[m.length()];
		for (int i = 0; i < m.length(); i++){
			a[i] = m.charAt(i);
		}
		
		int[] encode = CodificadorDelta.encode(a);
		
		JOptionPane.showMessageDialog(null,
				"Resultado: \n" + 
				Arrays.toString(encode));		

		// realizando a decompressão dos dados
		int[] decode = CodificadorDelta.decode(encode);
		char b[] = new char[decode.length];
		for (int i = 0; i < decode.length; i++){
			b[i] = (char)decode[i];
		}
		String frase = new String(b);
		
		JOptionPane.showMessageDialog(null,	"Resultado decompressão: \n" + 
				frase);			
	}
}

