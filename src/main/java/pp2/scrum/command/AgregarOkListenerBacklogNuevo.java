package pp2.scrum.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;

public class AgregarOkListenerBacklogNuevo implements Comando
{

    @Override
    public Resultado Execute(final HomeController homeController, ActionListener al) {
        Resultado resultado = new Resultado();
        try 
        {
            homeController.getBacklogNuevo().addokButtonListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    homeController.getBacklogNuevo().setVisible(false);
                }
            });
        }
        catch(Exception e)
        {
            resultado.AgregarError("Error", e.getMessage());
        };
        return resultado;
    }

}
