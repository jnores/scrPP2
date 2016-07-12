package pp2.scrum.dao;

import java.util.List;

public interface DaoSuperType<T> {

	List<T> getAll();
	T getById(long id);
}
