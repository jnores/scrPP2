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
import pp2.scrum.controller.UserStoryController;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.UserStory;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import java.awt.event.ActionEvent;

public class BacklogNuevoView extends JDialog
{
   private UserStoryPaginadoView backlogPanel;
   private ProyectoController controller;
   private HistoriaNuevaView dialogoHistoria;
   private JButton okButton,cancelButton,addStory;
   /**
    * Create the dialog.
    */
   public BacklogNuevoView(ProyectoController controller,UserStoryPaginadoView model)
   {
      this.controller = controller;
      this.backlogPanel = model;
      setTitle("Backlog Nuevo");
      setBounds(100, 100, 450, 300);
      getContentPane().setLayout(new BorderLayout());
      setLocationRelativeTo(null);
      getContentPane().add(backlogPanel, BorderLayout.CENTER);
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);  
      addStory = new JButton("Agregar Historia");
      addStory.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dialogoHistoria.showWindow(true);
         }
      });
      okButton = new JButton("OK");
      okButton.setActionCommand("OK");
      buttonPane.add(addStory);
      buttonPane.add(okButton);
      getRootPane().setDefaultButton(okButton);
      cancelButton = new JButton("Cancel");
      cancelButton.setActionCommand("Cancel");
      buttonPane.add(cancelButton);
      dialogoHistoria = new HistoriaNuevaView(new AltaUserStoryView(new UserStoryController(null)), this);
      dialogoHistoria.pack();
   }
   public void addokButtonListener(ActionListener listener) {
      okButton.addActionListener(listener);
   }
   
   public void addcancelBtnListener(ActionListener listener) {
      cancelButton.addActionListener(listener);
   }   
   
   private void setearVista()
   {
      SwingUtilities.updateComponentTreeUI(this);
   }
   
   public void limpiarPantalla()
   {
      backlogPanel = new UserStoryPaginadoView(new UserStoryPaginadoController(),new ArrayList<UserStory>() );
      getContentPane().remove(0);
      getContentPane().add(backlogPanel,BorderLayout.CENTER,0);
      setearVista();
   }

}
