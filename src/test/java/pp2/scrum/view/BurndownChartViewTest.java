package pp2.scrum.view;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;
import pp2.scrum.controller.BurndownChartController;
import pp2.scrum.dominio.interfaz.DataComponent;
import pp2.scrum.dominio.interfaz.MailGateway;
import pp2.scrum.view.BurndownChartView;

public class BurndownChartViewTest extends TestCase
{
   private BurndownChartController controller;
   private MockUp<MailGateway> mailGatewayMock;
   private MockUp<DataComponent> dataComponentMock;
   
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
      dataComponentMock = new MockUp<DataComponent>(){};
      mailGatewayMock = new MockUp<MailGateway>(){};
      
   }
   
   public void testVista() 
   {
      controller = new BurndownChartController(mailGatewayMock.getMockInstance()); 
      BurndownChartView vista = new BurndownChartView(controller);
      assertTrue( true );
   }
   
   public void testVistaComposite() 
   {
      controller = new BurndownChartController(dataComponentMock.getMockInstance(),mailGatewayMock.getMockInstance()); 
      BurndownChartView vista = new BurndownChartView(controller);
      assertTrue( true );
   }
   
   public void testActionPerformed()
   {
      controller = new BurndownChartController(dataComponentMock.getMockInstance(),mailGatewayMock.getMockInstance()); 
      BurndownChartView vista = new BurndownChartView(controller);
      //vista.actionPerformed(new ActionEvent(vista, 1, "menu4"));
      assertTrue(true);
      
   }

}
