package com.ungs.pp2.scrPP2.Dominio.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ungs.pp2.scrPP2.Controller.UserStoryHelper;
import com.ungs.pp2.scrPP2.Dominio.Composite.Avance;
import com.ungs.pp2.scrPP2.Dominio.Composite.DataComposite;
import com.ungs.pp2.scrPP2.Dominio.Composite.Estimado;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.EstadoTest;
import com.ungs.pp2.scrPP2.Plugins.ExportToText;
import com.ungs.pp2.scrPP2.View.AltaUserStoryView;
import com.ungs.pp2.scrPP2.View.BacklogNuevoView;
import com.ungs.pp2.scrPP2.View.BurndownChartView;
import com.ungs.pp2.scrPP2.View.FilterStoriesView;
import com.ungs.pp2.scrPP2.View.HomeView;
import com.ungs.pp2.scrPP2.View.ProyectoNuevoView;
import com.ungs.pp2.scrPP2.utils.UserStoryMapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class ExportToTextTest extends TestCase {
	UserStory userStory;
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ExportToTextTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
	    return new TestSuite( ExportToTextTest.class );
	}
	
	public void  setUp() {
		userStory = new UserStory("Titulo1", "Detalle1", "Autor1");
	}
	
	/**
	 * Verifico el texto logueado
	 */
	public void testExportToText() {
		UserStoryHelper userStoryHelper = new UserStoryHelper(this.userStory);
		
		ExportToText exporter = new ExportToText();
		String path="./prueba.xls";
		List<UserStoryHelper> lst = new ArrayList<>();
		lst.add(userStoryHelper);
		exporter.export(path, lst);
		
//		AltaUserStoryView altv = new AltaUserStoryView(null);
//		FilterStoriesView v = new FilterStoriesView(null); 
//		ProyectoNuevoView nuev = new ProyectoNuevoView(null);
//		BacklogNuevoView bcklg = new BacklogNuevoView(null);
//		Avance a = new Avance(null);
//		DataComposite dt = new DataComposite(null);
//		Estimado e = new Estimado(null);
	
	}
	
}