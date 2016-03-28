package com.ungs.pp2.scrPP2.View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ungs.pp2.scrPP2.Controller.UserStoryController;
import com.ungs.pp2.scrPP2.Controller.UserStoryHelper;

public class UserStoryView extends JPanel implements Observer
{
	/**
	 * default serial version
	 */
	private static final long serialVersionUID = 1L;
	private UserStoryController controller;
	private UserStoryHelper userStoryHelper;
	
	private JTextField txtTitulo;
	private JTextField txtDetalle;
	private JTextField txtAutor;
	
	public UserStoryView(UserStoryHelper userStoryHelper) 
	{
		this.userStoryHelper =userStoryHelper;
		
		this.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(12, 12, 70, 15);
		this.add(lblTitulo);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(12, 39, 70, 15);
		this.add(lblDetalle);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(12, 66, 70, 15);
		this.add(lblAutor);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(100, 10, 200, 19);
		this.add(txtTitulo);
		txtTitulo.setColumns(10);
		txtTitulo.setEditable(false);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(100, 37, 200, 19);
		this.add(txtDetalle);
		txtDetalle.setColumns(10);
		txtDetalle.setEditable(false);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(100, 64, 200, 19);
		this.add(txtAutor);
		txtAutor.setColumns(10);
		txtAutor.setEditable(false);
		
		this.cargarUserStory();
	}
	
	public void setController(UserStoryController controller) {
		this.controller = controller;
		this.updateEditable();
	}

	private boolean isEditable() {
		return this.controller != null;
	}
	
	private void updateEditable() {
		boolean isEditable = this.isEditable();
		
		txtTitulo.setEditable(isEditable);
		txtDetalle.setEditable(isEditable);
		txtAutor.setEditable(isEditable);
	}

	private void cargarUserStory() {
		this.txtTitulo.setText(this.userStoryHelper.getTitulo());
		this.txtDetalle.setText(this.userStoryHelper.getDetalle());
		this.txtAutor.setText(this.userStoryHelper.getAutor());
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.cargarUserStory();
	}

}