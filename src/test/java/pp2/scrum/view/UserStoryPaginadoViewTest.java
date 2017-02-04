package pp2.scrum.view;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;

public class UserStoryPaginadoViewTest extends TestCase {
    private UserStoryPaginadoController controller;
    private List<UserStory> model;

    public UserStoryPaginadoViewTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(UserStoryPaginadoViewTest.class);
    }

    protected void setUp() {
        controller = new UserStoryPaginadoController();
        model = new ArrayList<UserStory>();

    }

    public void testMainUserStoryMain() {
        UserStoryPaginadoView vista = new UserStoryPaginadoView(controller,
                model);
        assertTrue(true);
        vista.update(null, new Tarea());
        vista.agregarHistoria(new UserStory("user1", "detalle1"));
        vista.agregarHistoria(new UserStory("user2", "detalle2"));
        vista.agregarHistoria(new UserStory("user3", "detalle3"));
        vista.agregarHistoria(new UserStory("user4", "detalle4"));
        vista.agregarHistoria(new UserStory("user5", "detalle5"));
        vista.agregarHistoria(new UserStory("user6", "detalle6"));
        vista.limpiarLista();
    }

}
