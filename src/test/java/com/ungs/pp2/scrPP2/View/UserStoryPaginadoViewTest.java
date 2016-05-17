package com.ungs.pp2.scrPP2.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.View.UserStoryPaginadoView;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.Mock;
import mockit.MockUp;

public class UserStoryPaginadoViewTest extends TestCase
{
   private UserStoryPaginadoController controller;
   private MockUp<IConsulta> consultaMock;
   
   public UserStoryPaginadoViewTest( String testName ) {
      super( testName );
  }
  
  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
      return new TestSuite( UserStoryPaginadoViewTest.class );
  }

   protected void setUp()
   {
   
      consultaMock = new MockUp<IConsulta>(){
         @Mock
         public List<UserStory> ObtenerUserStoriesDB()
         {
            return new ArrayList<UserStory>(Arrays.asList              
               (
                     new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo2", "Detalle2", "Autor2", "Responsable2", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo3", "Detalle3", "Autor3", "Responsable3", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo4", "Detalle4", "Autor4", "Responsable4", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo5", "Detalle5", "Autor5", "Responsable5", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo6", "Detalle6", "Autor6", "Responsable6", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo7", "Detalle7", "Autor7", "Responsable7", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo8", "Detalle8", "Autor8", "Responsable8", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo9", "Detalle9", "Autor9", "Responsable9", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo10", "Detalle10", "Autor10", "Responsable10", 10, 40, 1, Estado.ToDo, null, null),
                     new UserStory("Titulo11", "Detalle11", "Autor11", "Responsable11", 10, 40, 1, Estado.ToDo, null, null)
               ));
         }
      };
      controller = new UserStoryPaginadoController(consultaMock.getMockInstance());  
   }
   
   public void testMainUserStoryMain() 
   {
      UserStoryPaginadoView vista = new UserStoryPaginadoView(controller);
      assertTrue( true );
   }

}
