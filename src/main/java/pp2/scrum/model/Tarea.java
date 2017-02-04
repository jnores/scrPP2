package pp2.scrum.model;

import java.util.ArrayList;

import pp2.scrum.logCommits.GeneradorIDs;

public class Tarea extends java.util.Observable {
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
