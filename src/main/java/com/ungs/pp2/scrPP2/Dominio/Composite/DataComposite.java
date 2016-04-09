package com.ungs.pp2.scrPP2.Dominio.Composite;

import java.util.ArrayList;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.ungs.pp2.scrPP2.Dominio.Entidad.Sprint;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IDataComponent;

public class DataComposite  implements IDataComponent{
	private ArrayList<IDataComponent> dataGraficos;
	private XYSeriesCollection series;
	private Sprint iteracion;
	
	public DataComposite(Sprint iteracion)
	{
		this.iteracion=iteracion;
		this.dataGraficos=new ArrayList<IDataComponent>();
		IDataComponent data=new Avance(iteracion);
		this.dataGraficos.add(data);
		data=new Estimado(iteracion);
		this.dataGraficos.add(data);
	}

	@Override
	public XYSeriesCollection getData() {
		System.out.println("ESTOY");
		XYSeriesCollection series=new XYSeriesCollection();
		for (IDataComponent it: this.dataGraficos) {
			series.addSeries(it.getData().getSeries(0));
		}
		return series;
	}
	
	public void addData(IDataComponent data){
		if (this.dataGraficos==null)
		{
			this.dataGraficos=new ArrayList<IDataComponent>();
		}
		this.dataGraficos.add(data);
	}

	@Override
	public XYSeriesCollection getData(Sprint iteracion) {
		this.series = new XYSeriesCollection();
		int indice=0;
		XYSeriesCollection data=new XYSeriesCollection();
		
		for (IDataComponent it: this.dataGraficos) {
			XYSeries serie=it.getData(iteracion).getSeries(indice);
			data.addSeries(serie);
		}
		return data;
	}

}
