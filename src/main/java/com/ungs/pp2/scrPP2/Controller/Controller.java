package com.ungs.pp2.scrPP2.Controller;

import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

public abstract class Controller 
{	
	   protected IConsulta consulta;

	   protected Controller(IConsulta consulta)
	   {
	      this.consulta = consulta;
	   }
}
