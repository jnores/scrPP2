/**
 * 
 */
package pp2.scrum.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author yoshknight
 *
 */
public class Backlog extends Observable {

    private List<UserStory> listUserStories;
    public Backlog() {
        listUserStories = new ArrayList<>();
    }
    
    public List<UserStory> getList() {
        return listUserStories;
    }

    public void addUserStory(UserStory userStory) {
        if (!listUserStories.contains(userStory)) {
            listUserStories.add(userStory);
            setChanged();
            notifyObservers();
        }
    }
    public void removeUserStory(UserStory userStory) {
        if (!listUserStories.contains(userStory)) {
            listUserStories.remove(userStory);
            setChanged();
            notifyObservers();
        }
    }

    public int size() {
        return listUserStories.size();
    }

}
