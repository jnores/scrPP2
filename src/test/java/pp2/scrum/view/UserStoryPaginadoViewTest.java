package pp2.scrum.view;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.dominio.entidad.MailGateway;
import pp2.scrum.view.UserStoryPaginadoView;

public class UserStoryPaginadoViewTest extends TestCase
{
   private UserStoryPaginadoController controller;
   private MockUp<MailGateway> mailGatewayMock;
   
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
   
      mailGatewayMock = new MockUp<MailGateway>(){};
      controller = new UserStoryPaginadoController(mailGatewayMock.getMockInstance());  
   }
   
   public void testMainUserStoryMain() 
   {
      UserStoryPaginadoView vista = new UserStoryPaginadoView(controller);
      assertTrue( true );
   }

}
