package pp2.scrum.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pp2.scrum.dominio.entidad.Miembro;
import pp2.scrum.dominio.entidad.Proyecto;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.interfaz.IConsulta;
import pp2.scrum.dominio.interfaz.IMailGateway;

public class ProyectoController extends Controller 
{
	   private Proyecto proyecto;

	   //La consulta se pasa a cada controller para hacer consultas a la base y son pasadas a su padre
	   public ProyectoController(IConsulta consulta,Proyecto model,IMailGateway mailGateway) {
		   super (consulta,mailGateway);
	      this.proyecto = model;
	   }

	   /**
	    * Genera una Lista de UserStories
	    * @return List<UserStory> totalidad de userstories del proyecto.
	    */
	   public List<UserStoryHelper> getAllUserStories() {
		   Set<UserStory> userStories = proyecto.getAllUserStories();
		   ArrayList<UserStoryHelper> userStoriesHelpers = new ArrayList<UserStoryHelper>();
		   for(UserStory userStory: userStories) {
			   userStoriesHelpers.add( new UserStoryHelper(userStory,proyecto.getResponsable(userStory) ) );
		   }
			   
		   return userStoriesHelpers;
	   }
	   
	   /**
	    * Genera una Lista de UserStories
	    * @return List<UserStory> totalidad de userstories del proyecto.
	    */
	   public List<UserStoryHelper> getBacklog() {
		   List<UserStory> userStories = proyecto.getBacklog();
		   ArrayList<UserStoryHelper> userStoriesHelpers = new ArrayList<UserStoryHelper>();
		   for(UserStory userStory: userStories) {
			   userStoriesHelpers.add( new UserStoryHelper(userStory,proyecto.getResponsable(userStory) ) );
		   }
			   
		   return userStoriesHelpers;
	   }
	   
	   public UserStoryHelper getUserStoryHelper(int id) {
		   UserStory userStory = proyecto.getUserStoryPorId(id);
		   Miembro   miembro   = proyecto.getResponsable(userStory);
		   return new UserStoryHelper(userStory,miembro);
	   }
	   
	   public void setProyecto(Proyecto proyecto)
	   {
	      this.proyecto = proyecto;
	   }
	   
	   public Proyecto getProyecto()
      {
         return proyecto;
      }
	   
	   public IMailGateway getMailGateway()
      {
         return mailGateway;
      }

	public long getSiguienteStoryID() {
		return proyecto.getSiguienteStoryID();
	}

	public void agregarUserStory(UserStory us) {
		if (us==null)
			throw new InvalidParameterException("Se esperaba una user story para agregar y se recibio un elemento nulo.");
		proyecto.addUserStory(us);
		
	}
}
