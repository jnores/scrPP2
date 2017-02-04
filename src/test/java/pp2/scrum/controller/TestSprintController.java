/**
 * 
 */
package pp2.scrum.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;

/**
 * @author yoshknight
 *
 */
public class TestSprintController extends TestCase {
    Tarea t1b;
    SprintController controller;

    /**
     * @param name
     */
    public TestSprintController(String name) {
        super(name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        Backlog stories = new Backlog();

        Tarea t1a = new Tarea("tarea a de us 1");
        t1b = new Tarea("tarea b de us 1");
        List<Tarea> tareas1 = new ArrayList<Tarea>();
        tareas1.add(t1a);
        tareas1.add(t1b);

        Tarea t2a = new Tarea("tarea a de us 2");
        Tarea t2b = new Tarea("tarea b de us 2");
        List<Tarea> tareas2 = new ArrayList<Tarea>();
        tareas2.add(t2a);
        tareas2.add(t2b);

        stories.addUserStory(new UserStory("Titulo1", "Detalle1", 5, null, tareas1));
        stories.addUserStory(new UserStory("Titulo2", "Detalle2", 10, null, tareas2));

        Sprint sprint = new Sprint(1, new Date(), 21, stories);
        controller = new SprintController(sprint);
    }

    /**
     * Se consulta por una historia que pertenezca a alguna de las User Stories
     * del sprint. Se espera que no se generen excepiones ni errores
     */
    public void testHistoriaExistente() {
        try {
            controller.getEstadoTarea(t1b);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    /**
     * Se consulta por una historia que no pertenezca a ninguna de las User
     * Stories del sprint. Se espera que se generé una excepcion
     */
    public void testHistoriaNoExistente() {
        Tarea tareaNoCargada = new Tarea("Tarea No Cargada");
        try {
            controller.getEstadoTarea(tareaNoCargada);
            assertTrue(false);
        } catch (InvalidParameterException e) {
        } catch (Exception e) {
            assertTrue(false);
        }
    }

}
