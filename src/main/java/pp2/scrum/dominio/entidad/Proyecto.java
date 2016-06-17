package pp2.scrum.dominio.entidad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.utils.Logger;

/**
 * @author yoshknight
 *
 */
public class Proyecto {
   private String titulo;
//	private Date fechaInicio,fechaFin;
	private List<UserStoryHelper> backlog;
	private Map<String,Miembro> miembros;
	private List<Sprint> iteraciones;
	private Map<UserStoryHelper,Miembro> asignaciones;

	public Proyecto() {
		this.backlog      = new ArrayList<UserStoryHelper>();
		this.miembros     = new HashMap<String,Miembro>();
		this.iteraciones  = new ArrayList<Sprint>();
		this.asignaciones = new HashMap<UserStoryHelper,Miembro>();
	}
	
	/**
	 * @return Coleccion de miembros que componene el proyecto
	 */
	public Collection<Miembro> getMiembros() {
		return miembros.values();
	}
	
	/**
	 * @return Coleccion de nombres de los miembros
	 */
	public Set<String> getNombresMiembros() {
		return miembros.keySet();
	}
	
	/**
	 * @return Coleccion de UserStories del proyecto
	 */
	public Set<UserStoryHelper> getAllUserStories() {
		ArrayList<UserStoryHelper> allStories;
		allStories = new ArrayList<UserStoryHelper>( this.backlog );
		for (Sprint it: iteraciones) {
			allStories.addAll(it.getUserStories());
		}
		return new HashSet<UserStoryHelper>(allStories);
	}
	
	/**
	 * @return Coleccion de UserStories del backlog
	 */
	public List<UserStoryHelper> getBacklog() {
		return backlog;
	}
	
	/**
	 * @param miembro Miembro del proyecto
	 * @return Coleccion de UserStories del proyecto asignadas al reurso 
	 */
	public Set<UserStoryHelper> getAllUserStoriesFromMiembro(Miembro miembro) {
		ArrayList<UserStoryHelper> allStories = new ArrayList<UserStoryHelper>();
		for (Map.Entry<UserStoryHelper, Miembro> entry : this.asignaciones.entrySet()) {
			if (entry.getValue().equals(miembro) ) {
				allStories.add(entry.getKey());
			}
		}
		
		return new HashSet<UserStoryHelper>(allStories);
	}
	
	/**
	 * @param nombre  Nombre del miemro del proyecto
	 * @return Miebro del proyecto
	 */
	public Miembro getMiembroPorNombre(String nombre) {
		Miembro miembro=null;
		if (this.miembros.containsKey(nombre) ){
			miembro=miembros.get(nombre);
		}
		return miembro;
	}
	
	/**
	 * @param userStory  La user story que se debe agregar al bachlog
	 */
	public void addUserStory(UserStoryHelper userStory) {
		//Logger.log("ADD USER STORY ["+userStory.getId()+"]: "+userStory.getTitulo());
		Logger.log("ADD USER STORY: "+userStory.getTitulo());
		this.backlog.add( userStory);
	}
	
	/**
	 * @param miembro El miembro que se debe agregar al proyecto
	 */
	public void addMiembro(Miembro miembro) {
		if ( !this.miembros.containsValue(miembro) ) {
			this.miembros.put(miembro.getNombre(), miembro);
		}
	}
	
	/**
	 * @param userStory  La user story a asignar
	 * @param miembro El miembro que se le asignara la user story
	 */
	public void asignarUserStory(UserStoryHelper userStory,Miembro miembro) {
		if ( this.backlog.contains(userStory) && this.miembros.containsValue(miembro)) {
			this.asignaciones.put(userStory, miembro);
		}
	}

	public UserStoryHelper getUserStoryPorId(int id) {
		UserStoryHelper userStory = null;
		getBacklog();
		for (UserStoryHelper us:backlog) {
			if (us.getId() == id) {
				userStory = us;
				break;
			}
		}
		return userStory;
	}

	public Miembro getResponsable(UserStoryHelper userStory) {
		Miembro miembro = null;
		if ( userStory != null ) {
			if ( this.asignaciones.containsKey(userStory) ) {
				miembro = this.asignaciones.get(userStory);  
			}
		}
		return miembro;
	}
	
	public void setTitulo(String titulo)
	{
	   this.titulo = titulo;
	}
	
	public String getTitulo(String titulo)
    {
      return this.titulo;
    }
	
	/**
	 * TODO Esto funciona solo para cuando existe un unico proyecto. y todas las us estan en el backlog.
	 * @return
	 */
	public long getSiguienteStoryID(){
		long id=0;
		for (UserStoryHelper us:backlog)
			if (us.getId()>id)
				id=us.getId();
		return id+1;
	}

}
