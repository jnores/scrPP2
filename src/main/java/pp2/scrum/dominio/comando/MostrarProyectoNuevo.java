package pp2.scrum.dominio.comando;

import java.security.InvalidParameterException;

import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.Request;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.interfaz.IComando;

public class MostrarProyectoNuevo implements IComando<HomeController>
{

   public Resultado Execute(HomeController homeController)
   {
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

@Override
public void configurar(Request request) throws InvalidParameterException {
	// TODO Auto-generated method stub
	
}

}
