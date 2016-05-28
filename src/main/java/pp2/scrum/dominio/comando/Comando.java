package pp2.scrum.dominio.comando;

import pp2.scrum.dominio.Resultado;

public abstract class Comando
{
   private Resultado resultado;
   
   Comando()
   {
      resultado = new Resultado();
   }

   public Resultado getResultado()
   {
      return resultado;
   }

   public void setResultado(Resultado resultado)
   {
      this.resultado = resultado;
   }

}
