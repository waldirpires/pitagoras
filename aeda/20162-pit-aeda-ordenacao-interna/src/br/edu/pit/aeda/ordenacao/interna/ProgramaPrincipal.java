package br.edu.pit.aeda.ordenacao.interna;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import br.edu.pit.aeda.ordenacao.interna.io.LeitorDeArquivo;
import br.edu.pit.aeda.ordenacao.interna.utils.GeradorNumeros;

public class ProgramaPrincipal {

  public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
    
    // prerrequisitos
    // tamanho do vetor
    int tam = 100;
    // nome do arquivo para armazenamento do vetor
    String nomeArquivo = "dados-"+tam + ".dat";
    // gerando o vetor de tamanho n no arquivo
    GeradorNumeros.gerarNumeros(nomeArquivo, tam, false);
    // lendo o arquivo gerado acima e armazenando-o em um vetor
    int b[] = LeitorDeArquivo.lerDeArquivo("dados-"+tam); 
    
  }

}
