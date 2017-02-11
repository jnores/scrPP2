package pp2.mock.scrum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pp2.mock.scrum.calendario.MockCalendario;
import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Miembro;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;

public class MockProyectoDAO extends ProyectoDAO {

    List<Proyecto> listaProyectos = new ArrayList<Proyecto>();

    public MockProyectoDAO() {

        MockCalendario calendario = new MockCalendario();
        
        int diasTranscurridos = 7;
        
        int sp1 = 5, sp2 = 10, sp3 = 10, sp4 = 5;

        Tarea t1a, t1b, t2a, t2b, t3a, t3b, t4a, t4b;

        List<Sprint> sprints = new ArrayList<>();
        Backlog sprintBacklog = new Backlog();
        Backlog productBacklog = new Backlog();

        // -- Cargo el backlog del sprint
        
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
        tareas6.add(new Tarea("tarea 6"));

        sprintBacklog.addUserStory(new UserStory("Titulo1", "Detalle1", sp1, null, tareas1));
        sprintBacklog.addUserStory(new UserStory("Titulo2", "Detalle2", sp2, null, tareas2));
        sprintBacklog.addUserStory(new UserStory("Titulo3", "Detalle3", sp3, null, tareas3));
        sprintBacklog.addUserStory(new UserStory("Titulo4", "Detalle4", sp4, null, tareas4));
        sprintBacklog.addUserStory(new UserStory("Titulo5", "Detalle5", sp3, null, tareas5));
        sprintBacklog.addUserStory(new UserStory("Titulo6", "Detalle6", sp4, null, tareas6));

        
        Date inicioSprint = calendario.agregarDias(calendario.getToday(),
                -diasTranscurridos);
        
        // -- Cargo la pizarra de estados y el registro de ultimo cambio.
        
        Map<Tarea,Date> logUltimoCambio = new HashMap<>();
        Map<Tarea,Estado> pizarraEstados = new HashMap<>();
        
        Estado estadoAux = Estado.getDefault();
        for (UserStory us : sprintBacklog.getList())
            for (Tarea t : us.getTareas())
                pizarraEstados.put(t, estadoAux);

        Date fechaAux = calendario.agregarDias(inicioSprint, 1);
        logUltimoCambio.put(t1a, fechaAux);
        pizarraEstados.put(t1a, Estado.Done);

        fechaAux = calendario.agregarDias(inicioSprint, 2);
        logUltimoCambio.put(t1b, fechaAux);
        pizarraEstados.put(t1b, Estado.Done);

        fechaAux = calendario.agregarDias(inicioSprint, 3);
        logUltimoCambio.put(t2a, fechaAux);
        pizarraEstados.put(t2a, Estado.Done);

        fechaAux = calendario.agregarDias(inicioSprint, 4);
        logUltimoCambio.put(t2b, fechaAux);
        pizarraEstados.put(t2b, Estado.Done);

        fechaAux = calendario.agregarDias(inicioSprint, 5);
        logUltimoCambio.put(t3b, fechaAux);
        pizarraEstados.put(t3b, Estado.Done);

        fechaAux = calendario.agregarDias(inicioSprint, 6);
        logUltimoCambio.put(t4a, fechaAux);
        pizarraEstados.put(t4a, Estado.Done);
        
        // -- Creo el sprint
        
        Sprint sprintCargado = new Sprint(1, inicioSprint, 21, sprintBacklog,pizarraEstados,logUltimoCambio);
        
        sprints.add(sprintCargado);
        
        Set<Miembro> miembros = new HashSet<>();
        miembros.add(new Miembro("Ivo"));
        miembros.add(new Miembro("Nores"));
        miembros.add(new Miembro("Roger"));
        miembros.add(new Miembro("Victoria"));
        
        Proyecto proyecto =  new Proyecto(1, "Test 1", productBacklog,miembros,sprints);
        
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
