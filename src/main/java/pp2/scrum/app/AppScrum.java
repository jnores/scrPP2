package pp2.scrum.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import pp2.scrum.controller.BurndownChartController;
import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.mock.dao.MockProyectoDAO;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.EnviadorMail;
import pp2.scrum.utils.Logger;
import pp2.scrum.view.BurndownChartView;
import pp2.scrum.view.HomeView;
import pp2.scrum.view.UserStoryListView;
import pp2.scrum.view.UserStoryOrderableView;
import pp2.scrum.view.UserStoryPaginadoView;

public class AppScrum {
	private static ProyectoDAO proyectoDAO;
	private static Proyecto proyecto;
	
	
	private static void procesarConfiguracion() {
		// TODO Auto-generated method stub
		
	}
	

	private static void iniciarComponentes() {
		// TODO Auto-generated method stub
		proyectoDAO = new MockProyectoDAO();
		
	}

	/**
	 * Se uestra al inicio de la aplicacion todos los proyectos que se tienen registrado.
	 * Si se desea, se puede cancelar para iniciar un nuevo proyecto
	 * 
	 * TODO Varias funciones para poder crear un proyecto nuevo no estan disponibles por
	 * lo que solo se permitira inicar  un proyecto pre guardado.
	 */
	private static void IniciarPrograma() {
		// TODO Auto-generated method stub
		List<Proyecto> proyectos = proyectoDAO.getAll();
		Integer idProyecto=null;
		switch (proyectos.size()) {
		case 0: // TODO iniciar nuevo proyecto
			break;
		case 1: // Iniciar el unico proyecto existent
			idProyecto=0;
			break;

		default: // Pregutar que proyecto se desea iniciar.
			Icon questionIcon = UIManager.getIcon("OptionPane.questionIcon");  
		        Object[] possibilities = new Object[proyectos.size()];
		        int id = 0;
		        for (Proyecto p : proyectos) {
		        	possibilities[id++] = p.getNombre();
		        }
		        
		        idProyecto = (Integer) JOptionPane.showInputDialog(null,  
		                "Por favor Seleccione un proyeco para continuar:", "Proyectos...",  
		                JOptionPane.PLAIN_MESSAGE, questionIcon, possibilities, "Proyectos");
			break;
		}
		Logger.log("ID proyecto "+idProyecto);
		if(idProyecto==null){
			// Launch nre proyect
			proyecto= new Proyecto();
		} else {
			proyecto =proyectos.get(idProyecto);
		}
			
	
	}

	public static void main( String[ ] args ) {


		procesarConfiguracion();
		iniciarComponentes();
		IniciarPrograma();
		
		Logger.log("Iniciando Aplicación");

		//Creo la dependencia al iniciar la aplicacion una sola vez
		// TODO No hardcodear la configuracion del servidor. esto deberia levantarlo de un archivo de confiuracion
		MailGateway mailGateway = new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mailmail", 15);
		HomeController controller = new HomeController(mailGateway);
		BurndownChartView chartView = new BurndownChartView(new BurndownChartController(new Sprint(1,new Date("03/10/2016"), 21, new ArrayList<UserStory>()), mailGateway));
		UserStoryPaginadoView listadoPaginado = new UserStoryPaginadoView(new UserStoryPaginadoController(mailGateway),new ArrayList<UserStory>());
		UserStoryOrderableView filtrado = new UserStoryOrderableView(new UserStoryListView( controller.getProyectoController().getBacklog() ));



		HomeView view = new HomeView(controller, chartView, listadoPaginado, filtrado);	
		view.setVisible( true );



	}
}

