package pp2.mock.scrum.dao;

import java.util.ArrayList;
import java.util.List;

import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.model.Proyecto;

public class MockProyectoDAO extends ProyectoDAO {
	
	private Proyecto proyecto; 
	public MockProyectoDAO() {
		proyecto = new Proyecto("proyecto1");
	}

	@Override
	public List<Proyecto> getAll() {
		// TODO Auto-generated method stub
		List<Proyecto> all = new ArrayList<Proyecto>();
		all.add(proyecto);
		return all;
	}

	@Override
	public Proyecto getById(long id) {
		return proyecto;
	}
	
}
