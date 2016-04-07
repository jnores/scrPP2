package com.ungs.pp2.scrPP2.View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ungs.pp2.scrPP2.Controller.UserStoryHelper;

public class UserStoryView extends JPanel implements Observer
{
	/**
	 * default serial version
	 */
	private static final long serialVersionUID = 1L;
	private UserStoryHelper userStoryHelper;
	
	private JTextArea txtTitulo;
	private JTextField txtAutor;
	private JTextField txtResponsable;
	
	public UserStoryView(UserStoryHelper userStoryHelper) 
	{
		this.userStoryHelper =userStoryHelper;
		this.setBounds(0,0,490, 178);
		
		setBorder(BorderFactory.createTitledBorder("User Story #"+userStoryHelper.getId()+" ["+userStoryHelper.getEstado()+"]"));
		this.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(12, 27, 100, 15);
		this.add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(12, 122, 100, 15);
		this.add(lblAutor);
		
		JLabel lblResponsable = new JLabel("Responsable");
		lblResponsable.setBounds(12, 149, 100, 15);
		this.add(lblResponsable);
		
		txtTitulo = new JTextArea();
		txtTitulo.setLineWrap(true);
		txtTitulo.setBounds(110, 25, 368, 81);
		this.add(txtTitulo);
		txtTitulo.setEditable(false);
		
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
	
	private void cargarUserStory() {
		this.txtTitulo.setText(this.userStoryHelper.getTitulo());
		this.txtAutor.setText(this.userStoryHelper.getAutor());
		this.txtResponsable.setText(this.userStoryHelper.getResponsable());
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.cargarUserStory();
	}
}