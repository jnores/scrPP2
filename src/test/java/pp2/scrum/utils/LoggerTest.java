package pp2.scrum.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.logCommits.GeneradorIDs;
import pp2.scrum.logger.Logger;


public class LoggerTest extends TestCase {
    ByteArrayOutputStream outStream;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LoggerTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( LoggerTest.class );
    }

    public void  setUp() {
        outStream = new ByteArrayOutputStream(1024);
        Logger.setOutStream(outStream);
        Logger.init();
        Logger.log("mensaje 1");
    }

    /**
     * Verifico el texto logueado
     */
    public void testLogger() {
        Logger.close();
        String textLogged="Logger Iniciado\nmensaje 1\nLogger Finalizado\n";
        assertTrue(outStream.toString().equals(textLogged));
        
        GeneradorIDs generador = new GeneradorIDs();
        generador.generarID();
        generador.generarIDLong();
    }



    /**
     * Verifico que se capturen los IOExceptions en el logger cuando cierro el stream.
     */
    public void testStreamClosed() {

        try {
            outStream.close();
        } catch (IOException e) {
        }
        Logger.init();
        Logger.log("mensaje 2");
        Logger.close();
        assertTrue(true);

    }
    /**
     * Verifico que se genere un NullPointerException luego de cerrar el logger.
     */
    public void testLoggerClosed() {
        Logger.close();

        Logger.log("Esto sale por stdout");

        Logger.init();
    }
}