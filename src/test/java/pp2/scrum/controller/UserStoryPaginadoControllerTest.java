package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;
import pp2.scrum.dominio.Estado;
import pp2.scrum.dominio.entidad.MailGateway;
import pp2.scrum.dominio.entidad.Tarea;
import pp2.scrum.dominio.entidad.UserStory;
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
      
      assertEquals(controller.getPaginaActual().getPagina(), 1);
      assertEquals(controller.getItemsTotales(), 0);
      assertEquals(controller.getPaginasTotales(), 0);
      assertTrue(controller.getModel() != null);
      List<UserStory> lista = controller.ListarUserStories(null);
      assertEquals(lista.size(), 0);
      controller.setModel(null);
   }
   
   public void testUserPaginadoStoryPaginacion()
   {        
      List<UserStory> listaDefault,lista;
      listaDefault = controller.ListarUserStories(null);
      lista = controller.ObtenerPaginaAnterior();
      assertEquals(listaDefault.size(), lista.size());
      
      lista = controller.ObtenerPaginaPrimera();
      assertEquals(listaDefault.size(), lista.size());
      
      lista = controller.ObtenerPaginaSiguiente();
      assertEquals(controller.getPaginaActual().getPagina(), 2);
      
      lista = controller.ObtenerPaginaUltima();
      assertEquals(controller.getPaginaActual().getPagina(), 0);
      
      Paginacion paginacion = new Paginacion("Id", DirOrden.Desc, 1, 5);
      listaDefault = controller.ListarUserStories(paginacion);
      assertEquals(controller.getPaginaActual().getDireccionOrden(), DirOrden.Desc);
      paginacion.setDireccionOrden(DirOrden.Asc);
      paginacion.setItemsPorPagina(4);
      paginacion.setOrdenarPor("Id");
      paginacion.setPagina(2);
      
      assertEquals(controller.getPaginaActual().getDireccionOrden(), DirOrden.Asc);
      assertEquals(controller.getPaginaActual().getPagina(), 2);
      
   }
   
   public void testFinalizarStory()
   {  
      List<UserStory> historias = new ArrayList<UserStory>();
      List<Tarea> tareas = new ArrayList<Tarea>();
      UserStory story = new UserStory("titulo1", "detalle1", "autor1", "responsable1", 10, 50, 1, Estado.getDefault(), null,tareas);
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
