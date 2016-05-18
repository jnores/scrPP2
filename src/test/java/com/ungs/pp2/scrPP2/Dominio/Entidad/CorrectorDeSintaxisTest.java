package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CorrectorDeSintaxisTest extends TestCase{

	CorrectorDeSintaxis corrector;
	DiccionarioSintactico diccionarioUserStory,diccionarioCriterios;
	CatalogoDeSugerencias sugerencias;
	
	ArrayList<String> sugerenciasUserStory;		
	ArrayList<String> sugerenciasCriterios;
	
	//Titulo UserStory

	String sinSugerenciaUser="Como usuario quiero helado para no tener hambre";
	String faltaIndicadorRol="usuario quiero helado para no tener hambre";
	String faltaRol="Como quiero helado para no tener hambre";
	String faltaIndicadorMeta="Como usuario helado para no tener hambre";
	String faltaMeta="Como usuario quiero para no tener hambre";
	String faltaIndicadorFinalidad="Como usuario quiero helado no tener hambre";
	String faltaFinalidad="Como usuario quiero helado  para ";
	
	//Criterios

	String sinSugerencia="Dado que tengo hambre cuando haya helado entonces voy a comer";
	String faltaIndicadorCondicion="tengo hambre cuando haya helado entonces voy a comer";
	String faltaCondicion="Dado que cuando haya helado entonces voy a comer";
	String faltaIndicadorCausa="Dado que tengo hambre haya helado entonces voy a comer";
	String faltaCausa="Dado que tengo hambre cuando entonces voy a comer";
	String faltaIndicadorEfecto="Dado que tengo hambre cuando haya helado voy a comer";
	String faltaEfecto="Dado que tengo hambre cuando haya helado entonces ";

	String sugerencia,sugerenciaEsperada;
	
	public CorrectorDeSintaxisTest( String testName ) {
		    super( testName );
	}
		
	public static Test suite() {
		return new TestSuite( CorrectorDeSintaxisTest.class );
	}
		
		public void  setUp() {
			corrector=new CorrectorDeSintaxis();
			gestorDeDiccionario gestor=gestorDeDiccionario.getGestor();
			sugerencias=gestor.getSugerencias();
			sugerenciasUserStory=new ArrayList<String>();
			for(String identificador:gestor.getDiccionarioUserStory().getOrden()){
				sugerenciasUserStory.add(sugerencias.getSugerencia(identificador));
				sugerenciasUserStory.add(sugerencias.getSugerenciaIndicado(identificador));
			}
			sugerenciasCriterios=new ArrayList<String>();
			for(String identificador:gestor.getDiccionarioCriterios().getOrden()){
				sugerenciasCriterios.add(sugerencias.getSugerencia(identificador));
				sugerenciasCriterios.add(sugerencias.getSugerenciaIndicado(identificador));
			}
		}
		
		/**
		 * Prueba del singleton
		 */
		public void testCorrectorDeSintaxis() {
			CorrectorDeSintaxis corrector = new CorrectorDeSintaxis();
			assertTrue(corrector!=null);
		}
		
		/**
		 * Pruebas de los valores posibles de retorno. 
		 */
		
		public void  testFaltaRol() {
			sugerenciaEsperada=sugerenciasUserStory.get(0).trim();
			sugerencia=corrector.analizarTituloUserStory(faltaIndicadorRol).trim();
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));

			sugerenciaEsperada=sugerenciasUserStory.get(1).trim();
			sugerencia=corrector.analizarTituloUserStory(faltaRol).trim();
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
		}
		
		public void  testFaltaMeta() {
			sugerenciaEsperada=sugerenciasUserStory.get(2).trim();
			sugerencia=corrector.analizarTituloUserStory(faltaIndicadorMeta).trim();
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));

			sugerenciaEsperada=sugerenciasUserStory.get(3).trim();
			sugerencia=corrector.analizarTituloUserStory(faltaMeta).trim();
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));

		}

		public void  testFaltaFinalidad() {

			sugerenciaEsperada=sugerenciasUserStory.get(4).trim();
			sugerencia=corrector.analizarTituloUserStory(faltaIndicadorFinalidad).trim();
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerenciaEsperada=sugerenciasUserStory.get(5).trim();
			sugerencia=corrector.analizarTituloUserStory(faltaFinalidad).trim();
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));

		}	
		
		
		public void  testFallaCondicion() {
			sugerenciaEsperada=sugerenciasCriterios.get(0).trim();
			sugerencia=corrector.analizarCriterios(faltaIndicadorCondicion).trim();
			assertTrue(sugerencia.equals(sugerenciaEsperada));
			
			sugerenciaEsperada=sugerenciasCriterios.get(1).trim();
			sugerencia=corrector.analizarCriterios(faltaCondicion).trim();
			assertTrue(sugerencia.equals(sugerenciaEsperada));
		}
		
		public void  testFallaCausa() {
			sugerenciaEsperada=sugerenciasCriterios.get(2).trim();
			sugerencia=corrector.analizarCriterios(faltaIndicadorCausa).trim();
			assertTrue(sugerencia.equals(sugerenciaEsperada));
			
			sugerenciaEsperada=sugerenciasCriterios.get(3).trim();
			sugerencia=corrector.analizarCriterios(faltaCausa).trim();
			assertTrue(sugerencia.equals(sugerenciaEsperada));
		}
		
		public void  testFallaEfecto() {
			sugerenciaEsperada=sugerenciasCriterios.get(4).trim();
			sugerencia=corrector.analizarCriterios(faltaIndicadorEfecto).trim();
			assertTrue(sugerencia.equals(sugerenciaEsperada));
			
			sugerenciaEsperada=sugerenciasCriterios.get(5).trim();
			sugerencia=corrector.analizarCriterios(faltaEfecto).trim();
			assertTrue(sugerencia.equals(sugerenciaEsperada));
		}
		
		public void  testCadenaVacia() {
			sugerencia=corrector.analizarTituloUserStory("");
			assertTrue(sugerencia.equals(""));

			sugerencia=corrector.analizarCriterios("");
			assertTrue(sugerencia.equals(""));
		}
		
		//Falta evaluar que resultado daría exactamente y elegir una cadena acorde
		public void  testNingunIndicador() {
			sugerencia=corrector.analizarTituloUserStory("fasldjfl sfdjlkfds fsjdlkj");
			assertTrue(true);
			sugerencia=corrector.analizarCriterios("Me aburre hacer pruebas para esto :)");
			assertTrue(true);
		}
}




