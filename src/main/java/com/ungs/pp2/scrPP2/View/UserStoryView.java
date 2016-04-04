package com.ungs.pp2.scrPP2.View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
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
	private JTextField txtResponsable;
	
	public UserStoryView(UserStoryHelper userStoryHelper) 
	{
		this.userStoryHelper =userStoryHelper;
		this.setBounds(0,0,300, 120);
		
		setBorder(BorderFactory.createTitledBorder("User Story #"+userStoryHelper.getId()));
		this.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(12, 12, 100, 15);
		this.add(lblTitulo);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(12, 39, 100, 15);
		this.add(lblDetalle);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(12, 66, 100, 15);
		this.add(lblAutor);
		
		JLabel lblResponsable = new JLabel("Responsable");
		lblResponsable.setBounds(12, 93, 100, 15);
		this.add(lblResponsable);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(110, 10, 200, 19);
		this.add(txtTitulo);
		txtTitulo.setColumns(10);
		txtTitulo.setEditable(false);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(110, 37, 200, 19);
		this.add(txtDetalle);
		txtDetalle.setColumns(10);
		txtDetalle.setEditable(false);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(110, 64, 200, 19);
		this.add(txtAutor);
		txtAutor.setColumns(10);
		txtAutor.setEditable(false);
		
		txtResponsable = new JTextField();
		txtResponsable.setBounds(110, 91, 200, 19);
		this.add(txtResponsable);
		txtResponsable.setColumns(10);
		txtResponsable.setEditable(false);
		
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
		txtResponsable.setEditable(isEditable);
	}

	private void cargarUserStory() {
		this.txtTitulo.setText(this.userStoryHelper.getTitulo());
		this.txtDetalle.setText(this.userStoryHelper.getDetalle());
		this.txtAutor.setText(this.userStoryHelper.getAutor());
		this.txtResponsable.setText(this.userStoryHelper.getResponsable());
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.cargarUserStory();
	}

}