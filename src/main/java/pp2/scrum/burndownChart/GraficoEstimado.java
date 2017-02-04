/**
 * 
 */
package pp2.scrum.burndownChart;

import java.util.ArrayList;
import java.util.List;

import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;

/**
 * @author yoshknight
 *
 */
public class GraficoEstimado implements Graficador {
    /* (non-Javadoc)
     * @see pp2.scrum.burndownChart.Graficador#getTablaDeValores(pp2.scrum.model.Sprint)
     */
    @Override
    public List<Integer> getTablaDeValores(Sprint iteracion) {
        int dias = iteracion.getDuracion();
        Integer storyPoints,reduccion;
        storyPoints=this.getTotalStoryPoints(iteracion.getBacklog().getList());
        List<Integer> tablaEstimado =  new ArrayList<>();
        
        reduccion=storyPoints/dias;

        for(int dia=0;dia<=dias;dia++){
                tablaEstimado.add(dia, storyPoints);
                storyPoints=storyPoints-reduccion;
        }             
        return tablaEstimado;
    }
    
    private Integer getTotalStoryPoints(List<UserStory> historias){
        int storyPointsPactados=0;
        for(UserStory story: historias )
                storyPointsPactados += story.getStoryPoints();
        
        return storyPointsPactados;
    }


}
