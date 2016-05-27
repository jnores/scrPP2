package pp2.scrum.logCommits;

public class Commit {
	private String shaCommit;
	private String autor;
	private String fecha;
	private String mensaje;
	
	public Commit(String sha){
		this.shaCommit=sha;	
	}
	
	public void addAutor(String autor){
		this.autor=autor;
	}
	
	public void addDate(String fecha){
		this.fecha=fecha;
	}
	
	public void addMensaje(String mensaje){
		this.mensaje=mensaje;
	}
	public String getDate(){
		return this.fecha;
	}
	public String getSha(){
		return this.shaCommit;
	}

	public String getAutor(){
		return this.autor;
	}
	public String getMensaje(){
		return this.mensaje;
	}
}
