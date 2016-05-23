package pp2.scrum.controller;


import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.entidad.Proyecto;
import pp2.scrum.dominio.interfaz.IAppController;
import pp2.scrum.dominio.interfaz.IComando;
import pp2.scrum.dominio.interfaz.IConsulta;
import pp2.scrum.utils.UserStoryMapper;
import pp2.scrum.view.BacklogNuevoView;
import pp2.scrum.view.ProyectoNuevoView;

public class HomeController extends Controller implements IAppController
{
   private ProyectoNuevoView proyectoNuevo;
   private BacklogNuevoView backlogNuevo;
   private ProyectoController proyectoController;


	public HomeController(IConsulta consulta,UserStoryMapper usMapper) 
	{	
		super(consulta);
	    proyectoController = new ProyectoController(null, new Proyecto(usMapper));
		proyectoNuevo = new ProyectoNuevoView(proyectoController);
		backlogNuevo = new BacklogNuevoView(proyectoController);
	}

   @Override
   public Resultado Execute(IComando commando)
   {
      return commando.Execute(this);
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
