package pp2.scrum.logCommits;

import java.util.ArrayList;
import pp2.scrum.dominio.entidad.Tarea;
import pp2.scrum.dominio.enums.Estado;
import pp2.scrum.utils.RegexFacilities;

public class VinculadorCommitsTarea {
    private ArrayList<Commit> commits;
    private ArrayList<Tarea> tareasNoTerminadas;

    //no debería recibir las tareas sino alguien que le pase una tarea por un ID
    public VinculadorCommitsTarea(ArrayList<Tarea> tareasNoTerminadas, String path){
        this.tareasNoTerminadas=tareasNoTerminadas;
        InterpreteCommits interprete=new InterpreteCommits(path);
        commits=interprete.getCommits();
        for(Commit commit:commits){
            vincular(commit);
        }
    }

    private void vincular(Commit commit){
        String mensaje=RegexFacilities.normalizarTexto(commit.getMensaje());
        String aux=RegexFacilities.removerPatronTexto(".*#tarea:\\s*",mensaje);
        String id=RegexFacilities.removerPatronTexto("\\D+.*$",aux);
        aux=RegexFacilities.removerPatronTexto(".*#estado:(\\s)*",mensaje);
        String estado=RegexFacilities.removerPatronTexto("\\W.*$",aux);
        try{
            Integer idTarea=Integer.parseInt(id);
            Tarea tarea=getTarea(idTarea);
            tarea.addCommit(commit.getSha());
            aux=RegexFacilities.normalizarTexto(estado);
            Estado estadoNuevo=Estado.Doing;
            if(aux.equals("done")){
                estadoNuevo=Estado.Done;
            }
            setEstadoTarea(tarea, estadoNuevo);
        }catch(Exception exc){ exc.getMessage();}
    }
    // el evaluar no evalua. setea 
    // => ver si se usa un ciclo para avanzar hasta el nuevo estado
    //    Argumento: al tener 2 if. cuando la tarea esta en ToDo y se pasa a Done queda 
    //    en un estado intermedio invalido. es por un instante de tiempo pero es invalido.  
    private void setEstadoTarea(Tarea tarea,Estado estadoActualTarea){
        while(tarea.getEstado().compareTo(estadoActualTarea) < 0) {
            tarea.avanzarEstado();
        }
    } 

    //getTarea es temporal
    private Tarea getTarea(int id){
        for(Tarea tarea:tareasNoTerminadas){
            if(tarea.getId()==id){
                return tarea;
            }
        }
        return null;
    }

    // no poner los main en las clases. para esto estan los tests
    // Ver si se puede volver al estado previo. porque puede pasar. prioridad_Baja
    // no pasar el path del archivo. habrirlo con el interpreteCommits y pasarle la lista de commits. 
//    public static void main(String[] args) {
//        ArrayList<Tarea> tareas=new ArrayList<Tarea> ();
//        for(int i=1; i<10;i++){
//            Tarea tarea=new Tarea();
//            tarea.setId(i);
//            tareas.add(tarea);
//        }
//        VinculadorCommitsTarea vinculos=new VinculadorCommitsTarea(tareas,"src/main/resources/file/GitLog.txt");
//        for(Tarea t:tareas)
//            System.out.println(t.getEstado()+" => "+ (t.getCommits().isEmpty()?"-":t.getCommits().get(0)));
//    }
}
