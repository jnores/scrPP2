package pp2.scrum.controller;

import pp2.scrum.dominio.Estado;
import pp2.scrum.dominio.entidad.Miembro;
import pp2.scrum.dominio.entidad.UserStory;

public class UserStoryHelper
{
	private UserStory userStory;
	private Miembro miembro;
	
	@SuppressWarnings("unused")
	private UserStoryHelper(){ }
	
	public UserStoryHelper(UserStory us) {
		this.userStory = us;
		this.miembro   = null;
	}
	
	public UserStoryHelper(UserStory us,Miembro miembro) {
		this.userStory = us;
		this.miembro   = miembro;
	}

	public long getId() {
		return userStory.getId();
	}

	public String getTitulo() {
		return this.userStory.getTitulo();
	}
	
	public String getDetalle() {
		return this.userStory.getDetalle();
	}
	
	public String getAutor() {
		return this.userStory.getAutor();
	}
	
	public int getStoryPoints()
	{
		return this.userStory.getStoryPoints();
	}
	
	public String getResponsable() {
		String responsable="-";
		if (miembro != null)
			responsable=miembro.getNombre();
		return responsable;
	}

	public Estado getEstado() {
		return userStory.getEstado();
	}
	
}
