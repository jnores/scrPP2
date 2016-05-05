package com.ungs.pp2.scrPP2;

import com.ungs.pp2.scrPP2.Controller.BurndownChartController;
import com.ungs.pp2.scrPP2.View.BurndownChartView;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IDataComponent;

public class MainBurndownChart {
	public static void main( String[ ] args ) {

		IDataComponent data=null;
		
		//Supongo que siguiendo el patrón de lo que han hecho... debería mandar un modelo XD
		BurndownChartController controller = new BurndownChartController(null, data);
		
		//La vista recibe el controlador o algo 
		BurndownChartView view = new BurndownChartView(controller);
		
		//view.showWindow(true);
		
	}	


}
