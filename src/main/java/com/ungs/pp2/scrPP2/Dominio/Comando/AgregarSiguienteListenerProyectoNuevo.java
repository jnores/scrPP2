package com.ungs.pp2.scrPP2.Dominio.Comando;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.Dominio.Resultado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IComando;

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

}
