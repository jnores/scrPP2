package pp2.scrum.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jfree.data.xy.XYSeriesCollection;

import pp2.scrum.dominio.composite.Avance;
import pp2.scrum.dominio.composite.DataComposite;
import pp2.scrum.dominio.composite.Estimado;
import pp2.scrum.dominio.entidad.DataComponent;
import pp2.scrum.dominio.entidad.MailGateway;
import pp2.scrum.dominio.entidad.Sprint;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.utils.OpcionGrafico;
import pp2.scrum.view.BurndownChartView;

public class BurndownChartController extends Controller
{
	private DataComponent modelo;
	private BurndownChartView vista;
	private OpcionGrafico Opcion;

	public BurndownChartController(MailGateway mailGateway) {
		super( mailGateway);
	}
	
	public BurndownChartController(DataComponent modelo,MailGateway mailGateway) 
	{
		super (mailGateway);
		this.modelo= modelo;
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
		Sprint iteracion=retriveFromDatabase();
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
	
	
	//Esto es una porqueria, parcialmente lo copie de alguien
	private static Sprint retriveFromDatabase(){
		    List<UserStoryHelper> stories = new ArrayList<UserStoryHelper>();
			stories.add(new UserStoryHelper( new UserStory("Titulo1", "Detalle1", 40, null, null)));
			stories.add(new UserStoryHelper( new UserStory("Titulo2", "Detalle2", 40, null, null)));
			stories.add(new UserStoryHelper( new UserStory("Titulo3", "Detalle3", 40, null, null)));
			stories.add(new UserStoryHelper( new UserStory("Titulo4", "Detalle4", 40, null, null)));
			Date fecha1 = new Date("03/10/2016"); 
			Date fecha2 = new Date("03/15/2016"); 
			Date fecha3 = new Date("03/20/2016");
			Sprint iteracion=new Sprint(1,fecha1, 21, stories);
			return iteracion;
		}
	
}
