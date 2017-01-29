package pp2.scrum.sprint1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import pp2.scrm.calendario.Calendario;
import pp2.scrm.calendario.CalendarioService;
import pp2.scrum.controller.SprintController;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;
import pp2.scrum.servicios.ServiceRegistry;

public class TestUSGestionDeEstados extends TestCase {
    Tarea tareaDefault,tareaDoing,tareaDone;
    Sprint sprint;
    SprintController sprintController;
    public TestUSGestionDeEstados(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        ServiceRegistry.getInstance().registerService(new Calendario());
        
        List<UserStory> stories = new ArrayList<UserStory>();
        
        tareaDefault = new Tarea("tarea en estado ToDo");
        tareaDoing = new Tarea("tarea en estado Doing");
        tareaDone = new Tarea("tarea en estado Done");
        
        
        Tarea t1a = new Tarea("tarea a de us 1");
        Tarea t1b = new Tarea("tarea b de us 1");
        List<Tarea> tareas1 = new ArrayList<Tarea>();
        tareas1.add(t1a);
        tareas1.add(t1b);
        tareas1.add(tareaDefault);

        Tarea t2a = new Tarea("tarea a de us 2");
        Tarea t2b = new Tarea("tarea b de us 2");
        List<Tarea> tareas2 = new ArrayList<Tarea>();
        tareas2.add(t2a);
        tareas2.add(t2b);
        tareas2.add(tareaDoing);

        Tarea t3a = new Tarea("tarea a de us 3");
        Tarea t3b = new Tarea("tarea b de us 3");
        List<Tarea> tareas3 = new ArrayList<Tarea>();
        tareas3.add(t3a);
        tareas3.add(t3b);
        tareas3.add(tareaDone);
        

        Tarea t4a = new Tarea("tarea a de us 4");
        Tarea t4b = new Tarea("tarea b de us 4");
        List<Tarea> tareas4 = new ArrayList<Tarea>();
        tareas4.add(t4a);
        tareas4.add(t4b);
        
        stories.add(new UserStory("Titulo1", "Detalle1",  5, null, tareas1));
        stories.add(new UserStory("Titulo2", "Detalle2", 10, null, tareas2));
        stories.add(new UserStory("Titulo3", "Detalle3", 10, null, tareas3));
        stories.add(new UserStory("Titulo4", "Detalle4",  5, null, tareas4));
        
        Date inicio = new Date(System.currentTimeMillis() - 6*CalendarioService.DAY);
        
        sprint = new Sprint(2, inicio,10,stories);
        sprint.changeEstadoTarea(tareaDoing, Estado.Doing);
        sprint.changeEstadoTarea(tareaDone, Estado.Done);
        
        sprintController = new SprintController(sprint);
    }

    /**
     * Si se crea una tarea, por defecto, la misma debe estar en estado "ToDo".
     */
    public void testEstadoPorDefecto() {
        Estado estadoTarea = sprintController.getEstadoTarea(tareaDefault);
        
        assertTrue(estadoTarea.equals(Estado.ToDo)); 
    }
    
    /**
     * Si paso una tarea de estado "ToDo" al siguiente estado, debe figurar en 
     * estado "doing"
     */
    public void testSiguienteEstadoFromToDo() {
        sprintController.avanzarEstado(tareaDefault);
        
        Estado estadoTarea = sprintController.getEstadoTarea(tareaDefault);
        assertTrue(estadoTarea.equals(Estado.Doing));
    }
    
    /**
     * Si quiero pasar al estado siguiente a una tarea que se encuentra en 
     * "done", debe generarse una excepción 
     */
    public void testSiguienteEstadoFromDone() {
        Estado estadoTarea = sprintController.getEstadoTarea(tareaDone);
        assertTrue(estadoTarea.equals(Estado.Done));
        try {
            sprintController.avanzarEstado(tareaDone);
            assertTrue(false);
        } catch(Exception e) {
        }
    }
    
}
