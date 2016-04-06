package com.ungs.pp2.scrPP2;

import java.util.ArrayList;
import java.util.List;

import com.ungs.pp2.scrPP2.Consulta.Consulta;
import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.View.UserStoryPaginadoView;

public class MainUserPaginadoStory

{
      public static void main(String[] args) {

		//Creo el controlador y le envío el modelo
		UserStoryPaginadoController controller = new UserStoryPaginadoController(new Consulta());
		
		//La vista recibe el controlador
		UserStoryPaginadoView view = new UserStoryPaginadoView(controller);

      //Muestro la ventana
		view.showWindow(true);
	}
}