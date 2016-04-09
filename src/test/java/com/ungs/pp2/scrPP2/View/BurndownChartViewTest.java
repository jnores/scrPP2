package com.ungs.pp2.scrPP2.View;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ungs.pp2.scrPP2.Controller.BurndownChartController;
import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IDataComponent;
import com.ungs.pp2.scrPP2.View.UserStoryPaginadoView;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.Mock;
import mockit.MockUp;

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
