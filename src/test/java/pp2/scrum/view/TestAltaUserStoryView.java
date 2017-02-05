/**
 * 
 */
package pp2.scrum.view;

import junit.framework.TestCase;
import pp2.mock.scrum.dao.MockProyectoDAO;
import pp2.scrum.controller.ProyectoController;
import pp2.scrum.model.Proyecto;

/**
 * @author yoshknight
 *
 */
public class TestAltaUserStoryView extends TestCase {
    ProyectoController controller;
    /**
     * @param name
     */
    public TestAltaUserStoryView(String name) {
        super(name);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        new Proyecto(1, "Test 1");
        controller = new ProyectoController(
                new Proyecto(1, "Test 1"), new MockProyectoDAO());
    }

    /**
     * Test method for {@link pp2.scrum.view.AltaUserStoryView#AltaUserStoryView(pp2.scrum.controller.UserStoryController)}.
     */
    public final void testAltaUserStoryView() {
        new AltaUserStoryView(controller);
        
    }

}
