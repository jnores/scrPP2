package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;
import pp2.scrum.domain.Tarea;
import pp2.scrum.domain.UserStory;
import pp2.scrum.utils.DirOrden;
import pp2.scrum.utils.Paginacion;

public class UserStoryPaginadoControllerTest extends TestCase
{
   private UserStoryPaginadoController controller;
   private MockUp<MailGateway> mailGatewayMock;
   
   public UserStoryPaginadoControllerTest( String testName )
   {
       super( testName );
   }

   public static Test suite()
   {
       return new TestSuite( UserStoryPaginadoControllerTest.class );
   }

   protected void setUp()
   {     
      mailGatewayMock = new MockUp<MailGateway>(){};
      controller = new UserStoryPaginadoController(mailGatewayMock.getMockInstance());
   }
   
   public void testUserPaginadoStoryController()
   {        
      controller.getModel();
      
      assertEquals(controller.getPaginacionActual().getPagina(), 1);
      assertEquals(controller.getItemsTotales(), 0);
      assertEquals(controller.getPaginasTotales(), 0);
      assertTrue(controller.getModel() != null);
      List<UserStory> lista = controller.listarUserStories(new Paginacion());
      assertEquals(lista.size(), 0);
      controller.setModel(null);
   }
   
   public void testUserPaginadoStoryPaginacion()
   {        
      List<UserStory> listaDefault,lista;
      listaDefault = controller.listarUserStories(new Paginacion());
      lista = controller.obtenerPaginacionAnterior();
      assertEquals(listaDefault.size(), lista.size());
      
      lista = controller.obtenerPaginacionPrimera();
      assertEquals(listaDefault.size(), lista.size());
      
      lista = controller.obtenerPaginacionSiguiente();
      assertEquals(controller.getPaginacionActual().getPagina(), 2);
      
      lista = controller.obtenerPaginacionUltima();
      assertEquals(controller.getPaginacionActual().getPagina(), 0);
      
      Paginacion paginacion = new Paginacion(1, 5,new ArrayList<UserStory>());
      listaDefault = controller.listarUserStories(paginacion);
      paginacion.setItemsPorPagina(4);
      paginacion.setPagina(2);
      assertEquals(controller.getPaginacionActual().getPagina(), 2);
      
   }
   
   public void testFinalizarStory()
   {  
      List<UserStory> historias = new ArrayList<UserStory>();
      List<Tarea> tareas = new ArrayList<Tarea>();
      UserStory story = new UserStory("titulo1", "detalle1", 50, null, tareas);
      tareas.add(new Tarea());
      historias.add(story);
      controller.setModel(historias);
      assertTrue(!controller.getModel().get(0).estaTerminada());
      controller.finalizarStory(controller.getModel().get(0));
      assertTrue(controller.getModel().get(0).estaTerminada());
      assertTrue(story.estaTerminada());
      assertTrue(story.getCriterios() != null);
   }
   
   
   
  
}
