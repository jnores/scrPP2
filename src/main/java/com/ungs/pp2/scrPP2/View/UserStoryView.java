package com.ungs.pp2.scrPP2.View;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ungs.pp2.scrPP2.Controller.UserStoryController;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class UserStoryView extends JFrame implements Observer
{
	private UserStoryController Controller;
	private JTable table;
	private JPanel contentPane;
	
	public UserStoryView(UserStoryController controller ) 
	{
		Controller = controller;
		setTitle("Historias de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 500, 200);
		
		contentPane = new JPanel();
		/*
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
		table.setModel(new DefaultTableModel(
		   new Object[][] {
		      {null, null, null, null, null},
		      {null, null, null, null, null},
		      {null, null, null, null, null},
		      {null, null, null, null, null},
		      {null, null, null, null, null},
		      {null, null, null, null, null},
		   },
		   new String[] {
		      "Titulo", "Responsable", "Estado", "Puntos", "Estimacion"
		   }
		));
		table.setBounds(0, 0, 510, 96);
		contentPane.add(table);
		*/
		
		int rows = 5;
		int cols = 5;
		String[] columnNames = {"Titulo", "Descripcion","Responsable","Estado","Puntos"};
		Object[][] data =
	        {
	              {null, null, null, null, null},
	              {null, null, null, null, null},
	              {null, null, null, null, null},
	              {null, null, null, null, null},
	              {null, null, null, null, null}
	        };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		JTable table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(header, BorderLayout.NORTH);
		contentPane.add(table, BorderLayout.CENTER);		
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