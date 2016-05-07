package com.ungs.pp2.scrPP2.View;

import com.ungs.pp2.scrPP2.Controller.BurndownChartController;
import com.ungs.pp2.scrPP2.Dominio.Enums.OpcionGrafico;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.BorderLayout;

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class BurndownChartView  extends JTabbedPane implements ActionListener
{
	/**
    * 
    */
   private static final long serialVersionUID = 1L;
   private ChartPanel panelAvance,panelEstimado,panelComparativo;
	private BurndownChartController controller;	
	private JFreeChart xylineChart;

	public BurndownChartView (BurndownChartController controller)
	{	   
		//setTitle("Burndown Chart");
		this.controller=controller;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(400,200);
		//this.setLocationRelativeTo(null);
      
      //this.setLayout(new BorderLayout());
		//this.setLayout(new FlowLayout());
		//this.setSize(600,400);

		dibujarGrafico(controller.getData(OpcionGrafico.Avance,1),panelAvance,"Avance");	
		dibujarGrafico(controller.getData(OpcionGrafico.Estimado,1),panelEstimado,"Estimado");
		dibujarGrafico(controller.getData(OpcionGrafico.Comparativo,1),panelComparativo,"Comparativo");
	// Create a tabbed pane
		//this.setLayout(new BorderLayout());
		setVisible(true);
		//this.add(panelAvance, BorderLayout.CENTER);
      revalidate();
      repaint();
      //this.setLayout(null);
      //topPanel.add( tabbedPane, BorderLayout.CENTER ); BORRAR
	}

	//Menu donde se selecciona el tipo de chart

	/*Esta función es la que propiamente dibuja el gráfico*/
	

	private void dibujarGrafico(XYSeriesCollection datos,ChartPanel panel,String tab){
		this.xylineChart = ChartFactory.createXYLineChart(
				"Burndown Chart","Días","Story Points",datos,
				PlotOrientation.VERTICAL,true,true,false);
		panel = new ChartPanel(xylineChart);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(panel);
		panel.setLayout(null);

		final XYPlot plot = xylineChart.getXYPlot( );
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
		renderer.setSeriesPaint( 0 , Color.CYAN );
		renderer.setSeriesPaint( 1 , Color.BLUE);
		renderer.setSeriesStroke( 0 , new BasicStroke( 2.0f ) );
		renderer.setSeriesStroke( 1 , new BasicStroke( 2.0f ) );
		plot.setRenderer( renderer ); 
		//setContentPane( this.panel );
		panel.setVisible(true);
		this.addTab( tab, panel);
		//this.add(panel, BorderLayout.CENTER);
		//panel.repaint();
		//this.showWindow(true);
	}

   @Override
   public void actionPerformed(ActionEvent e)
   {
      // TODO Auto-generated method stub
      
   }


	/*public void showWindow(boolean esVisible) {
		setVisible(esVisible);
	}*/


	/*
	public void actionPerformed(ActionEvent evento) {
		String comando=evento.getActionCommand();
		Integer iteracion=null;
		XYSeriesCollection datos = null;
		if (evento.getSource().equals(menu4)||
				evento.getSource().equals(menu5)||
				evento.getSource().equals(menu6))
		{
			try
			{iteracion=Integer.valueOf(JOptionPane.showInputDialog("Ingrese el número de Iteración"));}
			catch (Exception e)
			{JOptionPane.showMessageDialog(null, "Hubo un error al ingresar la iteración");}
		}
		
		if (evento.getSource().equals(menu1)) {
			datos = this.controller.getData(OpcionGrafico.Avance);
		} else if (evento.getSource().equals(menu2)) { 
			datos = this.controller.getData(OpcionGrafico.Estimado);
		} else if (evento.getSource().equals(menu3)) { 
			datos = this.controller.getData(OpcionGrafico.Comparativo);
		} else if (evento.getSource().equals(menu4)) {
			datos = this.controller.getData(OpcionGrafico.Avance,iteracion);
		} else if (evento.getSource().equals(menu5)) {
			datos = this.controller.getData(OpcionGrafico.Estimado,iteracion);
		} else if (evento.getSource().equals(menu6)) {
			datos = this.controller.getData(OpcionGrafico.Comparativo,iteracion);
		}
		
		/*if (datos != null) {
			this.dibujarGrafico(datos);
		} else {
			JOptionPane.showMessageDialog(null, "No se poseen suficientes datos para realizar el gráfico");
		}
	}*/

}
