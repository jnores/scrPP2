package pp2.scrum.controller;


import java.security.InvalidParameterException;

import pp2.scrum.dominio.Request;
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

	// TODO Con este execute aqui oblicamos a la vista a saber armar los command. esto no deberia ser asi! la vista debe saber hacer peticiones al controller
	// y el controller debera convertir estas peticiones en comandos, y ejecutarlos!
   @Override
   public Resultado Execute(IComando commando)
   {
      return commando.Execute(this);
   }

   public ProyectoNuevoView getProyectoNuevo()
   {
      return proyectoNuevo;
   }
   
   public Resultado processRequest(Request request) {
	   if ( !request.contieneParametro("accion") )
		   throw new RuntimeException("No especifico una accion en el Request. ");

	   String accion = request.obtenerParametro("accion");

	   IComando cmd;
	   try {
		   cmd = (IComando) Class.forName(accion+"Command").newInstance();
		   cmd.configurar(request);
	   } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		   throw new RuntimeException("La acción solicitada no pudo ser procesada.");
	   } catch (InvalidParameterException e) {
		   throw new RuntimeException("Los parametros especificados no so suficientes para realizar esta operación.");
	   }
	   
	   return cmd.Execute(this);
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
