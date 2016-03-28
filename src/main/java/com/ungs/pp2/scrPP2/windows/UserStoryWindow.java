package com.ungs.pp2.scrPP2.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserStoryWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UserStoryWindow( JPanel userStoryView) {
		this.contentPane = userStoryView;
		setTitle("Historia de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 318, 123);
		setContentPane(userStoryView);
	}
	
	public void showWindow(boolean b) {
		// TODO Auto-generated method stub
		setVisible(b);
	}

}
