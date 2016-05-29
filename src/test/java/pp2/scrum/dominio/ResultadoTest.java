/**
 * 
 */
package pp2.scrum.dominio;

import java.util.Map;

import junit.framework.TestCase;

/**
 * @author yoshknight
 *
 */
public class ResultadoTest extends TestCase {
    Resultado resultado=null;
    /**
     * @param name
     */
    public ResultadoTest(String name) {
        super(name);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        resultado = new Resultado();
    }

    /**
     * Test method for {@link pp2.scrum.dominio.Resultado#Errores()}.
     */
    public final void testErrores() {
        assertEquals(resultado.Errores().size(), 0);
        resultado.AgregarError("1","error 1");
        assertEquals(resultado.Errores().size(), 1);
        resultado.AgregarError("2","error 2");
        resultado.AgregarError("3","error 3");
        assertEquals(resultado.Errores().size(), 3);
    }

    /**
     * Test method for {@link pp2.scrum.dominio.Resultado#HayErrores()}.
     */
    public final void testHayErrores() {
        assertFalse(resultado.HayErrores());
        resultado.AgregarError("1","error 1");
        resultado.AgregarError("2","error 2");
        resultado.AgregarError("3","error 3");
        assertTrue(resultado.HayErrores());
    }

    /**
     * Test method for {@link pp2.scrum.dominio.Resultado#AgregarError(java.lang.String, java.lang.String)}.
     */
    public final void testAgregarError() {
        resultado.AgregarError("1","error 1");
        resultado.AgregarError("2","error 2");
        Map<String,String> errores =resultado.Errores();
        assertTrue(errores.get("1").equals("error 1"));
        assertTrue(errores.get("2").equals("error 2"));
        assertEquals(errores.size(),2);
        
    }

}
