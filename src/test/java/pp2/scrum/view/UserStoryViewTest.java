package pp2.scrum.view;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.Mock;
import mockit.MockUp;
import pp2.scrum.app.AppScrum;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.EnviadorMail;

public class UserStoryViewTest extends TestCase
{
   private UserStoryPaginadoController controller;
   private MailStub mailGatewayStub;
   private ObservadorDeHistoria observadorhistoria;
   private List<UserStory> historias;
   
   public UserStoryViewTest( String testName ) {
      super( testName );
  }
  
  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
      return new TestSuite( UserStoryViewTest.class );
  }

   protected void setUp()
   {
      historias = new ArrayList<UserStory>();
      List<Tarea> tareas = new ArrayList<Tarea>();
      tareas.add(new Tarea());
      UserStory story = new UserStory("titulo1", "detalle1", 50, null, tareas);      
      historias.add(story);
      
   }
   
   public void testEnviarMailStub() 
   {   
      //configurar stub
      mailGatewayStub = new MailStub();
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(mailGatewayStub,controller,"mail");
      //simular finalizar una historia
      controller.finalizarStory(controller.getModel().get(0));
   }
     
   public void testEnviarMailRealFallaPassIncorrecto() 
   {      
      //configurar Mail
      EnviadorMail enviador = new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mail", 15);    
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(enviador,controller,"no-mail@gmail.com");          
      //Enviar Mail
      controller.finalizarStory(controller.getModel().get(0));
   }
   
   public void testEnviarMailRealFallaConectarPuerto() 
   {      
      //configurar Mail
      EnviadorMail enviador = new EnviadorMail(9898,"127.0.0.1", "pp2mailsender", "mail", 15);    
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(enviador,controller,"no-mail@gmail.com");          
      //Enviar Mail
      controller.finalizarStory(controller.getModel().get(0));
   }
   
   public void testEnviarMailRealFallaTimeOut() 
   {      
      //configurar Mail
      EnviadorMail enviador = new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mail", 0);    
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(enviador,controller,"no-mail@gmail.com");          
      //Enviar Mail
      controller.finalizarStory(controller.getModel().get(0));
   }
   
   public void testEnviarMailReal() 
   
   {      
      //configurar Mail
      EnviadorMail enviador = new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mailmail", 15);    
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(enviador,controller,"julian.dirisio@gmail.com");          
      //Enviar Mail
      controller.finalizarStory(controller.getModel().get(0));
   }

}
