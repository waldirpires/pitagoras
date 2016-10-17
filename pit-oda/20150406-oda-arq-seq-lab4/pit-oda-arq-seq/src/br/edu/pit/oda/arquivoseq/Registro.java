package br.edu.pit.oda.arquivoseq;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Registro {

	// Implementar os seguintes campos:
	// matricula
	// nome
	// cidade
	// estado
	// salario
	String id;
	List<String> campos;
	
	// construtor padrão
	public Registro(String campos){
		this.campos = new ArrayList<>();		
		for (String s: campos.split(";")){
			this.campos.add(s);
		}
		this.id = this.campos.get(0);
	}
	
	@Override
	public String toString() {		
		return this.campos.toString();
	}

	public boolean equals(Registro arg0) {
		return this.toString().equals(
				arg0.toString());
	}	
	
}
