/**
 * 
 */
package pp2.scrum.verificarSprint;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yoshknight
 *
 */
public class TaskManager {
    private static Timer timer=new Timer();;
    
    public static void addTask(final Runnable cmd,long delay) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                cmd.run();
            }
        },
        delay);
    }
    
}
