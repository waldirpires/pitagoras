
/**
 * Escreva a descrição da classe Circulo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Circulo extends Figura
{
    int raio;
    
    public Circulo(int r){
        this.raio = r;
    }
    
    public int getRaio(){
        return raio;
    }
    
    public double calcularArea(){
        return Math.PI * raio * raio;
    }
    
    public String getNome(){
        return "Circulo!";
    }
}
