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
import pp2.scrum.utils.ObservadorDeHistoria;

public class UserStoryViewTest extends TestCase
{
   private UserStoryPaginadoController controller;
   private ObservadorDeHistoria observadorhistoria;
   private List<UserStory> historias;
   private MockUp<AppScrum> appMock;
   
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
      //Configuro el mail mock
      appMock = new MockUp<AppScrum>()
      {
         @Mock public MailGateway mailGateway() { return new MailStub(); }
      };
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(controller.getModel(),"mail");
      //simular finalizar una historia
      controller.finalizarStory(controller.getModel().get(0));
   }
     
   public void testEnviarMailRealFallaPassIncorrecto() 
   {      
    //Configuro el mail mock
      appMock = new MockUp<AppScrum>()
      {
         @Mock public MailGateway mailGateway() { return new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mail", 15); }
      };
      //configurar Mail   
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(controller.getModel(),"no-mail@gmail.com");          
      //Enviar Mail
      controller.finalizarStory(controller.getModel().get(0));
   }
   
   public void testEnviarMailRealFallaConectarPuerto() 
   {      
    //Configuro el mail mock
      appMock = new MockUp<AppScrum>()
      {
         @Mock public MailGateway mailGateway() { return new EnviadorMail(9898,"127.0.0.1", "pp2mailsender", "mail", 15); }
      };
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(controller.getModel(),"no-mail@gmail.com");          
      //Enviar Mail
      controller.finalizarStory(controller.getModel().get(0));
   }
   
   public void testEnviarMailRealFallaTimeOut() 
   {      
    //Configuro el mail mock
      appMock = new MockUp<AppScrum>()
      {
         @Mock public MailGateway mailGateway() { return new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mail", 0); }
      };   
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(controller.getModel(),"no-mail@gmail.com");          
      //Enviar Mail
      controller.finalizarStory(controller.getModel().get(0));
   }
   
   public void testEnviarMailReal()
   
   {      
    //Configuro el mail mock
      appMock = new MockUp<AppScrum>()
      {
         @Mock public MailGateway mailGateway() { return new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mailmail", 15); }
      };    
      controller = new UserStoryPaginadoController();
      //setear controller
      controller.actualizarPaginacion(historias);
      observadorhistoria = new ObservadorDeHistoria(controller.getModel(),"julian.dirisio@gmail.com");          
      //Enviar Mail
      controller.finalizarStory(controller.getModel().get(0));
   }

}
