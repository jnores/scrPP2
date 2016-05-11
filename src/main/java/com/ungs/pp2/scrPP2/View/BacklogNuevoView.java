package com.ungs.pp2.scrPP2.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.ungs.pp2.scrPP2.Consulta.Consulta;
import com.ungs.pp2.scrPP2.Controller.ProyectoController;
import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;

import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class BacklogNuevoView extends JDialog
{
   private UserStoryPaginadoView backlogPanel;
   private ProyectoController controller;
   private JButton okButton,cancelButton;
   /**
    * Create the dialog.
    */
   public BacklogNuevoView(ProyectoController controller)
   {
      this.controller = controller;
      this.backlogPanel = new UserStoryPaginadoView(new UserStoryPaginadoController(new Consulta()));
      setTitle("Backlog Nuevo");
      setBounds(100, 100, 450, 300);
      getContentPane().setLayout(new BorderLayout());
      setLocationRelativeTo(null);
      getContentPane().add(backlogPanel, BorderLayout.CENTER);
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);    
      okButton = new JButton("OK");
      okButton.setActionCommand("OK");
      buttonPane.add(okButton);
      getRootPane().setDefaultButton(okButton);
      cancelButton = new JButton("Cancel");
      cancelButton.setActionCommand("Cancel");
      buttonPane.add(cancelButton);
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
      backlogPanel = new UserStoryPaginadoView(new UserStoryPaginadoController(new Consulta()));
      getContentPane().remove(0);
      getContentPane().add(backlogPanel,BorderLayout.CENTER,0);
      setearVista();
   }

}
