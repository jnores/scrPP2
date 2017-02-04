package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.model.Miembro;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryComparator;

public class UserStoryComparatorTest extends TestCase {
    List<UserStory> stories;
    Miembro miembro1, miembro2, miembro3, miembro4;
    UserStory userStory1, userStory2, userStory3, userStory4;

    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public UserStoryComparatorTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(UserStoryComparatorTest.class);
    }

    public void setUp() {
        stories = new ArrayList<UserStory>();
        miembro1 = new Miembro("Victoria");
        miembro2 = new Miembro("Ivo");
        miembro3 = new Miembro("Jualian");
        miembro4 = new Miembro("Nores");

        userStory1 = new UserStory(1, "Como Recepcionista ...", "Detalle1");
        userStory2 = new UserStory(2, "Como Administrador ...", "Detalle2");
        userStory3 = new UserStory(3, "Como Gerente ...", "Detalle3");
        userStory4 = new UserStory(4, "Como Vendedor ...", "Detalle4");

        stories.add(userStory3);
        stories.add(userStory2);
        stories.add(userStory4);
        stories.add(userStory1);
    }

    /**
     * Verifico El orden en que estan cargadas
     */
    public void testUserStoryHelperComparator() {
        UserStory us = stories.get(0);
        assertEquals(us.getId(), userStory3.getId());

        us = stories.get(1);
        assertEquals(us.getId(), userStory2.getId());

        us = stories.get(2);
        assertEquals(us.getId(), userStory4.getId());

        us = stories.get(3);
        assertEquals(us.getId(), userStory1.getId());

    }

    /**
     * Verifico que Se ordenen por ID
     */
    public void testUserStoryHelperComparatorById() {
        Collections.sort(stories, UserStoryComparator.NUMERO_SORT);
        UserStory us;

        assertEquals(UserStoryComparator.NUMERO_SORT.toString(), "Número");

        us = stories.get(0);
        assertEquals(us.getId(), userStory1.getId());

        us = stories.get(1);
        assertEquals(us.getId(), userStory2.getId());

        us = stories.get(2);
        assertEquals(us.getId(), userStory3.getId());

        us = stories.get(3);
        assertEquals(us.getId(), userStory4.getId());

    }

    /**
     * Verifico que Se ordenen por ID
     */
    public void testUserStoryHelperComparatorByIdDesc() {
        Collections.sort(stories,
                UserStoryComparator.decending(UserStoryComparator.NUMERO_SORT));
        UserStory us;

        assertEquals(UserStoryComparator.NUMERO_SORT.toString(), "Número");

        us = stories.get(3);
        assertEquals(us.getId(), userStory1.getId());

        us = stories.get(2);
        assertEquals(us.getId(), userStory2.getId());

        us = stories.get(1);
        assertEquals(us.getId(), userStory3.getId());

        us = stories.get(0);
        assertEquals(us.getId(), userStory4.getId());
    }

    /**
     * Verifico que Se ordenen por titulo
     */
    public void testUserStoryHelperComparatorByTitulo() {
        Collections.sort(stories, UserStoryComparator.TITULO_SORT);
        UserStory us;

        assertEquals(UserStoryComparator.TITULO_SORT.toString(), "Título");

        us = stories.get(0);
        assertEquals(us.getId(), userStory2.getId());

        us = stories.get(1);
        assertEquals(us.getId(), userStory3.getId());

        us = stories.get(2);
        assertEquals(us.getId(), userStory1.getId());

        us = stories.get(3);
        assertEquals(us.getId(), userStory4.getId());

    }

    /**
     * Verifico que Se ordenen por titulo desc
     */
    public void testUserStoryHelperComparatorByTituloDesc() {
        Collections.sort(stories,
                UserStoryComparator.decending(UserStoryComparator.TITULO_SORT));
        UserStory us;

        assertEquals(UserStoryComparator.TITULO_SORT.toString(), "Título");

        us = stories.get(3);
        assertEquals(us.getId(), userStory2.getId());

        us = stories.get(2);
        assertEquals(us.getId(), userStory3.getId());

        us = stories.get(1);
        assertEquals(us.getId(), userStory1.getId());

        us = stories.get(0);
        assertEquals(us.getId(), userStory4.getId());

    }

}