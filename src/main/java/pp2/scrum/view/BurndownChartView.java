package pp2.scrum.view;

import pp2.scrum.burndownChart.OpcionGrafico;
import pp2.scrum.controller.BurndownChartController;

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
		this.controller=controller;
		dibujarGrafico(controller.getData(OpcionGrafico.Avance,1),panelAvance,"Avance");	
		dibujarGrafico(controller.getData(OpcionGrafico.Estimado,1),panelEstimado,"Estimado");
		dibujarGrafico(controller.getData(OpcionGrafico.Comparativo,1),panelComparativo,"Comparativo");
		setVisible(true);
      revalidate();
      repaint();
	}

	//Menu donde se selecciona el tipo de chart

	/*Esta función es la que propiamente dibuja el gráfico*/
	

	private void dibujarGrafico(XYSeriesCollection datos,ChartPanel panel,String tab){
		this.xylineChart = ChartFactory.createXYLineChart(
				"Burndown Chart","Días","Story Points",datos,
				PlotOrientation.VERTICAL,true,true,false);
		panel = new ChartPanel(xylineChart);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);

		final XYPlot plot = xylineChart.getXYPlot( );
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
		renderer.setSeriesPaint( 0 , Color.CYAN );
		renderer.setSeriesPaint( 1 , Color.BLUE);
		renderer.setSeriesStroke( 0 , new BasicStroke( 2.0f ) );
		renderer.setSeriesStroke( 1 , new BasicStroke( 2.0f ) );
		plot.setRenderer( renderer ); 
		panel.setVisible(true);
		this.addTab( tab, panel);
	}

   @Override
   public void actionPerformed(ActionEvent e)
   {
      // TODO Auto-generated method stub
      
   }

}
