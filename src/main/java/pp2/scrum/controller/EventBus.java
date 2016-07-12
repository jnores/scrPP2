/**
 * 
 */
package pp2.scrum.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author yoshknight
 *
 */
public interface EventBus {
    public void register(ActionListener listener);
    
    public void unregister(ActionListener listener);
    
    public void postEvent(final ActionEvent event) throws InterruptedException;
}
