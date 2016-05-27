package pp2.scrum.dominio.Entidad;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.dominio.entidad.CorrectorSintaxis;
import pp2.scrum.dominio.entidad.DiccionarioSintactico;
import pp2.scrum.dominio.entidad.GestorDiccionario;
import pp2.scrum.dominio.entidad.GestorSugerencias;

public class CorrectorDeSintaxisTest extends TestCase{

	CorrectorSintaxis corrector;
	DiccionarioSintactico diccionarioUserStory,diccionarioCriterios;
	GestorSugerencias sugerencias;
	
	//Criterios
	//Parciales
	String prueba0C="   Dado que son necesarios todos los datos  ";		//Es parcial así que es correcto
	String prueba0US="   Como   ";										//Es parcial así que es correcto
	String prueba1aUS="Como quiero contar "; 							//No indica rol
	String prueba1bC="cuando "; 											//No indica condición
	String prueba2aUS="En el rol de médico necesito para ";				//No indica meta
	String prueba2bUS="Como enfermera para"; 							//No indica meta
	String prueba4aUS="con el fin de "; 									//No indica ni rol, ni meta
	String prueba4bUS="En el rol de quiero para "; 						//No indica ni rol, ni meta
	String prueba4aC="Dado que cuando entonces  "; 						//No indica ni condición, ni causa
	String prueba4bC="entonces  ";		 								//No indica ni condición, ni causa
	
	//Titulo User Story
	//Completos
	String pruebaC0US="Como una doctora requiero consultar una historia clinica con el fin de diagnosticar al paciente  ";
	String pruebaC1aUS="Como quiero   contar con sugerencias para facilitar la escritura "; 				//No indica rol
	String pruebaC1bUS="  requiero contar con sugerencias con el proposito de facilitar la escritura ";	//No indica rol
	String pruebaC2aUS="En el rol de médico necesito para revisar dolencias previas ";					//No indica meta
	String pruebaC2bUS="Como enfermera con el fin de evitar tratamientos innecesarios ";					//No indica meta
	String pruebaC3aC="Dado que es necesario seleccionar un estado cuando no se seleccione ninguno ";	//No indica finalidad
	String pruebaC3bC="Dado que se necesita elegir un estado, cuando no se seleccione ninguno entonces ";//No indica finalidad
	String pruebaC4aUS="con el fin de evaluar el estado físico ";	 									//No indica ni rol, ni meta
	String pruebaC4bUS="   En el rol de quiero para estudiar el comportarmiento ";	 					//No indica ni rol, ni meta
	String pruebaC4cUS="Médico quiero para efectuar evaluaciones periodicas "; 							//No indica ni rol, ni meta
	String pruebaC4dUS="En el rol de para consultar expedientes ";		 								//No indica ni rol, ni meta
	String pruebaC5aC="Dado que cuando quiera presionar el botón ingresar, entonces ";					//No indica ni condición, ni efecto
	String pruebaC5aUS="En el rol de necesito ver el historial";										//No indica ni rol, ni finalidad
	String pruebaC6aC="Dado que se necesita al menos el título";										//No indica ni causa, ni efecto
	String pruebaC6bC="Debido a que no se pueden ingresar datos numericos";								//No indica ni causa, ni efecto
	String pruebaC7US="Como con el fin de";																//No indica rol, ni meta, ni finalidad

	String sugerencia,sugerenciaEsperada;
	
	public CorrectorDeSintaxisTest( String testName ) {
		    super( testName );
	}
		
	public static Test suite() {
		return new TestSuite( CorrectorDeSintaxisTest.class );
	}
		
		public void  setUp() {
			corrector=new CorrectorSintaxis();
			GestorDiccionario gestor=GestorDiccionario.getGestor();
			diccionarioUserStory=gestor.getDiccionarioUserStory();
			diccionarioCriterios=gestor.getDiccionarioCriterios();
			sugerencias=GestorSugerencias.getCatalogo();
		}
		
		/**
		 * Pruebas de los valores posibles de retorno. 
		 */
		
		
		public void  testSugerenciaCod0() {
			//Comprobación parcial 
			sugerenciaEsperada=sugerencias.getSugerencia("10");
			sugerencia=corrector.analizarTituloUserStory(prueba0US, false);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));

			sugerenciaEsperada=sugerencias.getSugerencia("20");
			sugerencia=corrector.analizarCriterios(prueba0C, false);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			//Comprobación total 
			sugerenciaEsperada=sugerencias.getSugerencia("10");
			sugerencia=corrector.analizarTituloUserStory(pruebaC0US, true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
		}
		
		public void  testSugerenciaCod1(){
			//Comprobación parcial

			sugerenciaEsperada=sugerencias.getSugerencia("21");
			sugerencia=corrector.analizarCriterios(prueba1bC,false);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerenciaEsperada=sugerencias.getSugerencia("11");
			sugerencia=corrector.analizarTituloUserStory(prueba1aUS,false);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			//Comprobación total
			sugerencia=corrector.analizarTituloUserStory(pruebaC1aUS,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerencia=corrector.analizarTituloUserStory(pruebaC1bUS,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
		}

		public void  testSugerenciaCod2Parcial(){

			sugerenciaEsperada=sugerencias.getSugerencia("12");
			
			//Comprobación parcial
			sugerencia=corrector.analizarTituloUserStory(prueba2aUS,false);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));

			sugerencia=corrector.analizarTituloUserStory(prueba2bUS,false);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			//Comprobación total
			sugerencia=corrector.analizarTituloUserStory(pruebaC2aUS,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerencia=corrector.analizarTituloUserStory(pruebaC2bUS,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
		}	
	
		public void  testSugerenciaCod2Completa(){

			sugerenciaEsperada=sugerencias.getSugerencia("12");
			
			//Comprobación total
			sugerencia=corrector.analizarTituloUserStory(pruebaC2aUS,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerencia=corrector.analizarTituloUserStory(pruebaC2bUS,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
		}	
		
		
		public void  testSugerenciaCod3(){

			sugerenciaEsperada=sugerencias.getSugerencia("23");
			//Comprobación total
			sugerencia=corrector.analizarCriterios(pruebaC3aC,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerencia=corrector.analizarCriterios(pruebaC3bC,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
		}
		
		public void  testSugerenciaCod4Parcial(){
			sugerenciaEsperada=sugerencias.getSugerencia("14");
			
			//Comprobación Parcial
			sugerencia=corrector.analizarTituloUserStory(prueba4aUS,false);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerencia=corrector.analizarTituloUserStory(prueba4bUS,false);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerenciaEsperada=sugerencias.getSugerencia("24");
			
			sugerencia=corrector.analizarCriterios(prueba4aC,false);
			assertTrue(sugerencia.equals(sugerenciaEsperada));
			
			sugerencia=corrector.analizarCriterios(prueba4aC,false);
			assertTrue(sugerencia.equals(sugerenciaEsperada));
		}
		
		public void  testSugerenciaCod4Total(){
			sugerenciaEsperada=sugerencias.getSugerencia("14");
			
			//Comprobación Total
			sugerencia=corrector.analizarTituloUserStory(pruebaC4aUS,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerencia=corrector.analizarTituloUserStory(pruebaC4bUS,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerencia=corrector.analizarTituloUserStory(pruebaC4cUS,true);
			assertTrue(sugerencia.equals(sugerenciaEsperada));
			
			sugerencia=corrector.analizarTituloUserStory(pruebaC4dUS,true);
			assertTrue(sugerencia.equals(sugerenciaEsperada));
		}
		
		public void  testSugerenciaCod5Total(){
			sugerenciaEsperada=sugerencias.getSugerencia("15");
			
			//Comprobación Total
			sugerencia=corrector.analizarTituloUserStory(pruebaC5aUS,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			

			sugerenciaEsperada=sugerencias.getSugerencia("25");
			
			sugerencia=corrector.analizarTituloUserStory(pruebaC5aC,true);
//			System.out.println("testSugerenciaCod5Total:"+sugerencia);
//			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
		}
		
		public void  testSugerenciaCod6Total(){
			sugerenciaEsperada=sugerencias.getSugerencia("16");
			
			//Comprobación Total
			sugerencia=corrector.analizarTituloUserStory(pruebaC6aC,true);
//			System.out.println("testSugerenciaCod6Total:"+sugerenciaEsperada);
//			System.out.println("testSugerenciaCod6Total:"+sugerencia);
//			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
			
			sugerencia=corrector.analizarTituloUserStory(pruebaC6bC,true);
//			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
		}
		
		public void  testSugerenciaCod7Total(){
			sugerenciaEsperada=sugerencias.getSugerencia("17");
			
			//Comprobación Total
			sugerencia=corrector.analizarTituloUserStory(pruebaC7US,true);
			assertTrue(sugerencia.equalsIgnoreCase(sugerenciaEsperada));
		}
		
		public void  testCadenaVacia() {
			//Parcial
			sugerencia=corrector.analizarTituloUserStory("",false);
			assertTrue(sugerencia.equals(""));

			//Completa
			sugerenciaEsperada=sugerencias.getSugerencia("27");
			sugerencia=corrector.analizarCriterios("",true);
			assertTrue(sugerencia.equals(sugerenciaEsperada));
		}
		
		//Falta evaluar que resultado daría exactamente y elegir una cadena acorde
		public void  testNingunIndicador() {
			//Parcial 
			sugerenciaEsperada="";
			sugerencia=corrector.analizarTituloUserStory("Nada", false);
//			System.out.println("testNingunIndicador:"+sugerencia);
//			assertTrue(sugerenciaEsperada.equals(sugerencia));
			
			//Completa
			sugerenciaEsperada=sugerencias.getSugerencia("27");
			sugerencia=corrector.analizarCriterios("NADA",true);
			assertTrue(sugerenciaEsperada.equals(sugerencia));
		}
}




