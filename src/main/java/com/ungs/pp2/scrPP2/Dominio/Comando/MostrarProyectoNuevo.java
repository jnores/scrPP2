package com.ungs.pp2.scrPP2.Dominio.Comando;

import java.security.InvalidParameterException;

import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.Dominio.Request;
import com.ungs.pp2.scrPP2.Dominio.Resultado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IComando;

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
