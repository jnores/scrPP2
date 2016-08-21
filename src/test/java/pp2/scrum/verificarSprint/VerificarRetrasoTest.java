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
import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.Calendario;

/**
 * @author yoshknight
 *
 */
public class VerificarRetrasoTest extends TestCase {
    UserStory us1,us2,us3;
    Sprint sprintRetrasado,sprintOK,sprintNuevo;
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
         
        List<UserStory> stories1 = new ArrayList<UserStory>();
        List<UserStoryHelper> stories2 = new ArrayList<UserStoryHelper>();
        stories1.add(us3=new UserStory("Titulo1", "Detalle1",5, null, null));
        stories1.add(us1=new UserStory("Titulo2", "Detalle2", 10, null, null));
        stories1.add(us2=new UserStory("Titulo3", "Detalle3", 10, null, null));
        stories1.add(new UserStory("Titulo4", "Detalle4",10, null, null));
        
        stories2.add(new UserStoryHelper(new UserStory("Titulo1", "Detalle1", 40, null, null)));
        stories2.add(new UserStoryHelper(new UserStory("Titulo2", "Detalle2", 10, null, null)));
        stories2.add(new UserStoryHelper(new UserStory("Titulo3", "Detalle3", 40, null, null)));
        stories2.add(new UserStoryHelper(new UserStory("Titulo4", "Detalle4", 40, null, null)));
        
        Date inicio = new Date(System.currentTimeMillis() - 6*Calendario.DAY);
        
        sprintRetrasado = new Sprint(1, inicio,10,stories1);
        sprintOK = new Sprint(1, inicio,10,stories1);
        sprintNuevo = new Sprint(1, new Date() ,10,stories1);
        
        notificado = false;
        bus = new BusEventSync();
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.VerificarRetraso#VerificarRetraso(pp2.scrum.dominio.entidad.Sprint)}.
     */
    public final void testVerificarRetraso() {
        assertFalse(notificado);
        bus.register(new NotificarRetraso(new NotificadorMock()));
        new VerificarRetraso(sprintRetrasado, bus ).run();
        assertTrue(notificado);
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.VerificarRetraso#run()}.
     */
    public final void testVerificarRetrasoOk() {
        bus.register(new NotificarRetraso(new NotificadorMock()));
        new VerificarRetraso(sprintOK, bus ).run();
        assertTrue(notificado);
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
