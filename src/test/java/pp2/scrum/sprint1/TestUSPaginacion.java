package pp2.scrum.sprint1;

import junit.framework.TestCase;

public class TestUSPaginacion extends TestCase {

    public TestUSPaginacion(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Debe poder visualizarse el número de página actual / cantidad de páginas 
     * totales.
     */
    public void testCantidadPaginas() {
        assertTrue(false);
    }
    
    /**
     * Existe una botonera para las paginas, y sus botones se pueden grisear
     * (deshabilitar).
     */
    public void testdeshabilitarControles() {
        assertTrue(false);
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
