package pp2.scrum.controller;

import java.util.List;

import pp2.scrum.model.CriterioAceptacion;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Miembro;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;

public class UserStoryHelper
{
	private UserStory userStory;
	private Miembro miembro;
	private int iteracion,horasEstimadas;
	private Estado estado;
	
	@SuppressWarnings("unused")
	private UserStoryHelper(){ }
	
	public UserStoryHelper(UserStory us) {
		this.userStory = us;
		this.miembro   = null;
		estado = Estado.getDefault();
	}
	
	public UserStoryHelper(UserStory us,Miembro miembro) {
		this.userStory = us;
		this.miembro   = miembro;
		estado = Estado.getDefault();
	}

	public long getId() {
		return userStory.getId();
	}

	public String getTitulo() {
		return this.userStory.getTitulo();
	}
	
	public String getDetalle() {
		return this.userStory.getDetalle();
	}
	
	public String getAutor() {
		return miembro != null ? miembro.getNombre(): "-";
	}
	
	public int getStoryPoints()
	{
		return this.userStory.getStoryPoints();
	}
	
	public String getResponsable() {
		String responsable="-";
		if (miembro != null)
			responsable=miembro.getNombre();
		return responsable;
	}

	public CriterioAceptacion getCriterios() {
		return userStory.getCriterio();
	}

	public List<Tarea> getTareas() {
		return userStory.getTareas();
	}

	public int getIteracion() {
		return iteracion;
	}
	
	public void setIteracion(int i) {
		iteracion = i;
	}

	public void setCriterios(CriterioAceptacion criterio) {
		userStory.setCriterio(criterio);		
	}
	
	public void setTareas(List<Tarea> tareas) {
		userStory.setTareas(tareas);		
	}

	public void setAutor(String string) {
		miembro = new Miembro(string);
		
	}

	public void setDetalle(String string) {
		userStory.setDetalle(string);
		
	}

	public void setEstado(Estado est) {
		estado = est;	
	}
	
	public Estado getEstado() {
		if (estaTerminada())
		{
			return Estado.Done;
		}
		return this.estado;	
	}

	public void setHorasEstimadas(int i) {
		horasEstimadas = i;		
	}

	public void setResponsable(String string) {
		miembro = new Miembro(string);		
	}

	public void setTitulo(String string) {
		userStory.setTitulo(string);
		
	}

	public void setStoryPoints(int i) {
		userStory.setStoryPoints(i);
		
	}

	public boolean estaTerminada() {
		return userStory.estaTerminada();
	}

	public Miembro getMiembro() {
		return miembro;
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setId(int i) {
		userStory.setId(i);;	
	}
	
	
}
