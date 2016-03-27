package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.List;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;

public class UserStory extends java.util.Observable
{
	
	private int Id;
	private String Titulo;
	private String Detalle;
	private String Autor;
	private String Responsable;
	private int HorasEstimadas;
	private int StoryPoints;
	private int Iteracion;
	private Estado Estado;
	private List<Criterio> Criterios;
	private List<Tarea> Tareas;
	
	public UserStory(String titulo, String detalle, String autor, String responsable, int horasEstimadas, int storyPoints, int iteracion, Estado estado, List<Criterio> criterios, List<Tarea> tareas) {
		Titulo = titulo;
		Detalle = detalle;
		Autor = autor;
		Responsable = responsable;
		HorasEstimadas = horasEstimadas;
		StoryPoints = storyPoints;
		Iteracion = iteracion;
		Estado = estado;
		Criterios = criterios;
		Tareas = tareas;
	}

	public UserStory() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public String getDetalle() {
		return Detalle;
	}

	public String getAutor() {
		return Autor;
	}

	public String getResponsable() {
		return Responsable;
	}

	public int getHorasEstimadas() {
		return HorasEstimadas;
	}

	public int getStoryPoints() {
		return StoryPoints;
	}

	public int getIteracion() {
		return Iteracion;
	}

	public Estado getEstado() {
		return Estado;
	}

	public List<Criterio> getCriterios() {
		return Criterios;
	}

	public List<Tarea> getTareas() {
		return Tareas;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
		fueModificado();
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
		fueModificado();
	}

	public void setAutor(String autor) {
		Autor = autor;
		fueModificado();
	}

	public void setResponsable(String responsable) {
		Responsable = responsable;
		fueModificado();
	}

	public void setHorasEstimadas(int horasEstimadas) {
		HorasEstimadas = horasEstimadas;
		fueModificado();
	}

	public void setStoryPoints(int storyPoints) {
		StoryPoints = storyPoints;
		fueModificado();
	}

	public void setIteracion(int iteracion) {
		Iteracion = iteracion;
		fueModificado();
	}

	public void setEstado(Estado estado) {
		Estado = estado;
		fueModificado();
	}

	public void setCriterios(List<Criterio> criterios) {
		Criterios = criterios;
		fueModificado();
	}

	public void setTareas(List<Tarea> tareas) {
		Tareas = tareas;
		fueModificado();
	}
	
	private void fueModificado() {
		setChanged();
		notifyObservers();
	}
}
