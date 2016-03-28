package com.ungs.pp2.scrPP2.Controller;

import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

public class UserStoryPaginadoController extends Controller 
{
	   private List<UserStory> model;

	   //La consulta se pasa a cada controller para hacer consultas a la base y son pasadas a su padre
	   public UserStoryPaginadoController(IConsulta consulta,List<UserStory> model) {
		   super (consulta);
	      this.model = model;
	   }

      public List<UserStory> getModel()
      {
         return model;
      }

      public void setModel(List<UserStory> model)
      {
         this.model = model;
      }
	   

	
}
