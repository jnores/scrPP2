package pp2.scrum.dominio.comando;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.interfaz.IComando;

public class AgregarSiguienteListenerProyectoNuevo implements IComando<HomeController>
{

   public Resultado Execute(final HomeController homeController)
   {
      Resultado resultado = new Resultado();
      try 
      {
         homeController.getProyectoNuevo().addsiguienteBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               homeController.getProyectoNuevo().setVisible(false);
               homeController.getBacklogNuevo().setVisible(true);
            }
         });
      }
      catch(Exception e)
      {
         resultado.AgregarError("Error", e.getMessage());
      };
      return resultado;
   }

@Override
public Resultado Execute(HomeController homeController, ActionListener al) {
    // TODO Auto-generated method stub
    return null;
}


}
