/**
 * 
 */
package pp2.scrum.busEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yoshknight
 *
 */
public class BusEvent {
    private Set<ActionListener> listeners = new LinkedHashSet<ActionListener>();
    private BlockingQueue<Runnable> dispatchQueue = new LinkedBlockingQueue<Runnable>();
//    private Thread thread= null;
    
    public BusEvent() {
//        thread = 
                new Thread(
                     new Runnable() {
                         @Override
                         public void run() {
                             while(true) {
                                 try {
                                     dispatchQueue.take().run();
                                 } catch (InterruptedException e) {
                                     // no se.
                                 }
                             }
                         }
                     }
                ).start();
    }
    
    public void register(ActionListener listener) {
        listeners.add(listener);
    }
    
    public void unregister(ActionListener listener) {
        listeners.remove(listener);
    }
    
    public void postEvent(final ActionEvent event) throws InterruptedException {
        dispatchQueue.put(
                new Runnable() {
                    @Override
                    public void run() {
                        for(ActionListener l: listeners){
                            l.actionPerformed(event);
                        }
                            
                    }
                }
                );
    }
//
//    public void destroy() {
//        thread.interrupt();
//    }
//    
}
