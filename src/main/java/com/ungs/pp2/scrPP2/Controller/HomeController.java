package com.ungs.pp2.scrPP2.Controller;


import java.security.InvalidParameterException;

import com.ungs.pp2.scrPP2.Dominio.Request;
import com.ungs.pp2.scrPP2.Dominio.Resultado;
import com.ungs.pp2.scrPP2.Dominio.Entidad.Proyecto;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IAppController;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IComando;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.View.BacklogNuevoView;
import com.ungs.pp2.scrPP2.View.ProyectoNuevoView;
import com.ungs.pp2.scrPP2.utils.UserStoryMapper;

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
	
	public void MostrarProyectoNuevo()
	{
	   proyectoNuevo.setVisible(true);
	}

	// TODO Con este execute aqui oblicamos a la vista a saber armar los command. esto no deberia ser asi! la vista debe saber hacer peticiones al controller
	// y el controller debera convertir estas peticiones en comandos, y ejecutarlos!
   @Override
   public Resultado Execute(IComando commando)
   {
      return commando.execute(this);
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
	   
	   return cmd.execute(this);
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
