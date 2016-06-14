package pp2.scrum.dominio.comando;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.entidad.Comando;

public class LimpiarBacklogNuevoView implements Comando<HomeController>
{


    @Override
    public Resultado Execute(final HomeController homeController, ActionListener al) {
        Resultado resultado = new Resultado();
        try 
        {
            homeController.getBacklogNuevo().addcancelBtnListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    homeController.getBacklogNuevo().setVisible(false);
                    homeController.getProyectoNuevo().limpiarPantalla();
                    homeController.getBacklogNuevo().limpiarPantalla();
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
