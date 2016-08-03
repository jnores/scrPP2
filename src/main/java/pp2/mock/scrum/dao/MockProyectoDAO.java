package pp2.mock.scrum.dao;

import java.util.ArrayList;
import java.util.List;

import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.model.Proyecto;

public class MockProyectoDAO extends ProyectoDAO {

    List<Proyecto> listaProyectos = new ArrayList<Proyecto>();

    public MockProyectoDAO() {
         listaProyectos.add(0, new Proyecto(1, "Test 1"));

    }

    @Override
    public List<Proyecto> getAll() {
        return listaProyectos;
    }

    @Override
    public Proyecto getById(long id) {
        return listaProyectos.get((int) id - 1);
    }

    @Override
    public long guardar(Proyecto proyecto) {
        long id = proyecto.getId();
        if (id < 1)
            id = listaProyectos.size();

        listaProyectos.add(new Proyecto(id, proyecto.getNombre(),
                proyecto.getBacklog(), proyecto.getMiembros(),
                proyecto.getIteraciones(), proyecto.getAsignaciones()));
        return id;
    }

}
