package com.ungs.pp2.scrPP2;

import com.ungs.pp2.scrPP2.Controller.CustomerController;
import com.ungs.pp2.scrPP2.Controller.UserStoryController;
import com.ungs.pp2.scrPP2.Dominio.Dto.StudentDto;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.View.CustomerView;
import com.ungs.pp2.scrPP2.View.UserStoryView;

public class MainUserStory {

	public static void main(String[] args) {

		//fetch student record based on his roll no from the database
		UserStory story  = retriveStudentFromDatabase();

		//Create a view : to write student details on console
		

		//Creo el controlador y le envío el modelo 
		UserStoryController controller = new UserStoryController(null, story);
		
		//La vista recibe el controlador
		UserStoryView view = new UserStoryView(controller);
		
		//Agrego la vista que es un observador del modelo 
		story.addObserver(view);
		
		//Seteo un cliente por defecto al modelo
		//customerModel.setCustomer(ctm);
		//Muestro la ventana
		view.showWindow(true);
		
	}
	private static UserStory retriveStudentFromDatabase(){
		UserStory story = new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null);
		return story;
	}
}