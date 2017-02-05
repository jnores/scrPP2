package pp2.scrum.command;

import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;

public class MostrarProyectoNuevo implements Comando {

    @Override
    public Resultado Execute(final HomeController homeController,
            ActionListener al) {
        Resultado resultado = new Resultado();
        try {
            
        } catch (Exception e) {
            resultado.AgregarError("Error", e.getMessage());
        }
        ;
        return resultado;
    }

}
