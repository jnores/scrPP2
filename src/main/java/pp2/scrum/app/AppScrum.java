package pp2.scrum.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import javax.naming.ConfigurationException;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import pp2.scrum.controller.BurndownChartController;
import pp2.scrum.controller.ComponentFactory;
import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.Logger;
import pp2.scrum.view.BurndownChartView;
import pp2.scrum.view.HomeView;
import pp2.scrum.view.UserStoryListView;
import pp2.scrum.view.UserStoryOrderableView;
import pp2.scrum.view.UserStoryPaginadoView;
/**
 * Esta clase representa la aplicacion, se encarga de iniciar los componentes necesarios y lanzar la palicacion.
 * 
 * @author yoshknight
 * 
 * TODO Ahora la clase es un singletone Se debe reemplazar por injeccion de dependencia 
 */
public class AppScrum
{
	private Properties propiedades;
	private ComponentFactory factory;
	


	private AppScrum() throws RuntimeException{
		throw new RuntimeException("Invalid Operation Exception.");
	}
	private AppScrum(Properties config) {
		propiedades = config;
		procesarConfiguracion();
		iniciarComponentes();
	}

	private void procesarConfiguracion() {
		
	}

	private void iniciarComponentes() {
		factory = new ComponentFactory(propiedades);
	}

	/**
	 * consulta que proyecto iniciar y ejecuta la aplicacion con el mismo.
	 * 
	 * TODO Varias funciones para poder crear un proyecto nuevo no estan disponibles por
	 * lo que solo se permitira inicar  un proyecto pre guardado.
	 */
	private void iniciarPrograma() 
	{
		Logger.log("Iniciando Aplicación");

		Proyecto proyecto = seleccionarProyecto();
		if (proyecto == null)
			throw new RuntimeException("Error al abrir el proyecto");

		//Creo la dependencia al iniciar la aplicacion una sola vez
		HomeController controller = new HomeController();
		BurndownChartView chartView = new BurndownChartView(new BurndownChartController(new Sprint(1,new Date("03/10/2016"), 21, new ArrayList<UserStory>())));
		UserStoryPaginadoView listadoPaginado = new UserStoryPaginadoView(new UserStoryPaginadoController(),new ArrayList<UserStory>());
		UserStoryOrderableView filtrado = new UserStoryOrderableView(new UserStoryListView( controller.getProyectoController().getBacklog() ));


		HomeView view = new HomeView(controller, chartView, listadoPaginado, filtrado, proyecto);	
		view.setVisible( true );
	}

	/**
	 * Se muestra al inicio de la aplicacion todos los proyectos que se tienen registrado.
	 * Si se desea, se puede cancelar para iniciar un nuevo proyecto
	 */
	private Proyecto seleccionarProyecto() {

		Logger.log("Seleccionar proyecto ");
		ProyectoDAO proyectoDAO;
		try {
			proyectoDAO = (ProyectoDAO)factory.getComponentByName("ProyectoDAO");
		} catch (NoSuchElementException | InstantiationException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		List<Proyecto> proyectos = proyectoDAO.getAll();
		Proyecto proyecto=null;
		Integer idProyecto=null;

		boolean consultarProyecto = propiedades.getProperty("ConsultarProyecto","no").toLowerCase().equals("si");

		if (consultarProyecto) {
			switch (proyectos.size()) {
			case 0: // TODO iniciar nuevo proyecto
				break;

			default: // Pregutar que proyecto se desea iniciar.
				Icon questionIcon = UIManager.getIcon("OptionPane.questionIcon");  
				Object[] possibilities = new Object[proyectos.size()];
				int id = 0;
				for (Proyecto p : proyectos) {
					possibilities[id++] = p.getNombre();
				}

				Object option = JOptionPane.showInputDialog(null,  
						"Por favor Seleccione un proyeco para continuar:", "Proyectos...",  
						JOptionPane.PLAIN_MESSAGE, questionIcon, possibilities, "Proyectos");
				if (option != null ) {
					for (id = 0; id < possibilities.length ; id++)
						if (possibilities[id].equals(option))
							break;
					idProyecto = id;
				}
				break;
			}
		} else {
			if (proyectos.size()>0) idProyecto=0;
		}

		Logger.log("ID proyecto: "+idProyecto);

		if(idProyecto==null){
			Logger.log("Creando nuevo proyecto");
			// TODO esto deberia lanzar un asistente para crear un nuevo proyecto y de paso guardarlo.
			proyecto = new Proyecto("Proyecto Nuevo");
		} else {
			proyecto = proyectos.get(idProyecto);
			Logger.log("Abriendo Proyecto: "+proyecto.getNombre());
		}
		
		return proyecto;
	}

	public static void main( String[ ] args ) 
	{

		String filePath = "src/main/resources/config/app_develop.properties";
		String errorMsg="";
		Properties propiedades = new Properties();		

		FileInputStream configFile;
		try {
			configFile = new FileInputStream(filePath);
			propiedades.load(configFile);

			AppScrum app = new AppScrum(propiedades);
			app.iniciarPrograma();
			
		} catch (FileNotFoundException e) {
			errorMsg = "ERROR! No se pudo abrir el archivo de configuración: "+filePath;
			e.printStackTrace();
		} catch (IOException e) {
			errorMsg = "ERROR! El archivo de configuracion no respeta el formato properties";
			e.printStackTrace();
		} catch (InvalidParameterException e) {
			// Levantando configuracion
			errorMsg="ERROR! No se pudieron iniciar todo los componentes.";
			e.printStackTrace();
		}

		if ( errorMsg.trim().length()>0 )
			JOptionPane.showMessageDialog(null, errorMsg, "ERROR!", JOptionPane.ERROR_MESSAGE);
	}
}

