package com.ungs.pp2.scrPP2.View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ungs.pp2.scrPP2.Controller.CustomerController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.Customer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerView extends JFrame implements Observer
{
	/**
	 * default serial version
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CustomerController controller;	
	private JTextField txtRazonSocial;
	private JTextField txtRazonSocialActual;

	/**
	 * Create the frame.
	 */
	public CustomerView(CustomerController controller) {
		setTitle("Clientes");
		this.controller=controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 112);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseRaznSocial = new JLabel("Ingrese razón social:");
		lblIngreseRaznSocial.setBounds(10, 11, 130, 14);
		contentPane.add(lblIngreseRaznSocial);
		
		JLabel lblRaznSocialActual = new JLabel("Razón social actual:");
		lblRaznSocialActual.setBounds(10, 53, 130, 14);
		contentPane.add(lblRaznSocialActual);
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setBounds(140, 8, 193, 20);
		contentPane.add(txtRazonSocial);
		txtRazonSocial.setColumns(10);
		
		txtRazonSocialActual = new JTextField();
		txtRazonSocialActual.setEnabled(false);
		txtRazonSocialActual.setColumns(10);
		txtRazonSocialActual.setBounds(140, 50, 193, 20);
		contentPane.add(txtRazonSocialActual);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				razonSocialUpdate();
			}
		});
		btnAplicar.setBounds(341, 7, 91, 60);
		contentPane.add(btnAplicar);
	}
	
	private void razonSocialUpdate()
	{
		this.controller.actualizarRazonSocial(txtRazonSocial.getText());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		//Corazonada que algo de esto esta bien.. recibe el cambio del objeto observable,
		//en este caso, customer

		if (arg0 instanceof Customer)
		{
			Customer cm = (Customer)arg0;
			txtRazonSocialActual.setText(cm.getRazonSocial());
		}
	}

	public void showWindow(boolean b) {
		// TODO Auto-generated method stub
		setVisible(b);
	}
}
