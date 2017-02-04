package pp2.scrum.view;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import pp2.scrum.model.UserStory;

public class UserStoryListView extends JPanel implements Observer
{
	/**
	 * default serial version
	 */
	private JFileChooser archivo;
	private static final long serialVersionUID = 1L;
	private List<UserStory> userStories;
	
	public UserStoryListView(List<UserStory> userStories) 
	{
		this.userStories = userStories;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.cargarUserStories();
		
	}
	
	private void cargarUserStories() {
//		Container cont = new Container();
		int width=0, height=0;

		for(UserStory userStory: userStories) {
			UserStoryView usv = new UserStoryView(userStory);	
			width = (int)usv.getBounds().getWidth();
			height += (int)usv.getBounds().getHeight();
			
			add( usv, -1 );
		}
		
	}

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        
    }

}