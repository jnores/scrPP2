package pp2.scrum.dominio.interfaz;

import java.awt.event.ActionListener;

import pp2.scrum.dominio.Resultado;

public interface IComando<T>
{
    Resultado Execute(T TipoController);

    Resultado Execute(T homeController, ActionListener al);

}
