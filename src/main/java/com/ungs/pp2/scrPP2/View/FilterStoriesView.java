package com.ungs.pp2.scrPP2.View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.ungs.pp2.scrPP2.Controller.UserStoryController;

public class FilterStoriesView extends JPanel implements Observer
{
	/**
	 * default serial version
	 */
	private static final long serialVersionUID = 1L;
	private UserStoryController Controller;
	
	public FilterStoriesView(UserStoryController controller ) 
	{
		Controller = controller;
		setBounds(400, 400, 500, 200);		
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public void showWindow(boolean b) {
		// TODO Auto-generated method stub
		setVisible(b);
	}
}