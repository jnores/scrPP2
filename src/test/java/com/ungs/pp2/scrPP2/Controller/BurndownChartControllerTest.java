package com.ungs.pp2.scrPP2.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.Dominio.Enums.OpcionGrafico;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IDataComponent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;


public class BurndownChartControllerTest 
extends TestCase
{
	private MockUp<IConsulta> consultaMock;
	private MockUp<IDataComponent> dataComponentMock;

	
/**
 * Create the test case
 *
 * @param testName name of the test case
 */
public BurndownChartControllerTest( String testName )
{
    super( testName );
}

/**
 * @return the suite of tests being tested
 */
public static Test suite()
{
    return new TestSuite( BurndownChartControllerTest.class );
}

public void  setUp()
{
//	consultaMock = new MockUp<IConsulta>(){};
//	dataComponentMock = new MockUp<IDataComponent>(){}; 
}


public void testBurndownChartController()
{
//   BurndownChartController controller = new BurndownChartController(consultaMock.getMockInstance(),dataComponentMock.getMockInstance());
//   controller.getData(OpcionGrafico.Avance);
//   controller.getData(OpcionGrafico.Estimado, 1);
//   controller.getData(OpcionGrafico.Avance, 1);
//   controller.getData(OpcionGrafico.Comparativo, 1);
//   
//
//   assertTrue(true);
}
}