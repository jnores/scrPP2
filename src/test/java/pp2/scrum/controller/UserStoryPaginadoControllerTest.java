package pp2.scrum.controller;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;
import pp2.scrum.dominio.Paginacion;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.enums.DirOrden;
import pp2.scrum.dominio.interfaz.MailGateway;

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
  
}
