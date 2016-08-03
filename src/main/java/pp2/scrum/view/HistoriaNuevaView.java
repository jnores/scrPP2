package pp2.scrum.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class HistoriaNuevaView extends JDialog
{
   private BacklogNuevoView padre;
   private AltaUserStoryView panel;
   //private JButton okButton,cancelButton,addStory;
   /**
    * Create the dialog.
    */
   public HistoriaNuevaView(BacklogNuevoView padre)
   {
      super(padre,true);
      setResizable(false);
//      this.panel = new AltaUserStoryView(new UserStoryController(null), padre);
      this.padre = padre;
      setTitle("Historia Nueva");
      setBounds(100, 100, 548, 495);
      getContentPane().setLayout(new BorderLayout());
      setLocationRelativeTo(null);
      //panel.getli
//      getContentPane().add(panel, BorderLayout.CENTER);
   }
   
   private void setearVista()
   {
      SwingUtilities.updateComponentTreeUI(this);
   }
   
   public void showWindow(boolean esVisible) {
      setVisible(esVisible);
   }
   
   public void limpiarPantalla()
   {
//      backlogPanel = new UserStoryPaginadoView(new UserStoryPaginadoController(),new ArrayList<UserStory>() );
//      getContentPane().remove(0);
//      getContentPane().add(backlogPanel,BorderLayout.CENTER,0);
//      setearVista();
   }

}
