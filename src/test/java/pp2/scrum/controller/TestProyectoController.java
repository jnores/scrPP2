/**
 * 
 */
package pp2.scrum.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import junit.framework.TestCase;
import pp2.mock.scrum.dao.MockProyectoDAO;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;

/**
 * @author yoshknight
 *
 */
public class TestProyectoController extends TestCase {
    ProyectoController controller;

    /**
     * @param name
     */
    public TestProyectoController(String name) {
        super(name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        controller = new ProyectoController(
                new Proyecto(1, "testPryectoController"),
                new MockProyectoDAO());
    }

    /**
     * Test method for
     * {@link pp2.scrum.controller.ProyectoController#ProyectoController(pp2.scrum.model.Proyecto, pp2.scrum.dao.ProyectoDAO)}
     * .
     */
    public final void testProyectoController() {
        assertFalse(null == controller);
    }

    /**
     * Test method for
     * {@link pp2.scrum.controller.ProyectoController#getBacklog()}.
     */
    public final void testGetBacklog() {
        assertEquals(controller.getBacklog().size(), 0);
    }

    /**
     * Test method for
     * {@link pp2.scrum.controller.ProyectoController#agregarUserStory(pp2.scrum.model.UserStory)}
     * .
     */
    public final void testAgregarUserStory() {
        controller.agregarUserStory(new UserStory("titulo","Detalle"));
        try {
            controller.agregarUserStory(null);
            fail("No se genero la excepcion esperada");
        } catch (InvalidParameterException e) {
        } catch (Exception e) {
            fail("Se genero una exceocion no esperada");
        }
    }

    /**
     * Test method for
     * {@link pp2.scrum.controller.ProyectoController#altaUserStory(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.util.ArrayList)}
     * .
     */
    public final void testAltaUserStory() {
        controller.altaUserStory("titulo", "Detalle", "Criterios", 40, new ArrayList<Tarea>());
    }

    /**
     * Test method for
     * {@link pp2.scrum.controller.ProyectoController#obtenerSugerenciaTitulo(java.lang.String)}
     * .
     */
    public final void testObtenerSugerenciaTitulo() {
        controller.obtenerSugerenciaTitulo("testSugerenciaTitulo");
    }

    /**
     * Test method for
     * {@link pp2.scrum.controller.ProyectoController#obtenerSugerenciaCriterio(java.lang.String)}
     * .
     */
    public final void testObtenerSugerenciaCriterio() {
        controller.obtenerSugerenciaCriterio("testSugerenciaCriterio");
    }

    /**
     * Test method for
     * {@link pp2.scrum.controller.ProyectoController#save(pp2.scrum.model.Proyecto)}
     * .
     */
    public final void testSave() {
        controller.save(new Proyecto(2,"nuevo"));
    }

    /**
     * Test method for
     * {@link pp2.scrum.controller.ProyectoController#getCurrentSprint()}.
     */
    public final void testGetCurrentSprint() {
        Sprint sprint = controller.getCurrentSprint();
        assertNull(sprint);
        
    }

}
