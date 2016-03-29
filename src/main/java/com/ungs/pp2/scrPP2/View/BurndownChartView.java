package com.ungs.pp2.scrPP2.View;

import com.ungs.pp2.scrPP2.Controller.BurndownChartController;
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

public class BurndownChartView  extends JFrame implements ActionListener
{
	private ChartPanel panel;
	private BurndownChartController controller;	
	private JMenuBar menuBar;
	private JMenu menuP,menuI;
	private JMenuItem menu1,menu2,menu3,menu4,menu5,menu6;
	private JFreeChart xylineChart;

	public BurndownChartView (BurndownChartController controller)
	{
		setTitle("Burndown Chart");
		this.setLayout(new FlowLayout());
		this.controller=controller;
		this.setJMenuBar(cargarMenu());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);

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
		menuBar.add(menuI);

		//this.menu1.addActionListener(this);
		//this.menu2.addActionListener(this);
		//this.menu3.addActionListener(this);
		this.menu4.addActionListener(this);
		this.menu5.addActionListener(this);
		this.menu6.addActionListener(this);
		return menuBar;
	}

	/*Esta función es la que propiamente dibuja el gráfico*/
	private void dibujarGrafico(XYSeriesCollection datos){
		this.xylineChart = ChartFactory.createXYLineChart(
				"Burndown Chart","Días","Story Points",datos,
				PlotOrientation.VERTICAL,true,true,false);
		this.panel = new ChartPanel(xylineChart);
		this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.panel);
		this.panel.setLayout(null);

		final XYPlot plot = xylineChart.getXYPlot( );
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
		renderer.setSeriesPaint( 0 , Color.CYAN );
		renderer.setSeriesPaint( 1 , Color.BLUE);
		renderer.setSeriesStroke( 0 , new BasicStroke( 2.0f ) );
		renderer.setSeriesStroke( 1 , new BasicStroke( 2.0f ) );
		plot.setRenderer( renderer ); 
		setContentPane( this.panel );
		this.panel.setVisible(true);
		this.showWindow(true);
	}


	public void showWindow(boolean esVisible) {
		setVisible(esVisible);
	}

	//Se encarga de informar al controlador del evento.
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando=evento.getActionCommand();
		Integer iteracion=null;
		if (evento.getSource().equals(menu4)||
				evento.getSource().equals(menu5)||
				evento.getSource().equals(menu6))
		{
			try
			{iteracion=Integer.valueOf(JOptionPane.showInputDialog("Ingrese el número de Iteración"));}
			catch (Exception e)
			{JOptionPane.showMessageDialog(null, "Hubo un error al ingresar la iteración");}
		}
		
		if (evento.getSource().equals(menu1))
		{this.controller.getData(OpcionGrafico.Avance);}
		if (evento.getSource().equals(menu2))
		{this.controller.getData(OpcionGrafico.Estimado);}
		if (evento.getSource().equals(menu3))
		{this.controller.getData(OpcionGrafico.Comparativo);}
		if (evento.getSource().equals(menu4))
		{this.dibujarGrafico(this.controller.getData(OpcionGrafico.Avance,iteracion));}
		if (evento.getSource().equals(menu5))
		{this.dibujarGrafico(this.controller.getData(OpcionGrafico.Estimado,iteracion));}
		if (evento.getSource().equals(menu6))
		{this.dibujarGrafico(this.controller.getData(OpcionGrafico.Comparativo,iteracion));}
		
	}

}
