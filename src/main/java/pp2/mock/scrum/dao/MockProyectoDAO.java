package pp2.mock.scrum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pp2.mock.scrum.calendario.MockCalendario;
import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;
import pp2.scrum.servicios.ServiceRegistry;

public class MockProyectoDAO extends ProyectoDAO {

    List<Proyecto> listaProyectos = new ArrayList<Proyecto>();

    public MockProyectoDAO() {

        MockCalendario calendario = new MockCalendario();
        ServiceRegistry.getInstance().registerService(calendario);
        
        int diasTranscurridos;
        int sp1 = 5, sp2 = 10, sp3 = 10, sp4 = 5;

        Tarea t1a, t1b, t2a, t2b, t3a, t3b, t4a, t4b;

        Backlog stories = new Backlog();

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

        List<Tarea> tareas5 = new ArrayList<Tarea>();
        tareas5.add(new Tarea("tarea 5"));
        
        List<Tarea> tareas6 = new ArrayList<Tarea>();
        tareas6.add(new Tarea("tarea 5"));

        stories.addUserStory(new UserStory("Titulo1", "Detalle1", sp1, null, tareas1));
        stories.addUserStory(new UserStory("Titulo2", "Detalle2", sp2, null, tareas2));
        stories.addUserStory(new UserStory("Titulo3", "Detalle3", sp3, null, tareas3));
        stories.addUserStory(new UserStory("Titulo4", "Detalle4", sp4, null, tareas4));
        stories.addUserStory(new UserStory("Titulo5", "Detalle5", sp3, null, tareas5));
        stories.addUserStory(new UserStory("Titulo6", "Detalle6", sp4, null, tareas6));

        diasTranscurridos = 7;
        calendario.setFecha(new Date());
        Date inicioSprint = calendario.agregarDias(calendario.getToday(),
                -diasTranscurridos);
        Sprint sprintCargado = new Sprint(1, inicioSprint, 21, stories);
        
        Date fechaAux = calendario.agregarDias(inicioSprint, 1);
        calendario.setFecha(fechaAux);
        sprintCargado.changeEstadoTarea(t1a, Estado.Done);
        
        fechaAux = calendario.agregarDias(inicioSprint, 2);
        calendario.setFecha(fechaAux);
        sprintCargado.changeEstadoTarea(t1b, Estado.Done);
        
        fechaAux = calendario.agregarDias(inicioSprint, 3);
        calendario.setFecha(fechaAux);
        sprintCargado.changeEstadoTarea(t2a, Estado.Done);
        
        fechaAux = calendario.agregarDias(inicioSprint, 4);
        calendario.setFecha(fechaAux);
        sprintCargado.changeEstadoTarea(t2b, Estado.Done);
        
        fechaAux = calendario.agregarDias(inicioSprint, 5);
        calendario.setFecha(fechaAux);
        sprintCargado.changeEstadoTarea(t3b, Estado.Done);
        
        fechaAux = calendario.agregarDias(inicioSprint, 6);
        calendario.setFecha(fechaAux);
        sprintCargado.changeEstadoTarea(t4a, Estado.Done);

        calendario.setFecha(new Date());
        Proyecto proyecto =  new Proyecto(1, "Test 1");
        
        proyecto.addIteracion(sprintCargado);
        listaProyectos.add(0,proyecto);

    }

    @Override
    public List<Proyecto> getAll() {
        return listaProyectos;
    }

    @Override
    public Proyecto getById(long id) {
        return listaProyectos.get((int) id - 1);
    }

    @Override
    public long guardar(Proyecto proyecto) {
        long id = proyecto.getId();
        if (id < 1)
            id = listaProyectos.size();

        listaProyectos.add(new Proyecto(id, proyecto.getNombre(),
                proyecto.getBacklog(), proyecto.getMiembros(),
                proyecto.getIteraciones(), proyecto.getAsignaciones()));
        return id;
    }

}
