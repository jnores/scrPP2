package pp2.scrum.logCommits;

import java.util.ArrayList;

import pp2.scrum.correctorSintaxis.RegexFacilities;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Tarea;

public class VinculadorCommitsTarea {
    private GestorConsultas gestor;

    //no debería recibir las tareas sino alguien que le pase una tarea por un ID
    public VinculadorCommitsTarea(GestorConsultas gestor, ArrayList<Commit> commits){
        this.gestor=gestor;
        for(Commit commit:commits){
            vincular(commit);
        }
    }

    private void vincular(Commit commit){
        String mensaje=RegexFacilities.normalizarTexto(commit.getMensaje());
        String aux=RegexFacilities.removerPatronTexto(".*#tarea:\\s*",mensaje);
        String id=RegexFacilities.removerPatronTexto("\\s+.*$",aux);
        aux=RegexFacilities.removerPatronTexto(".*#estado:(\\s)*",mensaje);
        String estado=RegexFacilities.removerPatronTexto("\\W.*$",aux);
        try{
            Tarea tarea=gestor.getTarea(id);
            tarea.addCommit(commit.getSha());
            aux=RegexFacilities.normalizarTexto(estado);
            Estado estadoNuevo=Estado.Doing;
            if(aux.equals("done")){
                estadoNuevo=Estado.Done;
            }
            setEstadoTarea(tarea, estadoNuevo);
            gestor.guardarModificacionTarea(tarea);
        }catch(Exception exc){ exc.getMessage();}
    }
    
    private void setEstadoTarea(Tarea tarea,Estado estadoActualTarea){
        while(tarea.getEstado().compareTo(estadoActualTarea) < 0) {
            tarea.avanzarEstado();
        }
    } 
}
