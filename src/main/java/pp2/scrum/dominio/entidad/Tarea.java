package pp2.scrum.dominio.entidad;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import pp2.scrum.dominio.enums.Estado;
import pp2.scrum.utils.GeneradorIDs;

public class Tarea extends java.util.Observable
{
	private String id;
	private Estado estado;
	//almacena el identificador de los commits que resuelven la tarea
	private ArrayList<String> commitsVinculados;
	/**
	 * @param id
	 * @param tareas
	 */
//	public Tarea(int id) {
//		this.id=id;
//		estado = Estado.getDefault();
//	}
	
	public Tarea() {
		this.id = GeneradorIDs.generarID();
		estado = Estado.getDefault();
		this.commitsVinculados=new ArrayList<String>();
	}
	/**
	 * @return the id
	 */
	public void setId(String id) {
		this.id=id;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the tareas
	 */
	public Estado getEstado() {
		return estado;
	}
	/**
	 * @param tareas the tareas to set
	 */
	public void avanzarEstado() throws RuntimeException
	{
		estado = estado.avanzar();
		fueModificado();
	}
	
	public void addCommit(String id){
		this.commitsVinculados.add(id);
		fueModificado();
	}
	
	public ArrayList<String> getCommits(){
		return this.commitsVinculados;
	}
	
	private void fueModificado() {
      setChanged();
      notifyObservers();
   }
}
