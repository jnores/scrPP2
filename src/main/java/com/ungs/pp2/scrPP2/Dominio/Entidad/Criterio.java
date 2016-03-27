package com.ungs.pp2.scrPP2.Dominio.Entidad;

public class Criterio extends java.util.Observable
{
	private int Id;
	private String Descripcion;
	/**
	 * @param id
	 * @param descripcion
	 */
	public Criterio(int id, String descripcion) {
		Id = id;
		Descripcion = descripcion;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return Descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}	
}
