package pp2.scrum.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.UserStory;

public class ProyectoController extends Controller 
{
    private Proyecto proyecto;
    private ProyectoDAO proyectoDao;

    public ProyectoController(Proyecto model,ProyectoDAO proyectoDao) {
        this.proyecto = model;
        this.proyectoDao = proyectoDao;
    }

    //    /**
    //     * Genera una Lista de UserStories
    //     * @return List<UserStory> totalidad de userstories del proyecto.
    //     */
    //    public List<UserStoryHelper> getAllUserStories() {
    //        Collection<UserStory> userStories = proyecto.getAllUserStories();
    //        ArrayList<UserStoryHelper> userStoriesHelpers = new ArrayList<UserStoryHelper>();
    //        for(UserStory userStory: userStories) {
    //            userStoriesHelpers.add( new UserStoryHelper(userStory,proyecto.getResponsable(userStory) ) );
    //        }
    //
    //        return userStoriesHelpers;
    //    }

    /**
     * Genera una Lista de UserStories
     * @return List<UserStory> totalidad de userstories del proyecto.
     */
    public List<UserStoryHelper> getBacklog() {
        List<UserStory> userStories = proyecto.getBacklog();
        ArrayList<UserStoryHelper> userStoriesHelpers = new ArrayList<UserStoryHelper>();
        for(UserStory userStory: userStories) {
            userStoriesHelpers.add( new UserStoryHelper(userStory,proyecto.getResponsable(userStory) ) );
        }

        return userStoriesHelpers;
    }

    public UserStoryHelper getUserStory(int id) {
        UserStory us= proyecto.getUserStoryPorId(id);
        UserStoryHelper ush = new UserStoryHelper(us,proyecto.getResponsable(us));
        return ush;
    }

    public void agregarUserStory(UserStory us) {
        if (us==null)
            throw new InvalidParameterException("Se esperaba una user story para agregar y se recibio un elemento nulo.");
        proyecto.addUserStory(us);

    }

    /**
     * Metodo encargado de guardar un proyecto nuevo y retornar el proyecto persistido.
     * @param newProyecto Si el proyecto es un prpyecto nuevo, lo guarda. sino, lo actualiza.
     * @return
     */
    public Proyecto save(Proyecto newProyecto) {
        long proyectoId = proyectoDao.guardar(newProyecto);
        return proyectoDao.getById(proyectoId);
    }
}
