package pp2.scrum.sprint1;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import pp2.scrum.controller.UserStoryFiltradoController;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryFilter;
import pp2.scrum.view.ListaUserStoryView;

public class TestUSFiltrado extends TestCase implements ListaUserStoryView {

    UserStoryFiltradoController usfcVacio;
    UserStoryFiltradoController usfcCargado;
    List<UserStory> model;
    
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
        List<UserStory> listaVacia = new ArrayList<>();
        List<UserStory> listaCargada = new ArrayList<>();
        listaCargada.add( new UserStory( 3, "Como gerente de finanzas necesito...", "detalle Gerente...") );
        listaCargada.add( new UserStory( 2, "Como administrador necesito poder generar un reporte ...", "detalle Administrador...") );
        listaCargada.add( new UserStory( 1, "Como recepcionista necesito...", "detalle Recepcionista...") );
        
        usfcVacio = new UserStoryFiltradoController(listaVacia,this);
        usfcCargado = new UserStoryFiltradoController(listaCargada,this);
    }
    

    /**
     * Si el listado de Users Stories está vacío, las opciones de filtrado 
     * estarán des-habilitadas.
     */
    public void testFiltradorConlistaVacia() {
        assertFalse(usfcVacio.isEnabled());
    }
    
    /**
     * Si el filtro no tiene resultados se mostrara el listado vacío.
     */
    public void testFiltroSinResultados() {
        assertTrue(usfcCargado.isEnabled());
        
        assertEquals(model.get(0).getId(), 3);
        assertEquals(model.get(1).getId(), 2);
        assertEquals(model.get(2).getId(), 1);
        
        usfcCargado.filtrarPor(UserStoryFilter.TITULO,"Filtro sin resultados");
        
        assertEquals(model.size(), 0);
        
    }

    
    /**
     * Si se filtra por historia/titulo con la palabra "administrador".
     + El resultado será una lista con un solo registro, la historia #2.
     */
    public void testFiltroConUnResultado() {
        assertTrue(usfcCargado.isEnabled());
        
        assertEquals(model.get(0).getId(), 3);
        assertEquals(model.get(1).getId(), 2);
        assertEquals(model.get(2).getId(), 1);
        
        usfcCargado.filtrarPor(UserStoryFilter.TITULO,"administrador");
        
        assertEquals(model.size(), 1);
        assertEquals(model.get(0).getId(), 2);
    }

    @Override
    public void actualizarModelo(List<UserStory> modelo) {
        this.model = modelo;
    }


}
