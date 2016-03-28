package com.ungs.pp2.scrPP2;

import com.ungs.pp2.scrPP2.Controller.UserStoryController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.View.UserStoryView;
import com.ungs.pp2.scrPP2.windows.UserStoryWindow;

public class MainUserStory {

	public static void main(String[] args) {

		//fetch student record based on his roll no from the database
		UserStory story  = retriveUserStoryFromDatabase();

		//Create a view : to write student details on console
		UserStoryWindow userStoryWindow;

		//Creo el controlador y le envío el modelo 
		UserStoryController controller = new UserStoryController(null, story);
		
		//La vista recibe el controlador
		UserStoryView view = new UserStoryView(controller.getUserStoryHelper());
		
		//Agrego la vista que es un observador del modelo 
		story.addObserver(view);
		
		//Seteo un cliente por defecto al modelo
		//customerModel.setCustomer(ctm);
		//Muestro la ventana
		userStoryWindow = new UserStoryWindow(view);
		userStoryWindow.showWindow(true);
		
		// Simulo una modificacion externa, pasados 2 segundos de iniciado el sistema
		// espero 2 segundos
		//try {
		//    Thread.sleep(2000);                 //en milisegundos
		//} catch(InterruptedException ex) {
		//    Thread.currentThread().interrupt();
		//}
		//story.setAutor("Veronica");
		
	}
	private static UserStory retriveUserStoryFromDatabase(){
		UserStory story = new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null);
		return story;
	}
}