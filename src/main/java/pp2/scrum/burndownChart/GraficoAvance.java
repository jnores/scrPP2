/**
 * 
 */
package pp2.scrum.burndownChart;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pp2.scrm.calendario.Calendario;
import pp2.scrm.calendario.CalendarioService;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;
import pp2.scrum.servicios.ServiceRegistry;

/**
 * @author yoshknight
 *
 */
public class GraficoAvance implements Graficador {

    private int getStoryPointsDone(Date fecha,
            Map<Date, Integer> fechasFinalilzacion) {
        int storyPointsDone = 0;

        if (fechasFinalilzacion.containsKey(fecha))
            storyPointsDone = fechasFinalilzacion.get(fecha);
        
        return storyPointsDone;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pp2.scrum.burndownChart.Graficador#getTablaDeValores(pp2.scrum.model.
     * Sprint)
     */
    @Override
    public List<Integer> getTablaDeValores(Sprint iteracion) {
        List<Integer> tablaEstimado = new ArrayList<>();
        if (!ServiceRegistry.getInstance().hasService("calendario"))
            throw new RuntimeException(
                    "El servicio Calendario no fue inicializado.");

        CalendarioService calendario = (Calendario) ServiceRegistry.getInstance()
                .getService("calendario");

        Date fechaAux, fecha = iteracion.getfechaInicio();

        int nivelActual,dias = calendario.getDuracion(fecha, calendario.getToday());

        if (dias > iteracion.getDuracion())
            dias = iteracion.getDuracion();

        Integer storyPoints = iteracion.getStoryPointsPactados();
        Map<Date, Integer> fechasFinalizacion = new HashMap<>();
        
        for (UserStory us : iteracion.getBacklog()) {
            if ( iteracion.isUserStoryDone(us) ) {
                fechaAux = iteracion.getUltimoCambio(us);
                nivelActual = 0;
                if ( fechasFinalizacion.containsKey(fechaAux) )
                    nivelActual = fechasFinalizacion.get(fechaAux);
                nivelActual += us.getStoryPoints();
                fechasFinalizacion.put(fechaAux,Integer.valueOf(nivelActual));
            }
        }
        
//        fecha = iteracion.getfechaInicio();
        for (int i = 0; i <= dias; i++) {
            storyPoints -= getStoryPointsDone(fecha, fechasFinalizacion);

            fecha = calendario.agregarDias(fecha, 1);

            tablaEstimado.add(i, storyPoints);
        }

        return tablaEstimado;
    }

    private Map<UserStory, Date> calculateFechasFinalizacion() {
        // TODO Auto-generated method stub
        return null;
    }

}
