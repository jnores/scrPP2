package pp2.scrum.dao;

import java.util.ArrayList;
import java.util.List;

import pp2.scrum.model.Proyecto;

public class ProyectoDAO implements DaoSuperType<Proyecto> {

	@Override
	public List<Proyecto> getAll() {
		// TODO Auto-generated method stub
		List<Proyecto> all = new ArrayList<Proyecto>();
		all.add(new Proyecto("proyecto1"));
		
		return all;
	}

	@Override
	public Proyecto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
