/**
 * 
 */
package pp2.scrum.verificarSprint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import pp2.scrum.busEvent.BusEventSync;
import pp2.scrum.dominio.entidad.Sprint;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.enums.Estado;
import pp2.scrum.utils.Calendario;

/**
 * @author yoshknight
 *
 */
public class VerificarRetrasoTest extends TestCase {
    UserStory us1,us2,us3;
    Sprint sprintRetrasado,sprintOK,sprintNuevo;
    
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
        List<UserStory> stories2 = new ArrayList<UserStory>();
        stories1.add(us3=new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null));
        stories1.add(us1=new UserStory("Titulo2", "Detalle2", "Autor2", "Responsable2", 10, 40, 1, Estado.Done, null, null));
        stories1.add(us2=new UserStory("Titulo3", "Detalle3", "Autor3", "Responsable3", 10, 40, 1, Estado.ToDo, null, null));
        stories1.add(new UserStory("Titulo4", "Detalle4", "Autor4", "Responsable4", 10, 40, 1, Estado.ToDo, null, null));
        
        stories2.add(new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.Done, null, null));
        stories2.add(new UserStory("Titulo2", "Detalle2", "Autor2", "Responsable2", 10, 10, 1, Estado.ToDo, null, null));
        stories2.add(new UserStory("Titulo3", "Detalle3", "Autor3", "Responsable3", 10, 40, 1, Estado.Done, null, null));
        stories2.add(new UserStory("Titulo4", "Detalle4", "Autor4", "Responsable4", 10, 40, 1, Estado.Done, null, null));
        
        Date inicio = new Date(System.currentTimeMillis() - 6*Calendario.DAY);
        
        sprintRetrasado = new Sprint(1, inicio,10,stories1);
        sprintOK = new Sprint(1, inicio,10,stories2);
        sprintNuevo = new Sprint(1, new Date() ,10,stories1);
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.VerificarRetraso#VerificarRetraso(pp2.scrum.dominio.entidad.Sprint)}.
     */
    public final void testVerificarRetraso() {
        new VerificarRetraso(sprintRetrasado, new BusEventSync() ).run();
    }

    /**
     * Test method for {@link pp2.scrum.verificarSprint.VerificarRetraso#run()}.
     */
    public final void testRun() {
//        fail("Not yet implemented");
        new VerificarRetraso(sprintOK, new BusEventSync() ).run();
        new VerificarRetraso(sprintNuevo, new BusEventSync() ).run();
    }

}
