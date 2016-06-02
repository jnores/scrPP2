package pp2.scrum.dominio.comando;

import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.interfaz.Comando;

public class MostrarProyectoNuevo implements Comando<HomeController>
{

    @Override
    public Resultado Execute(final HomeController homeController, ActionListener al) {
        Resultado resultado = new Resultado();
        try 
        {
            homeController.getProyectoNuevo().setVisible(true);
        }
        catch(Exception e)
        {
            resultado.AgregarError("Error", e.getMessage());
        };
        return resultado;
    }

}
