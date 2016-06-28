package pp2.scrum.command;

import java.awt.event.ActionListener;

import pp2.scrum.controller.Resultado;

public interface Comando<T>
{

    Resultado Execute(final T homeController, ActionListener al);

}
