package pp2.scrum.model;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pp2.scrum.calendario.CalendarioService;
import pp2.scrum.servicios.ServiceRegistry;

public class Sprint {
    private int idIteracion;
    private Date fechaInicio;
    private int duracion;
    private Backlog sprintBacklog;
    private int StoryPointsPactados;
    private Map<Tarea, Estado> pizarraEstados;
    private Map<Tarea, Date> ultimoCambio;
    CalendarioService calendario;

    public Sprint(int idIteracion, Date fechaInicio, int duracion,
            Backlog historias) {
        // TODO: Esto se debe realizar cuando se commitea el sprint backlog
        // -- JN 20170114
        this(idIteracion, fechaInicio, duracion, historias,
                new HashMap<Tarea, Estado>(), new HashMap<Tarea, Date>());

        Estado estadoAux = Estado.getDefault();
        for (UserStory us : sprintBacklog.getList())
            for (Tarea t : us.getTareas())
                pizarraEstados.put(t, estadoAux);
    }

    public Sprint(int id, Date fechaInicio, int duracion, Backlog sprintBacklog,
            Map<Tarea, Estado> pizarraEstados,
            Map<Tarea, Date> logUltimoCambio) {

        calendario = (CalendarioService) ServiceRegistry.getInstance()
                .getService(CalendarioService.SERVICE_NAME);
        this.idIteracion = id;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.sprintBacklog = sprintBacklog;
        this.setStoryPointsPactados();

        this.pizarraEstados = pizarraEstados;
        this.ultimoCambio = logUltimoCambio;
    }

    private void setStoryPointsPactados() {
        int puntos = 0;
        if (this.sprintBacklog != null) {
            for (UserStory us : this.sprintBacklog.getList()) {
                puntos += us.getStoryPoints();
            }
        }
        this.StoryPointsPactados = puntos;
    }

    public int getIdIteracion() {
        return this.idIteracion;
    }

    public Date getfechaInicio() {
        return this.fechaInicio;
    }

    public Backlog getBacklog() {
        return this.sprintBacklog;
    }

    //
    // public void setUserStory(UserStory historia) {
    // this.StoryPointsPactados = +historia.getStoryPoints();
    // this.backlog.add(historia);
    // }

    public int getDuracion() {
        return this.duracion;
    }

    public int getStoryPointsPactados() {

        return this.StoryPointsPactados;
    }

    /**
     * Verifica si la userStory esta terminada o no en base al estado de sus
     * tareas.
     * 
     * @param us
     * @return
     */
    public boolean isUserStoryDone(UserStory us)
            throws InvalidParameterException {
        if (!contieneUserStory(us))
            throw new InvalidParameterException(
                    "La UserStory especificada no corresponde a este Sprint.");

        boolean isDone = true;
        for (Tarea tareaN : us.getTareas()) {
            if (!pizarraEstados.get(tareaN).equals(Estado.Done)) {
                isDone = false;
                break;
            }
        }
        return isDone;
    }

    public boolean contieneUserStory(UserStory us) {
        return sprintBacklog.getList().contains(us);
    }

    public void changeEstadoTarea(Tarea tarea, Estado newEstado)
            throws InvalidParameterException {
        if (!contieneTarea(tarea))
            throw new InvalidParameterException(
                    "La Tarea especificada no corresponde a este Sprint.");

        pizarraEstados.put(tarea, newEstado);
        ultimoCambio.put(tarea, calendario.getToday());
    }

    public Estado getEstadoTarea(Tarea tarea) {
        return pizarraEstados.get(tarea);
    }

    public boolean contieneTarea(Tarea tarea) {
        return pizarraEstados.containsKey(tarea);
    }

    public Date getUltimoCambio(Tarea tarea) {
        return ultimoCambio.get(tarea);
    }

    public Date getUltimoCambio(UserStory us) {
        Date lastUpdate = fechaInicio;
        for (Tarea t : us.getTareas()) {
            Date aux = this.getUltimoCambio(t);
            if (aux != null && lastUpdate.before(aux))
                lastUpdate = aux;
        }

        return lastUpdate.after(fechaInicio) ? lastUpdate : null;
    }

    public Map<Tarea, Estado> getPizarra() {
        return pizarraEstados;
    }

}
