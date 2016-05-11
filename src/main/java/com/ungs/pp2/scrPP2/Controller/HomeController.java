package com.ungs.pp2.scrPP2.Controller;


import com.ungs.pp2.scrPP2.Dominio.Entidad.Proyecto;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IAppController;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IComando;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.View.BacklogNuevoView;
import com.ungs.pp2.scrPP2.View.ProyectoNuevoView;
import com.ungs.pp2.scrPP2.Dominio.Resultado;

public class HomeController extends Controller implements IAppController
{
   private ProyectoNuevoView proyectoNuevo;
   private BacklogNuevoView backlogNuevo;
   private ProyectoController proyectoController;


	public HomeController(IConsulta consulta) 
	{	super(consulta);
	   proyectoController = new ProyectoController(null, new Proyecto());
		proyectoNuevo = new ProyectoNuevoView(proyectoController);
		backlogNuevo = new BacklogNuevoView(proyectoController);
	}
	
	public void MostrarProyectoNuevo()
	{
	   proyectoNuevo.setVisible(true);
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
}
