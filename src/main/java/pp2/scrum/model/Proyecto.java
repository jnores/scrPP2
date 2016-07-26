package pp2.scrum.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pp2.scrum.utils.Calendario;


/**
 * @author yoshknight
 *
 */
public class Proyecto {
	private String nombre;
	//	private Date fechaInicio,fechaFin;
	private List<UserStory> backlog;
	private Map<String,Miembro> miembros;
	private List<Sprint> iteraciones;
	private Map<UserStory,Miembro> asignaciones;

	public Proyecto() {
		this.backlog      = new ArrayList<UserStory>();
		this.miembros     = new HashMap<String,Miembro>();
		this.iteraciones  = new ArrayList<Sprint>();
		this.asignaciones = new HashMap<UserStory,Miembro>();
	}
	public Proyecto(String nombre) {
		this.nombre=nombre;
		this.backlog      = new ArrayList<UserStory>();
		this.miembros     = new HashMap<String,Miembro>();
		this.iteraciones  = new ArrayList<Sprint>();
		this.asignaciones = new HashMap<UserStory,Miembro>();
	}
	
	public Proyecto(String nombre,List<UserStory> backlog,Map<String,Miembro> miembros,List<Sprint> iteraciones,HashMap<UserStory,Miembro> asignaciones) {
      this.nombre=nombre;
      this.backlog      = new ArrayList<UserStory>();
      this.miembros     = new HashMap<String,Miembro>();
      this.iteraciones  = new ArrayList<Sprint>();
      this.asignaciones = new HashMap<UserStory,Miembro>();
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
	public Collection<UserStory> getAllUserStories() {
		ArrayList<UserStory> allStories;
		allStories = new ArrayList<UserStory>( this.backlog );
		for (Sprint it: iteraciones) {
			allStories.addAll(it.getUserStories());
		}
		return allStories;
	}

	/**
	 * @return Coleccion de UserStories del backlog
	 */
	public List<UserStory> getBacklog() {
		return backlog;
	}

	/**
	 * @param miembro Miembro del proyecto
	 * @return Coleccion de UserStories del proyecto asignadas al reurso 
	 */
	public Collection<UserStory> getAllUserStoriesFromMiembro(Miembro miembro) {
		ArrayList<UserStory> allStories = new ArrayList<UserStory>();
		for (Map.Entry<UserStory, Miembro> entry : this.asignaciones.entrySet()) {
			if (entry.getValue().equals(miembro) ) {
				allStories.add(entry.getKey());
			}
		}

		return allStories;
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
	public void addUserStory(UserStory userStory) {
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
	public void asignarUserStory(UserStory userStory,Miembro miembro) {
		if ( this.backlog.contains(userStory) && this.miembros.containsValue(miembro)) {
			this.asignaciones.put(userStory, miembro);
		}
	}

	public UserStory getUserStoryPorId(int id) {
		UserStory userStory = null;
		getBacklog();
		for (UserStory us:backlog) {
			if (us.getId() == id) {
				userStory = us;
				break;
			}
		}
		return userStory;
	}

	public Miembro getResponsable(UserStory userStory) {
		Miembro miembro = null;
		if ( userStory != null ) {
			if ( this.asignaciones.containsKey(userStory) ) {
				miembro = this.asignaciones.get(userStory);  
			}
		}
		return miembro;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	/**
	 * TODO Esto funciona solo para cuando existe un unico proyecto. y todas las us estan en el backlog.
	 * @return
	 */
	public long getSiguienteStoryID(){
		long id=0;
		for (UserStory us:backlog)
			if (us.getId()>id)
				id=us.getId();
		return id+1;
	}
	
	public Sprint iteracionActual() throws RuntimeException{
	   Date hoy = new Date();
	   for (Sprint sprint : iteraciones) {
	      if (hoy.after(sprint.getfechaInicio()) && hoy.before(Calendario.agregarDias(sprint.getfechaInicio(), sprint.getDuracion()))){
	         return sprint;
	      }
	   }
	   throw new RuntimeException("No existe Iteración actual");
	}

}
