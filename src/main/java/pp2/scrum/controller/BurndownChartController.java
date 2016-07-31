package pp2.scrum.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jfree.data.xy.XYSeriesCollection;

import pp2.scrum.burndownChart.Avance;
import pp2.scrum.burndownChart.DataComponent;
import pp2.scrum.burndownChart.DataComposite;
import pp2.scrum.burndownChart.Estimado;
import pp2.scrum.burndownChart.OpcionGrafico;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;
import pp2.scrum.view.BurndownChartView;

public class BurndownChartController extends Controller
{
	private DataComponent modelo;
	private BurndownChartView vista;
	private OpcionGrafico Opcion;
	private Sprint iteracion;

	public BurndownChartController(MailGateway mailGateway) {
		super();
	}
	
	public BurndownChartController(Sprint iteracion) 
	{
		this.iteracion= iteracion;
	}
	
	private void setModelo(OpcionGrafico opcion,Sprint iteracion){
		if(opcion.compareTo(opcion.Estimado)==0){
			modelo=new Estimado(iteracion);
		}
		if(opcion.compareTo(opcion.Avance)==0){
			modelo=new Avance(iteracion);
		}
		if(opcion.compareTo(opcion.Comparativo)==0){
			modelo=new DataComposite(iteracion);
		}
	}
	
	public XYSeriesCollection getData(OpcionGrafico opcion, Integer it)
	{	
		//Tengo que ver quien levanta esa maldita iteracion como tal, por ahora me cargo una berreta 
		setModelo(opcion,iteracion);
		if(it==iteracion.getIdIteracion())
			return modelo.getData(iteracion);
		 return null;
	}
	public XYSeriesCollection getData(OpcionGrafico opcion)
	{
		//setModelo(opcion);
		return null;
	}
	
}
