/**
 * 
 */
package pp2.scrum.command;

import java.awt.event.ActionListener;

import pp2.scrum.controller.BurndownChartController;
import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;
import pp2.scrum.model.Sprint;
import pp2.scrum.view.BurndownChartView;
import pp2.scrum.view.events.ViewUpdateEvent;

/**
 * @author yoshknight
 *
 */
public class MostrarBurnDownChart implements Comando {

    /*
     * (non-Javadoc)
     * 
     * @see
     * pp2.scrum.command.Comando#Execute(pp2.scrum.controller.HomeController,
     * java.awt.event.ActionListener)
     */
    @Override
    public Resultado Execute(HomeController homeController, ActionListener al) {
        Sprint currentSprint = homeController.getProyectoController()
                .getCurrentSprint();
        if (null != currentSprint) {
            BurndownChartController controller = new BurndownChartController(
                    currentSprint);
            BurndownChartView view = new BurndownChartView(controller);
            al.actionPerformed(new ViewUpdateEvent(view, 10, "UpdateView"));
        }
        return null;
    }

}
