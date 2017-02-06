package pp2.scrum.command;

import javax.swing.JFrame;

import pp2.scrum.model.Backlog;

public class AbrirFiltradoHistorias extends AbrirListadoHistorias {

    public AbrirFiltradoHistorias(String tipoBacklog) {
        super(tipoBacklog);
    }

    @Override
    protected JFrame createView(Backlog backlog) {
//        UserStoryFiltradoController controller = new UserStoryFiltradoController(
//                backlog);
//        
        return null;//new UserStoryFiltradoView(controller);
    }

}
