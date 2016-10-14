package br.edu.pit.aeda.ordenacao.interna.utils;

public class TempoUtil {

  public static void tempo(long start){
    System.out.println("Tempo: " + (System.currentTimeMillis() - start) + " ms");
  }
}
