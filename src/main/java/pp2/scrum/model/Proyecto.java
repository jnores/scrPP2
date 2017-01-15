package pp2.scrum.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pp2.scrum.utils.Calendario;

/**
 * @author yoshknight
 *
 */
public class Proyecto {
    private long id;
    protected String nombre;
    // private Date fechaInicio,fechaFin;
    private List<UserStory> backlog;
    protected Set<Miembro> miembros;
    protected List<Sprint> iteraciones;
    private Map<UserStory, Miembro> asignaciones;


    public Proyecto(long id,String nombre) {
        this(id, nombre, new ArrayList<UserStory>(),
                new HashSet<Miembro>(),
                new ArrayList<Sprint>(),
                new HashMap<UserStory, Miembro>());

    }

    public Proyecto(long id,String nombre, List<UserStory> backlog,
            Set<Miembro> miembros, List<Sprint> iteraciones,
            Map<UserStory, Miembro> asignaciones) {
        this.id = id;
        this.nombre = nombre;
        this.backlog = backlog;
        this.miembros = miembros;
        this.iteraciones = iteraciones;
        this.asignaciones = asignaciones;
    }
    
    public long getId() {
        return id;
    }    

    /**
     * @return Coleccion de miembros que componene el proyecto
     */
    public Set<Miembro> getMiembros() {
        return miembros;
    }
    
    public List<Sprint> getIteraciones() {
        return iteraciones;
    }
    
    public Map<UserStory, Miembro> getAsignaciones() {
        return asignaciones;
    }

       /**
     * @return Coleccion de UserStories del backlog
     */
    public List<UserStory> getBacklog() {
        return backlog;
    }

    /**
     * @param nombre
     *            Nombre del miemro del proyecto
     * @return Miebro del proyecto
     */
    public Miembro getMiembroPorNombre(String nombre) {
        Miembro miembro = null;
        for (Miembro m: miembros) {
            if (m.getNombre().equals(nombre)) {
                miembro = m;
                break;
            }
        }
        return miembro;
    }

    /**
     * @param userStory
     *            La user story que se debe agregar al bachlog
     */
    public void addUserStory(UserStory userStory) {
        this.backlog.add(userStory);
    }

    /**
     * @param miembro
     *            El miembro que se debe agregar al proyecto
     */
    public void addMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    /**
     * @param userStory
     *            La user story a asignar
     * @param miembro
     *            El miembro que se le asignara la user story
     */
    public void asignarUserStory(UserStory userStory, Miembro miembro) {
        if (this.backlog.contains(userStory)
                && this.miembros.contains(miembro)) {
            this.asignaciones.put(userStory, miembro);
        }
    }

    public UserStory getUserStoryPorId(int id) {
        UserStory userStory = null;
        getBacklog();
        for (UserStory us : backlog) {
            if (us.getId() == id) {
                userStory = us;
                break;
            }
        }
        return userStory;
    }

    public Miembro getResponsable(UserStory userStory) {
        Miembro miembro = null;
        if (userStory != null) {
            if (this.asignaciones.containsKey(userStory)) {
                miembro = this.asignaciones.get(userStory);
            }
        }
        return miembro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    /**
     * TODO Esto funciona solo para cuando existe un unico proyecto. y todas las
     * us estan en el backlog.
     * 
     * @return
     */
    public long getSiguienteStoryID() {
        long id = 0;
        for (UserStory us : backlog)
            if (us.getId() > id)
                id = us.getId();
        return id + 1;
    }

    public Sprint iteracionActual() throws RuntimeException {
        Date hoy = new Date();
        for (Sprint sprint : iteraciones) {
            if (hoy.after(sprint.getfechaInicio()) &&
                    hoy.before(
                            Calendario.agregarDias(
                                    sprint.getfechaInicio(),
                                    sprint.getDuracion()
                                    )
                            )
                    ) {
                return sprint;
            }
        }
        throw new RuntimeException("No existe una iteración actual");
    }

}
