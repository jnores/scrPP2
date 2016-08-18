package pp2.scrum.controller;


import java.awt.event.ActionListener;
import java.util.ArrayList;

import pp2.scrum.command.Comando;
import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.UserStory;
import pp2.scrum.view.BacklogNuevoView;
import pp2.scrum.view.ProyectoNuevoView;
import pp2.scrum.view.UserStoryPaginadoView;

public class HomeController extends Controller implements AppController
{
	private ProyectoNuevoView proyectoNuevo;
	private BacklogNuevoView backlogNuevo;
	private ProyectoController proyectoController;
	


	public HomeController(Proyecto proyecto,ComponentFactory factory) throws InstantiationException
	{	
		super();
		
		proyectoController = new ProyectoController(proyecto,(ProyectoDAO)factory.getComponentByName("ProyectoDAO"));
		proyectoNuevo = new ProyectoNuevoView(proyectoController);
		backlogNuevo = new BacklogNuevoView(proyectoController,new UserStoryPaginadoView(new UserStoryPaginadoController(),new ArrayList<UserStory>()));
	}

	@Override    
	public Resultado Execute(Comando commando,ActionListener al)
	{
		return commando.Execute(this,al);
	}

	public ProyectoNuevoView getProyectoNuevo()
	{
		return proyectoNuevo;
	}

	public void setProyectoNuevo(ProyectoNuevoView proyectoNuevo)
	{
		this.proyectoNuevo = proyectoNuevo;
	}

	public BacklogNuevoView getBacklogNuevo()
	{
		return backlogNuevo;
	}

	public void setBacklogNuevo(BacklogNuevoView backlogNuevo)
	{
		this.backlogNuevo = backlogNuevo;
	}
	public ProyectoController getProyectoController()
	{
		return proyectoController;
	}
}
