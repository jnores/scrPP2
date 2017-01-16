package pp2.scrum.controller;

import java.util.Collections;
import java.util.List;

import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryComparator;
import pp2.scrum.view.ListaUserStoryView;

public class UserStoryOrdenadoController {

    private List<UserStory> modelo;
    private ListaUserStoryView vista;
    public UserStoryOrdenadoController(List<UserStory> modelo,
            ListaUserStoryView vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        actualizarVista();
    }
    public boolean isEnabled() {
        return modelo != null && modelo.size()>0;
    }
    public void ordenarPor(UserStoryComparator tituloSort) {
        ordenarPor(tituloSort,true);
    }
        
    public void ordenarPor(UserStoryComparator comparator,boolean isAscendente) {
        if (isAscendente) {
            Collections.sort(modelo, comparator);
        } else {
            Collections.sort(modelo, UserStoryComparator.decending(comparator));
        }
        
        actualizarVista();
    }
    private void actualizarVista() {
        if (vista != null) {
            vista.actualizarModel(modelo);
        }
    }
    
    

}
