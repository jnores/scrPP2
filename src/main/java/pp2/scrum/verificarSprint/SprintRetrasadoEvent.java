/**
 * 
 */
package pp2.scrum.verificarSprint;

import java.awt.event.ActionEvent;

/**
 * @author yoshknight
 *
 */
public class SprintRetrasadoEvent extends ActionEvent { 
    
    private static final long serialVersionUID = 1L;

    public static final int ID = 36;
    public static final String COMMAND = "NotificarRetraso";
    
    private String titulo;
    private String detalle;

    /**
     * @param source
     * @param id
     * @param command
     */
    public SprintRetrasadoEvent(Object source, String titulo, String detalle) {
        super(source, ID, COMMAND);
        this.titulo  = titulo;
        this.detalle = detalle;
    }
    
    public String getTitulo() {
        return titulo.toString();
    }
    
    public String getDetalle() {
        return detalle.toString();
    }
    
    @Override
    public String toString() {
        return titulo;
    }
}
