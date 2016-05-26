/**
 * 
 */
package pp2.scrum.view.events;

import java.awt.event.ActionEvent;

/**
 * @author yoshknight
 *
 */
public class ViewUpdateEvent extends ActionEvent {

    /**
     * @param source
     * @param id
     * @param command
     */
    public ViewUpdateEvent(Object source, int id, String command) {
        super(source, id, command);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param source
     * @param id
     * @param command
     * @param modifiers
     */
    public ViewUpdateEvent(Object source, int id, String command, int modifiers) {
        super(source, id, command, modifiers);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param source
     * @param id
     * @param command
     * @param when
     * @param modifiers
     */
    public ViewUpdateEvent(Object source, int id, String command, long when, int modifiers) {
        super(source, id, command, when, modifiers);
        // TODO Auto-generated constructor stub
    }

}
