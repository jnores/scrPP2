package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author yoshknight
 *
 */
public class Proyecto {
	private Date fechaInicio,fechaFin;
	private Map<Integer,UserStory> backlog;
	private Map<String,Miembro> miembros;
	private List<Sprint> iteraciones;
	private Map<UserStory,Miembro> asignaciones;

	public Proyecto() {
		this.backlog      = new TreeMap<Integer,UserStory>();
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
	public Set<UserStory> getAllUserStories() {
		ArrayList<UserStory> allStories;
		allStories = new ArrayList<UserStory>( this.backlog.values() );
		for (Sprint it: iteraciones) {
			allStories.addAll(it.getUserStories());
		}
		return new HashSet<UserStory>(allStories);
	}
	
	/**
	 * @param miembro Miembro del proyecto
	 * @return Coleccion de UserStories del proyecto asignadas al reurso 
	 */
	public Set<UserStory> getAllUserStoriesFromMiembro(Miembro miembro) {
		ArrayList<UserStory> allStories = new ArrayList<UserStory>();
		for (Map.Entry<UserStory, Miembro> entry : this.asignaciones.entrySet()) {
			if (entry.getValue().equals(miembro) ) {
				allStories.add(entry.getKey());
			}
		}
		
		return new HashSet<UserStory>(allStories);
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
		if ( !this.backlog.containsValue(userStory) ) {
			this.backlog.put(userStory.getId(), userStory);
		}
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
		if ( this.backlog.containsValue(userStory) && this.miembros.containsValue(miembro)) {
			this.asignaciones.put(userStory, miembro);
		}
	}

	public UserStory getUserStoryPorId(int id) {
		UserStory userStory = null;
		if (this.backlog.containsKey(id))
			userStory = this.backlog.get(id);
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
	
	
}
