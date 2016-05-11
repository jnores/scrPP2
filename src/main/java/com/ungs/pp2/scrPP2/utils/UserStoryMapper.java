package com.ungs.pp2.scrPP2.utils;

import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;

/**
 * @author yoshknight
 *
 */
public interface UserStoryMapper {
	public List<UserStory> getBacklog();
//	public Set<UserStory> getSprint(long idSprint);
	
	public long getNextID();
	public void insert(UserStory us);
	public void update(UserStory us);
	public void delete(UserStory us);
}
