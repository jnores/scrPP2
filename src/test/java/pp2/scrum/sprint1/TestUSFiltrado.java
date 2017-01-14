package pp2.scrum.sprint1;

import junit.framework.TestCase;

public class TestUSFiltrado extends TestCase {

    public TestUSFiltrado(String name) {
        super(name);
    }

    /**
     * Las user Stories son las siguientes:
     * ""#2- Como administrador necesito poder generar un reporte ...""
     * ""#3- Como gerente de finanzas necesito...""
     * ""#1- Como recepcionista necesito...""
     */
    protected void setUp() throws Exception {
        super.setUp();
    }
    

    /**
     * Si el listado de Users Stories está vacío, las opciones de filtrado 
     * estarán des-habilitadas.
     */
    public void testFiltradorConlistaVacia() {
        assertTrue(false);
    }
    
    /**
     * Si el filtro no tiene resultados se mostrara el listado vacío.
     */
    public void testFiltroSinResultados() {
        assertTrue(false);
    }

    
    /**
     * "Si se filtra por historia con la palabra ""administrador"".
     + El resultado será una lista con un solo registro, la historia #2."
     */
    public void testFiltroConUnResultado() {
        assertTrue(false);
    }


}
