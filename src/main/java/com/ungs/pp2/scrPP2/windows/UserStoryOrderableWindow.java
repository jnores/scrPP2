package com.ungs.pp2.scrPP2.windows;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.ungs.pp2.scrPP2.View.UserStoryListView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.ungs.pp2.scrPP2.Dominio.Enums.UserStoryHelperComparator;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class UserStoryOrderableWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserStoryListView userStoriesPane;
	private JComboBox<UserStoryHelperComparator> cmbOpciones;
	private JToggleButton tglbtnAscdesc;
	private JButton btnOrdenar;
	private JButton btnExportar;

	/**
	 * Create the frame.
	 */
	public UserStoryOrderableWindow( UserStoryListView userStoriesList) {
		this.userStoriesPane = userStoriesList;

		setTitle("Historia de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 520, 300);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		
		cmbOpciones = new JComboBox<UserStoryHelperComparator>();
		cmbOpciones.setModel(new DefaultComboBoxModel<UserStoryHelperComparator>(UserStoryHelperComparator.values()));
		panel.add(cmbOpciones);
		
		tglbtnAscdesc = new JToggleButton("ASC(desc)");
		tglbtnAscdesc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ( tglbtnAscdesc.isSelected() ) {
					tglbtnAscdesc.setText("DESC(asc)");
				} else {
					tglbtnAscdesc.setText("ASC(desc)");
				}
					
			}
		});
		panel.add(tglbtnAscdesc);

		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userStoriesPane.ordenarPorOpcion(cmbOpciones.getItemAt(cmbOpciones.getSelectedIndex()),tglbtnAscdesc.isSelected());
			}
		});
		panel.add(btnOrdenar);
		
		boolean controlsEnabled = userStoriesList.getComponentCount() > 0;
		cmbOpciones.setEnabled(controlsEnabled);
		tglbtnAscdesc.setEnabled(controlsEnabled);
		btnOrdenar.setEnabled(controlsEnabled);
		
		btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userStoriesPane.exportar();
			}
		});
		panel.add(btnExportar);
			
		JScrollPane scrollPane = new JScrollPane(userStoriesList);
		//scrollPane.setBounds(5, 5, 380, 160);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 350, 160);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.validate();
	}
	
	public void showWindow(boolean b) {
		setVisible(b);
	}

}
