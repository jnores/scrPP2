/**
 * 
 */
package pp2.scrum.verificarSprint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import pp2.scrum.busEvent.BusEventSync;
import pp2.scrum.controller.EventBus;
import pp2.scrum.controller.Notificador;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.Calendario;

/**
 * @author yoshknight
 *
 */
public class VerificarRetrasoTest extends TestCase {
    Tarea t1a,t1b
            ,t2a,t2b
            ,t3a,t3b
            ,t4a,t4b;
    Sprint sprintAvanzado,sprintNuevo;
    boolean notificado;
    EventBus bus;
    
    /**
     * @param name
     */
    public VerificarRetrasoTest(String name) {
        super(name);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
         
        List<UserStory> stories = new ArrayList<UserStory>();
        
        t1a = new Tarea("tarea a de us 1");
        t1b = new Tarea("tarea b de us 1");
        List<Tarea> tareas1 = new ArrayList<Tarea>();
        tareas1.add(t1a);
        tareas1.add(t1b);

        t2a = new Tarea("tarea a de us 2");
        t2b = new Tarea("tarea b de us 2");
        List<Tarea> tareas2 = new ArrayList<Tarea>();
        tareas2.add(t2a);
        tareas2.add(t2b);

        t3a = new Tarea("tarea a de us 3");
        t3b = new Tarea("tarea b de us 3");
        List<Tarea> tareas3 = new ArrayList<Tarea>();
        tareas3.add(t3a);
        tareas3.add(t3b);

        t4a = new Tarea("tarea a de us 4");
        t4b = new Tarea("tarea b de us 4");
        List<Tarea> tareas4 = new ArrayList<Tarea>();
        tareas4.add(t4a);
        tareas4.add(t4b);
        
        stories.add(new UserStory("Titulo1", "Detalle1",  5, null, tareas1));
        stories.add(new UserStory("Titulo2", "Detalle2", 10, null, tareas2));
        stories.add(new UserStory("Titulo3", "Detalle3", 10, null, tareas3));
        stories.add(new UserStory("Titulo4", "Detalle4",  5, null, tareas4));
        

        Date inicio = new Date(System.currentTimeMillis() - 6*Calendario.DAY);
        
        sprintAvanzado = new Sprint(2, inicio,10,stories);
        sprintNuevo = new Sprint(3, new Date() ,10,stories);
        
        notificado = false;
        bus = new BusEventSync();
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.VerificarRetraso#VerificarRetraso(pp2.scrum.dominio.entidad.Sprint)}.
     */
    public final void testVerificarRetraso() {
        assertFalse(notificado);
        bus.register(new NotificarRetraso(new NotificadorMock()));
        // TODO Aca se debe cambiar el estado de las tareas necesarias para 
        // simular el avance del proyecto.
        sprintAvanzado.changeEstadoTarea(t1a,Estado.Done);
        sprintAvanzado.changeEstadoTarea(t1b,Estado.Done);
        sprintAvanzado.changeEstadoTarea(t2a,Estado.Done);
        sprintAvanzado.changeEstadoTarea(t2b,Estado.Done);
        
        new VerificarRetraso(sprintAvanzado, bus ).run();
        assertTrue(notificado);
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.VerificarRetraso#run()}.
     */
    public final void testVerificarRetrasoOk() {
        bus.register(new NotificarRetraso(new NotificadorMock()));
        // TODO Aca se debe cambiar el estado de las tareas necesarias para 
        // simular el avance del proyecto.
        sprintAvanzado.changeEstadoTarea(t2a,Estado.Done);
        sprintAvanzado.changeEstadoTarea(t2b,Estado.Done);
        sprintAvanzado.changeEstadoTarea(t3a,Estado.Done);
        sprintAvanzado.changeEstadoTarea(t3b,Estado.Done);
        
        new VerificarRetraso(sprintAvanzado, bus ).run();
        assertFalse(notificado);
    }
    
    /**
     * Test method for {@link pp2.scrum.verificarSprint.VerificarRetraso#run()}.
     */
    public final void testVerificarRetrasoNew() {
        bus.register(new NotificarRetraso(new NotificadorMock()));
        new VerificarRetraso(sprintNuevo, bus ).run();
        assertFalse(notificado);
    }
    
    private class NotificadorMock implements Notificador {

        @Override
        public void sendMail(String destino, String asunto, String mensaje) {
            System.out.println("<NotificadorMock>");
            System.out.println("\t<Destino>"+destino+"</Destino>");
            System.out.println("\t<Asunto>" +asunto+"</Asunto>");
            System.out.println("\t<Mensaje>"+mensaje+"</Mensaje>");
            System.out.println("</NotificadorMock>");
            notificado=true;
        }
        
    }

}
