package pp2.scrum.sprint1;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import junit.framework.TestCase;
import pp2.scrum.controller.UserStoryOrdenadoController;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryComparator;

public class TestUSOrdenado extends TestCase implements Observer {

    UserStoryOrdenadoController usocVacio;
    UserStoryOrdenadoController usocCargado;
    boolean observerUpdate;
    
    public TestUSOrdenado(String name) {
        super(name);
    }

    /**
     * Las user Stories son las siguientes:
     * "#2- Como administrador necesito poder generar un reporte ..."
     * "#3- Como gerente de finanzas necesito..."
     * "#1- Como recepcionista necesito..."
     */
    protected void setUp() throws Exception {
        super.setUp();
        
        Backlog backlogVacio = new Backlog();
        
        Backlog backlogCargado = new Backlog();
        backlogCargado.addUserStory( new UserStory( 3, "Como gerente de finanzas necesito...", "detalle Gerente...") );
        backlogCargado.addUserStory( new UserStory( 2, "Como administrador necesito poder generar un reporte ...", "detalle Administrador...") );
        backlogCargado.addUserStory( new UserStory( 1, "Como recepcionista necesito...", "detalle Recepcionista...") );
        
        

        usocVacio = new UserStoryOrdenadoController(backlogVacio);
        backlogVacio.addObserver(this);
        usocCargado = new UserStoryOrdenadoController(backlogCargado);
        backlogCargado.addObserver(this);
        observerUpdate = false;
        
    }
    
    /**
     * Si el listado esta vacío, las opciones de ordenamiento estarán 
     * des-habilitadas
     */
    public void testOrdenadorConlistaVacia() {
        assertFalse(usocVacio.isEnabled());
        assertFalse(observerUpdate);
    }
    
    /**
     * Teniendo la lista detallada en la historia de filtro, si se ordena 
     * por "Número" de historia se obtendrá la siguiente lista:
     * "#1- Como recepcionista..."
     * "#2- Como administrador..."
     * "#3- Como gerente de finanzas..."
     */
    public void testOrdenPorNumero() {
        assertTrue(usocCargado.isEnabled());
        
        List<UserStory> model = usocCargado.getData();
        assertEquals(model.size(), 3);
        assertEquals(model.get(0).getId(), 3);
        assertEquals(model.get(1).getId(), 2);
        assertEquals(model.get(2).getId(), 1);
        
        usocCargado.orderBy(UserStoryComparator.NUMERO_SORT);
        
//        
//        assertTrue(observerUpdate);
        
        model = usocCargado.getData();
        assertEquals(model.size(), 3);
        
        assertEquals(model.get(0).getId(), 1);
        assertEquals(model.get(1).getId(), 2);
        assertEquals(model.get(2).getId(), 3);
    }
    
    /**
     * Si se ordena por "Titulo" (historia): 
     * "#2- Como administrador..."
     * "#3-Como gerente de finanzas..." 
     * "#1- Como recepcionista..."
     */
    public void testOrdenPorTitulo() {
        assertTrue(usocCargado.isEnabled());
        
        List<UserStory> model = usocCargado.getData();
        assertEquals(model.size(), 3);
        
        assertEquals(model.get(0).getId(), 3);
        assertEquals(model.get(1).getId(), 2);
        assertEquals(model.get(2).getId(), 1);
        
        usocCargado.orderBy(UserStoryComparator.TITULO_SORT);
        
//        assertTrue(observerUpdate);
        
        model = usocCargado.getData();
        assertEquals(model.size(), 3);
        
        assertEquals(model.get(0).getId(), 2);
        assertEquals(model.get(1).getId(), 3);
        assertEquals(model.get(2).getId(), 1);
        
    }

    @Override
    public void update(Observable o, Object arg) {
        observerUpdate = true;
        
    }

}
