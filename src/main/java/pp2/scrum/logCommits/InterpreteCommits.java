package pp2.scrum.logCommits;

import java.util.ArrayList;

import pp2.scrum.correctorSintaxis.RegexFacilities;

public class InterpreteCommits {

	private ArrayList<Commit> commitsLog;

	public InterpreteCommits(String texto){
		Commit commit;
		commitsLog=new ArrayList<Commit>();
		String[] datosCommit=texto.split("\\n");
		int posicionActual=0;
		for(String dato:datosCommit){ 
			if(RegexFacilities.existeEnElTexto("^[Cc]ommit", dato)){
				String sha=RegexFacilities.removerPatronTexto("^[C|c]ommit(:\\s*|\\s+)",dato);
				//Cuando empieza un nuevo commit en el log se crea un objeto commit
				commit=new Commit(sha);
				commitsLog.add(commit);
				posicionActual=commitsLog.indexOf(commit);
			}
			if(RegexFacilities.existeEnElTexto("^[Aa]ut(h|)or", dato)){
				String autor=RegexFacilities.removerPatronTexto("^[Aa]ut[h|]or(:\\s*|\\s+)",dato);
				commitsLog.get(posicionActual).addAutor(autor);
			}
			if(RegexFacilities.existeEnElTexto("^Fecha|^Date", dato)){
				String fecha=RegexFacilities.removerPatronTexto("(^[Dd]ate|^[F|f]echa)(:\\s*|\\s+)",dato);
				commitsLog.get(posicionActual).addDate(fecha);
			}
			if(RegexFacilities.existeEnElTexto("[^(Commit)]|[^(Author)]|[^(Autor)]|[^(fecha)]|[^(Date)]", dato)){
					commitsLog.get(posicionActual).addMensaje(dato);	
			}	
		}
	}
	
	public ArrayList<Commit> getCommits(){
		return commitsLog;
	}

}
