/**
 * 
 */
package pp2.scrum.dominio.entidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author yoshknight
 *
 */
public interface BusEvent {
    public void register(ActionListener listener);
    
    public void unregister(ActionListener listener);
    
    public void postEvent(final ActionEvent event) throws InterruptedException;
}
