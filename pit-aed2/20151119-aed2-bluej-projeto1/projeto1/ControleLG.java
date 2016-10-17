
/**
 * Escreva a descrição da classe ControleLG aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ControleLG implements ControleRemoto
{
    int canal;    int volume;    boolean ligado = false;
    boolean mudo = false;    int ultimoVolume;
    
   public void liga(){   this.ligado = true;  }
   
   public void desliga(){   this.ligado = false;    }
   
   public void mudarCanal(int canal){  if (ligado) this.canal = canal;   }
   
   public void mudarVolume(int volume){ if (ligado) {this.volume = volume; 
    this.ultimoVolume = volume;}}
   
   public void apertarTeclaMudo() { if (ligado) {this.mudo = !mudo; 
       if (mudo){  this.ultimoVolume = this.volume; this.volume = 0;
        } else {   this.volume = this.ultimoVolume;
        }}
    }       
}