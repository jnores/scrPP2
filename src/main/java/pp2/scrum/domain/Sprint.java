package pp2.scrum.domain;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import pp2.scrum.controller.UserStoryHelper;

public class Sprint {
	private int idIteracion;
	private Date fechaInicio;
	private int duracion;
	private List<UserStoryHelper> sprintBacklog;
	private int StoryPointsPactados; 
	private GregorianCalendar calendario;
	
	public Sprint(int idIteracion,Date fechaInicio, int duracion, List<UserStoryHelper> historias) {
		this.idIteracion = idIteracion;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.sprintBacklog = historias;
		this.setStoryPointsPactados();
	}
	
	private void setStoryPointsPactados(){
		int puntos=0;
		if(this.sprintBacklog!=null){
			for (UserStoryHelper us: this.sprintBacklog) {
				puntos+=us.getStoryPoints();
			}
		}
		this.StoryPointsPactados=puntos;
	}

	public int getIdIteracion() {
		return this.idIteracion;
	}

	public Date getfechaInicio() {
		return this.fechaInicio;
	}
	
	public List<UserStoryHelper> getUserStories() {
		return this.sprintBacklog;
	}

	public void setDuracion(int dias) {
		this.duracion=dias;
	}

	public void setUserStories(List<UserStoryHelper> historias) {
		this.sprintBacklog=historias;
	}
	
	public void setUserStory(UserStoryHelper historia) {
		this.StoryPointsPactados=+historia.getStoryPoints();
		this.sprintBacklog.add(historia);
	}

	public int getDuracion() {
		return this.duracion;
	}
	
	public int getStoryPointsPactados() {
		return this.StoryPointsPactados;
	}
	
	public int getDiasTranscurridos() {
		Date fechaFinal=new Date();
		long tiempo = fechaFinal.getTime()-this.fechaInicio.getTime();
		Number convertir=tiempo/(1000*3600*24);
		int dias = convertir.intValue();

	    return dias;
	}
	
}
