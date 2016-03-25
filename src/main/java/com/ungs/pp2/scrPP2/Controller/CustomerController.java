package com.ungs.pp2.scrPP2.Controller;

import com.ungs.pp2.scrPP2.Dominio.Entidad.Customer;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

public class CustomerController extends Controller
{
	private Customer customer;
	
	public CustomerController(IConsulta consulta,Customer customer) 
	{
		super (consulta);
		this.customer=customer;
	}
	
	//Esto no creo que este bien... lo estoy manejando como si fuera un pasa manos y no esta bien
	public void actualizarRazonSocial(String razonSocial)
	{
		this.customer.actualizarRazonSocial(razonSocial);
	}
}
