package pp2.scrum.view;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.UserStory;
import pp2.scrum.view.UserStoryPaginadoView;

public class UserStoryPaginadoViewTest extends TestCase
{
   private UserStoryPaginadoController controller;
   private List<UserStory> model;
   
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
      controller = new UserStoryPaginadoController();
      model = new ArrayList<UserStory>();
      
   }
   
   public void testMainUserStoryMain() 
   {
      UserStoryPaginadoView vista = new UserStoryPaginadoView(controller,model);
      assertTrue( true );
   }

}
