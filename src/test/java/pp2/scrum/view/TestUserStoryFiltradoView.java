/**
 * 
 */
package pp2.scrum.view;

import junit.framework.TestCase;
import pp2.scrum.controller.UserStoryFiltradoController;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.UserStory;

/**
 * @author yoshknight
 *
 */
public class TestUserStoryFiltradoView extends TestCase {
    UserStoryFiltradoController usfcCargado;

    /**
     * @param name
     */
    public TestUserStoryFiltradoView(String name) {
        super(name);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        
        Backlog backlogCargado = new Backlog();
        backlogCargado.addUserStory( new UserStory( 3, "Como gerente de finanzas necesito...", "detalle Gerente...") );
        backlogCargado.addUserStory( new UserStory( 2, "Como administrador necesito poder generar un reporte ...", "detalle Administrador...") );
        backlogCargado.addUserStory( new UserStory( 1, "Como recepcionista necesito...", "detalle Recepcionista...") );
        
        usfcCargado = new UserStoryFiltradoController(backlogCargado);
        

    }
    
    public void testInitView() {
        UserStoryFiltradoView view = new UserStoryFiltradoView(usfcCargado);
        view.update(null, null);
        view.dispose();
    }

}
