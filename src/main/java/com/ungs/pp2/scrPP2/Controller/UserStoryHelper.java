package com.ungs.pp2.scrPP2.Controller;

import com.ungs.pp2.scrPP2.Dominio.Entidad.Miembro;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;

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
	
	public String getTitulo() {
		return this.userStory.getTitulo();
	}
	
	public String getDetalle() {
		return this.userStory.getDetalle();
	}
	
	public String getAutor() {
		return this.userStory.getAutor();
	}
	
	public String getResponsable() {
		String responsable="-";
		if (miembro != null)
			responsable=miembro.getNombre();
		return responsable;
	}
	
}
