package pp2.scrum.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import pp2.scrum.controller.UserStoryFiltradoController;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryFilter;

public class UserStoryFiltradoView extends JFrame implements Observer {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private UserStoryFiltradoController controller;
    private JComboBox<UserStoryFilter> cmbOpciones;
    private JToggleButton tglbtnAscdesc;
    private JButton btnOrdenar;
    private JTextArea txtBusqueda;
    // private JComboBox<Exporter> cmbTipoExport;
    private JPanel listaUserStories;

    /**
     * Create the frame.
     */
    public UserStoryFiltradoView(
            UserStoryFiltradoController usFiltradoController) {
        this.controller = usFiltradoController;
        controller.addObserver(this);

        setSize(600,300);

        listaUserStories = new JPanel();
        listaUserStories
                .setLayout(new BoxLayout(listaUserStories, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        this.getContentPane().add(panel, BorderLayout.NORTH);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        cmbOpciones = new JComboBox<UserStoryFilter>();
        cmbOpciones.setModel(new DefaultComboBoxModel<UserStoryFilter>(
                UserStoryFilter.values()));
        panel.add(cmbOpciones);
        txtBusqueda = new JTextArea("Busqueda: ");
        panel.add(txtBusqueda);

        tglbtnAscdesc = new JToggleButton("Contiene");
        tglbtnAscdesc.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                if (tglbtnAscdesc.isSelected()) {
                    tglbtnAscdesc.setText("No Contiene");
                } else {
                    tglbtnAscdesc.setText("Contiene");
                }

            }
        });
        tglbtnAscdesc.setSelected(false);
        panel.add(tglbtnAscdesc);

        btnOrdenar = new JButton("Filtrar");
        btnOrdenar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.filterBy(
                        cmbOpciones.getItemAt(cmbOpciones.getSelectedIndex()),
                        txtBusqueda.getText(), tglbtnAscdesc.isSelected());
                cargarLista();
            }
        });
        panel.add(btnOrdenar);

        verificarControles();

        JScrollPane scrollPane = new JScrollPane(listaUserStories);
        // scrollPane.setBounds(5, 5, 380, 160);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 350, 160);
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.validate();
        cargarLista();
    }

    private void verificarControles() {
        boolean controlsEnabled = controller.isEnabled();
        
        cmbOpciones.setEnabled(controlsEnabled);
        tglbtnAscdesc.setEnabled(controlsEnabled);
        btnOrdenar.setEnabled(controlsEnabled);
        txtBusqueda.setEnabled(controlsEnabled);
    }

    private void cargarLista() {
        List<UserStory> stories = controller.getData();
        int width = 0, height = 0;

        listaUserStories.removeAll();
        for (UserStory story : stories) {
            UserStoryView usv = new UserStoryView(story);
            width = (int) usv.getBounds().getWidth();
            height += (int) usv.getBounds().getHeight();

            listaUserStories.add(usv, -1);
        }
        listaUserStories.setPreferredSize(new Dimension(width, height));
        listaUserStories.setMaximumSize(new Dimension(width, height));

        listaUserStories.revalidate();
        listaUserStories.repaint();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        verificarControles();
        cargarLista();
    }
}
