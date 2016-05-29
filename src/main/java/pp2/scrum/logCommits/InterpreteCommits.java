package pp2.scrum.logCommits;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import pp2.scrum.utils.RegexFacilities;

public class InterpreteCommits {

	private ArrayList<Commit> commitsLog;

	public InterpreteCommits(String archivo){
		String cadena;
		FileReader lector;
		BufferedReader buffered;

		try {
			lector = new FileReader(archivo);
			buffered = new BufferedReader(lector);
			Commit commit;
			commitsLog=new ArrayList<Commit>();
			while((cadena = buffered.readLine())!=null) {
				if(RegexFacilities.existeEnElTexto("^[Cc]ommit", cadena)){
					String sha=RegexFacilities.removerPatronTexto("^[C|c]ommit(:\\s*|\\s+)",cadena);
					//Cuando empieza un nuevo commit en el log se crea un objeto commit
					commit=new Commit(sha);
					commitsLog.add(commit);
				}
				if(RegexFacilities.existeEnElTexto("^[Aa]ut(h|)or", cadena)){
					String autor=RegexFacilities.removerPatronTexto("^[Aa]ut[h|]or(:\\s*|\\s+)",cadena);
					commitsLog.get(commitsLog.size()-1).addAutor(autor);
				}
				
				if(RegexFacilities.existeEnElTexto("^Fecha|^Date", cadena)){
					String fecha=RegexFacilities.removerPatronTexto("(^[Dd]ate|^[F|f]echa)(:\\s*|\\s+)",cadena);
					commitsLog.get(commitsLog.size()-1).addDate(fecha);
				}
				if(RegexFacilities.existeEnElTexto("[^(Commit)]|[^(Author)]|[^(Autor)]|[^(fecha)]|[^(Date)]", cadena)){
					commitsLog.get(commitsLog.size()-1).addMensaje(cadena);	
				}	
			}
			buffered.close();
		} catch (FileNotFoundException excepcion){
			excepcion.getLocalizedMessage();
		}catch (IOException excepcion) {
			excepcion.getLocalizedMessage();
		}
	}
	
	public ArrayList<Commit> getCommits(){
		return commitsLog;
	}

//	public static void main(String[] args) {
//		InterpreteCommits interprete=new InterpreteCommits("src/main/resources/file/GitLog.txt");
//		for(Commit commit:interprete.getCommits()){
//			System.out.println(commit.getSha());
//			System.out.println(commit.getDate());
//			System.out.println(commit.getAutor());
//			System.out.println(commit.getMensaje());
//			
//		}
//	}

}
