package pp2.scrum.controller;

import java.util.List;

import pp2.scrum.domain.UserStory;

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
