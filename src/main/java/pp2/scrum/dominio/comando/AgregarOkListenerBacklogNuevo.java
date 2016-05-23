package pp2.scrum.dominio.comando;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.interfaz.IComando;

public class AgregarOkListenerBacklogNuevo implements IComando<HomeController>
{

   public Resultado Execute(final HomeController homeController)
   {
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
