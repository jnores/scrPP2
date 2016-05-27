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
			evaluarEstadoTarea(tarea, estadoNuevo);
		}catch(Exception exc){ exc.getMessage();}
	}
	
	private void evaluarEstadoTarea(Tarea tarea,Estado estadoActualTarea){
		if(tarea.getEstado()==Estado.ToDo){
			tarea.avanzarEstado();
		}
		if(tarea.getEstado()==Estado.Doing && estadoActualTarea==Estado.Done){
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
	
	public static void main(String[] args) {
		ArrayList<Tarea> tareas=new ArrayList<Tarea> ();
		for(int i=1; i<10;i++){
			Tarea tarea=new Tarea();
			tarea.setId(i);
			tareas.add(tarea);
		}
		VinculadorCommitsTarea vinculos=new VinculadorCommitsTarea(tareas,"src/main/resources/file/GitLog.txt");
		System.out.println(vinculos.getTarea(1).getEstado()+" "+ vinculos.getTarea(1).getCommits().get(0)+" "+vinculos.getTarea(2).getEstado());
	}
}
