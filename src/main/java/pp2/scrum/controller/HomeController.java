package pp2.scrum.controller;


import java.awt.event.ActionListener;

import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.entidad.AppController;
import pp2.scrum.dominio.entidad.Comando;
import pp2.scrum.dominio.entidad.MailGateway;
import pp2.scrum.dominio.entidad.Proyecto;
import pp2.scrum.view.BacklogNuevoView;
import pp2.scrum.view.ProyectoNuevoView;

public class HomeController extends Controller implements AppController
{
    private ProyectoNuevoView proyectoNuevo;
    private BacklogNuevoView backlogNuevo;
    private ProyectoController proyectoController;


    public HomeController(MailGateway mailGateway)
    {	
        super( mailGateway);
        proyectoController = new ProyectoController( new Proyecto(),mailGateway);
        proyectoNuevo = new ProyectoNuevoView(proyectoController);
        backlogNuevo = new BacklogNuevoView(proyectoController);
    }

    @Override    
    public Resultado Execute(Comando commando,ActionListener al)
    {
        return commando.Execute(this,al);
    }

    public ProyectoNuevoView getProyectoNuevo()
    {
        return proyectoNuevo;
    }

    public void setProyectoNuevo(ProyectoNuevoView proyectoNuevo)
    {
        this.proyectoNuevo = proyectoNuevo;
    }

    public BacklogNuevoView getBacklogNuevo()
    {
        return backlogNuevo;
    }

    public void setBacklogNuevo(BacklogNuevoView backlogNuevo)
    {
        this.backlogNuevo = backlogNuevo;
    }
    public ProyectoController getProyectoController()
    {
        return proyectoController;
    }
    @Override
    public MailGateway getMailGateway()
    {
        return mailGateway;
    }
}
