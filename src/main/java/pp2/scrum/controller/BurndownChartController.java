package pp2.scrum.controller;

import java.util.List;

import pp2.scrum.burndownChart.OpcionGrafico;
import pp2.scrum.model.Sprint;

public class BurndownChartController extends Controller {
    private Sprint iteracion;
    

    public BurndownChartController(Sprint iteracion) {
        this.iteracion = iteracion;
    }
    
    public boolean isEnabled() {
        return iteracion.getBacklog().size()>0;
    }

    public List<Integer> getTablaDeValores(OpcionGrafico tipo) {
        return tipo.getGraficador().getTablaDeValores(iteracion);
    }

}
