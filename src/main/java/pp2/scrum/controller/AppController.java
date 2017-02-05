package pp2.scrum.controller;

import java.awt.event.ActionListener;

import pp2.scrum.command.Comando;

public interface AppController {

    public Resultado Execute(Comando commando, ActionListener al);

    public String getApplicationName();

    public void closeApp();
}
