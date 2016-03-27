package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;

public class Tarea extends java.util.Observable
{
	private int Id;
	private Estado Estado;
	/**
	 * @param id
	 * @param tareas
	 */
	public Tarea(int id, Estado estado) {
		Id = id;
		Estado = estado;
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
	public Estado getEstado() {
		return Estado;
	}
	/**
	 * @param tareas the tareas to set
	 */
	public void setTareas(Estado estado) {
	   Estado = estado;
	}
}
