package pp2.scrum.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import pp2.scrum.command.AgregarOkListenerBacklogNuevo;
import pp2.scrum.command.AgregarSiguienteListenerProyectoNuevo;
import pp2.scrum.command.LimpiarBacklogNuevoView;
import pp2.scrum.command.LimpiarProyectoNuevoView;
import pp2.scrum.command.MostrarProyectoNuevo;
import pp2.scrum.controller.AppController;
import pp2.scrum.logger.Logger;
import pp2.scrum.view.events.ViewUpdateEvent;

public class HomeView extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel panel_Top;
    private AppController appController;
    private BurndownChartView burndownChartViewpanel;
    private UserStoryPaginadoView listadoPaginadoHistorias;
    private UserStoryOrderableView filtradoHistorias;
    private JMenuBar menuBar;
    private JMenu menuP, mnIteraciones, mnSprint, mnBacklog, mnBurnDownChart;
    private JMenuItem mnListadoHistoriasItem, mnBurndownItem, mnFiltradoItem,
            mnNuevoProyectoItem, mnNuevaUserStory, mntmAbrirProyecto, mntmCerrarProyecto;

    public HomeView(AppController controller) {
        
        this.appController = controller;
        getContentPane().setLayout(new BorderLayout());

        setTitle("Sistema para gestionar proyectos de SCRUM");
        this.setJMenuBar(cargarMenu());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Logger.log("Cerrando Aplicación");
            }
        });
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        // getContentPane().setLayout(new BorderLayout(0, 0));

        panel_Top = new JPanel();
        panel_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
        getContentPane().add(panel_Top, BorderLayout.NORTH);
        // panel_Top.setLayout(new BorderLayout(0, 0));

        JLabel lblProyecto = new JLabel(controller.getApplicationName());
        panel_Top.add(lblProyecto);

//        int lblNumero;
//        JLabel lblIteracion;
//        if (!ServiceRegistry.getInstance().hasService("calendario"))
//            throw new RuntimeException(
//                    "El servicio Calendario no fue inicializado.");
//
//        Calendario calendario = (Calendario) ServiceRegistry.getInstance()
//                .getService("calendario");
//        try {
//            Sprint sp = proyecto.iteracionActual();
//            lblNumero = sp.getIdIteracion();
//            lblIteracion = new JLabel("Iteración "
//                    + "(" + sp.getfechaInicio() + " - " + calendario
//                            .agregarDias(sp.getfechaInicio(), sp.getDuracion())
//                    + ")");
//        } catch (Exception e) {
//            lblNumero = 1;
//            lblIteracion = new JLabel("Iteración");
//        }

//        JLabel lblNumeroIteracion = new JLabel(String.valueOf(lblNumero));
//        panel_Top.add(lblNumeroIteracion);

//        panel_Top.add(lblIteracion);

        // panel_Main = new JPanel();
        // panel_Main.setLayout(new BorderLayout());

//        burndownChartViewpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
//        getContentPane().add(burndownChartViewpanel, BorderLayout.CENTER);

        // burndownChartViewpanel.setVisible(true);
        /*
         * panel_Main.add(burndownChartViewpanel); panel_Main.setBorder(new
         * LineBorder(new Color(0, 0, 0))); panel_Main.setBounds(0, 21, 584,
         * 319);
         */

        mnListadoHistoriasItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarListadoPaginadoHistorias();
                setearVista();
            }
        });

        mnBurndownItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarBurndownChart();
                setearVista();
            }
        });

        mnFiltradoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarFiltradoHistorias();
                setearVista();
            }
        });

        mnNuevaUserStory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // AppController.Execute(new MostrarAgregarHistoria(),
                // thisFrame);
                // MostrarUserStoryUpload();
                // setearVista();
            }
        });
    }

    // Menu donde se selecciona el tipo de chart
    private JMenuBar cargarMenu() {

        menuBar = new JMenuBar();
        menuP = new JMenu("Proyectos");
        mnIteraciones = new JMenu("Iteraciones");

        // menuP.add(menu1=new JMenuItem("Avance"));
        // menuP.add(menu2=new JMenuItem("Estimado"));
        // menuP.add(menu3=new JMenuItem("Comparativo"));

//        mnIteraciones.add(mnit1item = new JMenuItem("Primera"));
//        mnIteraciones.add(mnit2item = new JMenuItem("Segunda"));
//        mnIteraciones.add(mnit3item = new JMenuItem("Tercera"));

        menuBar.add(menuP);

        mnNuevoProyectoItem = new JMenuItem("Nuevo Proyecto");
        mnNuevoProyectoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appController.Execute(new MostrarProyectoNuevo(), this);
            }
        });

        appController.Execute(new AgregarOkListenerBacklogNuevo(), this);
        appController.Execute(new AgregarSiguienteListenerProyectoNuevo(),
                this);
        appController.Execute(new LimpiarProyectoNuevoView(), this);
        appController.Execute(new LimpiarBacklogNuevoView(), this);

        menuP.add(mnNuevoProyectoItem);

        mntmAbrirProyecto = new JMenuItem("Abrir Proyecto");
        mntmAbrirProyecto.setEnabled(false);
        menuP.add(mntmAbrirProyecto);

        mntmCerrarProyecto = new JMenuItem("Cerrar Proyecto");
        mntmCerrarProyecto.setEnabled(false);
        menuP.add(mntmCerrarProyecto);

        mnBacklog = new JMenu("Product Backlog");
        menuBar.add(mnBacklog);

        mnSprint = new JMenu("Sprint Backlog");
        menuBar.add(mnSprint);

        mnListadoHistoriasItem = new JMenuItem("Listado");
        mnSprint.add(mnListadoHistoriasItem);

        mnFiltradoItem = new JMenuItem("Filtrado");
        mnSprint.add(mnFiltradoItem);

        mnBurnDownChart = new JMenu("Burndown Chart");
        menuBar.add(mnBurnDownChart);

        mnBurndownItem = new JMenuItem("Gráfico");
        mnBurnDownChart.add(mnBurndownItem);
        menuBar.add(mnIteraciones);

        mnNuevaUserStory = new JMenuItem("Nueva historia");
        mnBacklog.add(mnNuevaUserStory);
        return menuBar;
    }

    private void MostrarListadoPaginadoHistorias() {
        getContentPane().remove(1);
        getContentPane().add(listadoPaginadoHistorias, BorderLayout.CENTER);
    }

    private void MostrarBurndownChart() {
        getContentPane().remove(1);
        burndownChartViewpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        getContentPane().add(burndownChartViewpanel, BorderLayout.CENTER);
    }

    private void MostrarFiltradoHistorias() {
        getContentPane().remove(1);
        // burndownChartViewpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        getContentPane().add(filtradoHistorias, BorderLayout.CENTER);
    }

    private void setearVista(JPanel panel, boolean conScroll) {
        getContentPane().remove(1);
        if (conScroll) {
            JScrollPane scroll = new JScrollPane(panel);
            scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            getContentPane().add(scroll, BorderLayout.CENTER);
        } else {
            getContentPane().add(panel, BorderLayout.CENTER);
        }

        SwingUtilities.updateComponentTreeUI(this);
    }

    private void setearVista() {
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void showWindow(boolean esVisible) {
        setVisible(esVisible);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e instanceof ViewUpdateEvent) {
            setearVista((JPanel) e.getSource(), true);
        }
        setearVista();

    }

}