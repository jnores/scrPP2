/**
 * 
 */
package pp2.scrum.dominio.comando;

import java.awt.event.ActionListener;

import pp2.scrum.controller.ControllerFactory;
import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.interfaz.IComando;
import pp2.scrum.view.AltaUserStoryView;
import pp2.scrum.view.events.ViewUpdateEvent;

/**
 * @author yoshknight
 *
 */
public class MostrarAgregarHistoria implements IComando<HomeController>{

    @Override
    public Resultado Execute(final HomeController homeController,ActionListener al) {
        Resultado resultado = new Resultado();
        try 
        {
            AltaUserStoryView view = new AltaUserStoryView(ControllerFactory.getUserStoryController());
            view.setVisible(true);
            al.actionPerformed(new ViewUpdateEvent(view, 37, "mostrarAgregarHistoria"));
        }
        catch(Exception e)
        {
            resultado.AgregarError("Error", e.getMessage());
        };
        return resultado;
    }


}
