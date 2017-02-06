package pp2.scrum.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import pp2.scrum.command.AbrirPaginadoHistorias;
import pp2.scrum.command.MostrarBurnDownChart;
import pp2.scrum.controller.AppController;
import pp2.scrum.view.events.ViewUpdateEvent;

public class HomeView extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private HomeView mThis = this;
    private JPanel panel_Top;
    private AppController appController;

    public HomeView(AppController controller) {

        this.appController = controller;
        getContentPane().setLayout(new BorderLayout());

        setTitle("Sistema para gestionar proyectos de SCRUM");
        this.setJMenuBar(createMenu());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                appController.closeApp();
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
        
        appController.Execute(new MostrarBurnDownChart(), mThis);
    }

    // Menu donde se selecciona el tipo de chart
    private JMenuBar createMenu() {
        // -- Se crea la barra de menus
        JMenuBar menuBar = new JMenuBar();

        // -- MENU

        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setMnemonic('A');
        menuBar.add(menuArchivo);

        JMenu menuProyecto = new JMenu("Proyecto");
        menuProyecto.setMnemonic('P');
        menuBar.add(menuProyecto);

        JMenu menuSprint = new JMenu("Sprint");
        menuSprint.setMnemonic('S');
        menuBar.add(menuSprint);

        JMenu menuHelp = new JMenu("Help");
        menuHelp.setMnemonic('H');
        menuBar.add(menuHelp);

        // -- /MENU

        // -- ARCHIVO

        JMenuItem menuItemNuevoProyecto = new JMenuItem("Nuevo Proyecto");
        menuItemNuevoProyecto.setEnabled(false);
        menuArchivo.add(menuItemNuevoProyecto);

        JMenuItem menuItemAbrirProyecto = new JMenuItem("Abrir Proyecto");
        menuItemAbrirProyecto.setEnabled(false);
        menuArchivo.add(menuItemAbrirProyecto);

        JMenuItem menuItemCerrarProyecto = new JMenuItem("Cerrar Proyecto");
        menuItemCerrarProyecto.setEnabled(false);
        menuArchivo.add(menuItemCerrarProyecto);

        menuArchivo.addSeparator();
        JMenuItem menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mThis.dispatchEvent(
                        new WindowEvent(mThis, WindowEvent.WINDOW_CLOSING));
            }
        });
        menuArchivo.add(menuItemSalir);
        
        // -- /ARCHIVO

        // -- PROYECTO
        
        JMenuItem menuItemNuevaHistoria = new JMenuItem("Agregar historia");
        menuProyecto.add(menuItemNuevaHistoria);

        // -- PRODUCT BACKLOG

        JMenu subMenuProductBacklog = new JMenu("Product Backlog");
        menuProyecto.add(subMenuProductBacklog);

        JMenuItem MenuItemPaginadoHistorias = new JMenuItem("Paginado");
        MenuItemPaginadoHistorias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // appController.Execute(new AbrirPaginadoHistorias(), mThis);
            }
        });
        subMenuProductBacklog.add(MenuItemPaginadoHistorias);

        JMenuItem menuItemFiltradoHistoras = new JMenuItem("Filtrado");
        menuItemFiltradoHistoras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // appController.Execute(new AbrirFiltradoHistorias(), mThis);
            }
        });
        subMenuProductBacklog.add(menuItemFiltradoHistoras);

        JMenuItem menuItemOrdenadoHistoras = new JMenuItem("Ordenado");
        menuItemOrdenadoHistoras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // appController.Execute(new AbrirFiltradoHistorias(), mThis);
            }
        });
        subMenuProductBacklog.add(menuItemOrdenadoHistoras);

        // -- /PRODUCT BACKLOG
        
        JMenuItem menuItemMiembros = new JMenuItem("Miembros");
        menuProyecto.add(menuItemMiembros);
        
        JMenuItem menuItemDetalles = new JMenuItem("Detalles");
        menuProyecto.add(menuItemDetalles);

        // -- /PROYECTO

        // -- SPRINT
        // -- SPRINT BACKLOG
        
        JMenu subMenuSprintBacklog = new JMenu("Sprint Backlog");
        menuSprint.add(subMenuSprintBacklog);

        JMenuItem MenuItemSprintPaginadoHistorias = new JMenuItem("Paginado");
        MenuItemSprintPaginadoHistorias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appController.Execute(new AbrirPaginadoHistorias("Sprint Backlog"), mThis);
            }
        });
        subMenuSprintBacklog.add(MenuItemSprintPaginadoHistorias);

        JMenuItem menuItemSprintFiltradoHistoras = new JMenuItem("Filtrado");
        menuItemSprintFiltradoHistoras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                 appController.Execute(new AbrirFiltradoHistorias(appController.getProductBacklog()), mThis);
            }
        });
        subMenuSprintBacklog.add(menuItemSprintFiltradoHistoras);

        JMenuItem menuItemSprintOrdenadoHistoras = new JMenuItem("Ordenado");
        menuItemSprintOrdenadoHistoras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                 appController.Execute(new AbrirFiltradoHistorias(), mThis);
            }
        });
        subMenuSprintBacklog.add(menuItemSprintOrdenadoHistoras);
        
        // -- /SPRINT BACKLOG

        JMenuItem menuItemBurndownChart = new JMenuItem("Gráficos");
        menuItemBurndownChart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 appController.Execute(new MostrarBurnDownChart(), mThis);
            }
        });
        menuSprint.add(menuItemBurndownChart);

        JMenuItem menuItemPizarra = new JMenuItem("Pizarra");
        menuItemPizarra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                 appController.Execute(new MostrarPizarra(), mThis);
            }
        });
        menuSprint.add(menuItemPizarra);
        
        // -- /SPRINT

        // -- HELP
        JMenuItem subMenuAcercaDe = new JMenuItem("Acerca de...");
        menuHelp.add(subMenuAcercaDe);
        // -- /HELP

        return menuBar;
    }

    private void setearVista(JPanel panel, boolean conScroll) {
        if ( getContentPane().getComponentCount() > 1 )
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

        SwingUtilities.updateComponentTreeUI(mThis);
    }

    private void setearVista() {
        SwingUtilities.updateComponentTreeUI(mThis);
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