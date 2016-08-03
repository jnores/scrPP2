/**
 * 
 */
package pp2.scrum.model;

import java.util.List;
import java.util.Set;

/**
 * @author yoshknight
 *
 */
public class ProyectoNuevo extends Proyecto {

    public ProyectoNuevo(){
        super(-1,"Proyecto Nuevo");
    }
    
    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }
    
    public void setIteraciones(List<Sprint> Nuevasiteraciones) {
        iteraciones = Nuevasiteraciones;
    }
    
    public void setMiembros(Set<Miembro> nuevosMiembros) {
        miembros = nuevosMiembros;
    }
}
