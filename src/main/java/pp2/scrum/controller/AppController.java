package pp2.scrum.controller;

import java.awt.event.ActionListener;

import pp2.scrum.command.Comando;

public interface AppController {

    @SuppressWarnings("rawtypes")
    public Resultado Execute(Comando commando, ActionListener al);
}
