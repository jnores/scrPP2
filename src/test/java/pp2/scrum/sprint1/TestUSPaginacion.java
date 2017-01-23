package pp2.scrum.sprint1;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import junit.framework.TestCase;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.Paginacion;

// TODO Implementar esto con BACKLOG Y OBSERVER en lugar de usar una lista 
// -- JN 20170123
public class TestUSPaginacion extends TestCase implements Observer{

    UserStoryPaginadoController controllerVacio, 
                                        controller3Historias, 
                                        controller5Historias,
                                        controller13Historias,
                                        controller13HistoriasFinal;
    Backlog backlog5Historias;
    boolean observerUpdate;
    
    public TestUSPaginacion(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        controllerVacio = new UserStoryPaginadoController();
        
        List<UserStory> historias = new ArrayList<>();
        historias.add(new UserStory(1, "t1", "d1"));
        historias.add(new UserStory(2, "t2", "d2"));
        historias.add(new UserStory(3, "t3", "d3"));
        controller3Historias = new UserStoryPaginadoController(
                    new Paginacion<UserStory>( 1, 5,historias)
                );
        
        List<UserStory> historias13 = new ArrayList<>();
        historias13.add(new UserStory(1,"t1","d1"));
        historias13.add(new UserStory(2,"t2","d2"));
        historias13.add(new UserStory(3,"t3","d3"));
        historias13.add(new UserStory(4,"t4","d4"));
        historias13.add(new UserStory(5,"t5","d5"));
        historias13.add(new UserStory(6,"t6","d6"));
        historias13.add(new UserStory(7,"t7","d7"));
        historias13.add(new UserStory(8,"t8","d8"));
        historias13.add(new UserStory(9,"t9","d9"));
        historias13.add(new UserStory(10,"t10","d10"));
        historias13.add(new UserStory(11,"t11","d11"));
        historias13.add(new UserStory(12,"t12","d12"));
        historias13.add(new UserStory(13,"t13","d13"));
        controller13Historias = new UserStoryPaginadoController(
                new Paginacion<UserStory>( 1, 5,historias13)
            );
        controller13HistoriasFinal = new UserStoryPaginadoController(
                new Paginacion<UserStory>( 3, 5,historias13)
            );
        
        backlog5Historias = new Backlog();
        List<UserStory> historias5 = new ArrayList<>();
        historias5.add(new UserStory(1,"t1","d1"));
        historias5.add(new UserStory(2,"t2","d2"));
        historias5.add(new UserStory(3,"t3","d3"));
        historias5.add(new UserStory(4,"t4","d4"));
        historias5.add(new UserStory(5,"t5","d5"));
        controller5Historias = new UserStoryPaginadoController(
                new Paginacion<UserStory>( 1, 5,historias5)
            );
        
        observerUpdate = false;
    }

    /**
     * Debe poder visualizarse el número de página actual / cantidad de páginas 
     * totales.
     */
    public void testCantidadPaginas() {
        
        assertEquals(controllerVacio.getPaginasTotales(), 0);
        assertEquals(controller13Historias.getPaginasTotales(), 3);
        
        assertTrue( controller13Historias.toString().trim().equals("1 / 3") );
        
    }
    
    /**
     * Existe una botonera para las paginas, y sus botones se pueden grisear
     * (deshabilitar).
     */
    public void testDeshabilitarControles() {
        assertFalse(controllerVacio.isEnabled());
        
        assertFalse(controllerVacio.hasNext());
        assertFalse(controllerVacio.hasPrev());
        
        // ----------------------------------
        assertTrue(controller13Historias.isEnabled());
        
        assertTrue(controller13Historias.hasNext());
        assertFalse(controller13Historias.hasPrev());
    }
    
    /**
     * De no existir ninguna historia cargada, la pantalla mostrará una tabla
     * con una fila que contendrá el mensaje:"No hay ninguna historia", con un
     * número de paginas al pie igual a "-" y los botones de navegacion de 
     * páginas grisados.
     */
    public void testListaVacia() {        
        assertTrue( controllerVacio.toString().trim().equals("-") );
        
        assertFalse(controllerVacio.hasNext());
        assertFalse(controllerVacio.hasPrev());
        
        // TODO Pedir los Datos y validar el mensaje a mostrar. JN 20170122
    }
    
    /**
     * Si se tienen menos de 5 historias, no deberán mostrarse filas vacias en
     * la tabla.
     */
    public void testEspacioDisponiblesEnPagina() {
        assertEquals(3, controller3Historias.obtenerPaginacionActual().size());
    }
    
    /**
     * Si se tienen 5 o menos historias, pulsar los botones de navegación de 
     * páginas no tendrá ningún efecto.
     */
    public void testUnaSolaPagina() {
        assertTrue(controller5Historias.isEnabled());
        
        assertFalse(controller5Historias.hasNext());
        assertFalse(controller5Historias.hasPrev());
    }
    
    /**
     * Si tengo 5 , al agregar una nueva, se deberá visualizar una página con 5 
     * registros y la siguiente con 1.
     */
    public void testAgregarUserStoryConPaginaLlena() {
        assertTrue(controller5Historias.isEnabled());
        
        assertFalse(observerUpdate);
        
        assertFalse(controller5Historias.hasNext());
        assertFalse(controller5Historias.hasPrev());
        assertEquals(1, controller5Historias.getPaginasTotales());
        
        
        backlog5Historias.addUserStory(new UserStory(6,"t6","d5"));
        assertTrue(observerUpdate);
        
        assertTrue(controller5Historias.hasNext());
        assertFalse(controller5Historias.hasPrev());
        assertEquals(2, controller5Historias.getPaginasTotales());
        
    }
    
    /**
     * Si tengo más de 10, estando en la 1º página saltar a la siguiente lleva 
     * a la página 2.
     */
    public void testPaginaSiguiente() {
        assertEquals(3, controller13Historias.getPaginasTotales());
        assertEquals(1, controller13Historias.getPaginaActual());
        
        controller13Historias.obtenerPaginacionSiguiente();
        
        assertEquals(2, controller13Historias.getPaginaActual());
    }
    
    /**
     * Si tengo más de 10, estando en la 1º página si se salta a la última 
     * lleva a la 3.
     */
    public void testUltimaPagina() {
        assertEquals(3, controller13Historias.getPaginasTotales());
        assertEquals(1, controller13Historias.getPaginaActual());
        
        controller13Historias.obtenerPaginacionUltima();
        
        assertEquals(3, controller13Historias.getPaginaActual());
    }
    
    /**
     * Si tengo más de 10, estando en la 3º página saltar a la anterior lleva 
     * a la página 2.
     */
    public void testPaginaAnterior() {
        assertEquals(3, controller13HistoriasFinal.getPaginasTotales());
        assertEquals(3, controller13HistoriasFinal.getPaginaActual());
        
        controller13HistoriasFinal.obtenerPaginacionAnterior();
        
        assertEquals(2, controller13HistoriasFinal.getPaginaActual());
    }
    
    /**
     * Si tengo más de 10, estando en la 3º página si se salta a la primera 
     * lleva a la 1.
     */
    public void testPrimerPagina() {
        assertEquals(3, controller13HistoriasFinal.getPaginasTotales());
        assertEquals(3, controller13HistoriasFinal.getPaginaActual());
        
        controller13HistoriasFinal.obtenerPaginacionPrimera();
        
        assertEquals(1, controller13HistoriasFinal.getPaginaActual());
    }

    @Override
    public void update(Observable o, Object arg) {
        observerUpdate = true;
        
    }
}
