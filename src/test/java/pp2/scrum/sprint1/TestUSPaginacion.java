package pp2.scrum.sprint1;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.Paginacion;

public class TestUSPaginacion extends TestCase {

    private UserStoryPaginadoController controllerVacio;
    private UserStoryPaginadoController controller2paginas;
    
    public TestUSPaginacion(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        controllerVacio = new UserStoryPaginadoController();
        List<UserStory> historias = new ArrayList<>();
        historias.add(new UserStory("t1", "d1"));
        historias.add(new UserStory("t2", "d2"));
        historias.add(new UserStory("t3", "d3"));
        controller2paginas = new UserStoryPaginadoController(
                    new Paginacion<UserStory>( 1, 2,historias)
                );
    }

    /**
     * Debe poder visualizarse el número de página actual / cantidad de páginas 
     * totales.
     */
    public void testCantidadPaginas() {
        
        assertEquals(controllerVacio.getPaginasTotales(), 0);
        assertEquals(controller2paginas.getPaginasTotales(), 2);
    }
    
    /**
     * Existe una botonera para las paginas, y sus botones se pueden grisear
     * (deshabilitar).
     */
    public void testDeshabilitarControles() {
        assertFalse(controllerVacio.isEnabled());
        
        assertTrue(controller2paginas.isEnabled());

    }
    
    /**
     * De no existir ninguna historia cargada, la pantalla mostrará una tabla
     * con una fila que contendrá el mensaje:"No hay ninguna historia", con un
     * número de paginas al pie igual a "-" y los botones de navegacion de 
     * páginas grisados.
     */
    public void testListaVacia() {
        assertTrue(false);
    }
    
    /**
     * Si se tienen menos de 5 historias, no deberán mostrarse filas vacias en
     * la tabla.
     */
    public void testEspacioDisponiblesEnPagina() {
        assertTrue(false);
    }
    
    /**
     * Si se tienen 5 o menos historias, pulsar los botones de navegación de 
     * páginas no tendrá ningún efecto.
     */
    public void testUnaSolaPagina() {
        assertTrue(false);
    }
    
    /**
     * Si tengo 5 , al agregar una nueva, se deberá visualizar una página con 5 
     * registros y la siguiente con 1.
     */
    public void testAgregarUserStoryConPaginaLlena() {
        assertTrue(false);
    }
    
    /**
     * Si tengo más de 10, estando en la 1º página saltar a la siguiente lleva 
     * a la página 2 y si se salta a la última lleva a la 3.
     */
    public void testPaginaSiguienteYUltimaagina() {
        assertTrue(false);
    }
    
    /**
     * Si tengo más de 10, estando en la 3º página saltar a la anterior lleva 
     * a la página 2 y si se salta a la primera lleva a la 1.
     */
    public void testPaginaAnteriorYPrimerPagina() {
        assertTrue(false);
    }
}
