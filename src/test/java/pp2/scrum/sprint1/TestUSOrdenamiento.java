package pp2.scrum.sprint1;

import junit.framework.TestCase;

public class TestUSOrdenamiento extends TestCase {

    public TestUSOrdenamiento(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        
    }
    
    /**
     * Si el listado esta vacío, las opciones de ordenamiento estarán 
     * des-habilitadas
     */
    public void testOrdenadorConlistaVacia() {
        
        assertTrue(false);
    }
    
    /**
     * Teniendo la lista detallada en la historia de filtro, si se ordena 
     * por "Número" de historia se obtendrá la siguiente lista:
     * "#1- Como recepcionista..."
     * "#2- Como administrador..."
     * "#3- Como gerente de finanzas..."
     */
    public void testOrdenPorNumero() {
        assertTrue(false);
    }

    
    /**
     * Si se ordena por "Titulo" (historia): 
     * "#2- Como administrador..."
     * "#3-Como gerente de finanzas..." 
     * "#1- Como recepcionista..."
     */
    public void testOrdenPorTitulo() {
        assertTrue(false);
    }

}
