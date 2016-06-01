package pp2.scrum.dominio.interfaz;

import java.awt.event.ActionListener;

import pp2.scrum.dominio.Resultado;

public interface IAppController
{

    public Resultado Execute(IComando commando, ActionListener al);
    public IMailGateway getMailGateway();
}
