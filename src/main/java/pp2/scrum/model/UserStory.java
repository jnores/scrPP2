package pp2.scrum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class UserStory extends Observable implements Observer
{

	private long id;
	private String titulo;
	private String detalle;
	private int storyPoints;
	private CriterioAceptacion criterio;
	private List<Tarea> tareas;

	public UserStory(String titulo, String detalle, int storyPoints, CriterioAceptacion criterio, List<Tarea> tareas) {
		this.titulo = titulo;
		this.detalle = detalle;
		this.storyPoints = storyPoints;
		this.criterio = criterio;
		this.tareas = tareas == null ? new ArrayList<Tarea>() : tareas;
		observarTareas(this.tareas);
	}

	public UserStory(String titulo, String detalle) {
		this(-1,titulo,detalle);
	}
	public UserStory(long id,String titulo, String detalle) {
		this.id = id;
		this.titulo = titulo;
		this.detalle = detalle;
		this.criterio = new CriterioAceptacion("");
		this.tareas = new ArrayList<Tarea>();
		observarTareas(this.tareas);
	}

	public void setId(long id) { //FIXME quitar
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public int getStoryPoints() {
		return this.storyPoints;
	}

	public CriterioAceptacion getCriterio() {
		return this.criterio;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
		fueModificado(null);
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
		fueModificado(null);
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
		fueModificado(null);
	}

	public void setCriterio(CriterioAceptacion criterio) {
		this.criterio = criterio;
		fueModificado(null);
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas== null ? new ArrayList<Tarea>() : tareas;
		observarTareas(this.tareas);
		fueModificado(null);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());;
		result = prime * result + ((detalle == null) ? 0 : detalle.hashCode());;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserStory)) {
			return false;
		}
		UserStory other = (UserStory) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	public boolean estaTerminada()
	{
		boolean termino = true;
		for (Tarea tarea : tareas)
		{
			if( ! tarea.getEstado().equals(Estado.Done) )
			{
				termino=false;
				break;
			}
		}
		return termino;
	}

	private void observarTareas(List<Tarea> tareas)
	{
		for (Tarea tarea : tareas)
		{
			tarea.addObserver(this);
		}
	}

	private void fueModificado(Object arg) {
		setChanged();
		notifyObservers(arg);
	}

	@Override
	public void update(Observable o, Object arg)
	{
		fueModificado(o);
		//if (estaTerminada())

	}



}
