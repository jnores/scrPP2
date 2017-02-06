package pp2.scrum.command;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.Sprint;

public abstract class AbrirListadoHistorias implements Comando {
    private String mTipoBacklog;

    public AbrirListadoHistorias(String tipoBacklog) {
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
        JFrame view = createView(backlog);
        view.setTitle(mTipoBacklog);
        view.setVisible(true);
        return null;
    }

    protected abstract JFrame createView(Backlog backlog);
}
