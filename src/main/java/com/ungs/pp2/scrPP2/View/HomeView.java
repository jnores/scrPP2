package com.ungs.pp2.scrPP2.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.ungs.pp2.scrPP2.MainUserStoryList;
import com.ungs.pp2.scrPP2.Consulta.Consulta;
import com.ungs.pp2.scrPP2.Controller.BurndownChartController;
import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.Controller.ProyectoController;
import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.Proyecto;
import com.ungs.pp2.scrPP2.utils.Logger;
import com.ungs.pp2.scrPP2.windows.UserStoryOrderableWindow;

public class HomeView  extends JFrame implements ActionListener
{
	/**
    * 
    */
   private static final long serialVersionUID = 1L;
   private JPanel panel_Top;
	private HomeController controller;
	private BurndownChartView burndownChartViewpanel;
	private UserStoryPaginadoView listadoPaginadoHistorias;
	private UserStoryOrderableWindow filtradoHistorias;
	private ProyectoNuevoView proyectoNuevo;
	private JMenuBar menuBar;
	private JMenu menuP,menuI,mnHistoria,mnBacklog;
	private JMenuItem mnListadoHistoriasItem,mnBurnDownchartItem,mnFiltradoItem,mnNuevoProyectoItem,menu5,menu6;

	public HomeView (HomeController controller)
	{
	   getContentPane().setLayout(new BorderLayout());
	   burndownChartViewpanel = new BurndownChartView(new BurndownChartController(null, null));
	   listadoPaginadoHistorias = new UserStoryPaginadoView(new UserStoryPaginadoController(new Consulta()));
	   filtradoHistorias = new UserStoryOrderableWindow(new UserStoryListView(new ProyectoController(null, MainUserStoryList.retriveProyectoFromDatabase()).getAllUserStories()));
	   proyectoNuevo = new ProyectoNuevoView(new ProyectoController(null, new Proyecto()));
	   
		setTitle("Scrummer");
		this.controller=controller;
		this.setJMenuBar(cargarMenu());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        Logger.close();
		    }
		});
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		//getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_Top = new JPanel();
		panel_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_Top,BorderLayout.NORTH);
		//panel_Top.setLayout(new BorderLayout(0, 0));
		
		JLabel lblProyecto = new JLabel("Proyecto");
		panel_Top.add(lblProyecto);
		
		JLabel label = new JLabel("-");
		panel_Top.add(label);
		
		JLabel lblNumeroIteracion = new JLabel("#");
		panel_Top.add(lblNumeroIteracion);
		
		JLabel lblIteracin = new JLabel("Iteración");
		panel_Top.add(lblIteracin);
		
		//panel_Main = new JPanel();
		//panel_Main.setLayout(new BorderLayout());	
		
		burndownChartViewpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(burndownChartViewpanel,BorderLayout.CENTER);
		
		//burndownChartViewpanel.setVisible(true);
      /*panel_Main.add(burndownChartViewpanel);
      panel_Main.setBorder(new LineBorder(new Color(0, 0, 0)));
      panel_Main.setBounds(0, 21, 584, 319);*/
		
		mnListadoHistoriasItem.addActionListener(new ActionListener() 
      { 
         public void actionPerformed(ActionEvent e) 
         { 
            MostrarListadoPaginadoHistorias();
            setearVista();
         } 
      });
		
		mnBurnDownchartItem.addActionListener(new ActionListener() 
      { 
         public void actionPerformed(ActionEvent e) 
         { 
            MostrarBurndownChart();
            setearVista();
         } 
      });
		
		mnFiltradoItem.addActionListener(new ActionListener() 
      { 
         public void actionPerformed(ActionEvent e) 
         { 
            MostrarFiltradoHistorias();
            setearVista();
         } 
      });
	}

	//Menu donde se selecciona el tipo de chart
	private JMenuBar cargarMenu(){

		menuBar= new JMenuBar();
		menuP= new JMenu("Proyecto");
		menuI= new JMenu("Iteracion");
		
		//menuP.add(menu1=new JMenuItem("Avance"));
		//menuP.add(menu2=new JMenuItem("Estimado"));
		//menuP.add(menu3=new JMenuItem("Comparativo"));

		menuI.add(mnBurnDownchartItem=new JMenuItem("Primera"));
		menuI.add(menu5=new JMenuItem("Segunda"));
		menuI.add(menu6=new JMenuItem("Tercera"));

		menuBar.add(menuP);
		
		mnNuevoProyectoItem = new JMenuItem("Nuevo Proyecto");
		mnNuevoProyectoItem.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		      proyectoNuevo.setVisible(true);
		   }
		});
		menuP.add(mnNuevoProyectoItem);
		
		mnBacklog = new JMenu("Backlog");
		menuBar.add(mnBacklog);
		menuBar.add(menuI);

		mnHistoria = new JMenu("Historia");
      menuBar.add(mnHistoria);
      
      mnListadoHistoriasItem = new JMenuItem("Listado");
      mnHistoria.add(mnListadoHistoriasItem);
      
      mnFiltradoItem = new JMenuItem("Filtrado");
      mnHistoria.add(mnFiltradoItem);
		return menuBar;
	}
	
	private void MostrarListadoPaginadoHistorias()
	{
	   getContentPane().remove(1);
	   getContentPane().add(listadoPaginadoHistorias,BorderLayout.CENTER);
	}
	
	private void MostrarBurndownChart()
   {
	   getContentPane().remove(1);
	   burndownChartViewpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
      getContentPane().add(burndownChartViewpanel,BorderLayout.CENTER);
   }
	
	private void MostrarFiltradoHistorias()
   {
      getContentPane().remove(1);
      //burndownChartViewpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
      getContentPane().add(filtradoHistorias,BorderLayout.CENTER);
   }
	
	private void setearVista()
	{
	   SwingUtilities.updateComponentTreeUI(this);
	}

	

	public void showWindow(boolean esVisible) {
		setVisible(esVisible);
	}

   @Override
   public void actionPerformed(ActionEvent e)
   {
      // TODO Auto-generated method stub
      
   }
	
}
