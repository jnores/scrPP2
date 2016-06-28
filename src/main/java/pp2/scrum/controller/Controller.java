package pp2.scrum.controller;

//Controller general para todos los controllers
public abstract class Controller 
{	
	   protected MailGateway mailGateway;

	   protected Controller(MailGateway mailGateway)
	   {
	      this.mailGateway = mailGateway;
	   }
}
