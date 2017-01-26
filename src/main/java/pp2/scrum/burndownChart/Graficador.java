/**
 * 
 */
package pp2.scrum.burndownChart;

import java.util.List;

import pp2.scrum.model.Sprint;

/**
 * @author yoshknight
 *
 */
public interface Graficador {

    List<Integer> getTablaDeValores(Sprint iteracion);
    
}
