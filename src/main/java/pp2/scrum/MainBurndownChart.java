package pp2.scrum;

import pp2.scrum.controller.BurndownChartController;
import pp2.scrum.dominio.interfaz.IDataComponent;
import pp2.scrum.view.BurndownChartView;

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
