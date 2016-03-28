package com.ungs.pp2.scrPP2.Controller;

import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;

public class UserStoryHelper
{
	private UserStory userStory;
	
	@SuppressWarnings("unused")
	private UserStoryHelper(){ }
	
	public UserStoryHelper(UserStory us) {
		this.userStory = us;
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
	
}
