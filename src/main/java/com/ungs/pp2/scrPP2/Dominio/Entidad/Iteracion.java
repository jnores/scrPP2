package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class Iteracion {
	private int idIteracion;
	private Date fechaInicio;
	private int duracion;
	private List<UserStory> historias;
	private int StoryPointsPactados; 
	private GregorianCalendar calendario;
	
	public Iteracion(int idIteracion,Date fechaInicio, int duracion, List<UserStory> historias) {
		this.idIteracion = idIteracion;
		this.setfechaInicio(fechaInicio);
		this.duracion = duracion;
		this.historias = historias;
		this.setStoryPointsPactados();
	}
	
	private void setStoryPointsPactados(){
		int puntos=0;
		if(this.historias!=null){
			for (UserStory us: this.historias) {
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
	
	public List<UserStory> getUserStories() {
		return this.historias;
	}

	public void setfechaInicio(Date fechaInicio) {
		this.fechaInicio=fechaInicio;
	}

	public void setDuracion(int dias) {
		this.duracion=dias;
	}

	public void setUserStories(List<UserStory> historias) {
		this.historias=historias;
	}
	
	public void setUserStory(UserStory historia) {
		this.StoryPointsPactados=+historia.getStoryPoints();
		this.historias.add(historia);
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
