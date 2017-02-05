package pp2.scrum.view;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.UserStory;

public class UserStoryPaginadoViewTest extends TestCase {
    private UserStoryPaginadoController controller;
    Backlog modelo;

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
        modelo = new Backlog();
        controller = new UserStoryPaginadoController(modelo);
    }

    public void testMainUserStoryMain() {
        UserStoryPaginadoView vista = new UserStoryPaginadoView(controller);
        modelo.addUserStory(new UserStory("user1", "detalle1"));
        modelo.addUserStory(new UserStory("user2", "detalle2"));
        modelo.addUserStory(new UserStory("user3", "detalle3"));
        modelo.addUserStory(new UserStory("user4", "detalle4"));
        modelo.addUserStory(new UserStory("user5", "detalle5"));
        modelo.addUserStory(new UserStory("user6", "detalle6"));
        vista.limpiarLista();
    }

}
