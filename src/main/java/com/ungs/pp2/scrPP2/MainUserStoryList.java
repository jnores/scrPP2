package com.ungs.pp2.scrPP2;

import java.io.IOException;

import com.ungs.pp2.scrPP2.Controller.ProyectoController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.Miembro;
import com.ungs.pp2.scrPP2.Dominio.Entidad.Proyecto;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.View.UserStoryListView;
import com.ungs.pp2.scrPP2.textUtils.TextUserStoryMapper;
import com.ungs.pp2.scrPP2.windows.UserStoryOrderableWindow;

public class MainUserStoryList {

	public static void main(String[] args) {

		//fetch student record based on his roll no from the database
		Proyecto proyecto;
		try {
			proyecto = retriveProyectoFromDatabase();
		
			//Create a view : to write student details on console
			UserStoryOrderableWindow userStoryWindow;
	
			//Creo el controlador y le envío el modelo 
			ProyectoController controller = new ProyectoController(null, proyecto);
			
			//La vista recibe el controlador
			UserStoryListView view = new UserStoryListView(controller.getAllUserStories());
			//Agrego la vista que es un observador del modelo 
			
			//Seteo un cliente por defecto al modelo
			//customerModel.setCustomer(ctm);
			//Muestro la ventana
			userStoryWindow = new UserStoryOrderableWindow(view);
			userStoryWindow.showWindow(true);
		} catch (RuntimeException | IOException e) {
			// e.printStackTrace();
		}

		
	}
	private static Proyecto retriveProyectoFromDatabase() throws RuntimeException, IOException{
		Proyecto proyecto;

		Miembro miembro1
		   ,miembro2
		   ,miembro3
		   ,miembro4
		   ;
		UserStory userStory1
				 ,userStory2
				 ,userStory3
				 ,userStory4
				 ;
		miembro1 = new Miembro("Victoria");
		miembro2 = new Miembro("Ivo");
		miembro3 = new Miembro("Jualian");
		miembro4 = new Miembro("Nores");
		
		userStory1 =  new UserStory("Como Recepcionista ...", "Detalle1", "Autor1");
		userStory1.setId(1);
		userStory1.setEstado(Estado.Done);
		userStory2 =  new UserStory("Como Administrador ...", "Detalle2", "Autor2");
		userStory2.setId(2);
		userStory2.setEstado(Estado.Doing);
		userStory3 =  new UserStory("Como Gerente ...", "Detalle3", "Autor3");
		userStory3.setId(3);
		userStory3.setEstado(Estado.ToDo);
		userStory4 =  new UserStory("Como Vendedor ...", "Detalle4", "Autor4");
		userStory4.setId(4);
		userStory4.setEstado(Estado.ToDo);
		
		proyecto= new Proyecto(new TextUserStoryMapper() );
		proyecto.addMiembro(miembro1);
		proyecto.addMiembro(miembro2);
		proyecto.addMiembro(miembro3);
		proyecto.addMiembro(miembro4);
		
		proyecto.addUserStory(userStory1);
		proyecto.addUserStory(userStory2);
		proyecto.addUserStory(userStory3);
		proyecto.addUserStory(userStory4);
		
		proyecto.asignarUserStory(userStory3, miembro2);
		proyecto.asignarUserStory(userStory2, miembro1);
		proyecto.asignarUserStory(userStory4, miembro4);
		proyecto.asignarUserStory(userStory1, miembro3);
		
		return proyecto;
	}
}