/**
 * 
 */
package pp2.scrum.utils;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import pp2.scrm.calendario.Calendario;

/**
 * @author yoshknight
 *
 */
public class CalendarioTest extends TestCase {

    Calendario calendario;
    /**
     * @param name
     */
    public CalendarioTest(String name) {
        super(name);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        calendario = new Calendario();
    }

    public void testCAlendario() {
        calendario = new Calendario();
    }

    public void testGetFechaIntermedia() {
        Calendar c1 = Calendar.getInstance();
        c1.set(2016, 0 , 1); // 2016 enero 1
        Date inicio = c1.getTime();
        c1.add(Calendar.DATE,20); // 2016 enero 21
        Date fin = c1.getTime();
        c1.set(2016, 0 , 11); // 2016 enero 11
        Date medio = c1.getTime();

        assertEquals(medio.getTime(),calendario.getFechaIntermedia(inicio,fin).getTime());
    }

    public void testGetDuracion() {
        int duracion = 20;
        Calendar c1 = Calendar.getInstance();
        c1.set(2016, 0 , 1); // 2016 enero 1
        Date inicio = c1.getTime();
        c1.add(Calendar.DATE,duracion); // 2016 enero 21
        Date fin = c1.getTime();

        assertEquals(duracion,calendario.getDuracion(inicio,fin));
    }

    public void testAgregarDias() {
        Calendar c1 = Calendar.getInstance();
        c1.set(2016, 0 , 1); // 2016 enero 1
        Date inicio = c1.getTime();
        c1.set(2016, 0 , 11); // 2016 enero 1
        Date fin = c1.getTime();
        

        assertTrue(fin.equals(calendario.agregarDias(inicio,10)) );
    }




}
