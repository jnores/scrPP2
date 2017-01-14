package pp2.scrum.sprint1;

import junit.framework.TestCase;

public class TestUSBurndownChart extends TestCase {

    public TestUSBurndownChart(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }
    
    /**
     * En el caso en que se seleccione ver el burndown chart de un proyecto, sin 
     * user stories cargadas; o de una iteración, sin user stories asociadas, el 
     * sistema deberá dar el mensaje: &ldquo;No se poseen suficientes datos para 
     * realizar el gráfico&rdquo;.
     */
    public void testBurndownChartSinDatosDisponibles() {
        assertTrue(false);
    }

    /**
     * Si se selecciona un gráfico estimado, el mismo debe tener un valor 
     * inicial en el eje de ordenadas, igual a la sumatoria de los story points 
     * pactados, para el periodo seleccionado.
     */
    public void testBurndowmChartEstimado_ValorInicial() {
        assertTrue(false);
    }
    
    /**
     * Cuando se muestren gráficos estimados, estos deben reducir su valor, por 
     * día, en una cantidad igual, a la sumatoria de los story points dividido 
     * la cantidad de días del periodo.
     */
    public void testBurndowmChartEstimado_PendienteConstante() {
        assertTrue(false);
    }
    
    /**
     * La cantidad de días que se muestra en el eje X, en caso de un gráfico 
     * estimado o comparativo, debe ser la misma cantidad de días del periodo 
     * considerado.
     */
    public void testBurndownChartEstimado_LongitudDuracionDelPeriodo() {
        assertTrue(false);
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
