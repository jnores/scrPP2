package pp2.scrum;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import pp2.scrum.controller.BurndownChartController;
import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.domain.Sprint;
import pp2.scrum.domain.UserStory;
import pp2.scrum.utils.EnviadorMail;
import pp2.scrum.utils.Logger;
import pp2.scrum.view.BurndownChartView;
import pp2.scrum.view.HomeView;
import pp2.scrum.view.UserStoryListView;
import pp2.scrum.view.UserStoryOrderableView;
import pp2.scrum.view.UserStoryPaginadoView;

public class MainScrum {
	public static void main( String[ ] args ) {

		EventQueue.invokeLater( new Runnable() {
			@Override
			public void run() {

				Logger.init();
				
				//Creo la dependencia al iniciar la aplicacion una sola vez
				MailGateway mailGateway = new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mailmail", 15);
				HomeController controller = new HomeController(mailGateway);
				BurndownChartView chartView = new BurndownChartView(new BurndownChartController(new Sprint(1,new Date("03/10/2016"), 21, new ArrayList<UserStory>()), mailGateway));
				UserStoryPaginadoView listadoPaginado = new UserStoryPaginadoView(new UserStoryPaginadoController(mailGateway),new ArrayList<UserStory>());
				UserStoryOrderableView filtrado = new UserStoryOrderableView(new UserStoryListView( controller.getProyectoController().getBacklog() ));
				
				

				HomeView view = new HomeView(controller, chartView, listadoPaginado, filtrado);	
				view.setVisible( true );


			}});
	}}

