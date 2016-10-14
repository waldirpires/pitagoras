package br.edu.pit.aeda.ordenacao.interna;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import br.edu.pit.aeda.ordenacao.interna.io.EscritorDeArquivo;
import br.edu.pit.aeda.ordenacao.interna.io.LeitorDeArquivo;
import br.edu.pit.aeda.ordenacao.interna.utils.ArranjoUtil;
import br.edu.pit.aeda.ordenacao.interna.utils.GeradorNumeros;
import br.edu.pit.aeda.ordenacao.interna.utils.SegurancaUtil;
import br.edu.pit.aeda.ordenacao.interna.utils.TempoUtil;

public class ProgramaPrincipal {

  static void gerarNumeros(int tam, boolean gerarSeArquivoExistir) throws IOException, NoSuchAlgorithmException{
    int a[] = GeradorNumeros.gerarNumeros(0, tam, tam, true);
    String nomeArquivo = "dados-"+tam;
    if (!new File(nomeArquivo).exists() || (new File(nomeArquivo).exists() && gerarSeArquivoExistir)){
      EscritorDeArquivo.escreverEmArquivo(a, "dados-"+tam);
      System.out.println("Antes da ordenação: " + tam);
      System.out.println(SegurancaUtil.gerarHashMd5(Arrays.toString(a)));
      System.out.println();    
    } else {
      System.out.println("Arquivo nao gerado");
    }
  }
  
  public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
    // TODO Auto-generated method stub

    int tam = 100;
    long start = System.currentTimeMillis();
    gerarNumeros(tam, false);

    int b[] = LeitorDeArquivo.lerDeArquivo("dados-"+tam); 
        //Arrays.copyOf(a, tam);
    
    //ArranjoUtil.imprimirVetor(a);
    
    start = System.currentTimeMillis();
    OrdenacaoInterna.selecao(b);
    TempoUtil.tempo(start);
    System.out.println("Depois da ordenação por seleção: " + tam);
    System.out.println(SegurancaUtil.gerarHashMd5(Arrays.toString(b)));
    System.out.println("Ordenado: " + ArranjoUtil.estahOrdenado(b));
    System.out.println();
    
    b = LeitorDeArquivo.lerDeArquivo("dados-"+tam);
    System.out.println("Ordenado: " + ArranjoUtil.estahOrdenado(b));    
    start = System.currentTimeMillis();
    OrdenacaoInterna.merge(0, b);
    TempoUtil.tempo(start);
    System.out.println("Depois da ordenação por mergesort: " + tam);
    System.out.println(SegurancaUtil.gerarHashMd5(Arrays.toString(b)));
    ArranjoUtil.imprimirVetor(b);
    System.out.println("Ordenado: " + ArranjoUtil.estahOrdenado(b));    
    System.out.println();
    
    b = LeitorDeArquivo.lerDeArquivo("dados-"+tam);
    System.out.println("Ordenado: " + ArranjoUtil.estahOrdenado(b));    
    start = System.currentTimeMillis();
    OrdenacaoInterna.quicksort(b);
    TempoUtil.tempo(start);
    System.out.println("Depois da ordenação por quicksort: " + tam);
    System.out.println(SegurancaUtil.gerarHashMd5(Arrays.toString(b)));
    System.out.println("Ordenado: " + ArranjoUtil.estahOrdenado(b));
    System.out.println();
    
    b = LeitorDeArquivo.lerDeArquivo("dados-"+tam);
    System.out.println("Ordenado: " + ArranjoUtil.estahOrdenado(b));    
    start = System.currentTimeMillis();
    Arrays.sort(b);
    TempoUtil.tempo(start);
    System.out.println("Depois da ordenação por Arrays.sort(): " + tam);
    System.out.println(SegurancaUtil.gerarHashMd5(Arrays.toString(b)));
    System.out.println("Ordenado: " + ArranjoUtil.estahOrdenado(b));
    System.out.println();
    
  }

}
