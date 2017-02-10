package pp2.scrum.controller;

import java.security.InvalidParameterException;
import java.util.List;

import pp2.scrum.correctorSintaxis.CorrectorSintaxis;
import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.CriterioAceptacion;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;

public class ProyectoController extends Controller {
    private Proyecto proyecto;
    private ProyectoDAO proyectoDao;
    private CorrectorSintaxis modeloCorrector;

    public ProyectoController(Proyecto model, ProyectoDAO proyectoDao) {
        this.proyecto = model;
        this.proyectoDao = proyectoDao;
        modeloCorrector = new CorrectorSintaxis();
    }

    // /**
    // * Genera una Lista de UserStories
    // * @return List<UserStory> totalidad de userstories del proyecto.
    // */
    // public List<UserStoryHelper> getAllUserStories() {
    // Collection<UserStory> userStories = proyecto.getAllUserStories();
    // ArrayList<UserStoryHelper> userStoriesHelpers = new
    // ArrayList<UserStoryHelper>();
    // for(UserStory userStory: userStories) {
    // userStoriesHelpers.add( new
    // UserStoryHelper(userStory,proyecto.getResponsable(userStory) ) );
    // }
    //
    // return userStoriesHelpers;
    // }

    /**
     * Genera una Lista de UserStories
     * 
     * @return List<UserStory> totalidad de userstories del proyecto.
     */
    public Backlog getBacklog() {
        return proyecto.getBacklog();
        // List<UserStory> userStories = proyecto.getBacklog();
        // ArrayList<UserStoryHelper> userStoriesHelpers = new
        // ArrayList<UserStoryHelper>();
        // for(UserStory userStory: userStories) {
        // userStoriesHelpers.add( new
        // UserStoryHelper(userStory,proyecto.getResponsable(userStory) ) );
        // }
        //
        // return userStoriesHelpers;
    }

    // public UserStoryHelper getUserStory(int id) {
    // UserStory us= proyecto.getUserStoryPorId(id);
    // UserStoryHelper ush = new
    // UserStoryHelper(us,proyecto.getResponsable(us));
    // return ush;
    // }

    public void agregarUserStory(UserStory us) {
        if (us == null)
            throw new InvalidParameterException(
                    "Se esperaba una user story para agregar y se recibio un elemento nulo.");
        proyecto.addUserStory(us);

    }

    public void altaUserStory(String titulo, String detalle, String criterios,
            Integer puntos, List<Tarea> tareas) {
        // Falta lo importante
        // if (hs==null)
        // throw new InvalidParameterException("Se esperaba una cantidad de
        // horas mayor a cero y se recibio un elemento nulo.");
        // if (puntos==null)
        // throw new InvalidParameterException("Se esperaba una cantidad de
        // puntos mayor a cero y se recibio un elemento nulo.");
        CriterioAceptacion criterio = new CriterioAceptacion(criterios);
        UserStory us = new UserStory(titulo, detalle, puntos, criterio, tareas);
        agregarUserStory(us);
    }

    public String obtenerSugerenciaTitulo(String frase) {
        return modeloCorrector.analizarTituloUserStory(frase, false);
    }

    public String obtenerSugerenciaCriterio(String frase) {
        return modeloCorrector.analizarCriterios(frase, false);
    }

    /**
     * Metodo encargado de guardar un proyecto nuevo y retornar el proyecto
     * persistido.
     * 
     * @param newProyecto
     *            Si el proyecto es un prpyecto nuevo, lo guarda. sino, lo
     *            actualiza.
     * @return
     */
    public Proyecto save(Proyecto newProyecto) {
        long proyectoId = proyectoDao.guardar(newProyecto);
        return proyectoDao.getById(proyectoId);
    }

    public Sprint getCurrentSprint() {
        List<Sprint> iteraciones = proyecto.getIteraciones();
        Sprint current = null;
        if (iteraciones.size() > 0)
            current = iteraciones.get(iteraciones.size() - 1);
        return current;
    }

}
