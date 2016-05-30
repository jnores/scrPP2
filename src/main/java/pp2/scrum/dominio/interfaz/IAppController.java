package pp2.scrum.dominio.interfaz;

import java.awt.event.ActionListener;

import pp2.scrum.dominio.Resultado;

public interface IAppController
{

    Resultado Execute(IComando commando, ActionListener al);
}
