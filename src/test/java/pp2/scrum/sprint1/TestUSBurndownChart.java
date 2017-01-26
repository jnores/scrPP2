package pp2.scrum.sprint1;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import pp2.scrum.burndownChart.OpcionGrafico;
import pp2.scrum.controller.BurndownChartController;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.Calendario;

public class TestUSBurndownChart extends TestCase {

    Sprint sprintCargado;
    BurndownChartController controllerSinHistorias, controllerConHistorias;
    int totalSp;

    public TestUSBurndownChart(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();

        Sprint sprintVacio = new Sprint(1, Calendario.getToday(), 21,
                new ArrayList<UserStory>());

        controllerSinHistorias = new BurndownChartController(sprintVacio);

        Tarea t1a, t1b, t2a, t2b, t3a, t3b, t4a, t4b;
        int sp1 = 5, sp2 = 10, sp3 = 10, sp4 = 5;

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

        totalSp = sp1 + sp2 + sp3 + sp4;
        sprintCargado = new Sprint(1, Calendario.getToday(), 21,
                stories);
        sprintCargado.changeEstadoTarea(t1a, Estado.Done);
        sprintCargado.changeEstadoTarea(t1b, Estado.Done);
        sprintCargado.changeEstadoTarea(t2a, Estado.Done);
        sprintCargado.changeEstadoTarea(t2b, Estado.Done);
        sprintCargado.changeEstadoTarea(t3b, Estado.Done);
        sprintCargado.changeEstadoTarea(t4a, Estado.Done);
        controllerConHistorias = new BurndownChartController(sprintCargado);
    }

    /**
     * En el caso en que se seleccione ver el burndown chart de un proyecto, sin
     * user stories cargadas; o de una iteración, sin user stories asociadas, el
     * sistema deberá dar el mensaje: &ldquo;No se poseen suficientes datos para
     * realizar el gráfico&rdquo;.
     */
    public void testBurndownChartSinDatosDisponibles() {
        assertFalse(controllerSinHistorias.isEnabled());
        assertTrue(controllerConHistorias.isEnabled());
    }

    /**
     * Si se selecciona un gráfico estimado, el mismo debe tener un valor
     * inicial en el eje de ordenadas, igual a la sumatoria de los story points
     * pactados, para el periodo seleccionado.
     */
    public void testBurndowmChartEstimado_ValorInicial() {
        assertTrue(controllerConHistorias.isEnabled());

        List<Integer> tablaDeValores = controllerConHistorias
                .getTablaDeValores(OpcionGrafico.Estimado);
        assertEquals(tablaDeValores.get(0).intValue(), totalSp );
    }

    /**
     * Cuando se muestren gráficos estimados, estos deben reducir su valor, por
     * día, en una cantidad igual, a la sumatoria de los story points dividido
     * la cantidad de días del periodo.
     */
    public void testBurndowmChartEstimado_PendienteConstante() {
        assertTrue(controllerConHistorias.isEnabled());

        List<Integer> tablaDeValores = controllerConHistorias
                .getTablaDeValores(OpcionGrafico.Estimado);
        int storyPoints = tablaDeValores.get(0);
        int dias = tablaDeValores.size()-1;
        int reduccion=storyPoints/dias;

        for(int dia=1;dia<=dias;dia++) {
            assertEquals(reduccion, (storyPoints-tablaDeValores.get(dia)));    
            storyPoints=storyPoints-reduccion;
        }
    }

    /**
     * La cantidad de días que se muestra en el eje X, en caso de un gráfico
     * estimado o comparativo, debe ser la misma cantidad de días del periodo
     * considerado.
     */
    public void testBurndownChartEstimado_LongitudDuracionDelPeriodo() {
        assertTrue(controllerConHistorias.isEnabled());

        List<Integer> tablaDeValores = controllerConHistorias
                .getTablaDeValores(OpcionGrafico.Estimado);
        int duracionSprintMasValorInicial = sprintCargado.getDuracion() +1;
        assertEquals(tablaDeValores.size(),  duracionSprintMasValorInicial);
    }

    /**
     * Para un gráfico de story points realizados, la cantidad de días que se
     * muestren debe ser equivalente a los días transcurridos del periodo, solo
     * en el caso que sea un periodo finalizado, será igual a la cantidad de
     * días del periodo.
     */
    public void testBurndownChartRealizado_LongitudTiempoTranscurrido() {
        assertTrue(false);
    }

    /**
     * Si se muestra un gráfico de story points realizados, el mismo debe
     * reflejar la cantidad de story points, marcados como done en ese día.
     */
    public void testBurndownChartRealizado_ValorDiario() {
        assertTrue(false);
    }

}
