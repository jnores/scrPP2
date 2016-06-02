/**
 * 
 */
package pp2.scrum.busEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

import pp2.scrum.dominio.interfaz.BusEvent;

/**
 * @author yoshknight
 *
 */
public class BusEventSync implements BusEvent{
    private Set<ActionListener> listeners = new LinkedHashSet<ActionListener>();

    public BusEventSync() {
    }
    
    @Override
    public void register(ActionListener listener) {
        listeners.add(listener);
    }
    
    @Override
    public void unregister(ActionListener listener) {
        listeners.remove(listener);
    }
    
    @Override
    public void postEvent(final ActionEvent event) throws InterruptedException {
        for(ActionListener l: listeners){
            l.actionPerformed(event);
        };
    } 
}
