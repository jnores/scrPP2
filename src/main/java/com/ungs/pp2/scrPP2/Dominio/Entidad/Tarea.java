package com.ungs.pp2.scrPP2.Dominio.Entidad;



import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;

public class Tarea extends java.util.Observable
{
	private int id;
	private Estado estado;
	/**
	 * @param id
	 * @param tareas
	 */
//	public Tarea(int id) {
//		this.id=id;
//		estado = Estado.getDefault();
//	}
	
	public Tarea() {
	
		estado = Estado.getDefault();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	
	//esto no va
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the tareas
	 */
	public Estado getEstado() {
		return estado;
	}
	/**
	 * @param tareas the tareas to set
	 */
	public void avanzarEstado()
	{
		estado = estado.avanzar();
	}
}
