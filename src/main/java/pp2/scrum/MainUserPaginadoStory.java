package pp2.scrum;

import pp2.scrum.consulta.Consulta;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.view.UserStoryPaginadoView;

public class MainUserPaginadoStory

{
      public static void main(String[] args) {

		//Creo el controlador y le envío el modelo
		UserStoryPaginadoController controller = new UserStoryPaginadoController(new Consulta(),null);
		
		//La vista recibe el controlador
		UserStoryPaginadoView view = new UserStoryPaginadoView(controller);

      //Muestro la ventana
		view.showWindow(true);
	}
}