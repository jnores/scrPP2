package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.listadoHistorias.Paginacion;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;

public class UserStoryPaginadoControllerTest extends TestCase {
    private UserStoryPaginadoController controller;

    public UserStoryPaginadoControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(UserStoryPaginadoControllerTest.class);
    }

    protected void setUp() {
        controller = new UserStoryPaginadoController();
    }

    public void testUserPaginadoStoryController() {
        controller.getModel();

        assertEquals(controller.getPaginacionActual().getPagina(), 1);
        assertEquals(controller.getItemsTotales(), 0);
        assertEquals(controller.getPaginasTotales(), 0);
        assertTrue(controller.getModel() != null);
        List<UserStory> lista = controller.listarUserStories(
                new Paginacion<>(1, 5, new ArrayList<UserStory>()));
        assertEquals(lista.size(), 0);
        controller.actualizarPaginacion(null);
    }

    public void testUserPaginadoStoryPaginacion() {
        List<UserStory> listaDefault, lista;
        listaDefault = controller.listarUserStories(
                new Paginacion<>(1, 5, new ArrayList<UserStory>()));
        lista = controller.obtenerPaginacionAnterior();
        assertEquals(listaDefault.size(), lista.size());

        lista = controller.obtenerPaginacionPrimera();
        assertEquals(listaDefault.size(), lista.size());

        lista = controller.obtenerPaginacionSiguiente();
        assertEquals(controller.getPaginacionActual().getPagina(), 2);

        lista = controller.obtenerPaginacionUltima();
        assertEquals(controller.getPaginacionActual().getPagina(), 0);

        Paginacion<UserStory> paginacion = new Paginacion<>(1, 5,
                new ArrayList<UserStory>());
        listaDefault = controller.listarUserStories(paginacion);
        paginacion.paginacionSiguiente();
        assertEquals(controller.getPaginacionActual().getPagina(), 2);
        controller.getPaginacionActual().paginacionAnterior();
        assertEquals(controller.getPaginacionActual().getPagina(), 1);

        List<UserStory> historias = new ArrayList<>();
        historias.add(new UserStory("t1", "d1"));
        historias.add(new UserStory("t2", "d2"));
        historias.add(new UserStory("t3", "d3"));
        controller.actualizarPaginacion(historias);
        controller.obtenerPaginacionActual();
        controller.getPaginacionActual().listarPaginacion();
        controller.getPaginacionActual().paginacionSiguiente();
        controller.getPaginacionActual().paginacionAnterior();

    }

    public void testFinalizarStory() {
        List<UserStory> historias = new ArrayList<UserStory>();
        List<Tarea> tareas = new ArrayList<Tarea>();
        UserStory story = new UserStory("titulo1", "detalle1", 50, null,
                tareas);
        tareas.add(new Tarea());
        historias.add(story);
        controller.actualizarPaginacion(historias);
        assertFalse(controller.getModel().get(0).estaTerminada());
        controller.finalizarStory(story);
        assertTrue(controller.getModel().get(0).estaTerminada());
        assertTrue(story.estaTerminada());
    }

}
