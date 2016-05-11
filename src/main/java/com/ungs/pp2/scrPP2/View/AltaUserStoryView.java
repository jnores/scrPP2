package com.ungs.pp2.scrPP2.View;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.ungs.pp2.scrPP2.Controller.AltaUserStoryController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;

//No incluyo autor, eso esta almacenado en el logueo. El id igual, viene como dato. 
public class AltaUserStoryView extends JPanel{

	private final JTextArea areaTitulo;
	private final JTextArea areaDetalle;
	private	final JTextArea areaCriterios;
	private final JTextArea areaSugerencia;
	private final JTextField campoAsignadoA;
	private final JTextField campoPuntos;
	private final JTextField campoHoras;
	
	private JPanel panelTitulo,panelDetalle,panelCriterio,panelSugerencia;
	private JScrollPane scrollTitulo,scrollDetalle,scrollCriterio;
	
	private boolean mostrarSugerencias;
	private JCheckBox check;
	private Box boxVertical;
	private JButton botonAgregar;
	private AltaUserStoryController controlador;
	
	private final String resumen="Como <Rol> necesito <Meta> para <Finalidad>.";
	private final String  detalle="Utilice este espacio para explicar con más detalle, la meta y el propósito de esta user story";
	private final String criterio="Especifique criterios de aceptación para la user story.\n"
			+ "Intente que los criterios tengan una correspondencia con los test.";
	
	private static final long serialVersionUID = 1L; 

	public AltaUserStoryView(AltaUserStoryController controlador)
	{
		this.controlador=controlador;
		mostrarSugerencias=true;
		boxVertical=Box.createVerticalBox();
		panelTitulo=new JPanel();panelDetalle=new JPanel();panelCriterio=new JPanel();panelSugerencia=new JPanel();
		scrollTitulo=new JScrollPane();scrollDetalle=new JScrollPane();scrollCriterio=new JScrollPane();
		
		botonAgregar=new JButton("Agregar");
		botonAgregar.setAlignmentX(Box.RIGHT_ALIGNMENT);
		
		check=new JCheckBox("Sugerencias habilitadas");
		check.setBorder(BorderFactory.createRaisedBevelBorder());
		check.setAlignmentX(Box.CENTER_ALIGNMENT);
		check.setSelected(true);
		
		areaTitulo=new JTextArea(2,40);
		areaTitulo.setAlignmentX(Box.CENTER_ALIGNMENT);
		areaTitulo.setLineWrap(true);
		areaTitulo.setWrapStyleWord(true);
		scrollTitulo.setBorder(BorderFactory.createTitledBorder("Titulo"));
		scrollTitulo.setViewportView(areaTitulo);
		scrollTitulo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaTitulo.setText(resumen);
		panelTitulo.add(scrollTitulo);

		areaDetalle=new JTextArea(3,40);
		areaDetalle.setAlignmentX(Box.CENTER_ALIGNMENT);
		areaDetalle.setLineWrap(true);
		areaDetalle.setWrapStyleWord(true);        
		scrollDetalle.setBorder(BorderFactory.createTitledBorder("Detalle"));
		scrollDetalle.setViewportView(areaDetalle);
		scrollDetalle.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaDetalle.setText(detalle);
		panelDetalle.add(scrollDetalle);
		
		areaCriterios=new JTextArea(3,40);
		areaCriterios.setAlignmentX(Box.CENTER_ALIGNMENT);
		areaCriterios.setLineWrap(true);
		areaCriterios.setWrapStyleWord(true);        
		scrollCriterio.setBorder(BorderFactory.createTitledBorder("Criterio de Aceptación"));
		scrollCriterio.add(areaCriterios);
		scrollCriterio.setViewportView(areaCriterios);
		scrollCriterio.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaCriterios.setText(criterio);
		panelCriterio.add(scrollCriterio);
		
		areaSugerencia=new JTextArea(2,40);
		areaSugerencia.setForeground(Color.red);
		areaSugerencia.setBorder(BorderFactory.createTitledBorder("Sugerencia"));
		areaSugerencia.setVisible(false);
		areaSugerencia.setEditable(false);
		areaSugerencia.setLineWrap(true);
		areaSugerencia.setWrapStyleWord(true);
		panelSugerencia.add(areaSugerencia);
		
		campoAsignadoA=new JTextField();
		campoAsignadoA.setBorder(BorderFactory.createTitledBorder("Asignado A:"));
		campoAsignadoA.setAlignmentX(Box.LEFT_ALIGNMENT); 
        
		campoPuntos=new JTextField();
		campoPuntos.setBorder(BorderFactory.createTitledBorder("Puntos:"));
		campoPuntos.setAlignmentX(Box.LEFT_ALIGNMENT);

		campoHoras=new JTextField();
		campoHoras.setBorder(BorderFactory.createTitledBorder("Horas:"));
		campoHoras.setAlignmentX(Box.LEFT_ALIGNMENT);
        
        configurarAcciones();
        insertarEnBox();
        this.add(boxVertical);
        setVisible(true);
	}
	
	private void insertarEnBox(){
		Box boxHTitulo=Box.createHorizontalBox();
		boxHTitulo.add(Box.createHorizontalStrut(10));
		boxHTitulo.add(panelTitulo);
		boxHTitulo.setAlignmentY(BOTTOM_ALIGNMENT);
     
		Box boxHDetalle=Box.createHorizontalBox();
		boxHDetalle.add(Box.createHorizontalStrut(10));
		boxHDetalle.add(panelDetalle);
		boxHDetalle.setAlignmentY(BOTTOM_ALIGNMENT);
     
		Box boxHCriterio=Box.createHorizontalBox();
		boxHCriterio.add(Box.createHorizontalStrut(10));
		boxHCriterio.add(panelCriterio);
		boxHCriterio.setAlignmentY(BOTTOM_ALIGNMENT);

		Box boxHSugerencia=Box.createHorizontalBox();
		boxHSugerencia.add(Box.createHorizontalStrut(10));
		boxHSugerencia.add(panelSugerencia);
		boxHSugerencia.setAlignmentY(BOTTOM_ALIGNMENT);
		
		Box boxHExtras=Box.createHorizontalBox();
		boxHExtras.add(Box.createHorizontalStrut(10));
		boxHExtras.add(campoPuntos);
		boxHExtras.add(Box.createHorizontalGlue());
		boxHExtras.add(campoHoras);
		boxHExtras.setAlignmentY(BOTTOM_ALIGNMENT);

		Box boxHBotones=Box.createHorizontalBox();
		boxHBotones.add(Box.createHorizontalStrut(10));
		boxHBotones.add(campoAsignadoA);
		boxHBotones.add(Box.createHorizontalGlue());
		boxHBotones.add(botonAgregar);
		boxHBotones.setAlignmentY(BOTTOM_ALIGNMENT);
		
		boxVertical.setBounds(this.getBounds());
		boxVertical.add(boxHTitulo);
		boxVertical.add(Box.createVerticalStrut(5));
		boxVertical.add(check);
		boxVertical.add(Box.createVerticalStrut(5));
		boxVertical.add(panelSugerencia);
		boxVertical.add(Box.createVerticalStrut(5));
		boxVertical.add(boxHDetalle);
		boxVertical.add(Box.createVerticalGlue());
		boxVertical.add(boxHCriterio);
		boxVertical.add(Box.createVerticalGlue());
		boxVertical.add(boxHExtras);
		boxVertical.add(Box.createVerticalGlue());
		boxVertical.add(boxHBotones);
		
	}
	
	private void configurarAcciones() {
		agregarKeyListener();
		agregarListenerAlBoton();
		agregarFoco();
		agregarAccionCheck();
	}
	
	private void agregarAccionCheck(){
		check.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(mostrarSugerencias=check.isSelected()){

					check.setText("Sugerencias habilitadas");
					if(areaTitulo.getText().isEmpty()){
						areaTitulo.setText(resumen);
					}
					if(areaDetalle.getText().isEmpty()){
						areaDetalle.setText(detalle);
					}
					if(areaCriterios.getText().isEmpty()){
						areaCriterios.setText(criterio);
					}
				}else{
					mostrarSugerencias=false;
					check.setText("Sugerencias Deshabilitadas");
					if(areaSugerencia.isVisible()){
						areaSugerencia.setVisible(false);
					}
					if(areaTitulo.getText().equals(resumen)){
						areaTitulo.setText("");
					}
					if(areaDetalle.getText().equals(detalle)){
						areaDetalle.setText("");
					}
					if(areaCriterios.getText().equals(criterio)){
						areaCriterios.setText("");
					}
				}
				
			}
			
		});
	}

	private void agregarKeyListener(){
		areaTitulo.addKeyListener(new KeyListener(){
        	public void keyPressed(KeyEvent keyEvent){}

			@Override
			public void keyTyped(KeyEvent keyEvent) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if(!mostrarSugerencias){return;}
				if(keyEvent.getKeyCode()==KeyEvent.VK_SPACE){
        			String sugerencia=controlador.obtenerSugerencia(areaTitulo.getText());
        			if(!sugerencia.isEmpty()){
        				areaSugerencia.setText(sugerencia);
            			areaSugerencia.setVisible(true);
        			}else{
        				areaSugerencia.setVisible(false);
        			}
        			
        		}
			};
        });

		
		campoPuntos.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent keyEvent){}

			@Override
			public void keyTyped(KeyEvent keyEvent) {}
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				String caracter=String.valueOf(keyEvent.getKeyChar());
				String numeros="1234567890";
				if(!numeros.contains(caracter)){
					campoPuntos.setText(campoPuntos.getText().replace(caracter, ""));
        		}
			};
        });
		
		campoHoras.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent keyEvent){}

			@Override
			public void keyTyped(KeyEvent keyEvent) {}
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				String caracter=String.valueOf(keyEvent.getKeyChar());
				String numeros="1234567890";
				if(!numeros.contains(caracter)){
					campoHoras.setText(campoHoras.getText().replace(caracter, ""));
        		}
			};
        });
	}
	
	
	private void agregarListenerAlBoton(){
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String titulo=areaTitulo.getText();
				String detalle=areaDetalle.getText();
				if(titulo.equals(resumen)){
					JOptionPane.showMessageDialog(null, "No se puede guardar el formato de muestra, como una user story.");
					return;
				}
				if((!titulo.isEmpty()) && (!detalle.isEmpty())){
					String sugerencia=controlador.obtenerSugerencia(titulo);
					if(!sugerencia.isEmpty()){
						JOptionPane.showMessageDialog(null, sugerencia+"\nA pesar de la sugerencia ¿Aún desea guardar esta User Story?");
					}else{
						String criterios=areaCriterios.getText();
						String asignadoA=campoAsignadoA.getText();
						Integer horasEstimadas=0,puntos=0;
						try{
							horasEstimadas=Integer.getInteger(campoHoras.getText());

							puntos=Integer.getInteger(campoPuntos.getText());
							
						}catch(Exception excepcion){}
						controlador.altaUserStory(titulo,detalle,criterios,asignadoA,horasEstimadas,puntos);
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Una User Story necesita al menos un Titulo y el detalle. "
							+ "No se puede guardar esta User Story");
				}
			}
		});
	}
	
	private void agregarFoco(){
		areaTitulo.addFocusListener(new FocusListener() {
		      public void focusGained(FocusEvent e) {
		    	  areaTitulo.selectAll();
		      }
		      public void focusLost(FocusEvent e) {
		    	  areaTitulo.select(0, 0);
		      }
		});
		areaDetalle.addFocusListener(new FocusListener() {
		      public void focusGained(FocusEvent e) {
		    	  areaDetalle.selectAll();
		      }
		      public void focusLost(FocusEvent e) {
		    	  areaTitulo.select(0, 0);
		      }
		});
		areaCriterios.addFocusListener(new FocusListener() {
		      public void focusGained(FocusEvent e) {
		    	  areaCriterios.selectAll();
		      }
		      public void focusLost(FocusEvent e) {
		    	  areaTitulo.select(0,0);
		      }
		});
	}
		
	/*
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (true) {
		} else {
			JOptionPane.showMessageDialog(null, "Se desactivo la opción de sugerencias, "
					+ "recuerde que puede reactivar las sugerencias en cualquier momento");
		}
	}*/

}
