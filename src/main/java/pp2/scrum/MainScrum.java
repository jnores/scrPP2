package pp2.scrum;

import java.awt.EventQueue;

import pp2.scrum.consulta.EnviadorMail;
import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.interfaz.IMailGateway;
import pp2.scrum.utils.Logger;
import pp2.scrum.view.HomeView;

public class MainScrum {
	public static void main( String[ ] args ) {

//		JFrame.setDefaultLookAndFeelDecorated(true);
//		JDialog.setDefaultLookAndFeelDecorated(true);
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				try {
////					TODO comente esta linea porque esta generando un exceso de informacion 
////					y rompio  la integracion continnua al generar un archivo de log mayr a 4M
////					Averiguar como deshabilitarlo para las pruebas o como deshabilitarle el log de errores. 
//					UIManager.setLookAndFeel(new SubstanceChallengerDeepLookAndFeel());
//				} catch (Exception e) {
//					JFrame.setDefaultLookAndFeelDecorated(false);
//				}
//			}
//		});

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
				
				//Creo la dependencia al iniciar la aplicacion una sola vez
				IMailGateway mailGateway = new EnviadorMail(4444,"127.0.0.1", "pp2mailsender", "mailmail", 15);
				
				HomeController controller = new HomeController(null,mailGateway);

				HomeView view = new HomeView(controller);	
				view.setVisible( true );


			}});
	}}

