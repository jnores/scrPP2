package pp2.scrum.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.Mock;
import mockit.MockUp;
import pp2.scrum.controller.BurndownChartController;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.enums.Estado;
import pp2.scrum.dominio.interfaz.IConsulta;
import pp2.scrum.dominio.interfaz.IDataComponent;
import pp2.scrum.view.BurndownChartView;
import pp2.scrum.view.UserStoryPaginadoView;

public class BurndownChartViewTest extends TestCase
{
   private BurndownChartController controller;
   private MockUp<IConsulta> consultaMock;
   private MockUp<IDataComponent> dataComponentMock;
   
   public BurndownChartViewTest( String testName ) {
      super( testName );
  }
  
  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
      return new TestSuite( BurndownChartViewTest.class );
  }

   protected void setUp()
   {
      consultaMock = new MockUp<IConsulta>(){};
      dataComponentMock = new MockUp<IDataComponent>(){};   
      
   }
   
   public void testVista() 
   {
      controller = new BurndownChartController(consultaMock.getMockInstance()); 
      BurndownChartView vista = new BurndownChartView(controller);
      assertTrue( true );
   }
   
   public void testVistaComposite() 
   {
      controller = new BurndownChartController(consultaMock.getMockInstance(),dataComponentMock.getMockInstance()); 
      BurndownChartView vista = new BurndownChartView(controller);
      assertTrue( true );
   }
   
   public void testActionPerformed()
   {
      controller = new BurndownChartController(consultaMock.getMockInstance(),dataComponentMock.getMockInstance()); 
      BurndownChartView vista = new BurndownChartView(controller);
      //vista.actionPerformed(new ActionEvent(vista, 1, "menu4"));
      assertTrue(true);
      
   }

}
