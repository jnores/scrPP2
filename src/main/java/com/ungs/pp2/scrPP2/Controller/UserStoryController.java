package com.ungs.pp2.scrPP2.Controller;

import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

public class UserStoryController extends Controller 
{
	   private UserStory model;

	   //La consulta se pasa a cada controller para hacer consultas a la base y son pasadas a su padre
	   public UserStoryController(IConsulta consulta,UserStory model) {
		   super (consulta);
	      this.model = model;
	   }

	   /**
	    * Genera un helper mediante el cual la vista accede a los datos que tiene que mostrar
	    * @return UserStpryHelper 
	    */
	   public UserStoryHelper getUserStoryHelper() {
		   UserStoryHelper ush = new UserStoryHelper(model);
		   return ush;
	   }
	
}
