package pp2.scrum.command;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;
import pp2.scrum.view.AltaUserStoryView;

public class AbrirCrearHistoria implements Comando {

    /*
     * (non-Javadoc)
     * 
     * @see
     * pp2.scrum.command.Comando#Execute(pp2.scrum.controller.HomeController,
     * java.awt.event.ActionListener)
     */
    @Override
    public Resultado Execute(HomeController homeController, ActionListener al) {

        JFrame view = new AltaUserStoryView(
                homeController.getProyectoController());
        view.setVisible(true);
        return null;
    }
}
