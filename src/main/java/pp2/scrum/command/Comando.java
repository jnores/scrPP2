package pp2.scrum.command;

import java.awt.event.ActionListener;

import pp2.scrum.controller.HomeController;
import pp2.scrum.controller.Resultado;

public interface Comando
{

    Resultado Execute(final HomeController homeController, ActionListener al);

}
