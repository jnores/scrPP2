package com.ungs.pp2.scrPP2;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.View.HomeView;

import org.pushingpixels.substance.api.skin.SubstanceChallengerDeepLookAndFeel;
/*SubstanceBusinessBlackSteelLookAndFeel;SubstanceBusinessLookAndFeel;
 * SubstanceChallengerDeepLookAndFeel;SubstanceDustCoffeeLookAndFeel;
 * SubstanceDustLookAndFeel;SubstanceEmeraldDuskLookAndFeel;
 * SubstanceGeminiLookAndFeel;SubstanceGraphiteAquaLookAndFeel;
 * SubstanceGraphiteGlassLookAndFeel;SubstanceMagellanLookAndFeel;
 * SubstanceMistSilverLookAndFeel;SubstanceSaharaLookAndFeel;*/

import com.ungs.pp2.scrPP2.utils.Logger;

public class MainScrum {
	public static void main( String[ ] args ) {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SubstanceChallengerDeepLookAndFeel());
				} catch (Exception e) {
					JFrame.setDefaultLookAndFeelDecorated(false);
				}
			}
		});

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
	}}

