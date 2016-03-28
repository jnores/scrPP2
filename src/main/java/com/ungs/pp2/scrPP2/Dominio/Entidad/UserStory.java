package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.List;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;

public class UserStory extends java.util.Observable
{
	
	private int id;
	private String titulo;
	private String detalle;
	private String autor;
	private String responsable;
	private int horasEstimadas;
	private int storyPoints;
	private int iteracion;
	private Estado estado;
	private List<Criterio> criterios;
	private List<Tarea> tareas;
	
	public UserStory(String titulo, String detalle, String autor, String responsable, int horasEstimadas, int storyPoints, int iteracion, Estado estado, List<Criterio> criterios, List<Tarea> tareas) {
		this.titulo = titulo;
		this.detalle = detalle;
		this.autor = autor;
		this.responsable = responsable;
		this.horasEstimadas = horasEstimadas;
		this.storyPoints = storyPoints;
		this.iteracion = iteracion;
		this.estado = estado;
		this.criterios = criterios;
		this.tareas = tareas;
	}
	
	public UserStory(String titulo, String detalle, String autor) {
		this.titulo = titulo;
		this.detalle = detalle;
		this.autor = autor;
		this.estado = Estado.ToDo;
	}

	public UserStory() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return this.id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public int getHorasEstimadas() {
		return this.horasEstimadas;
	}

	public int getStoryPoints() {
		return this.storyPoints;
	}

	public int getIteracion() {
		return this.iteracion;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public List<Criterio> getCriterios() {
		return this.criterios;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
		fueModificado();
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
		fueModificado();
	}

	public void setAutor(String autor) {
		this.autor = autor;
		fueModificado();
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
		fueModificado();
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
		fueModificado();
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
		fueModificado();
	}

	public void setIteracion(int iteracion) {
		this.iteracion = iteracion;
		fueModificado();
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
		fueModificado();
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
		fueModificado();
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
		fueModificado();
	}
	
	private void fueModificado() {
		setChanged();
		notifyObservers();
	}
}
