package com.ungs.pp2.scrPP2.Dominio.Entidad;

public class Customer extends java.util.Observable  
{
	private String razon_Social;
	private String cuit;

	
	public Customer(String razonSocial, String cuit)
	{
		this.razon_Social=razonSocial;
		this.cuit = cuit;
	}
	
	public String getRazon_Social() {
		return razon_Social;
	}

	public void actualizarRazonSocial(String razonSocial)
	{
		this.razon_Social = razonSocial;
		setChanged();
		notifyObservers();
	}
}
