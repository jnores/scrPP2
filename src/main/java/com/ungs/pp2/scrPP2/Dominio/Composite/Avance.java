package com.ungs.pp2.scrPP2.Dominio.Composite;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import org.jfree.data.xy.*;

import com.ungs.pp2.scrPP2.Dominio.Entidad.Iteracion;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IDataComponent;

public class Avance implements IDataComponent{
	private XYSeries avance; 
	private XYSeriesCollection dataset;
	
	public Avance(Iteracion iteracion)
	{
		
	}
	
	@Override
	public XYSeriesCollection getData() {
		return null;
	}
	
	private Integer getStoryPointsDone(Date fecha,Iteracion iteracion)
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
	public XYSeriesCollection getData(Iteracion iteracion) {
		avance = new XYSeries( "Avance" );
		
		Date fecha=iteracion.getfechaInicio();
		Date fechaF= new Date();
		int dias=iteracion.getDiasTranscurridos();
		Integer storyPoints=iteracion.getStoryPointsPactados();
		for(int i=0;i<dias+1;i++){
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
