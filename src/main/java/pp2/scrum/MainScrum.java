package pp2.scrum;

import java.awt.EventQueue;

import pp2.scrum.consulta.EnviadorMail;
import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.interfaz.MailGateway;
import pp2.scrum.utils.Logger;
import pp2.scrum.view.HomeView;

public class MainScrum {
	public static void main( String[ ] args ) {

		EventQueue.invokeLater( new Runnable() {
			@Override
			public void run() {

				Logger.init();
				
				//Creo la dependencia al iniciar la aplicacion una sola vez
				MailGateway mailGateway = new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mailmail", 15);
				
				HomeController controller = new HomeController(mailGateway);

				HomeView view = new HomeView(controller);	
				view.setVisible( true );


			}});
	}}

