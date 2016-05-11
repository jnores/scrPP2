package com.ungs.pp2.scrPP2;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.View.HomeView;

import org.pushingpixels.substance.api.skin.SubstanceAutumnLookAndFeel;
/*SubstanceBusinessBlackSteelLookAndFeel;SubstanceBusinessLookAndFeel;
 * SubstanceChallengerDeepLookAndFeel;SubstanceDustCoffeeLookAndFeel;
 * SubstanceDustLookAndFeel;SubstanceEmeraldDuskLookAndFeel;
 * SubstanceGeminiLookAndFeel;SubstanceGraphiteAquaLookAndFeel;
 * SubstanceGraphiteGlassLookAndFeel;SubstanceMagellanLookAndFeel;
 * SubstanceMistSilverLookAndFeel;SubstanceSaharaLookAndFeel;*/

public class MainScrum {
	public static void main( String[ ] args ) {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());
				} catch (Exception e) {
					JFrame.setDefaultLookAndFeelDecorated(false);
				}
			}
		});

		EventQueue.invokeLater( new Runnable() {
			@Override
			public void run() {

				HomeController controller = new HomeController(null);

				HomeView view = new HomeView(controller);	
				view.setVisible( true );

			}});		  
	}	
}

