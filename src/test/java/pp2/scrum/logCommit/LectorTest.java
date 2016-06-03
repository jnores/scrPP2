package pp2.scrum.logCommit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.utils.Lector;
import pp2.scrum.utils.RegexFacilities;

public class LectorTest extends TestCase{
	
	String path="src/main/resources/file/ArchivoPrueba.txt";
	
	String texto="";
	Lector lector;

	String idCommit1="id1"; String idCommit2="id2";
	String autor1="autor1";String autor2="autor2";
	String fecha1 ="Fri Sep 3 15:35:34 2016 -0300";
	String mensaje1="#Tarea:1abcdef1 Cambio 6 #ESTADO: done";
	String fecha2 =" Thu Sep 5 08:59:32 2016 -0800";
	String mensaje2="#tarea:2abcdef2 Cambio 5 #estado: doing";
	

	public LectorTest(String testName){
		    super( testName );
	}

	public static Test suite() {
		return new TestSuite( LectorTest.class );
	}
	 
	public void  setUp() {
		Lector lector=new Lector();
		texto=lector.leerArchivo(path);
	}
	
	public void  testContieneTexto() {
		assertTrue(texto.contains(idCommit1));
		assertTrue(texto.contains(idCommit2));
		assertTrue(texto.contains(mensaje1));
		assertTrue(texto.contains(mensaje2));
		assertTrue(texto.contains(fecha1));
		assertTrue(texto.contains(fecha2));
	}
	
	public void  testNoContieneTexto() {
		assertFalse(texto.contains("I dont want to be the one"));
		assertFalse(texto.contains("Or why I have to scream"));
	}
	
	public void  testOrdenTexto() {
		assertTrue(RegexFacilities.existeEnElTexto("[cC][oO][Mm][Mm][iI][tT]:*\\s*"+idCommit1, texto));
		assertTrue(RegexFacilities.existeEnElTexto("[cC][oO][Mm][Mm][iI][tT]:*\\s*"+idCommit2, texto));
	}

}
