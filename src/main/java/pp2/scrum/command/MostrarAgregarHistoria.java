/**
 * 
 */
package pp2.scrum.command;

import java.awt.event.ActionListener;

import pp2.scrum.controller.ControllerFactory;
import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;
import pp2.scrum.controller.UserStoryController;
import pp2.scrum.view.AltaUserStoryView;
import pp2.scrum.view.events.ViewUpdateEvent;

/**
 * @author yoshknight
 *
 */
public class MostrarAgregarHistoria implements Comando<HomeController>{
	AltaUserStoryView view=null;

	@Override
	public Resultado Execute(final HomeController homeController,ActionListener al) {
		Resultado resultado = new Resultado();
		try 
		{
			if (view==null) {
				UserStoryController usc = new UserStoryController(null);
				view = new AltaUserStoryView(usc);
			}
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
