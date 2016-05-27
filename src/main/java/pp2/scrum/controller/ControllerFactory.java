/**
 * 
 */
package pp2.scrum.controller;

/**
 * @author yoshknight
 *
 */
public class ControllerFactory {
    
    public static UserStoryController getUserStoryController() {
        UserStoryController usc=null;
        try {
            usc = new UserStoryController(null);
        } catch (Exception e) {
            
        }
        return usc;
    }
}
