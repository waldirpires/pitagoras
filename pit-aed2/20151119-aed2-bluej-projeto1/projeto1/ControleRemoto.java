
/**
 * Escreva a descrição da interface ControleRemoto aqui.
 * 
 * @author (seu nome) 
 * @version (número da versão ou data)
 */

public interface ControleRemoto
{
   public abstract void liga();
   
   public abstract void desliga();
   
   public abstract void mudarCanal(int canal);
   
   public abstract void mudarVolume(int volume);
   
   public abstract void apertarTeclaMudo();
   
}
