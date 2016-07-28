package pp2.scrum.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.UtilDateModel;
import pp2.scrum.controller.ProyectoController;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.UserStory;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;

public class HistoriaNuevaView extends JDialog
{
   private BacklogNuevoView padre;
   private AltaUserStoryView panel;
   //private JButton okButton,cancelButton,addStory;
   /**
    * Create the dialog.
    */
   public HistoriaNuevaView(AltaUserStoryView panel,BacklogNuevoView padre)
   {
      super(padre,true);
      setResizable(false);
      this.panel = panel;
      this.padre = padre;
      setTitle("Historia Nueva");
      setBounds(100, 100, 548, 495);
      getContentPane().setLayout(new BorderLayout());
      setLocationRelativeTo(null);
      getContentPane().add(panel, BorderLayout.CENTER);
   }
   
   private void setearVista()
   {
      SwingUtilities.updateComponentTreeUI(this);
   }
   
   public void showWindow(boolean esVisible) {
      setVisible(esVisible);
   }
   
   public void addHistoria(){
	   padre.addHistoria();
   }
   
   public void limpiarPantalla()
   {
//      backlogPanel = new UserStoryPaginadoView(new UserStoryPaginadoController(),new ArrayList<UserStory>() );
//      getContentPane().remove(0);
//      getContentPane().add(backlogPanel,BorderLayout.CENTER,0);
//      setearVista();
   }

}
