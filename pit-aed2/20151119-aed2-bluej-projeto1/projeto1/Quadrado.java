
/**
 * Escreva a descrição da classe Quadrado aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Quadrado extends Figura
{
  int lado;
  
  public Quadrado(int l){
      this.lado = l;
    }
  
  public double calcularArea(){
      return lado * lado;
    }
    
  public String getNome(){
      return "Quadrado!";
    }
}
