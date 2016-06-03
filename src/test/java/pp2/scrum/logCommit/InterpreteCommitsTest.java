package pp2.scrum.logCommit;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.logCommits.Commit;
import pp2.scrum.logCommits.InterpreteCommits;
import pp2.scrum.utils.Lector;

public class InterpreteCommitsTest extends TestCase {

	InterpreteCommits interprete;
	ArrayList<Commit> commits;
	Commit commit;
	String path="src/main/resources/file/ArchivoPrueba.txt";
	String idCommit1="id1"; String idCommit2="id2";
	String autor1="autor1";String autor2="autor2";
	String fecha1 ="Fri Sep 3 15:35:34 2016 -0300";
	String mensaje1="#Tarea:1abcdef1 Cambio 6 #ESTADO: done";
	String fecha2 ="Thu Sep 5 08:59:32 2016-0800";
	String mensaje2="#tarea:2abcdef2 Cambio 5 #estado: doing";

	public InterpreteCommitsTest( String testName ) {
		    super( testName );
	}
	
	
	public static Test suite() {
		return new TestSuite( InterpreteCommitsTest.class );
	}
	 
	public void  setUp() {
		Lector lector=new Lector();
		String texto=lector.leerArchivo(path);
		interprete=new InterpreteCommits(texto);
	}
	
	public void  testEvaluarCargaID() {
		commits=interprete.getCommits();
		commit=commits.get(0);
		assertTrue(commit.getSha().trim().equals(idCommit1));
		commit=commits.get(1);
		assertTrue(commit.getSha().trim().equals(idCommit2));
	}
	public void  testEvaluarCargaMensaje() {
		commits=interprete.getCommits();
		commit=commits.get(0);
		assertTrue(commit.getMensaje().trim().equals(mensaje1.trim()));

		commit=commits.get(1);
		assertTrue(commit.getMensaje().trim().equals(mensaje2.trim()));
	}
	public void  testEvaluarCargaFecha() {
		commits=interprete.getCommits();
		commit=commits.get(0);
		assertTrue(commit.getDate().trim().equals(fecha1.trim()));
	}
	
	public void  testEvaluarCargaAutor() {
		commits=interprete.getCommits();
		commit=commits.get(0);
		assertTrue(commit.getAutor().trim().equals(autor1.trim()));

		commit=commits.get(1);
		assertTrue(commit.getAutor().trim().equals(autor2.trim()));
	}
}
