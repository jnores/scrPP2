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
	private Properties propiedades;
	private ComponentFactory factory;

	private AppScrum(Properties config) {
		propiedades = config;
		iniciarComponentes();
		iniciarPrograma();
	}

	/**
	 * Inicia los componentes que necesita el sistema. Segun el archivo de configuración
	 * por el momento inicia un factory.
	 */
	private void iniciarComponentes() {
		factory = new ComponentFactory(propiedades);
	}

	/**
	 * Consulta que proyecto iniciar y ejecuta la aplicacion con el mismo.
	 *  
	 */
	private void iniciarPrograma() 
	{
		Logger.log("Iniciando Aplicación");

		ProyectoDAO proyectoDAO;
		try {
			proyectoDAO = (ProyectoDAO)factory.getComponentByName("ProyectoDAO");
		} catch (NoSuchElementException | InstantiationException e) {
			throw new RuntimeException("No se pudo iniciar el componente ProyectoDAO", e);
		}
		List<Proyecto> proyectosGuardados = proyectoDAO.getAll();

		Proyecto proyecto = null;
		if ( proyectosGuardados.size()>0 )
			proyecto = seleccionarProyecto(proyectosGuardados);

		if ( proyecto==null ) {
			Logger.log("Creando nuevo proyecto");
			proyecto = crearNuevoProyecto(proyectoDAO);
		} 

		if (proyecto != null) {
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

	private Proyecto crearNuevoProyecto(ProyectoDAO proyectoDAO) {
		// TODO Esto deberia lanzar un asistente para crear un nuevo proyecto y guardarlo antes de retornarlo.
		return new Proyecto("Proyecto Nuevo");
	}


	/**
	 * Se muestra al inicio de la aplicacion todos los proyectos que se tienen registrado.
	 * Si se desea, se puede cancelar para iniciar un nuevo proyecto
	 */
	private Proyecto seleccionarProyecto(List<Proyecto> proyectos) {

		Logger.log("Seleccionar proyecto ");

		Proyecto proyecto=null;
		Integer idProyecto=null;

		boolean consultarProyecto = propiedades.getProperty("ConsultarProyecto","no").toLowerCase().equals("si");

		if (consultarProyecto && proyectos.size() > 0) {
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
		} else {
			if (proyectos.size()>0) 
				idProyecto= Integer.getInteger( propiedades.getProperty("IdProyectoDefault","0") ) ;
		}

		Logger.log("ID proyecto: "+idProyecto);

		if(idProyecto!=null){
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

			new AppScrum(propiedades);

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

