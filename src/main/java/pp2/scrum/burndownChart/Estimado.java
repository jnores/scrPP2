package pp2.scrum.burndownChart;

import java.util.List;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import pp2.scrum.domain.Sprint;
import pp2.scrum.domain.UserStory;

/**
 * Componente hoja, muestra la situación idealizada, 
 * con un ritmo constante de realización de story points. 
 **/

public class Estimado implements DataComponent 
{
	private Integer storyPointsPactados, dias;

	//Contempla solo la iteración, no el proyecto.
	public Estimado(Sprint iteracion)
	{
		
	}
	
	//Todavía no tengo el de proyecto, basicamente porque no tengo cuanto dura el proyecto XD
	/*public Estimado(List<UserStory> historias)
	{
		this.storyPointsPactados=0;
		Iterator it=historias.iterator();
		while (it.hasNext())
		{
			UserStory story=(UserStory) it.next();
			this.storyPointsPactados=+story.getStoryPoints();
		}
	}*/

	/**todavía no tengo como implementarlo, para el proyecto 
	(no tengo en ningun lado la duracion del proyecto)*/
	@Override
	public XYSeriesCollection getData() 
	{
		return null;
	}
	
	private Integer getTotalStoryPoints(List<UserStory> historias){
		storyPointsPactados=0;
		for(UserStory story: historias )
			storyPointsPactados += story.getStoryPoints();
		
		return storyPointsPactados;
	}

	@Override
	public XYSeriesCollection getData(Sprint iteracion) {
		this.dias=iteracion.getDuracion();
		Integer storyPoints,reduccion;
		storyPoints=this.getTotalStoryPoints(iteracion.getUserStories());
		final XYSeries estimado = new XYSeries( "Estimado" );
		
		reduccion=this.storyPointsPactados/this.dias;

		for(int dia=0;dia<=this.dias;dia++){
			estimado.add(dia,storyPoints);
			storyPoints=storyPoints-reduccion;
		}             
		final XYSeriesCollection dataset = new XYSeriesCollection( );   
		dataset.addSeries(estimado);		
		return dataset;
	}
		
}
