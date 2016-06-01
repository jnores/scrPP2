package pp2.scrum.controller;

import pp2.scrum.dominio.interfaz.IConsulta;
import pp2.scrum.dominio.interfaz.IMailGateway;

//Controller general para todos los controllers
public abstract class Controller 
{	
	   protected IConsulta consulta;
	   protected IMailGateway mailGateway;

	   protected Controller(IConsulta consulta,IMailGateway mailGateway)
	   {
	      this.consulta = consulta;
	      this.mailGateway = mailGateway;
	   }
}
