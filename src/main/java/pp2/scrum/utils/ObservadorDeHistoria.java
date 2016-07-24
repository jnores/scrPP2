package pp2.scrum.utils;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import pp2.scrum.app.AppScrum;
import pp2.scrum.controller.Mail;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.Resultado;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.CriterioAceptacion;
import pp2.scrum.model.UserStory;

public class ObservadorDeHistoria implements Observer
{
   private List<UserStory> historias;
   private String mailDestino;
   
   public ObservadorDeHistoria(List<UserStory> historias,String mail)
   {
      this.historias = historias;
      this.mailDestino = mail;
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
       for (CriterioAceptacion criterio : story.getCriterios())
       {
          criterios+="* "+ criterio.getDescripcion() + nuevaLinea;        
       }
               
       String cuerpo = "Detalle:" + nuevaLinea;
       cuerpo += story.getDetalle() + nuevaLinea;
       cuerpo += "Criterios:" + nuevaLinea;
       cuerpo += criterios;
       //cuerpo += "Autor:" + nuevaLinea;
       //cuerpo += story.getAutor() + nuevaLinea;
       cuerpo += "Puntos:" + nuevaLinea;
       cuerpo += story.getStoryPoints() + nuevaLinea;
       
       Mail mail = new Mail(destino, "Historia finalizada: " +  story.getTitulo(),cuerpo);
       Logger.init();
       Resultado respuesta = AppScrum.getInstance().mailGateway().enviar(mail);
       for (String comment : respuesta.Errores().values())
       {
          Logger.log(comment);
       }
       Logger.close();
       return respuesta;
   }

}
