package pp2.scrum.view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutFocusTraversalPolicy;

import pp2.scrum.controller.UserStoryController;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

//No incluyo autor, eso esta almacenado en el logueo. El id igual, viene como dato. 
public class AltaUserStoryView extends JPanel{

	private final JTextArea areaTitulo;
	private final JTextArea areaDetalle;
	private	final JTextArea areaCriterios;
	private final JTextArea areaSugerenciaTitulo;
	private final JTextArea areaSugerenciaCriterio;
	private final JTextField campoPuntos;
	
	private JPanel panelTitulo,panelDetalle,panelCriterio,panelSugerenciaTitulo,panelSugerenciaCriterio;
	private JScrollPane scrollTitulo,scrollDetalle,scrollCriterio;
	
	private boolean mostrarSugerencias;
	private JCheckBox check;
	private Box boxVertical;
	private JButton botonAgregar,botonAgregarTareas;
	private UserStoryController controlador;
	
	private final String resumen="Como <Rol> necesito <Meta> para <Finalidad>.";
	private final String  detalle="Utilice este espacio para explicar con más detalle, la meta y el propósito de esta user story";
	private final String criterio="Especifique criterios de aceptación para la user story.\n"
			+ "Intente que los criterios tengan una correspondencia con los test.";
	
	private AltaTareaView altaTarea;
	
	private static final long serialVersionUID = 1L; 

	public AltaUserStoryView(UserStoryController controlador)
	{
		this.controlador=controlador;
		mostrarSugerencias=true;
		boxVertical=Box.createVerticalBox();
		panelTitulo=new JPanel();panelDetalle=new JPanel();panelCriterio=new JPanel();panelSugerenciaTitulo=new JPanel();panelSugerenciaCriterio=new JPanel();
		scrollTitulo=new JScrollPane();scrollDetalle=new JScrollPane();scrollCriterio=new JScrollPane();
		

		botonAgregarTareas=new JButton("Tareas");
		botonAgregarTareas.setAlignmentX(Box.LEFT_ALIGNMENT);
		
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
		
		areaSugerenciaTitulo=new JTextArea(2,40);
		areaSugerenciaTitulo.setForeground(Color.red);
		areaSugerenciaTitulo.setBorder(BorderFactory.createTitledBorder("Sugerencia"));
		areaSugerenciaTitulo.setVisible(false);
		areaSugerenciaTitulo.setEditable(false);
		areaSugerenciaTitulo.setLineWrap(true);
		areaSugerenciaTitulo.setWrapStyleWord(true);
		panelSugerenciaTitulo.add(areaSugerenciaTitulo);
		

		areaSugerenciaCriterio=new JTextArea(2,40);
		areaSugerenciaCriterio.setForeground(Color.red);
		areaSugerenciaCriterio.setBorder(BorderFactory.createTitledBorder("Sugerencia"));
		areaSugerenciaCriterio.setVisible(false);
		areaSugerenciaCriterio.setEditable(false);
		areaSugerenciaCriterio.setLineWrap(true);
		areaSugerenciaCriterio.setWrapStyleWord(true);
		panelSugerenciaCriterio.add(areaSugerenciaCriterio);
		
		campoPuntos=new JTextField();
		campoPuntos.setBorder(BorderFactory.createTitledBorder("Puntos:"));
		campoPuntos.setAlignmentX(Box.LEFT_ALIGNMENT);
		
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
		boxHSugerencia.add(panelSugerenciaTitulo);
		boxHSugerencia.setAlignmentY(BOTTOM_ALIGNMENT);
		
		
		Box boxHExtras=Box.createHorizontalBox();
		boxHExtras.add(Box.createHorizontalStrut(10));
		boxHExtras.add(campoPuntos);
		boxHExtras.setAlignmentY(BOTTOM_ALIGNMENT);

		Box boxHBotones=Box.createHorizontalBox();
		boxHBotones.add(botonAgregarTareas); //BOTON que agrega tareas
		boxHBotones.add(botonAgregar);
		boxHBotones.setAlignmentY(BOTTOM_ALIGNMENT);
		
		boxVertical.setBounds(this.getBounds());
		boxVertical.add(boxHTitulo);
		boxVertical.add(Box.createVerticalStrut(5));
		boxVertical.add(check);
		boxVertical.add(Box.createVerticalStrut(5));
		boxVertical.add(panelSugerenciaTitulo);
		boxVertical.add(Box.createVerticalStrut(5));
		boxVertical.add(boxHDetalle);
		boxVertical.add(Box.createVerticalGlue());
		boxVertical.add(boxHCriterio);
		boxVertical.add(Box.createVerticalStrut(5));
		boxVertical.add(panelSugerenciaCriterio);
		boxVertical.add(Box.createVerticalStrut(5));
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
					if(areaSugerenciaTitulo.isVisible()){
						areaSugerenciaTitulo.setVisible(false);
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
				if(keyEvent.getKeyCode()==KeyEvent.VK_SPACE|| keyEvent.getKeyCode()==KeyEvent.VK_TAB|| keyEvent.getKeyCode()==KeyEvent.VK_ENTER){
        			String sugerencia=controlador.obtenerSugerenciaTitulo(areaTitulo.getText());
        			if(!sugerencia.isEmpty()){
        				areaSugerenciaTitulo.setText(sugerencia);
            			areaSugerenciaTitulo.setVisible(true);
        			}else{
        				areaSugerenciaTitulo.setVisible(false);
        			}
        			
        		}
			};
        });

		areaCriterios.addKeyListener(new KeyListener(){
        	public void keyPressed(KeyEvent keyEvent){}

			@Override
			public void keyTyped(KeyEvent keyEvent) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if(!mostrarSugerencias){return;}
				if(keyEvent.getKeyCode()==KeyEvent.VK_SPACE || keyEvent.getKeyCode()==KeyEvent.VK_TAB || keyEvent.getKeyCode()==KeyEvent.VK_ENTER){
        			String sugerencia=controlador.obtenerSugerenciaCriterio(areaCriterios.getText());
        			if(!sugerencia.isEmpty()){
        				areaSugerenciaCriterio.setText(sugerencia);
        				areaSugerenciaCriterio.setVisible(true);
        			}else{
        				areaSugerenciaCriterio.setVisible(false);
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
					String sugerencia=controlador.obtenerSugerenciaTitulo(titulo);
					if(!sugerencia.isEmpty()){
						int resultado=JOptionPane.showOptionDialog(null, sugerencia+"\nA pesar de la sugerencia ¿Aún desea guardar esta User Story?", 
								"Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,null,null);
						if(resultado==JOptionPane.YES_OPTION){
							guardarUserStory(titulo,detalle);
						}
					}else{
							guardarUserStory(titulo,detalle);
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Una User Story necesita al menos un Titulo y el detalle. "
							+ "No se puede guardar esta User Story");
				}
			}						
		});
		botonAgregarTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(altaTarea==null){
					altaTarea=new AltaTareaView();
				}else{
					if(altaTarea.isDisplayable()){
						altaTarea.setVisible(true);
					}else{
						altaTarea=new AltaTareaView();;
					}
				}
			}	
		});
	}
	
	private void guardarUserStory(String titulo,String detalle){
		String criterios=areaCriterios.getText();
		Integer puntos=0;
		try{
			puntos=Integer.parseInt(campoPuntos.getText());
			if(altaTarea.isDisplayable()){
				ArrayList<String> tareas=altaTarea.getTareas();
			}
			controlador.altaUserStory(titulo,detalle,criterios,puntos);
		}catch(Exception excepcion) {
			JOptionPane.showMessageDialog(null, "ERROR: Al intentar agregar la user story\n" +
					excepcion.getMessage());
		}
		if(this.altaTarea.isActive()){
			altaTarea.dispose();
		}
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
}
