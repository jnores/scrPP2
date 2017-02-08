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
import pp2.scrum.utils.Paginacion;

public class UserStoryPaginadoView extends JFrame implements Observer
{
    /**
     * default serial version
     */
    private static final long serialVersionUID = 1L;
    private UserStoryPaginadoController Controller;
    private JTable table;
    private JPanel panel;
    private Object[][] data;
    private JLabel PageNumberLabel;
    private List<UserStory> Stories;
    private TableModel modelTabla;
    private JButton  btnPrimero,btnAnterior,btnSiguiente,btnUltimo ;

    public UserStoryPaginadoView(UserStoryPaginadoController controller ) 
    {

        Controller = controller;
        
        setSize(600,300);

        btnPrimero = new JButton("");
        btnAnterior = new JButton("");
        btnSiguiente = new JButton("");
        btnUltimo = new JButton("");

        Stories = controller.getModel();
        cargarVista();

        btnAnterior.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
                obtenerPaginaAnterior();
            } 
        });
        btnSiguiente.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
                obtenerPaginaSiguiente();
            } 
        });
        btnPrimero.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
                obtenerPaginaPrimera();
            } 
        });
        btnUltimo.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
                obtenerPaginaUltima();
            } 
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        setearVista();
    }

    private void setearVista()
    {
        habilitarBotones(false);
        if (Stories.size() == 0)
        {
            data = new Object[][] {{"No hay Historias"}} ;
            PageNumberLabel = new JLabel(" - ");      
        }
        else 
        {              
            data = new Object[Stories.size()][] ;
            int i = 0;
            for (UserStory story : Stories)
            {
                Object[] fila = {story.getTitulo(), story.getDetalle(),story.getStoryPoints()};
                data[i] = fila;
                i++;
                story.addObserver(this);
            }    
            PageNumberLabel = new JLabel(Controller.getPaginacionActual().getPagina()+ " / " + Controller.getPaginasTotales());
            if (Controller.getPaginasTotales() > 1){
                habilitarBotones(true);
                if (Controller.getPaginacionActual().getPagina() == 1){
                    habilitarAtras(false);
                }
                if (Controller.getPaginacionActual().getPagina() == Controller.getPaginasTotales()){
                    habilitarAdelante(false);
                }
            }
        }

        String[] columnNames = {"Titulo", "Descripcion","Puntos"};

        modelTabla = new DefaultTableModel(data, columnNames){

            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                //No editable
                return false;
            }
        };
        try{
            JTable s = (JTable) this.getComponent(1);
            s.setModel(modelTabla);

            JPanel p = (JPanel) this.getComponent(2);
            JLabel l = (JLabel) p.getComponent(3);
            l.setText(PageNumberLabel.getText());
        }
        catch( Exception e){

        }

        this.revalidate();
        this.repaint();
    }
    
    private void cargarVista()
    {
        setearVista();
        table = new JTable(modelTabla);
        panel = new JPanel();
        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);


        this.add(panel, BorderLayout.SOUTH);

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();


        ImageIcon primero = new ImageIcon(classloader.getResource("images/Primero.png"));
        btnPrimero.setIcon(primero);
        panel.add(btnPrimero);


        btnAnterior.setIcon(new ImageIcon(classloader.getResource("images/Anterior.png")));
        panel.add(btnAnterior);


        panel.add(PageNumberLabel);


        btnSiguiente.setIcon(new ImageIcon(classloader.getResource("images/Siguiente.png")));
        panel.add(btnSiguiente);


        btnUltimo.setIcon(new ImageIcon(classloader.getResource("images/Ultimo.png")));
        panel.add(btnUltimo);

    }

    private void habilitarBotones(boolean bool)
    {
        btnPrimero.setEnabled(bool);
        btnUltimo.setEnabled(bool);
        btnSiguiente.setEnabled(bool);
        btnAnterior.setEnabled(bool);
    }

    private void habilitarAdelante(boolean bool)
    {
        btnUltimo.setEnabled(bool);
        btnSiguiente.setEnabled(bool);
    }

    private void habilitarAtras(boolean bool)
    {
        btnPrimero.setEnabled(bool);
        btnAnterior.setEnabled(bool);
    }

    private void obtenerPaginaAnterior()
    {
        Paginacion<UserStory> actual = Controller.getPaginacionActual();
        if (actual.getPagina() != 1)
        {
            Stories = Controller.obtenerPaginacionAnterior();
            setearVista();
        }
    }

    private void obtenerPaginaSiguiente()
    {
        Paginacion<UserStory> actual = Controller.getPaginacionActual();
        if (actual.getPagina() != Controller.getPaginasTotales())
        {
            Stories = Controller.obtenerPaginacionSiguiente();
            setearVista();
        }
    }

    private void obtenerPaginaPrimera()
    {
        Paginacion<UserStory> actual = Controller.getPaginacionActual();
        if (actual.getPagina() != 1)
        {
            Stories = Controller.obtenerPaginacionPrimera();
            setearVista();
        }
    }

    private void obtenerPaginaUltima()
    {
        Paginacion<UserStory> actual = Controller.getPaginacionActual();
        if (actual.getPagina() != Controller.getPaginasTotales())
        {
            Stories = Controller.obtenerPaginacionUltima();
            setearVista();
        }      
    }
    
    public void limpiarLista()
    {
        Controller.actualizarPaginacion(new ArrayList<UserStory>());
        setearVista();
    }
}