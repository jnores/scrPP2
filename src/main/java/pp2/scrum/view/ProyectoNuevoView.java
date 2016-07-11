package pp2.scrum.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import pp2.scrum.controller.ProyectoController;
import pp2.scrum.model.Miembro;
import net.sourceforge.jdatepicker.DateModel;
import javax.swing.SpringLayout;
import java.awt.Dialog.ModalityType;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProyectoNuevoView extends JDialog
{
   private ProyectoController controller;
   private final JPanel contentPanel = new JPanel();
   private JTextField titulo;
   private JDatePickerImpl datePickerInicio,datePickerFin;
   private JComboBox<Miembro> comboLider;
   private JButton siguientebtn, cancelButton;

   /**
    * Launch the application.
    */

   /**
    * Create the dialog.
    */
   public ProyectoNuevoView(ProyectoController controller)
   {
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      setModalityType(ModalityType.APPLICATION_MODAL);
      this.controller = controller;
      setTitle("Nuevo Proyecto");
      setBounds(100, 100, 450, 300);
      setLocationRelativeTo(null);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
      
      JLabel lblNombreDelProyecto = new JLabel("Nombre del Proyecto:");
      lblNombreDelProyecto.setBounds(10, 11, 134, 14);
      contentPanel.add(lblNombreDelProyecto);
      
      titulo = new JTextField();
      titulo.setBounds(148, 8, 134, 20);
      contentPanel.add(titulo);
      titulo.setColumns(10);
      
      
      UtilDateModel model=new UtilDateModel();
      JDatePanelImpl datePanel = new JDatePanelImpl(model);    
      datePickerInicio = new JDatePickerImpl(datePanel);
      datePickerInicio.setBounds(135, 39, 200, 29);
      contentPanel.add(datePickerInicio);
      
      UtilDateModel model2=new UtilDateModel();
      JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
      datePickerFin = new JDatePickerImpl(datePanel2);
      datePickerFin.setBounds(135, 83, 200, 29);
      contentPanel.add(datePickerFin);
      
      JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
      lblFechaInicio.setBounds(10, 36, 78, 32);
      contentPanel.add(lblFechaInicio);
      
      JLabel lblFechaFin = new JLabel("Fecha Fin:");
      lblFechaFin.setBounds(10, 83, 78, 29);
      contentPanel.add(lblFechaFin);
      
      JLabel lblLiderResponsable = new JLabel("Lider / Responsable");
      lblLiderResponsable.setBounds(10, 133, 113, 20);
      contentPanel.add(lblLiderResponsable);
      
      comboLider = new JComboBox<Miembro>();
      comboLider.setBounds(135, 133, 176, 20);
      comboLider.addItem(new Miembro("Jose"));
      comboLider.addItem(new Miembro("Ivo"));
      contentPanel.add(comboLider);
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      siguientebtn = new JButton("Siguiente");
      siguientebtn.setActionCommand("OK");
      buttonPane.add(siguientebtn);
      cancelButton = new JButton("Cancel");
      cancelButton.setActionCommand("Cancel");
      buttonPane.add(cancelButton);
   }
   
   public void addsiguienteBtnListener(ActionListener listener) {
      siguientebtn.addActionListener(listener);
   }
   
   public void addcancelBtnListener(ActionListener listener) {
      cancelButton.addActionListener(listener);
   }
   
   public void limpiarPantalla()
   {
      titulo.setText("");
      ((UtilDateModel)datePickerInicio.getModel()).setValue(null);
      ((UtilDateModel)datePickerFin.getModel()).setValue(null);  
   }
}
