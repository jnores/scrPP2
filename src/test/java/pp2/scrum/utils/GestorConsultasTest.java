package pp2.scrum.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.logCommits.GestorConsultas;
import pp2.scrum.logCommits.GestorVinculos;
import pp2.scrum.model.Tarea;


public class GestorConsultasTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GestorConsultasTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( GestorConsultasTest.class );
    }

    public void  setUp() {
       
    }

    /**
     * Verifico el texto logueado
     */
    public void testGestor() {
       GestorConsultas gestor = new GestorConsultas();
       Tarea t1 = new Tarea("Tarea1");
       gestor.getTarea("1");
       int size = gestor.getTarea().size();
       assertTrue(size == 0);
       gestor.guardarModificacionTarea(t1);
       size = gestor.getTarea().size();
       assertTrue(size == 1);
       
    }
    
    public void testGestorVinculo() {
       GestorConsultas gestor = new GestorConsultas();
       GestorVinculos gestorVinculo = new GestorVinculos("",gestor);
       GestorVinculos gestorVinculo2 = new GestorVinculos(null,gestor);
       Tarea t1 = new Tarea("Tarea1");
       gestor.getTarea("1");
       int size = gestor.getTarea().size();
       assertTrue(size == 0);
       gestor.guardarModificacionTarea(t1);
       size = gestor.getTarea().size();
       assertTrue(size == 1);
       
    }
}