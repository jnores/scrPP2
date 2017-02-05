package pp2.scrum.controller;

import java.awt.event.ActionListener;

import pp2.scrum.calendario.CalendarioService;
import pp2.scrum.command.Comando;
import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.logger.Logger;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Sprint;
import pp2.scrum.servicios.ServiceRegistry;

public class HomeController extends Controller implements AppController {
    private ProyectoController proyectoController;
    private Proyecto proyecto;

    public HomeController(Proyecto proyecto, ComponentFactory factory)
            throws InstantiationException {
        super();
        this.proyecto = proyecto;
        proyectoController = new ProyectoController(proyecto,
                (ProyectoDAO) factory.getComponentByName("ProyectoDAO"));
    }

    @Override
    public Resultado Execute(Comando commando, ActionListener al) {
        return commando.Execute(this, al);
    }

    @Override
    public String getApplicationName() {
        String nombre = proyecto.getNombre();
        Sprint iteracion = proyecto.iteracionActual();
        CalendarioService calendario = (CalendarioService) ServiceRegistry
                .getInstance().getService("Calendario");
        if (iteracion != null)
            nombre += " - Iteración " + iteracion.getIdIteracion() + "("
                    + iteracion.getfechaInicio() + " - "
                    + calendario.agregarDias(iteracion.getfechaInicio(),
                            iteracion.getDuracion())
                    + ")";
        return nombre;
    }

    public ProyectoController getProyectoController() {
        return proyectoController;
    }

    @Override
    public void closeApp() {
        Logger.log("Cerrando Aplicación");
    }
}
