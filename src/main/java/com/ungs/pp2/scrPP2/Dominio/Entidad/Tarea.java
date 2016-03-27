package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;

public class Tarea extends java.util.Observable
{
	private int Id;
	private List<Estado> Tareas;
	/**
	 * @param id
	 * @param tareas
	 */
	public Tarea(int id, List<Estado> tareas) {
		Id = id;
		Tareas = tareas;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * @return the tareas
	 */
	public List<Estado> getTareas() {
		return Tareas;
	}
	/**
	 * @param tareas the tareas to set
	 */
	public void setTareas(List<Estado> tareas) {
		Tareas = tareas;
	}
}
