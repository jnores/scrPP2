package pp2.scrum.controller;

import pp2.scrum.dominio.interfaz.IConsulta;

//Controller general para todos los controllers
public abstract class Controller 
{	
	   protected IConsulta consulta;

	   protected Controller(IConsulta consulta)
	   {
	      this.consulta = consulta;
	   }
}
