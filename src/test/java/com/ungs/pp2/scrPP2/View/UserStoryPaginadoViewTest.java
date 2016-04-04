package com.ungs.pp2.scrPP2.View;

import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.View.UserStoryPaginadoView;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
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
      consultaMock = new MockUp<IConsulta>(){};
      controller = new UserStoryPaginadoController(consultaMock.getMockInstance());  
   }
   
   public void testMainUserStoryMain() 
   {
      UserStoryPaginadoView vista = new UserStoryPaginadoView(controller);
      assertTrue( true );
   }

}
