package pp2.scrum.sprint1;

import junit.framework.TestCase;

public class TestUSGestionDeEstados extends TestCase {

    public TestUSGestionDeEstados(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Si se crea una tarea, por defecto, la misma debe estar en estado "ToDo".
     */
    public void testEstadoPorDefecto() {
        assertTrue(false); 
    }
    
    /**
     * Si paso una tarea de estado "ToDo" al siguiente estado, debe figurar en 
     * estado "doing"
     */
    public void testSiguienteEstadoFromToDo() {
        assertTrue(false);
    }
    
    /**
     * Si quiero pasar al estado siguiente a una tarea que se encuentra en 
     * "done", debe generarse una excepción 
     */
    public void testSiguienteEstadoFromDone() {
        assertTrue(false);
    }
    
}
