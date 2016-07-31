package pp2.scrum.logCommits;

import java.util.ArrayList;

public class GestorVinculos {
	
	private String defaultPath="src/main/resources/file/GitLog.txt";
	
	public GestorVinculos(String path,GestorConsultas gestor){
		
		String pathCommits=path;
		if(pathCommits==null)
			pathCommits=defaultPath;
		Lector lector= new Lector();
		String datos=lector.leerArchivo(path);
		InterpreteCommits interprete=new InterpreteCommits(datos);
        ArrayList<Commit> commits=interprete.getCommits();
        VinculadorCommitsTarea viculador=new VinculadorCommitsTarea(gestor,commits); 
	}
}
