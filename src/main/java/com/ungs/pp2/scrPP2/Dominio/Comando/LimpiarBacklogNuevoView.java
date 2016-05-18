package com.ungs.pp2.scrPP2.Dominio.Comando;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.Dominio.Request;
import com.ungs.pp2.scrPP2.Dominio.Resultado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IComando;

public class LimpiarBacklogNuevoView implements IComando<HomeController>
{

   public Resultado Execute(final HomeController homeController)
   {
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

@Override
public void configurar(Request request) throws InvalidParameterException {
	// TODO Auto-generated method stub
	
}


}
