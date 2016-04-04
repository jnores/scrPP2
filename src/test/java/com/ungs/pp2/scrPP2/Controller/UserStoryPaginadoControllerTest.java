package com.ungs.pp2.scrPP2.Controller;

import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;

public class UserStoryPaginadoControllerTest extends TestCase
{
   private MockUp<IConsulta> consultaMock;
   private List<UserStory> model;
   
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
      consultaMock = new MockUp<IConsulta>(){};
   }
   
   public void testUserPaginadoStoryController()
   {  
      UserStoryPaginadoController controller = new UserStoryPaginadoController(consultaMock.getMockInstance());
      
      controller.getModel();
      
      assertEquals(controller.getPaginaActual().getPagina(), 1);
      assertEquals(controller.getItemsTotales(), 11);
      assertEquals(controller.getPaginasTotales(), 3);
      assertTrue(controller.getModel() != null);
      List<UserStory> lista = controller.ListarUserStories(null);
      assertEquals(lista.size(), 5);
      controller.setModel(null);
   }

}
