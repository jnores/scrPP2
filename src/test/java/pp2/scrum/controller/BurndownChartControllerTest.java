package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.enums.Estado;
import pp2.scrum.dominio.enums.OpcionGrafico;
import pp2.scrum.dominio.interfaz.IConsulta;
import pp2.scrum.dominio.interfaz.IDataComponent;


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