package com.ungs.pp2.scrPP2.Dominio.Composite;

import java.util.ArrayList;
import java.util.Iterator;

import org.jfree.data.xy.*;

import com.ungs.pp2.scrPP2.Dominio.Entidad.Iteracion;

public class DataComposite  implements DataComponent{
	private ArrayList<DataComponent> dataGraficos;
	private XYSeriesCollection series;
	private Iteracion iteracion;
	
	public DataComposite(Iteracion iteracion)
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
		System.out.println("ESTOY");
		XYSeriesCollection series=new XYSeriesCollection();
		Iterator it=this.dataGraficos.iterator();
		while (it.hasNext()){
			DataComponent var=(DataComponent)it.next();
			series.addSeries(var.getData().getSeries(0));
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
	public XYSeriesCollection getData(Iteracion iteracion) {
		Iterator it=this.dataGraficos.iterator();
		this.series = new XYSeriesCollection();
		int indice=0;
		XYSeriesCollection data=new XYSeriesCollection();
		while(it.hasNext()){
			DataComponent datos= (DataComponent) it.next();
			XYSeries serie=datos.getData(iteracion).getSeries(indice);
			data.addSeries(serie);
		}
		return data;
	}

}
