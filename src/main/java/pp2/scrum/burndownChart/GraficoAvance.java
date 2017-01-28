/**
 * 
 */
package pp2.scrum.burndownChart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.Calendario;

/**
 * @author yoshknight
 *
 */
public class GraficoAvance implements Graficador {

    private Integer getStoryPointsDone(Date fecha,Sprint iteracion)
    {
            Integer storyPointsDone=0;
            
            for (UserStory story: iteracion.getBacklog() )
                    storyPointsDone += story.getStoryPoints();
            
            return storyPointsDone;
    }
    
    /* (non-Javadoc)
     * @see pp2.scrum.burndownChart.Graficador#getTablaDeValores(pp2.scrum.model.Sprint)
     */
    @Override
    public List<Integer> getTablaDeValores(Sprint iteracion) {
        List<Integer> tablaEstimado =  new ArrayList<>();
        
        Date fechaInicio=iteracion.getfechaInicio();
        int dias=Calendario.getDuracion(fechaInicio,Calendario.getToday());
        
        if (dias > iteracion.getDuracion())
                dias = iteracion.getDuracion();
        
        Integer storyPoints=iteracion.getStoryPointsPactados();
        
        for(int i=0;i<=dias;i++){
                storyPoints = storyPoints-this.getStoryPointsDone(fechaInicio, iteracion);
                fechaInicio = Calendario.agregarDias(fechaInicio, 1);
                tablaEstimado.add(i,storyPoints);
        }
        
        return tablaEstimado;
    }

}
