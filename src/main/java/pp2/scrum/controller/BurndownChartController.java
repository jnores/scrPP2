package pp2.scrum.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jfree.data.xy.XYSeriesCollection;

import pp2.scrum.dominio.composite.Avance;
import pp2.scrum.dominio.composite.DataComposite;
import pp2.scrum.dominio.composite.Estimado;
import pp2.scrum.dominio.entidad.Sprint;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.enums.Estado;
import pp2.scrum.dominio.enums.OpcionGrafico;
import pp2.scrum.dominio.interfaz.IConsulta;
import pp2.scrum.dominio.interfaz.IDataComponent;
import pp2.scrum.view.BurndownChartView;

public class BurndownChartController extends Controller
{
	private IDataComponent modelo;
	private BurndownChartView vista;
	private OpcionGrafico Opcion;

	public BurndownChartController(IConsulta consulta) {
		super(consulta);
	}
	
	public BurndownChartController(IConsulta consulta,IDataComponent modelo) 
	{
		super (consulta);
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
		   UserStory us1,us2,us3; 
		   List<UserStory> stories = new ArrayList<UserStory>();
			stories.add(us3=new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.Done, null, null));
			stories.add(us1=new UserStory("Titulo2", "Detalle2", "Autor2", "Responsable2", 10, 40, 1, Estado.Done, null, null));
			stories.add(us2=new UserStory("Titulo3", "Detalle3", "Autor3", "Responsable3", 10, 40, 1, Estado.Done, null, null));
			stories.add(new UserStory("Titulo4", "Detalle4", "Autor4", "Responsable4", 10, 40, 1, Estado.ToDo, null, null));
			Date fecha1 = new Date("03/10/2016"); 
			Date fecha2 = new Date("03/15/2016"); 
			Date fecha3 = new Date("03/20/2016");
			us1.setFecha(fecha2);
			us2.setFecha(fecha2);
			us3.setFecha(fecha3);
			Sprint iteracion=new Sprint(1,fecha1, 21, stories);
			return iteracion;
		}
	
}
