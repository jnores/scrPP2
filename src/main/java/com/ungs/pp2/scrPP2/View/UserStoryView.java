package com.ungs.pp2.scrPP2.View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	
	private JTextArea txtTitulo;
	private JTextArea txtDetalle;
	private JTextField txtAutor;
	private JTextField txtResponsable;
	
	public UserStoryView(UserStoryHelper userStoryHelper) 
	{
		this.userStoryHelper =userStoryHelper;
		this.setBounds(0,0,490, 178);
		
		setBorder(BorderFactory.createTitledBorder("User Story #"+userStoryHelper.getId()));
		this.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(12, 12, 100, 15);
		this.add(lblTitulo);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(12, 63, 100, 15);
		this.add(lblDetalle);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(12, 122, 100, 15);
		this.add(lblAutor);
		
		JLabel lblResponsable = new JLabel("Responsable");
		lblResponsable.setBounds(12, 149, 100, 15);
		this.add(lblResponsable);
		
		txtTitulo = new JTextArea();
		txtTitulo.setLineWrap(true);
		txtTitulo.setBounds(110, 10, 368, 41);
		this.add(txtTitulo);
		txtTitulo.setEditable(false);
		
		txtDetalle = new JTextArea();
		txtDetalle.setLineWrap(true);
		txtDetalle.setBounds(110, 61, 368, 49);
		this.add(txtDetalle);
		txtDetalle.setEditable(false);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(110, 120, 368, 19);
		this.add(txtAutor);
		txtAutor.setEditable(false);
		
		txtResponsable = new JTextField();
		txtResponsable.setBounds(110, 147, 368, 19);
		this.add(txtResponsable);
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