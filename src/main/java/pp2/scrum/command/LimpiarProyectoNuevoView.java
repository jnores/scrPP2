package pp2.scrum.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;

public class LimpiarProyectoNuevoView implements Comando {

    @Override
    public Resultado Execute(final HomeController homeController,
            ActionListener al) {
        Resultado resultado = new Resultado();
        try {
            homeController.getProyectoNuevo()
                    .addcancelBtnListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            homeController.getProyectoNuevo().setVisible(false);
                            homeController.getProyectoNuevo().limpiarPantalla();
                            homeController.getBacklogNuevo().limpiarPantalla();
                        }
                    });
        } catch (Exception e) {
            resultado.AgregarError("Error", e.getMessage());
        }
        ;
        return resultado;
    }

}
