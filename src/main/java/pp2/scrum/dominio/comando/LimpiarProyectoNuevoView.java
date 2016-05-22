package pp2.scrum.dominio.comando;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.Request;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.interfaz.IComando;

public class LimpiarProyectoNuevoView implements IComando<HomeController>
{

   public Resultado Execute(final HomeController homeController)
   {
      Resultado resultado = new Resultado();
      try 
      {
         homeController.getProyectoNuevo().addcancelBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               homeController.getProyectoNuevo().setVisible(false);
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

   @Override
   public void configurar(Request request) throws InvalidParameterException {
   	// TODO Auto-generated method stub
   	
   }

}
