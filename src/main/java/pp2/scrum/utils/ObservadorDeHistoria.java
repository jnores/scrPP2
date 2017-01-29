package pp2.scrum.utils;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import pp2.scrum.controller.Mail;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.Resultado;
import pp2.scrum.logger.Logger;
import pp2.scrum.model.UserStory;

public class ObservadorDeHistoria implements Observer
{
   private List<UserStory> historias;
   private String mailDestino;
   private MailGateway mailGateway;
   
   public ObservadorDeHistoria(List<UserStory> historias,String mail,MailGateway mailGateway)
   {
      this.historias = historias;
      this.mailDestino = mail;
      this.mailGateway = mailGateway;
      observarHistorias(this.historias);
   }

   @Override
   public void update(Observable o, Object arg)
   {
      UserStory historia = (UserStory) o;
      if (historia.estaTerminada())
      {
         enviarHistoriaMail(mailDestino, historia);
      }            
   }
   
   private void observarHistorias(List<UserStory> stories)
   {
      for (UserStory story : stories)
      {
         story.addObserver(this);
      }
   }
   
   private Resultado enviarHistoriaMail(String destino , UserStory story)
   {        
       String nuevaLinea = System.lineSeparator();
       String criterios="";
       criterios+=story.getCriterio() + nuevaLinea;               
       String cuerpo = "Detalle:" + nuevaLinea;
       cuerpo += story.getDetalle() + nuevaLinea;
       cuerpo += "Criterios:" + nuevaLinea;
       cuerpo += criterios;
       //cuerpo += "Autor:" + nuevaLinea;
       //cuerpo += story.getAutor() + nuevaLinea;
       cuerpo += "Puntos:" + nuevaLinea;
       cuerpo += story.getStoryPoints() + nuevaLinea;
       
       Mail mail = new Mail(destino, "Historia finalizada: " +  story.getTitulo(),cuerpo);
       
       Resultado respuesta = mailGateway.enviar(mail);
       for (String comment : respuesta.Errores().values())
       {
          Logger.log(comment);
       }
       Logger.close();
       return respuesta;
   }

}
