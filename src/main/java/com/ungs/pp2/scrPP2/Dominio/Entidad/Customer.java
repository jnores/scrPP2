package com.ungs.pp2.scrPP2.Dominio.Entidad;

public class Customer extends java.util.Observable
{
	private String razonSocial;
	private String cuit;

	
	public Customer(String razonSocial, String cuit) {
		this.razonSocial=razonSocial;
		this.cuit = cuit;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}

	public void actualizarRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the cuit
	 */
	public String getCuit() {
		return cuit;
	}

	/**
	 * @param cuit the cuit to set
	 */
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
}
