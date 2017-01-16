/**
 * 
 */
package pp2.scrum.controller;

import java.security.InvalidParameterException;

import pp2.scrum.model.Estado;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;

/**
 * @author yoshknight
 *
 */
public class SprintController extends Controller {

    private Sprint modelo;
    
    /**
     * 
     * @param model
     */
    public SprintController (Sprint modelo) {
        this.modelo = modelo;
    }

    public Estado getEstadoTarea(Tarea tarea) throws InvalidParameterException {
       if ( ! modelo.contieneTarea(tarea) )
           throw new InvalidParameterException("La tarea consultada no pertenece al presente sprint.");
       
       return modelo.getPizarra().get(tarea);
       
    }

    public void avanzarEstado(Tarea tarea) throws InvalidParameterException, RuntimeException {
        Estado estadoActual = getEstadoTarea(tarea);
        
        Estado estadoNuevo = estadoActual.avanzar();
        
        modelo.getPizarra().put(tarea,estadoNuevo);
    }
}
