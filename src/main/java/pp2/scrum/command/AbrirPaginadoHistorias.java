package pp2.scrum.command;

import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.Sprint;
import pp2.scrum.view.UserStoryPaginadoView;

public class AbrirPaginadoHistorias implements Comando {
    private String mTipoBacklog;

    public AbrirPaginadoHistorias(String tipoBacklog) {
        mTipoBacklog = tipoBacklog;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pp2.scrum.command.Comando#Execute(pp2.scrum.controller.HomeController,
     * java.awt.event.ActionListener)
     */
    @Override
    public Resultado Execute(HomeController homeController, ActionListener al) {
        Backlog backlog;
        if (mTipoBacklog.toLowerCase().equals("sprint backlog")) {
            Sprint currentSprint = homeController.getProyectoController()
                    .getCurrentSprint();
            if (null != currentSprint)
                backlog = currentSprint.getBacklog();
            else
                backlog = new Backlog();
        } else {
            backlog = homeController.getProyectoController().getBacklog();
        }
        UserStoryPaginadoController controller = new UserStoryPaginadoController(
                backlog);
        UserStoryPaginadoView view = new UserStoryPaginadoView(controller);
        view.showWindow(true);
        return null;
    }

}
