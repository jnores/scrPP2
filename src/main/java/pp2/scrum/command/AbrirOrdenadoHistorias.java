package pp2.scrum.command;

import javax.swing.JFrame;

import pp2.scrum.controller.UserStoryOrdenadoController;
import pp2.scrum.model.Backlog;
import pp2.scrum.view.UserStoryOrderableView;

public class AbrirOrdenadoHistorias extends AbrirListadoHistorias {

    public AbrirOrdenadoHistorias(String tipoBacklog) {
        super(tipoBacklog);
    }

    @Override
    protected JFrame createView(Backlog backlog) {
        UserStoryOrdenadoController controller = new UserStoryOrdenadoController(
                backlog);
        
        return new UserStoryOrderableView(controller);
    }

}
