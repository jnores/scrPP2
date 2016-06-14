package pp2.scrum.dominio.composite;

import java.util.ArrayList;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import pp2.scrum.dominio.entidad.DataComponent;
import pp2.scrum.dominio.entidad.Sprint;

public class DataComposite  implements DataComponent{
	private ArrayList<DataComponent> dataGraficos;
	private XYSeriesCollection series;
	private Sprint iteracion;
	
	public DataComposite(Sprint iteracion)
	{
		this.iteracion=iteracion;
		this.dataGraficos=new ArrayList<DataComponent>();
		DataComponent data=new Avance(iteracion);
		this.dataGraficos.add(data);
		data=new Estimado(iteracion);
		this.dataGraficos.add(data);
	}

	@Override
	public XYSeriesCollection getData() {
		XYSeriesCollection series=new XYSeriesCollection();
		for (DataComponent it: this.dataGraficos) {
			series.addSeries(it.getData().getSeries(0));
		}
		return series;
	}
	
	public void addData(DataComponent data){
		if (this.dataGraficos==null)
		{
			this.dataGraficos=new ArrayList<DataComponent>();
		}
		this.dataGraficos.add(data);
	}

	@Override
	public XYSeriesCollection getData(Sprint iteracion) {
		this.series = new XYSeriesCollection();
		int indice=0;
		XYSeriesCollection data=new XYSeriesCollection();
		
		for (DataComponent it: this.dataGraficos) {
			XYSeries serie=it.getData(iteracion).getSeries(indice);
			data.addSeries(serie);
		}
		return data;
	}

}
