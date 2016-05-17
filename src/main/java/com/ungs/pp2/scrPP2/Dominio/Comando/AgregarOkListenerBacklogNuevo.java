package com.ungs.pp2.scrPP2.Dominio.Comando;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.Dominio.Request;
import com.ungs.pp2.scrPP2.Dominio.Resultado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IComando;

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

@Override
public void configurar(Request request) throws InvalidParameterException {
	// TODO Auto-generated method stub
	
}

@Override
public Resultado execute(HomeController TipoController) {
	// TODO Auto-generated method stub
	return null;
}
}
