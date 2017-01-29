package pp2.scrum.burndownChart;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import pp2.scrm.calendario.Calendario;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;
import pp2.scrum.servicios.ServiceRegistry;

public class Avance implements DataComponent{
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
		
		for (UserStory story: iteracion.getBacklog() )
			storyPointsDone += story.getStoryPoints();
		
		return storyPointsDone;
	}

	
	@Override
	public XYSeriesCollection getData(Sprint iteracion) {
		avance = new XYSeries( "Avance" );
		
		Date fechaInicio=iteracion.getfechaInicio();
		if (!ServiceRegistry.getInstance().hasService("calendario"))
	            throw new RuntimeException(
	                    "El servicio Calendario no fue inicializado.");
	        
	        Calendario calendario = (Calendario) ServiceRegistry.getInstance()
	                .getService("calendario");
	        
		int dias=calendario.getDuracion(fechaInicio,calendario.getToday());
		
		if (dias > iteracion.getDuracion())
			dias = iteracion.getDuracion();
		
		Integer storyPoints=iteracion.getStoryPointsPactados();
		for(int i=0;i<=dias;i++){
			storyPoints=storyPoints-this.getStoryPointsDone(fechaInicio, iteracion);
			fechaInicio = this.sumarDia(fechaInicio);
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
