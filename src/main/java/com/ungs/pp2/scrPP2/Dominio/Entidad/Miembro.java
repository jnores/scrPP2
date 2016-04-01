package com.ungs.pp2.scrPP2.Dominio.Entidad;

/**
 * @author yoshknight
 *
 */
public class Miembro {

	private String nombre;
	private String perfil;
	
	@SuppressWarnings("unused")
	private Miembro() {	}
	/**
	 * @param nombre the nombre to set
	 */
	public Miembro(String nombre) {
		this.nombre = nombre;
		this.perfil = "";
	}
	
	/**
	 * @param nombre the nombre to set
	 * @param nombre the nombre to set
	 */
	public Miembro(String nombre,String perfil) {
		this.nombre = nombre;
		this.perfil = perfil;
	}
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
