package pp2.scrum.view;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.dominio.entidad.UserStory;

public class ObservadorDeHistoria implements Observer
{
   private UserStoryPaginadoController controller;
   private String mailDestino;
   
   public ObservadorDeHistoria(UserStoryPaginadoController controller,String mail)
   {
      this.controller = controller;
      this.mailDestino = mail;
      observarHistorias(this.controller.getModel());
   }

   @Override
   public void update(Observable o, Object arg)
   {
      UserStory historia = (UserStory) o;
      if (historia.estaTerminada())
      {
         controller.enviarHistoriaMail(mailDestino, historia);
      }            
   }
   
   private void observarHistorias(List<UserStory> stories)
   {
      for (UserStory story : stories)
      {
         story.addObserver(this);
      }
   }

}
