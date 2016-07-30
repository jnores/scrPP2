package pp2.scrum.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

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
 */
public class AppScrum
{
	private static String configFilePath;
	
	private Properties propiedades;
	private ComponentFactory factory;

	private AppScrum(Properties config) {
		this(config,null);
	}

	private AppScrum(Properties config,Proyecto proyecto) {
		Logger.log("Iniciando Aplicación");

		propiedades = config;
		iniciarComponentes();
		if ( proyecto == null ) 
			proyecto = obtenerProyecto();
		abrirProyecto(proyecto);
	}


	/**
	 * Inicia los componentes que necesita el sistema. Segun el archivo de configuración
	 * por el momento inicia un factory.
	 */
	private void iniciarComponentes() {
		Logger.log("Iniciando Componentes");
		factory = new ComponentFactory(propiedades);
		Logger.log("Componentes Iniciados");
	}

	/**
	 * Consulta los proyectos guardados y se los muestra al usuario para que elija cual quiere iniciar.
	 * Si no selecciona un proyecto se crea uno nuevo. 
	 * @return Proyecto. Retorna le proyecto elejido. 
	 */
	private Proyecto obtenerProyecto() {
		Logger.log("Obteniendo Proyecto");
		ProyectoDAO proyectoDAO;
		Proyecto  proyecto = null;
		try {
			proyectoDAO = (ProyectoDAO)factory.getComponentByName("ProyectoDAO");
		} catch (NoSuchElementException | InstantiationException e) {
			throw new RuntimeException("No se pudo iniciar el componente ProyectoDAO", e);
		}

		List<Proyecto> proyectosGuardados = proyectoDAO.getAll();

		if ( proyectosGuardados.size()>0 )
			proyecto = seleccionarProyecto(proyectosGuardados);

		if ( proyecto==null ) {
			Logger.log("Creando nuevo proyecto");
			proyecto = crearNuevoProyecto(proyectoDAO);
		} 
		
		return proyecto;
	}
	
	/**
	 * Se muestra al inicio de la aplicacion todos los proyectos que se tienen registrado.
	 * Si se desea, se puede cancelar para iniciar un nuevo proyecto
	 */
	private Proyecto seleccionarProyecto(List<Proyecto> proyectos) {
		Logger.log("Seleccionando Proyecto");

		Proyecto proyecto=null;
		Integer idProyecto=null;

		if (proyectos.size() > 0) {
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
		}

		Logger.log("ID proyecto: "+idProyecto);

		if(idProyecto!=null){
			proyecto = proyectos.get(idProyecto);
		}
		return proyecto;
	}

	/**
	 * 
	 * @param proyectoDAO
	 * @return Proyecto nuevo.
	 */
	private Proyecto crearNuevoProyecto(ProyectoDAO proyectoDAO) {
		Logger.log("Creando proyecto Nuevo");
		// TODO Esto deberia lanzar un asistente para crear un nuevo proyecto y guardarlo antes de retornarlo.
		return new Proyecto("Proyecto Nuevo");
	}
	
	/**
	 * Consulta que proyecto iniciar y ejecuta la aplicacion con el mismo.
	 *  
	 */
	private void abrirProyecto(Proyecto proyecto) 
	{
		if (proyecto != null) {
			Logger.log("Abriendo Proyecto: "+proyecto.getNombre());
			// TODO Aca solo se deberia crear el home controller y home view y pasar factory y proyecto.
			HomeController controller = new HomeController(proyecto);

			BurndownChartView chartView = new BurndownChartView(new BurndownChartController(new Sprint(1,new Date("03/10/2016"), 21, new ArrayList<UserStory>())));
			UserStoryPaginadoView listadoPaginado = new UserStoryPaginadoView(new UserStoryPaginadoController(),new ArrayList<UserStory>());
			UserStoryOrderableView filtrado = new UserStoryOrderableView(new UserStoryListView( controller.getProyectoController().getBacklog() ));

			HomeView view = new HomeView(controller, chartView, listadoPaginado, filtrado, proyecto);	
			view.setVisible( true );
		} else {
			JOptionPane.showMessageDialog(null, "No se Seleccionó ningun proyecto", "Finalizando programa", JOptionPane.INFORMATION_MESSAGE);
		}
	}


	/**
	 *  Método encargado de iniciar una nueva instancia de la aplicacion que trabajara de forma independiente.
	 * 
	 * @param proyecto si es null se consulta al usuario que proyecto de los que tiene gurdados desea iniciar.
	 */
	public static void abrirPrograma(Proyecto proyecto) {
		String errorMsg="";
		Properties propiedades = new Properties();		

		FileInputStream configFile;
		try {
			configFile = new FileInputStream(configFilePath);
			propiedades.load(configFile);

			new AppScrum(propiedades,proyecto);

		} catch (FileNotFoundException e) {
			errorMsg = "ERROR! No se pudo abrir el archivo de configuración: "+configFilePath;
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

	public static void main( String[ ] args ) 
	{
		configFilePath = "src/main/resources/config/app_develop.properties";
		// abrirPrograma(null);
		
		// Como estamos en ambiente de desarrollo esto inicia un proyecto predefinido sin consultarle al usuario.
		Proyecto proyecto = new pp2.mock.scrum.dao.MockProyectoDAO().getById(0);		
		abrirPrograma(proyecto);
	}
}

