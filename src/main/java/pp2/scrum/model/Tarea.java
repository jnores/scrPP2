package pp2.scrum.model;

import java.util.ArrayList;

import pp2.scrum.logCommits.GeneradorIDs;

public class Tarea extends java.util.Observable {
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((detalle == null) ? 0 : detalle.hashCode());
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
        if (!(obj instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) obj;
        if (detalle == null) {
            if (other.detalle != null) {
                return false;
            }
        } else if (!detalle.equals(other.detalle)) {
            return false;
        }
        return true;
    }

    private String id, detalle;
    /**
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    private Estado estado;
    // almacena el identificador de los commits que resuelven la tarea
    private ArrayList<String> commitsVinculados;

    /**
     * @param id
     * @param tareas
     */
    public Tarea(String detalle) {
        this.detalle = detalle;
        this.id = GeneradorIDs.generarID();
        estado = Estado.getDefault();
        this.commitsVinculados = new ArrayList<String>();
    }

    public Tarea() {
        this.id = GeneradorIDs.generarID();
        estado = Estado.getDefault();
        this.commitsVinculados = new ArrayList<String>();
    }

    /**
     * @return the id
     */
    public void setId(String id) {
        this.id = id;
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
     * @param tareas
     *            the tareas to set
     */
    public void avanzarEstado() throws RuntimeException {
        estado = estado.avanzar();
        fueModificado();
    }

    public void addCommit(String id) {
        this.commitsVinculados.add(id);
        fueModificado();
    }

    public ArrayList<String> getCommits() {
        return this.commitsVinculados;
    }

    private void fueModificado() {
        setChanged();
        notifyObservers();
    }
}
