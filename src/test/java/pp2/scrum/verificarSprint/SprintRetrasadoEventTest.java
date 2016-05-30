/**
 * 
 */
package pp2.scrum.verificarSprint;

import junit.framework.TestCase;

/**
 * @author yoshknight
 *
 */
public class SprintRetrasadoEventTest extends TestCase {
    SprintRetrasadoEvent evento;
    String titulo, detalle;
    /**
     * @param name
     */
    public SprintRetrasadoEventTest(String name) {
        super(name);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        titulo  = "Evento de prueba";
        detalle = "Detalle de prueba";
                
        evento = new SprintRetrasadoEvent(this,titulo,detalle);
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.SprintRetrasadoEvent#SprintRetrasadoEvent(java.lang.Object, java.lang.String, java.lang.String)}.
     */
    public final void testSprintRetrasadoEvent() {
        new SprintRetrasadoEvent(this,titulo,detalle);
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.SprintRetrasadoEvent#getTitulo()}.
     */
    public final void testGetTitulo() {
        assertTrue(evento.getTitulo().equals(titulo));
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.SprintRetrasadoEvent#getDetalle()}.
     */
    public final void testGetDetalle() {
        assertTrue(evento.getDetalle().equals(detalle));
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.SprintRetrasadoEvent#toString()}.
     */
    public final void testToString() {
        assertTrue(evento.toString().equals(titulo));
    }

}
