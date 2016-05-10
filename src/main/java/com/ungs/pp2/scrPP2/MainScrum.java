package com.ungs.pp2.scrPP2;

import java.awt.EventQueue;

import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.View.HomeView;
import com.ungs.pp2.scrPP2.utils.Logger;

public class MainScrum {
	public static void main( String[ ] args ) {
	   EventQueue.invokeLater( new Runnable() {
         @Override
         public void run() {
        	
//			try {
//				OutputStream f = new FileOutputStream("/tmp/scrumMGR.log",true);
//				Logger.setOutStream(f);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
        	Logger.init();
            HomeController controller = new HomeController(null);
		
            HomeView view = new HomeView(controller);	
            view.setVisible( true );

      }});		  
	}	
}
