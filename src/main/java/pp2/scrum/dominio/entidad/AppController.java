package pp2.scrum.dominio.entidad;

import java.awt.event.ActionListener;

import pp2.scrum.dominio.Resultado;

public interface AppController
{

    public Resultado Execute(Comando commando, ActionListener al);
    public MailGateway getMailGateway();
}
