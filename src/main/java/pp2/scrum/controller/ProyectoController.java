package pp2.scrum.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pp2.scrum.dominio.entidad.MailGateway;
import pp2.scrum.dominio.entidad.Miembro;
import pp2.scrum.dominio.entidad.Proyecto;
import pp2.scrum.dominio.entidad.UserStory;

public class ProyectoController extends Controller 
{
    private Proyecto proyecto;

    public ProyectoController(Proyecto model,MailGateway mailGateway) {
        super (mailGateway);
        this.proyecto = model;
    }

    /**
     * Genera una Lista de UserStories
     * @return List<UserStory> totalidad de userstories del proyecto.
     */
    public List<UserStoryHelper> getAllUserStories() {
        Set<UserStoryHelper> userStories = proyecto.getAllUserStories();
        ArrayList<UserStoryHelper> userStoriesHelpers = new ArrayList<UserStoryHelper>();
        for(UserStoryHelper userStory: userStories) {
            userStoriesHelpers.add( userStory );
        }

        return userStoriesHelpers;
    }

    /**
     * Genera una Lista de UserStories
     * @return List<UserStory> totalidad de userstories del proyecto.
     */
    public List<UserStoryHelper> getBacklog() {
        List<UserStoryHelper> userStories = proyecto.getBacklog();
        ArrayList<UserStoryHelper> userStoriesHelpers = new ArrayList<UserStoryHelper>();
        for(UserStoryHelper userStory: userStories) {
            userStoriesHelpers.add( userStory);
        }

        return userStoriesHelpers;
    }

    public UserStoryHelper getUserStoryHelper(int id) {           //FIXME
        return proyecto.getUserStoryPorId(id);
    }

    public void setProyecto(Proyecto proyecto)
    {
        this.proyecto = proyecto;
    }

    public Proyecto getProyecto()
    {
        return proyecto;
    }

    public MailGateway getMailGateway()
    {
        return mailGateway;
    }

    public long getSiguienteStoryID() {
        return proyecto.getSiguienteStoryID();
    }

    public void agregarUserStory(UserStoryHelper us) {
        if (us==null)
            throw new InvalidParameterException("Se esperaba una user story para agregar y se recibio un elemento nulo.");
        proyecto.addUserStory(us);

    }
}
