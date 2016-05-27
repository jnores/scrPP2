package pp2.scrum.dominio.entidad;

import java.util.ArrayList;

import pp2.scrum.dominio.enums.Estado;

public class Tarea extends java.util.Observable
{
	private int id;
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
	
		estado = Estado.getDefault();
		this.commitsVinculados=new ArrayList<String>();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	
	//esto no va
	public void setId(int id) {
		this.id = id;
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
	}
	
	public void addCommit(String id){
		this.commitsVinculados.add(id);
	}
	
	public ArrayList<String> getCommits(){
		return this.commitsVinculados;
	}
}
