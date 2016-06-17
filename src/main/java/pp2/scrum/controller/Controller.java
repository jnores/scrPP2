package pp2.scrum.controller;

import pp2.scrum.dominio.entidad.MailGateway;

//Controller general para todos los controllers
public abstract class Controller 
{	
	   protected MailGateway mailGateway;

	   protected Controller(MailGateway mailGateway)
	   {
	      this.mailGateway = mailGateway;
	   }
}
