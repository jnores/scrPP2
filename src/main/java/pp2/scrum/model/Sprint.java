package pp2.scrum.model;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sprint {
    private int idIteracion;
    private Date fechaInicio;
    private int duracion;
    private List<UserStory> backlog;
    private int StoryPointsPactados; 
    private Map<Tarea, Estado > pizarraEstados;

    public Sprint(int idIteracion,Date fechaInicio, int duracion, List<UserStory> historias) {
        this.idIteracion = idIteracion;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.backlog = historias;
        this.setStoryPointsPactados();

        pizarraEstados = new HashMap< Tarea,Estado >(); 

        // TODO: Esto se debe realizar cuando se commitea el sprint backlog 
        // -- JN 20170114 
        Estado estadoAux = Estado.getDefault();
        if (historias != null) {   
            for (UserStory us : historias)
                for ( Tarea t : us.getTareas() )
                    pizarraEstados.put( t, estadoAux );
        }

    }

    private void setStoryPointsPactados(){
        int puntos=0;
        if(this.backlog!=null){
            for (UserStory us: this.backlog) {
                puntos+=us.getStoryPoints();
            }
        }
        this.StoryPointsPactados=puntos;
    }

    public int getIdIteracion() {
        return this.idIteracion;
    }

    public Date getfechaInicio() {
        return this.fechaInicio;
    }

    public List<UserStory> getBacklog() {
        return this.backlog;
    }

    public void setDuracion(int dias) {
        this.duracion=dias;
    }

    public void setUserStories(List<UserStory> historias) {
        this.backlog=historias;
    }

    public void setUserStory(UserStory historia) {
        this.StoryPointsPactados=+historia.getStoryPoints();
        this.backlog.add(historia);
    }

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
    public boolean isUserStoryDone(UserStory us) throws InvalidParameterException{
        if (! contieneUserStory(us) )
            throw new InvalidParameterException("La UserStory especificada no corresponde a este Sprint.");
        
        boolean isDone=true;
        for ( Tarea tareaN: us.getTareas() ) {
            if ( ! pizarraEstados.get(tareaN).equals(Estado.Done) )
            {
                isDone=false;
                break;
            }
        }
        return isDone;
    }

    public boolean contieneUserStory(UserStory us) {
        return backlog.contains(us);
    }

    public void changeEstadoTarea(Tarea tarea, Estado newEstado) throws InvalidParameterException{
        if ( ! contieneTarea(tarea) )
            throw new InvalidParameterException("La UserStory especificada no corresponde a este Sprint.");
        
        pizarraEstados.put(tarea, newEstado);
    }

    public Estado getEstadoTarea(Tarea tarea) {
        return pizarraEstados.get(tarea);
    }

    public boolean contieneTarea(Tarea tarea) {
        return pizarraEstados.containsKey(tarea);
    }

    public Map<Tarea, Estado> getPizarra() {
        return pizarraEstados;
    }
    

}
