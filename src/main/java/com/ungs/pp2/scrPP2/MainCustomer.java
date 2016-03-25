package com.ungs.pp2.scrPP2;

import com.ungs.pp2.scrPP2.Controller.CustomerController;
import com.ungs.pp2.scrPP2.Dominio.Entidad.Customer;
import com.ungs.pp2.scrPP2.View.CustomerView;

public class MainCustomer 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Inicializo el modelo
				Customer customer= new Customer("PEPE SRL","00-00000000-0");
						
				//Creo el controlador y le envío el modelo 
				CustomerController customerController = new CustomerController(null, customer);
				
				//La vista recibe el controlador
				CustomerView view = new CustomerView(customerController);
				
				//Agrego la vista que es un observador del modelo 
				customer.addObserver(view);
				
				//Seteo un cliente por defecto al modelo
				//customerModel.setCustomer(ctm);
				//Muestro la ventana
				view.showWindow(true);

	}

}
