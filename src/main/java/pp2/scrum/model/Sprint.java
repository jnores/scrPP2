package pp2.scrum.model;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Sprint {
    private int idIteracion;
    private Date fechaInicio;
    private int duracion;
    private List<UserStory> sprintBacklog;
    private int StoryPointsPactados; 
    private Map<Tarea, Estado > pizarraEstados;

    public Sprint(int idIteracion,Date fechaInicio, int duracion, List<UserStory> historias) {
        this.idIteracion = idIteracion;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.sprintBacklog = historias;
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
        if(this.sprintBacklog!=null){
            for (UserStory us: this.sprintBacklog) {
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

    public List<UserStory> getUserStories() {
        return this.sprintBacklog;
    }

    public void setDuracion(int dias) {
        this.duracion=dias;
    }

    public void setUserStories(List<UserStory> historias) {
        this.sprintBacklog=historias;
    }

    public void setUserStory(UserStory historia) {
        this.StoryPointsPactados=+historia.getStoryPoints();
        this.sprintBacklog.add(historia);
    }

    public int getDuracion() {
        return this.duracion;
    }

    public int getStoryPointsPactados() {
        return this.StoryPointsPactados;
    }

    public int getDiasTranscurridos() {
        Date fechaFinal=new Date();
        long tiempo = fechaFinal.getTime()-this.fechaInicio.getTime();
        Number convertir=tiempo/(1000*3600*24);
        int dias = convertir.intValue();

        return dias;
    }

//    /**
//     * 
//     * @param us UserStory de la que se quiere obtener el estado.
//     * @return Estado que tiene la userStory,. si no se encuentra la historia retorna null.
//     */
//    public Estado stateStory(UserStory us) {
//        Estado key=null;
//        for( Entry<Estado, List<UserStory> > entry : pizarraEstados.entrySet()) {
//            if ( entry.getValue().contains(us) ) {
//                key = entry.getKey();
//                break;
//            }
//        }
//        //FIXME Si la histora no pertenece a este sprint, retorna null.
//        return key;
//    }

    /**
     * Verifica si la userStory esta terminada o no en base al estado de sus 
     * tareas. 
     * 
     * @param us
     * @return
     */
    public boolean isDone(UserStory us) throws InvalidParameterException{
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
        return sprintBacklog.contains(us);
    }

    public void changeEstado(Tarea tarea, Estado newEstado) throws InvalidParameterException{
        if ( ! pizarraEstados.containsKey(tarea) )
            throw new InvalidParameterException("La UserStory especificada no corresponde a este Sprint.");
        
        pizarraEstados.put(tarea, newEstado);
    }

}
