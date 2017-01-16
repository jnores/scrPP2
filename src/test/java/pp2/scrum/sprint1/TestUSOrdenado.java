package pp2.scrum.sprint1;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import pp2.scrum.controller.UserStoryOrdenadoController;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryComparator;
import pp2.scrum.view.ListaUserStoryView;

public class TestUSOrdenado extends TestCase implements ListaUserStoryView {

    UserStoryOrdenadoController usocVacio;
    UserStoryOrdenadoController usocCargado;
    List<UserStory> model;
    
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
        List<UserStory> listaVacia = new ArrayList<>();
        List<UserStory> listaCargada = new ArrayList<>();
        listaCargada.add( new UserStory( 3, "Como gerente de finanzas necesito...", "detalle Gerente...") );
        listaCargada.add( new UserStory( 2, "Como administrador necesito poder generar un reporte ...", "detalle Administrador...") );
        listaCargada.add( new UserStory( 1, "Como recepcionista necesito...", "detalle Recepcionista...") );
        
        usocVacio = new UserStoryOrdenadoController(listaVacia,this);
        usocCargado = new UserStoryOrdenadoController(listaCargada,this);
    }
    
    /**
     * Si el listado esta vacío, las opciones de ordenamiento estarán 
     * des-habilitadas
     */
    public void testOrdenadorConlistaVacia() {
        assertFalse(usocVacio.isEnabled());
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
        
        assertEquals(model.get(0).getId(), 3);
        assertEquals(model.get(1).getId(), 2);
        assertEquals(model.get(2).getId(), 1);
        
        usocCargado.ordenarPor(UserStoryComparator.NUMERO_SORT);
        
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
        
        assertEquals(model.get(0).getId(), 3);
        assertEquals(model.get(1).getId(), 2);
        assertEquals(model.get(2).getId(), 1);
        
        usocCargado.ordenarPor(UserStoryComparator.TITULO_SORT);
        
        assertEquals(model.get(0).getId(), 2);
        assertEquals(model.get(1).getId(), 3);
        assertEquals(model.get(2).getId(), 1);
        
    }
    
    @Override
    public void actualizarModelo(List<UserStory> modelo) {
        this.model = modelo;
    }

}
