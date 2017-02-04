package pp2.scrum.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import pp2.scrum.burndownChart.OpcionGrafico;
import pp2.scrum.controller.BurndownChartController;

public class BurndownChartView extends JTabbedPane implements ActionListener {
    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    private ChartPanel panelAvance, panelEstimado, panelComparativo;
    private BurndownChartController controller;
    private JFreeChart xylineChart;

    public BurndownChartView(BurndownChartController controller) {
        this.controller = controller;
        
        initGraficos();
        
        setVisible(true);
        revalidate();
        repaint();
    }

    private void initGraficos() {

        dibujarGrafico( createSeries(OpcionGrafico.Avance), panelAvance,
                "Avance");
        dibujarGrafico(createSeries(OpcionGrafico.Estimado),
                panelEstimado, "Estimado");
        dibujarGrafico( createSeries(OpcionGrafico.Avance,OpcionGrafico.Estimado),
                panelComparativo, "Comparativo");
    }
    // Menu donde se selecciona el tipo de chart

    /* Esta función es la que propiamente dibuja el gráfico */

    private XYSeriesCollection createSeries(OpcionGrafico... tiposGraficos) {
        XYSeriesCollection collection = new XYSeriesCollection();
        for (OpcionGrafico grafico: tiposGraficos)
        {
            List<Integer> tabla = controller.getTablaDeValores(grafico);
            XYSeries serie = new XYSeries(grafico.toString());
            int pos = 0;
            for(Integer valor:tabla)
                serie.add(pos++, valor.doubleValue());
            
            collection.addSeries(serie);
        }
        
        return collection;
    }

    private void dibujarGrafico(XYSeriesCollection datos, ChartPanel panel,
            String tab) {
        this.xylineChart = ChartFactory.createXYLineChart("Burndown Chart",
                "Días", "Story Points", datos, PlotOrientation.VERTICAL, true,
                true, false);
        panel = new ChartPanel(xylineChart);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);

        final XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesPaint(0, Color.CYAN);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
        panel.setVisible(true);
        this.addTab(tab, panel);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
