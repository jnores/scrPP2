package com.ungs.pp2.scrPP2.View;

import java.awt.Dimension;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.ungs.pp2.scrPP2.Controller.UserStoryHelper;
import com.ungs.pp2.scrPP2.Dominio.Enums.UserStoryHelperComparator;

public class UserStoryListView extends JPanel implements Observer
{
	/**
	 * default serial version
	 */
	private static final long serialVersionUID = 1L;
	private List<UserStoryHelper> userStoriesHelper;
	
	public UserStoryListView(List<UserStoryHelper> userStoriesHelper) 
	{
		this.userStoriesHelper = userStoriesHelper;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.cargarUserStories();
	}
	
	
	private void cargarUserStories() {
//		Container cont = new Container();
		int width=0, height=0;

		for(UserStoryHelper userStoryHelper: userStoriesHelper) {
			UserStoryView usv = new UserStoryView(userStoryHelper);
			width = (int)usv.getBounds().getWidth();
			height += (int)usv.getBounds().getHeight();
			
			add( usv, -1 );
			System.out.println("print story "+userStoryHelper.getTitulo() );
		}
		setPreferredSize( new Dimension(width, height));
		setMaximumSize( new Dimension(width, height));
		
		revalidate();
		repaint();
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.cargarUserStories();
	}


	public void ordenarPorTitulo() {
		Collections.sort(userStoriesHelper, UserStoryHelperComparator.getComparator(UserStoryHelperComparator.TITLE_SORT));
		removeAll();
		cargarUserStories();
		
	}

}