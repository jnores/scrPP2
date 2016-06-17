package pp2.scrum.dominio.entidad;

import java.util.List;

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
