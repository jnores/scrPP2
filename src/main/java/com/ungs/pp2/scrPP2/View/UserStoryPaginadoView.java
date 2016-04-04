package com.ungs.pp2.scrPP2.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;
import com.ungs.pp2.scrPP2.Dominio.Paginacion;
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
	private JPanel contentPane,panel;
	private Object[][] data;
	private JLabel PageNumberLabel;
	private List<UserStory> Stories;
	private JButton btnPrimero,btnAnterior,btnSiguiente,btnUltimo ;
	
	public UserStoryPaginadoView(UserStoryPaginadoController controller ) 
	{
		Controller = controller;
		setTitle("Historias de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 500, 200);
		
		btnPrimero = new JButton("");
		btnAnterior = new JButton("");
		btnSiguiente = new JButton("");
		btnUltimo = new JButton("");
		

		// Seteo la lista paginada con la 1º pagina por defecto
		Stories = controller.ListarUserStories(null);
		setearVista();
			
		btnAnterior.addActionListener(new ActionListener() 
		{ 
		   public void actionPerformed(ActionEvent e) 
		   { 
		      obtenerPaginaAnterior();
		   } 
		});
		btnSiguiente.addActionListener(new ActionListener() 
      { 
         public void actionPerformed(ActionEvent e) 
         { 
           obtenerPaginaSiguiente();
         } 
      });
		btnPrimero.addActionListener(new ActionListener() 
      { 
         public void actionPerformed(ActionEvent e) 
         { 
           obtenerPaginaPrimera();
         } 
      });
		btnUltimo.addActionListener(new ActionListener() 
      { 
         public void actionPerformed(ActionEvent e) 
         { 
           obtenerPaginaUltima();
         } 
      });
	}


	@Override
	public void update(Observable o, Object arg) {
	   setearVista();
	}
	
	public void showWindow(boolean b) {
		setVisible(b);
	}
	
	private void setearVista()
	{
	   if (Stories.size() == 0)
	   {
	      data = new Object[][] {{"No hay Historias"}} ;
	      PageNumberLabel = new JLabel(" - ");
	      habilitarBotones(false);
	   }
	   else 
	   {	      	   
   	   data = new Object[Stories.size()][] ;
         int i = 0;
         for (UserStory story : Stories)
         {
            Object[] fila = {story.getTitulo(), story.getDetalle(),story.getResponsable(),story.getEstado(),story.getStoryPoints()};
            data[i] = fila;
            i++;
            story.addObserver(this);
         }    
         PageNumberLabel = new JLabel(Controller.getPaginaActual().getPagina()+ " / " + Controller.getPaginasTotales());
         habilitarBotones(true);
	   }
	   String[] columnNames = {"Titulo", "Descripcion","Responsable","Estado","Puntos"};
	   @SuppressWarnings("serial")
      TableModel model = new DefaultTableModel(data, columnNames){
	      @Override
	      public boolean isCellEditable(int row, int column) {
	         //No editable
	         return false;
	      }
	   };
      table = new JTable(model);
      contentPane = new JPanel();
      panel = new JPanel();
      JTableHeader header = table.getTableHeader();
      setContentPane(contentPane);
      contentPane.setLayout(new BorderLayout());
      contentPane.add(header, BorderLayout.NORTH);
      contentPane.add(table, BorderLayout.CENTER);
      
      
      contentPane.add(panel, BorderLayout.SOUTH);
      
      
      ImageIcon primero = new ImageIcon(UserStoryPaginadoView.class.getResource("/com/ungs/pp2/scrPP2/Resources/Images/Primero.png"));
      btnPrimero.setIcon(primero);
      panel.add(btnPrimero);
      
      
      btnAnterior.setIcon(new ImageIcon(UserStoryPaginadoView.class.getResource("/com/ungs/pp2/scrPP2/Resources/Images/Anterior.png")));
      panel.add(btnAnterior);
      
      
      panel.add(PageNumberLabel);
      
      
      btnSiguiente.setIcon(new ImageIcon(UserStoryPaginadoView.class.getResource("/com/ungs/pp2/scrPP2/Resources/Images/Siguiente.png")));
      panel.add(btnSiguiente);
      
      
      btnUltimo.setIcon(new ImageIcon(UserStoryPaginadoView.class.getResource("/com/ungs/pp2/scrPP2/Resources/Images/Ultimo.png")));
      panel.add(btnUltimo);
      SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void habilitarBotones(boolean bool)
	{
	    btnPrimero.setEnabled(bool);
	    btnUltimo.setEnabled(bool);
	    btnSiguiente.setEnabled(bool);
	    btnAnterior.setEnabled(bool);
	}
	
	private void obtenerPaginaAnterior()
	{
	   Paginacion actual = Controller.getPaginaActual();
	   if (actual.getPagina() != 1)
	   {
	      Stories = Controller.ListarUserStories(new Paginacion(actual.getOrdenarPor(), actual.getDireccionOrden(), actual.getPagina() - 1, actual.getItemsPorPagina()));
	      setearVista();
	   }
	}
	
	private void obtenerPaginaSiguiente()
   {
	   Paginacion actual = Controller.getPaginaActual();
      if (actual.getPagina() != Controller.getPaginasTotales())
      {
         Stories = Controller.ListarUserStories(new Paginacion(actual.getOrdenarPor(), actual.getDireccionOrden(), actual.getPagina() + 1, actual.getItemsPorPagina()));
         setearVista();
      }
   }
	
	private void obtenerPaginaPrimera()
   {
	   Paginacion actual = Controller.getPaginaActual();
      if (actual.getPagina() != 1)
      {
         Stories = Controller.ListarUserStories(new Paginacion(actual.getOrdenarPor(), actual.getDireccionOrden(), 1, actual.getItemsPorPagina()));
         setearVista();
      }
   }
	
	private void obtenerPaginaUltima()
   {
	   Paginacion actual = Controller.getPaginaActual();
      if (actual.getPagina() != Controller.getPaginasTotales())
      {
         Stories = Controller.ListarUserStories(new Paginacion(actual.getOrdenarPor(), actual.getDireccionOrden(), Controller.getPaginasTotales(), actual.getItemsPorPagina()));
         setearVista();
      }      
   }
}