package com.ungs.pp2.scrPP2.windows;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UserStoryWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public UserStoryWindow( JPanel userStoryView) {
		//add(userStoryView);

		setTitle("Historia de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 400, 200);
		setResizable(false);
//		setContentPane(userStoryView);
		
		JScrollPane scrollPane = new JScrollPane(userStoryView);
		//scrollPane.setBounds(5, 5, 380, 160);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 350, 160);
		add(scrollPane,BorderLayout.CENTER);
		scrollPane.validate();
	}
	
	public void showWindow(boolean b) {
		// TODO Auto-generated method stub
		setVisible(b);
	}

}
