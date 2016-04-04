package com.ungs.pp2.scrPP2.windows;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.ungs.pp2.scrPP2.View.UserStoryListView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserStoryOrderableWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserStoryListView userStoriesPane;

	/**
	 * Create the frame.
	 */
	public UserStoryOrderableWindow( UserStoryListView userStoriesList) {
		//add(userStoryView);
		this.userStoriesPane = userStoriesList;

		setTitle("Historia de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 400, 300);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnOrdenar = new JButton("Ordenar por Título");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userStoriesPane.ordenarPorTitulo();
			}
		});
		panel.add(btnOrdenar, BorderLayout.NORTH);
			
		JScrollPane scrollPane = new JScrollPane(userStoriesList);
		//scrollPane.setBounds(5, 5, 380, 160);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 350, 160);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.validate();
	}
	
	public void showWindow(boolean b) {
		// TODO Auto-generated method stub
		setVisible(b);
	}

}
