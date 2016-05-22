package pp2.scrum.dominio.entidad;

import java.util.Date;
import java.util.List;

import pp2.scrum.dominio.enums.Estado;

public class UserStory extends java.util.Observable
{
	
	private long id;
	private String titulo;
	private String detalle;
	private String autor;
	private String responsable;
	private Date fechaDone;
	private int horasEstimadas;
	private int storyPoints;
	private int iteracion;
	private Estado estado;
	private List<CriterioAceptacion> criterios;
	private List<Tarea> tareas;
	
	public UserStory(String titulo, String detalle, String autor, String responsable, int horasEstimadas, int storyPoints, int iteracion, Estado estado, List<CriterioAceptacion> criterios, List<Tarea> tareas) {
		this.titulo = titulo;
		this.detalle = detalle;
		this.autor = autor;
		this.responsable = responsable;
		this.horasEstimadas = horasEstimadas;
		this.storyPoints = storyPoints;
		this.iteracion = iteracion;
		this.estado = estado;
		this.criterios = criterios;
		this.tareas = tareas;
		this.fechaDone=null;
	}
	
	public UserStory(String titulo, String detalle, String autor) {
		this.titulo = titulo;
		this.detalle = detalle;
		this.autor = autor;
		//Estado por defecto al crear la user story
		this.estado = Estado.getDefault();
		this.fechaDone=null;
	}
	public UserStory(long id,String titulo, String detalle, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.detalle = detalle;
		this.autor = autor;
		//Estado por defecto al crear la user story
		this.estado = Estado.getDefault();
		this.fechaDone=null;
	}
	
	public void setId(long id) {
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

	public String getAutor() {
		return this.autor;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public int getHorasEstimadas() {
		return this.horasEstimadas;
	}

	public int getStoryPoints() {
		return this.storyPoints;
	}

	public int getIteracion() {
		return this.iteracion;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public List<CriterioAceptacion> getCriterios() {
		return this.criterios;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
		fueModificado();
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
		fueModificado();
	}

	public void setAutor(String autor) {
		this.autor = autor;
		fueModificado();
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
		fueModificado();
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
		fueModificado();
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
		fueModificado();
	}

	public void setIteracion(int iteracion) {
		this.iteracion = iteracion;
		fueModificado();
	}

	//NO SIRVE es de PRUEBA...
	public void setFecha(Date fecha){
		this.fechaDone=fecha;
	}
	
	//Agregue la fecha en que se culmina la user story para graficar el chart
	public void setEstado(Estado estado) {
		if(estado.compareTo(Estado.Done)==0)
		{this.fechaDone=new Date();}
		this.estado = estado;
		fueModificado();
	}

	public void setCriterios(List<CriterioAceptacion> criterios) {
		this.criterios = criterios;
		fueModificado();
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
		fueModificado();
	}
	
	public Date getFechaDone(){
		return this.fechaDone;
	}
	
	private void fueModificado() {
		setChanged();
		notifyObservers();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
	
}
