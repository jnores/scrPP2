package pp2.scrum.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import pp2.scrum.model.Tarea;

public class AltaTareaView extends JDialog{

	private JPanel panel;
	private Box boxVertical,boxVerticalTarea,boxHorizontal;
	private JButton botonNuevaTarea,botonCancelar,botonGuardar;
	private JScrollPane scroll;
	private static final long serialVersionUID = 1L;
	private ArrayList<JTextArea> descripcionTareas;

	public AltaTareaView()
	{
	    setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Agregar Tareas");
		iniciar();
		organizar();
		agregarAcciones();
		
		//setVisible(true);
	}
	
	private void iniciar(){
		this.descripcionTareas=new ArrayList<JTextArea>();
		panel=new JPanel();
		scroll=new JScrollPane(panel);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		boxVertical=Box.createVerticalBox();
		boxVerticalTarea=Box.createVerticalBox();
		boxHorizontal=Box.createHorizontalBox();
		
		botonNuevaTarea=new JButton("Nueva Tarea");
	    botonGuardar= new JButton("Agregar");
	    botonCancelar = new JButton("Cancelar");

	    agregarTarea();
	}
	
	private void organizar(){

		boxHorizontal.add(botonNuevaTarea);
		boxHorizontal.add(Box.createHorizontalGlue());
		boxHorizontal.add(botonGuardar);
		boxHorizontal.add(Box.createHorizontalGlue());
		boxHorizontal.add(botonCancelar);
		
		boxVertical.add(boxVerticalTarea);
		boxVertical.add(Box.createVerticalStrut(10));
		boxVertical.add(boxHorizontal);

		panel.add(boxVertical);
		
		this.add(scroll);
	}
	
	private void agregarTarea(){
		JTextArea detalle=new JTextArea(3,35);
		detalle.setAlignmentX(Box.CENTER_ALIGNMENT);
		detalle.setLineWrap(true);
		detalle.setWrapStyleWord(true);
		JScrollPane scrollDetalle=new JScrollPane();
		scrollDetalle.setBorder(BorderFactory.createTitledBorder("Tarea"));
		scrollDetalle.setViewportView(detalle);
		scrollDetalle.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JPanel panelDetalle=new JPanel();
		panelDetalle.add(scrollDetalle);
		boxVerticalTarea.add(panelDetalle);
		descripcionTareas.add(detalle);
	}
	
	private void agregarAcciones(){
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		botonNuevaTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				agregarTarea();
				actualizarVista();
			}
		});
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
	}
	
	private void actualizarVista(){
	    SwingUtilities.updateComponentTreeUI(this);
	}
	
	public ArrayList<Tarea> getTareas(){
		ArrayList<Tarea> lista=new ArrayList<Tarea>();
		for(JTextArea texto:descripcionTareas){
			String data=texto.getText();
			if(!data.isEmpty()){
				lista.add(new Tarea(data));
			}
		}
		return lista;
	}
}
