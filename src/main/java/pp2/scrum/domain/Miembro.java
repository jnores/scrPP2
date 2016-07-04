package pp2.scrum.domain;

/**
 * @author yoshknight
 *
 */
public class Miembro {

	private String nombre;
	private String perfil;
	
	/**
	 * @param nombre the nombre to set
	 */
	public Miembro(String nombre) {
		this.nombre = nombre;
		this.perfil = "";
	}
	
	/**
	 * @param nombre the nombre to set
	 * @param nombre the nombre to set
	 */
	public Miembro(String nombre,String perfil) {
		this.nombre = nombre;
		this.perfil = perfil;
	}
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String toString()
	{
	     return nombre; 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
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
		if (!(obj instanceof Miembro)) {
			return false;
		}
		Miembro other = (Miembro) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		if (perfil == null) {
			if (other.perfil != null) {
				return false;
			}
		} else if (!perfil.equals(other.perfil)) {
			return false;
		}
		return true;
	}

}
