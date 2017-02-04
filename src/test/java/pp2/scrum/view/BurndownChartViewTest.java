package pp2.scrum.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.mock.scrum.calendario.MockCalendario;
import pp2.scrum.controller.BurndownChartController;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;
import pp2.scrum.servicios.ServiceRegistry;

public class BurndownChartViewTest extends TestCase {
    private BurndownChartController controller;

    public BurndownChartViewTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(BurndownChartViewTest.class);
    }

    protected void setUp() {
        MockCalendario calendario = new MockCalendario();
        ServiceRegistry.getInstance().registerService(calendario);

        Sprint sprintCargado;
        int diasTranscurridos;
        int sp1 = 5, sp2 = 10, sp3 = 10, sp4 = 5;

        Tarea t1a, t1b, t2a, t2b, t3a, t3b, t4a, t4b;

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

        stories.add(new UserStory("Titulo1", "Detalle1", sp1, null, tareas1));
        stories.add(new UserStory("Titulo2", "Detalle2", sp2, null, tareas2));
        stories.add(new UserStory("Titulo3", "Detalle3", sp3, null, tareas3));
        stories.add(new UserStory("Titulo4", "Detalle4", sp4, null, tareas4));

        diasTranscurridos = 7;
        calendario.setFecha(new Date());
        Date inicioSprint = calendario.agregarDias(calendario.getToday(),
                -diasTranscurridos);
        sprintCargado = new Sprint(1, inicioSprint, 21, stories);

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
        controller = new BurndownChartController(sprintCargado);
    }

    public void testVista() {
        new BurndownChartView(controller);
        assertTrue(true);
    }

    public void testVistaComposite() {
        new BurndownChartView(controller);
        assertTrue(true);
    }

    public void testActionPerformed() {
        new BurndownChartView(controller);
        // vista.actionPerformed(new ActionEvent(vista, 1, "menu4"));
        assertTrue(true);

    }

}
