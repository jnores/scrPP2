package com.ungs.pp2.scrPP2;

import java.util.ArrayList;
import java.util.List;

import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.View.UserStoryPaginadoView;

public class MainUserPaginadoStory {

	public static void main(String[] args) {

		//fetch student record based on his roll no from the database
		List<UserStory> stories  = retriveStudentFromDatabase();

		//Create a view : to write student details on console
		

		//Creo el controlador y le envío el modelo 
		UserStoryPaginadoController controller = new UserStoryPaginadoController(null, stories);
		
		//La vista recibe el controlador
		UserStoryPaginadoView view = new UserStoryPaginadoView(controller);
		
		//Agrego la vista que es un observador del modelo
		for (UserStory story : stories)
		{
		   story.addObserver(view);
		}
		
		//Seteo un cliente por defecto al modelo
		//customerModel.setCustomer(ctm);
		//Muestro la ventana
		view.showWindow(true);
		
	}
	private static List<UserStory> retriveStudentFromDatabase(){
	   
	   List<UserStory> stories = new ArrayList<UserStory>();
		stories.add(new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null));
		stories.add(new UserStory("Titulo2", "Detalle2", "Autor2", "Responsable2", 10, 40, 1, Estado.ToDo, null, null));
		stories.add(new UserStory("Titulo3", "Detalle3", "Autor3", "Responsable3", 10, 40, 1, Estado.ToDo, null, null));
		stories.add(new UserStory("Titulo4", "Detalle4", "Autor4", "Responsable4", 10, 40, 1, Estado.ToDo, null, null));
		return stories;
	}
}