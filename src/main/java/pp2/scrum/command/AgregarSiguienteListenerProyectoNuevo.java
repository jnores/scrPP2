package pp2.scrum.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;

public class AgregarSiguienteListenerProyectoNuevo implements Comando {

    @Override
    public Resultado Execute(final HomeController homeController,
            ActionListener al) {
        //
        Resultado resultado = new Resultado();
        try {
            homeController.getProyectoNuevo()
                    .addsiguienteBtnListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            homeController.getProyectoNuevo().setVisible(false);
                            homeController.getBacklogNuevo().setVisible(true);
                        }
                    });
        } catch (Exception e) {
            resultado.AgregarError("Error", e.getMessage());
        }
        ;
        return resultado;
    }

}
