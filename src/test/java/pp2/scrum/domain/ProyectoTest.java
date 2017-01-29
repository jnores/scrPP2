package pp2.scrum.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.mock.scrum.dao.MockProyectoDAO;
import pp2.scrm.calendario.Calendario;
import pp2.scrum.burndownChart.DataComposite;
import pp2.scrum.model.Miembro;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;

public class ProyectoTest extends TestCase {

    Proyecto proyecto;
    Miembro miembro1, miembro2;
    UserStory userStory1, userStory2, userStory3, userStory4;

    Calendario calendario;

    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public ProyectoTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ProyectoTest.class);
    }

    public void setUp() {
        calendario = new Calendario();
        miembro1 = new Miembro("Victoria", "Desarrollador");
        miembro2 = new Miembro("Ivo", "Diseñador");
        userStory1 = new UserStory("Titulo1", "Detalle1");// ,miembro1);
        userStory2 = new UserStory("Titulo2", "Detalle2");// ,miembro1);
        userStory3 = new UserStory("Titulo3", "Detalle3");// ,miembro2);
        userStory4 = new UserStory("Titulo4", "Detalle4");// ,miembro2);

        proyecto = new Proyecto(1, "test");
        proyecto.addMiembro(miembro1);
        proyecto.addMiembro(miembro2);

        proyecto.addUserStory(userStory1);
        proyecto.addUserStory(userStory2);
        proyecto.addUserStory(userStory3);
        proyecto.addUserStory(userStory4);

        proyecto.asignarUserStory(userStory2, miembro1);
        proyecto.asignarUserStory(userStory4, miembro2);

    }

    /**
     * Verifico que se asignen bien los atributos en el setUp
     */
    public void testPryecto() {

        Collection<Miembro> miembros = this.proyecto.getMiembros();
        assertEquals(miembros.size(), 2);

        // ProyectoNuevoView p = new ProyectoNuevoView(null);

    }

    // /**
    // * Verifico que se puedan obtener las user stories asignadas al proyecto.
    // */
    // public void testProyectoGetUserStories() {
    // Collection<UserStory> userStories = this.proyecto.getAllUserStories();
    // assertEquals(userStories.size(),4);
    //
    // Collection<UserStory> userStoriesFromMiembro1=
    // this.proyecto.getAllUserStoriesFromMiembro(miembro1);
    // assertEquals(userStoriesFromMiembro1.size(),1);
    // assertTrue(userStoriesFromMiembro1.contains(userStory2));
    // }

    /**
     * Verifico que se puedan obtener las Miembros pos su nombre
     */
    public void testProyectoGetMiembro() {
        Miembro miembro = this.proyecto.getMiembroPorNombre("Ivo");
        assertEquals(miembro, this.miembro2);

    }

    public void testPryectoDAO() {

        MockProyectoDAO mockProyecto = new MockProyectoDAO();
        assertTrue(mockProyecto.getById(1) != null);
        assertEquals(mockProyecto.guardar(proyecto), 1);
        Collection<Miembro> miembros = this.proyecto.getMiembros();
        assertEquals(miembros.size(), 2);

    }

    public void testPryectoEntidad() {
        Set<Miembro> miembros = new HashSet<>();
        List<Sprint> iteraciones = new ArrayList<>();
        List<UserStory> historias = new ArrayList<>();
        miembros.add(miembro1);
        userStory1.setId(2);
        historias.add(userStory1);
        historias.add(userStory2);
        Date manana = calendario.agregarDias(new Date(), -1);
        iteraciones.add(new Sprint(1, manana, 14, historias));
        Proyecto proyecto = new Proyecto(0, "P1", historias, miembros,
                iteraciones, new HashMap<UserStory, Miembro>());

        // assertEquals(proyecto.getAllUserStories().size(),4);
        assertTrue(proyecto.getMiembroPorNombre("Victoria") != null);
        proyecto.getUserStoryPorId(-1);
        proyecto.asignarUserStory(userStory1, miembro1);
        proyecto.getResponsable(userStory1);
        proyecto.setNombre("n1");
        assertEquals(proyecto.getSiguienteStoryID(), 3);
        assertTrue(proyecto.iteracionActual() != null);
        // iteraciones.get(0).stateStory(userStory1);

        DataComposite compo = new DataComposite(iteraciones.get(0));
        compo.addData(compo);

    }
}