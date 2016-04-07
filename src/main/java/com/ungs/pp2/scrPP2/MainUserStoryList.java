package com.ungs.pp2.scrPP2;

import com.ungs.pp2.scrPP2.Controller.ProyectoController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.Miembro;
import com.ungs.pp2.scrPP2.Dominio.Entidad.Proyecto;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.View.UserStoryListView;
import com.ungs.pp2.scrPP2.windows.UserStoryOrderableWindow;

public class MainUserStoryList {

	public static void main(String[] args) {

		//fetch student record based on his roll no from the database
		Proyecto proyecto  = retriveProyectoFromDatabase();

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
		
	}
	private static Proyecto retriveProyectoFromDatabase(){
		Proyecto proyecto;
		Miembro miembro1
			   ,miembro2
			   ;
		UserStory userStory1
				 ,userStory2
				 ,userStory3
				 ;
		miembro1 = new Miembro("Victoria","Desarrollador");
		miembro2 = new Miembro("Ivo","Diseñador");
		userStory1 =  new UserStory("Como recepcionista necesito poder registrar el ingreso de cada lote de insumos para que el mismo se valide con los pedidos realizados", "Detalle1", "Autor1");
		userStory2 =  new UserStory("Como administrador necesito poder generar un reporte de avances de cada empleado para poder analizar el desempeño de los mismos", "Detalle2", "Autor2");
		userStory3 =  new UserStory("Como gerente de finanzas necesito generar reportes de compra de insumos para evaluar el cierre de activos y pasivos a fin de cada mes", "Detalle3", "Autor3");

		userStory1.setId(1);
		userStory2.setId(2);
		userStory3.setId(3);
		
		proyecto= new Proyecto();
		proyecto.addMiembro(miembro1);
		proyecto.addMiembro(miembro2);
		
		proyecto.addUserStory(userStory1);
		proyecto.addUserStory(userStory2);
		proyecto.addUserStory(userStory3);
		
		proyecto.asignarUserStory(userStory2, miembro1);
		proyecto.asignarUserStory(userStory3, miembro2);
		
		return proyecto;
	}
}