package pp2.scrum.sprint1;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import junit.framework.TestCase;
import pp2.scrum.controller.UserStoryFiltradoController;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryFilter;

public class TestUSFiltrado extends TestCase implements Observer {

    UserStoryFiltradoController usfcVacio;
    UserStoryFiltradoController usfcCargado;
    boolean observerUpdate;
    
    public TestUSFiltrado(String name) {
        super(name);
    }

    /**
     * Las user Stories son las siguientes:
     * ""#2- Como administrador necesito poder generar un reporte ...""
     * ""#3- Como gerente de finanzas necesito...""
     * ""#1- Como recepcionista necesito...""
     */
    protected void setUp() throws Exception {
        super.setUp();

        Backlog backlogVacio = new Backlog();
        
        Backlog backlogCargado = new Backlog();
        backlogCargado.addUserStory( new UserStory( 3, "Como gerente de finanzas necesito...", "detalle Gerente...") );
        backlogCargado.addUserStory( new UserStory( 2, "Como administrador necesito poder generar un reporte ...", "detalle Administrador...") );
        backlogCargado.addUserStory( new UserStory( 1, "Como recepcionista necesito...", "detalle Recepcionista...") );        

        usfcVacio = new UserStoryFiltradoController(backlogVacio);
        usfcVacio.addObserver(this);
        usfcCargado = new UserStoryFiltradoController(backlogCargado);
        usfcCargado.addObserver(this);
        observerUpdate = false;
    }
    

    /**
     * Si el listado de Users Stories está vacío, las opciones de filtrado 
     * estarán des-habilitadas.
     */
    public void testFiltradorConlistaVacia() {
        assertFalse(usfcVacio.isEnabled());
        assertFalse(observerUpdate);
    }
    
    /**
     * Si el filtro no tiene resultados se mostrara el listado vacío.
     */
    public void testFiltroSinResultados() {
        assertTrue(usfcCargado.isEnabled());

        List<UserStory> model = usfcCargado.getData();
        assertEquals(model.size(), 3);

        assertEquals(model.get(0).getId(), 3);
        assertEquals(model.get(1).getId(), 2);
        assertEquals(model.get(2).getId(), 1);
        
        usfcCargado.filterBy(UserStoryFilter.TITULO,"Filtro sin resultados");

        model = usfcCargado.getData();        
        
        assertEquals(model.size(), 0);
        
    }

    
    /**
     * Si se filtra por historia/titulo con la palabra "administrador".
     + El resultado será una lista con un solo registro, la historia #2.
     */
    public void testFiltroConUnResultado() {
        assertTrue(usfcCargado.isEnabled());
        
        List<UserStory> model = usfcCargado.getData();
        assertEquals(model.size(), 3);
        
        assertEquals(model.get(0).getId(), 3);
        assertEquals(model.get(1).getId(), 2);
        assertEquals(model.get(2).getId(), 1);
        
        usfcCargado.filterBy(UserStoryFilter.TITULO,"administrador");

        model = usfcCargado.getData();

        assertEquals(model.size(), 1);
        assertEquals(model.get(0).getId(), 2);
    }


    @Override
    public void update(Observable o, Object arg) {
        observerUpdate = true;
        
    }

}
