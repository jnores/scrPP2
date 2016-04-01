package com.ungs.pp2.scrPP2.View;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;
import com.ungs.pp2.scrPP2.Dominio.ListaPaginada;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UserStoryPaginadoView extends JFrame implements Observer
{
	/**
	 * default serial version
	 */
	private static final long serialVersionUID = 1L;
	private UserStoryPaginadoController Controller;
	private JTable table;
	private JPanel contentPane;
	
	public UserStoryPaginadoView(UserStoryPaginadoController controller ) 
	{
		Controller = controller;
		setTitle("Historias de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 500, 200);
		
		contentPane = new JPanel();
		
		int rows = 5;
		int cols = 5;
		String[] columnNames = {"Titulo", "Descripcion","Responsable","Estado","Puntos"};
		List<UserStory> stories = controller.ListarUserStories(null);
		
		
		Object[][] data = new Object[stories.size()][] ;
		int i = 0;
		for (UserStory story : stories)
		{
		   Object[] fila = {story.getTitulo(), story.getDetalle(),story.getResponsable(),story.getEstado(),story.getStoryPoints()};
		   data[i] = fila;
		   i++;
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(header, BorderLayout.NORTH);
		contentPane.add(table, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnPrimero = new JButton("");
		ImageIcon primero = new ImageIcon(UserStoryPaginadoView.class.getResource("/com/ungs/pp2/scrPP2/Resources/Images/Primero.png"));
		btnPrimero.setIcon(primero);
		panel.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(UserStoryPaginadoView.class.getResource("/com/ungs/pp2/scrPP2/Resources/Images/Anterior.png")));
		panel.add(btnAnterior);
		
		JLabel pageNumberLabel = new JLabel(controller.getPaginaActual().getPagina()+ " / " +controller.getPaginasTotales());
		panel.add(pageNumberLabel);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(UserStoryPaginadoView.class.getResource("/com/ungs/pp2/scrPP2/Resources/Images/Siguiente.png")));
		panel.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(UserStoryPaginadoView.class.getResource("/com/ungs/pp2/scrPP2/Resources/Images/Ultimo.png")));
		panel.add(btnUltimo);
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