package pp2.scrum.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.UserStory;

public class UserStoryPaginadoView extends JFrame implements Observer {
    /**
     * default serial version
     */
    private static final long serialVersionUID = 1L;
    private UserStoryPaginadoController controller;
    private JTable table;
    private JPanel panel;
    private Object[][] data;
    private JLabel PageNumberLabel;
    private TableModel modelTabla;
    private JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;

    public UserStoryPaginadoView(UserStoryPaginadoController controller) {

        this.controller = controller;
        this.controller.addObserver(this);

        setSize(600, 300);

        btnPrimero = new JButton("");
        btnAnterior = new JButton("");
        btnSiguiente = new JButton("");
        btnUltimo = new JButton("");

        cargarVista();
    }

    private void cargarVista() {
        table = new JTable();
        panel = new JPanel();
        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);

        this.add(panel, BorderLayout.SOUTH);

        ClassLoader classloader = Thread.currentThread()
                .getContextClassLoader();

        ImageIcon primero = new ImageIcon(
                classloader.getResource("images/Primero.png"));
        btnPrimero.setIcon(primero);
        btnPrimero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obtenerPaginaPrimera();
            }
        });
        panel.add(btnPrimero);

        btnAnterior.setIcon(
                new ImageIcon(classloader.getResource("images/Anterior.png")));
        btnAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obtenerPaginaAnterior();
            }
        });
        panel.add(btnAnterior);

        PageNumberLabel = new JLabel(controller.toString());
        panel.add(PageNumberLabel);

        btnSiguiente.setIcon(
                new ImageIcon(classloader.getResource("images/Siguiente.png")));

        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obtenerPaginaSiguiente();
            }
        });
        panel.add(btnSiguiente);

        btnUltimo.setIcon(
                new ImageIcon(classloader.getResource("images/Ultimo.png")));
        btnUltimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obtenerPaginaUltima();
            }
        });
        panel.add(btnUltimo);

        setearVista();
    }

    @Override
    public void update(Observable o, Object arg) {
        controller.actualizarPaginacion();
        setearVista();
    }

    private void setearVista() {
        List<UserStory> stories = controller.obtenerPaginacionActual();

        PageNumberLabel.setText(controller.toString());

        actualizarBotones();
        
        if (stories.size() == 0) {
            data = new Object[][] { { "No hay Historias" } };
        } else {
            data = new Object[stories.size()][];
            int i = 0;
            for (UserStory story : stories) {
                Object[] fila = { story.getTitulo(), story.getDetalle(),
                        story.getStoryPoints() };
                data[i] = fila;
                i++;
                story.addObserver(this);
            }
        }

        String[] columnNames = { "Titulo", "Descripcion", "Puntos" };

        modelTabla = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                // No editable
                return false;
            }
        };
        
        table.setModel(modelTabla);

        revalidate();
        repaint();
    }

    private void actualizarBotones() {
        habilitarAtras(false);
        habilitarAdelante(false);

        if (controller.isEnabled()) {
            if (controller.hasPrev()) {
                habilitarAtras(true);
            }

            if (controller.hasNext()) {
                habilitarAdelante(true);
            }
        }
    }

    private void habilitarAdelante(boolean bool) {
        btnUltimo.setEnabled(bool);
        btnSiguiente.setEnabled(bool);
    }

    private void habilitarAtras(boolean bool) {
        btnPrimero.setEnabled(bool);
        btnAnterior.setEnabled(bool);
    }

    private void obtenerPaginaAnterior() {
        controller.obtenerPaginacionAnterior();
        setearVista();

    }

    private void obtenerPaginaSiguiente() {
        controller.obtenerPaginacionSiguiente();
        setearVista();
    }

    private void obtenerPaginaPrimera() {
        controller.obtenerPaginacionPrimera();
        setearVista();
    }

    private void obtenerPaginaUltima() {
        controller.obtenerPaginacionUltima();
        setearVista();
    }

    public void limpiarLista() {
        controller.actualizarPaginacion(new ArrayList<UserStory>());
        setearVista();
    }
}