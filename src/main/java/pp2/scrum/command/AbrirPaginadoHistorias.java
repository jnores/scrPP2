package pp2.scrum.command;

import javax.swing.JFrame;

import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.Backlog;
import pp2.scrum.view.UserStoryPaginadoView;

public class AbrirPaginadoHistorias extends AbrirListadoHistorias {

    public AbrirPaginadoHistorias(String tipoBacklog) {
        super(tipoBacklog);
    }

    @Override
    protected JFrame createView(Backlog backlog) {
        UserStoryPaginadoController controller = new UserStoryPaginadoController(
                backlog);
        
        return new UserStoryPaginadoView(controller);
    }

}
