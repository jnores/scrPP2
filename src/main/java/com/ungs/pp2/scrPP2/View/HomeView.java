package com.ungs.pp2.scrPP2.View;

import com.ungs.pp2.scrPP2.Controller.BurndownChartController;
import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.Dominio.Enums.OpcionGrafico;

import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.Color;
import java.awt.BasicStroke; 

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Panel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class HomeView  extends JFrame implements ActionListener
{
	/**
    * 
    */
   private static final long serialVersionUID = 1L;
   private JPanel panel_Main;
   private JPanel panel_Top;
	private HomeController controller;
	private BurndownChartView burndownChartViewpanel;
	private JMenuBar menuBar;
	private JMenu menuP,menuI;
	private JMenuItem menu1,menu2,menu3,menu4,menu5,menu6;
	private JFreeChart xylineChart;

	public HomeView (HomeController controller)
	{
	   burndownChartViewpanel = new BurndownChartView(new BurndownChartController(null, null));
	   
		setTitle("Scrummer");
		this.controller=controller;
		this.setJMenuBar(cargarMenu());
		
		JMenu mnHistoria = new JMenu("Historia");
		menuBar.add(mnHistoria);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panel_Top = new JPanel();
		panel_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Top.setBounds(0, 0, 584, 26);
		getContentPane().add(panel_Top);
		
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
		burndownChartViewpanel.setBounds(0, 28, 584, 312);
		getContentPane().add(burndownChartViewpanel);
		
		//burndownChartViewpanel.setVisible(true);
      /*panel_Main.add(burndownChartViewpanel);
      panel_Main.setBorder(new LineBorder(new Color(0, 0, 0)));
      panel_Main.setBounds(0, 21, 584, 319);*/
	}

	//Menu donde se selecciona el tipo de chart
	private JMenuBar cargarMenu(){

		menuBar= new JMenuBar();
		menuP= new JMenu("Proyecto");
		menuI= new JMenu("Iteracion");
		
		//menuP.add(menu1=new JMenuItem("Avance"));
		//menuP.add(menu2=new JMenuItem("Estimado"));
		//menuP.add(menu3=new JMenuItem("Comparativo"));

		menuI.add(menu4=new JMenuItem("Avance"));
		menuI.add(menu5=new JMenuItem("Estimado"));
		menuI.add(menu6=new JMenuItem("Comparativo"));

		menuBar.add(menuP);
		
		JMenu mnBacklog = new JMenu("Backlog");
		menuBar.add(mnBacklog);
		menuBar.add(menuI);

		//this.menu1.addActionListener(this);
		//this.menu2.addActionListener(this);
		//this.menu3.addActionListener(this);
		this.menu4.addActionListener(this);
		this.menu5.addActionListener(this);
		this.menu6.addActionListener(this);
		return menuBar;
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
