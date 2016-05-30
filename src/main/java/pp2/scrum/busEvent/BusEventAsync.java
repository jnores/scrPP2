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
public class BusEventAsync implements BusEvent{
    private Set<ActionListener> listeners = new LinkedHashSet<ActionListener>();
    private BlockingQueue<Runnable> dispatchQueue = new LinkedBlockingQueue<Runnable>();
    private Thread thread = null;
    
    public BusEventAsync() {
        thread = new Thread(
                     new Runnable() {
                         @Override
                         public void run() {
                             boolean run = true;
                             while(run) {
                                 try {
                                     dispatchQueue.take().run();
                                 } catch (InterruptedException e) {
                                     run=false;
                                 }
                             }
                         }
                     }
                );
        thread.start();
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

    public void destroy() {
        thread.interrupt();
    }
    
}
