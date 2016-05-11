package com.ungs.pp2.scrPP2.Dominio.Entidad;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CorrectorDeSintaxisTest extends TestCase{

	String fraseCorrecta,fallaMeta,fallaRol,vacia,noIndicaNada, sinIndMeta;
	
	String formato="Recuerde que el formato de una user story es \"Como un <ROL> necesito <META> para <PROPÓSITO>.\"\n"
			+ "Ejemplo: Como <moderador>, necesito <poder crear nuevas salas de juego>, para <invitar a los usuarios>.";
	String faltaRol="Recuerde indicar a quién va dirigida la User Story";
	String faltaIndRol="En general una user story empieza con la palabra \"Como\"";
	String faltaMeta="Recuerde indicar la meta de la user story, tras ";
	String faltaIndMeta="Recuerde marcar la meta, \"necesito, requiero, quiero, etc.\"";
	
	public CorrectorDeSintaxisTest( String testName ) {
		    super( testName );
	}
		
	public static Test suite() {
		return new TestSuite( CorrectorDeSintaxisTest.class );
	}
		
		public void  setUp() {
			fraseCorrecta="Como rol requiero esta meta para tal propósito";
			fallaMeta="Como rol requiero para propósito";
			fallaRol="Como quiero un helado con el fin de";
			sinIndMeta="Como programador estoy considerando no hacer nada, con el fin de no cansarme";
			vacia="";
			noIndicaNada="Probando uno, dos tres";
		}
		
		/**
		 * Prueba del singleton
		 */
		public void testCorrectorDeSintaxis() {
			CorrectorDeSintaxis corrector = CorrectorDeSintaxis.getCorrector();
			assertTrue(corrector!=null);
		}
		
		/**
		 * Pruebas de los valores posibles de retorno. 
		 */
		//Con frases pertenecientes al archivo Aceptadas.txt
		public void  testFraseCorrecta() {
			CorrectorDeSintaxis corrector=CorrectorDeSintaxis.getCorrector();
			String sugerencia=corrector.analizarFrase(fraseCorrecta);
			assertTrue(sugerencia.equals(vacia));
		}
			
		public void  testFallaMeta() {
			CorrectorDeSintaxis corrector=CorrectorDeSintaxis.getCorrector();
			String sugerencia=corrector.analizarFrase(fallaMeta);
			assertTrue(sugerencia.contains(faltaMeta));
			sugerencia=corrector.analizarFrase("Como programador solicito con el fin de");
			assertTrue(sugerencia.contains(faltaMeta));
		}
		
		public void  testFallaRol() {
			CorrectorDeSintaxis corrector=CorrectorDeSintaxis.getCorrector();
			String sugerencia=corrector.analizarFrase(fallaRol);
			assertTrue(sugerencia.equals(faltaRol));
			sugerencia=corrector.analizarFrase("En el rol de necesito");
			assertTrue(sugerencia.equals(faltaRol));
		}
		
		public void  testVacio() {
			CorrectorDeSintaxis corrector=CorrectorDeSintaxis.getCorrector();
			String sugerencia=corrector.analizarFrase(vacia);
			assertTrue(sugerencia.equals(vacia));
		}
		
		public void  testNoHayIndMeta() {
			CorrectorDeSintaxis corrector=CorrectorDeSintaxis.getCorrector();
			String sugerencia=corrector.analizarFrase(sinIndMeta);
			assertTrue(sugerencia.equals("Recuerde marcar la meta, \"necesito, requiero, quiero, etc.\""));
		}
		
		public void  testNingunIndicador() {
			CorrectorDeSintaxis corrector=CorrectorDeSintaxis.getCorrector();
			String sugerencia=corrector.analizarFrase(noIndicaNada);
			assertTrue(sugerencia.equals(formato));
			sugerencia=corrector.analizarFrase("Me aburre hacer pruebas para esto :)");
			assertTrue(sugerencia.equals(formato));
		}
}




