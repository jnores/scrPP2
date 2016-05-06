package com.ungs.pp2.scrPP2;

import java.awt.EventQueue;

import com.ungs.pp2.scrPP2.Controller.BurndownChartController;
import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.View.BurndownChartView;
import com.ungs.pp2.scrPP2.View.HomeView;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IDataComponent;

public class MainScrum {
	public static void main( String[ ] args ) {
	   EventQueue.invokeLater( new Runnable() {
         @Override
         public void run() {
            
            HomeController controller = new HomeController(null);
		
            HomeView view = new HomeView(controller);	
            view.setVisible( true );

      }});		  
	}	
}
