package pp2.scrum.dominio.composite;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import org.jfree.data.xy.*;

import pp2.scrum.dominio.entidad.Sprint;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.interfaz.IDataComponent;

public class Avance implements IDataComponent{
	private XYSeries avance; 
	private XYSeriesCollection dataset;
	
	public Avance(Sprint iteracion)
	{
		
	}
	
	@Override
	public XYSeriesCollection getData() {
		return null;
	}
	
	private Integer getStoryPointsDone(Date fecha,Sprint iteracion)
	{
		Integer storyPointsDone=0;
		Iterator<UserStory> it=iteracion.getUserStories().iterator();
		
		while(it.hasNext())
		{
			UserStory story= it.next();
			//ver
			Date fechaDone=story.getFechaDone();
			
			if(fechaDone!=null)
				if(fecha.compareTo(story.getFechaDone())==0){
					storyPointsDone=storyPointsDone+story.getStoryPoints();
			}
		}
		return storyPointsDone;
	}

	
	@Override
	public XYSeriesCollection getData(Sprint iteracion) {
		avance = new XYSeries( "Avance" );
		
		Date fecha=iteracion.getfechaInicio();
		Date fechaF= new Date();
		int dias=iteracion.getDiasTranscurridos();
		
		if (dias > iteracion.getDuracion())
			dias = iteracion.getDuracion();
		
		Integer storyPoints=iteracion.getStoryPointsPactados();
		for(int i=0;i<=dias;i++){
			storyPoints=storyPoints-this.getStoryPointsDone(fecha, iteracion);
			fecha = this.sumarDia(fecha);
			avance.add(i,storyPoints);
		}
	             
		dataset = new XYSeriesCollection( );   
		dataset.addSeries(avance);
		return dataset;
	}
	
	private Date sumarDia(Date fecha)
	{
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(fecha);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

}
