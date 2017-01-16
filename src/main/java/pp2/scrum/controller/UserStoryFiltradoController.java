package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.List;

import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryFilter;
import pp2.scrum.view.ListaUserStoryView;

public class UserStoryFiltradoController {

    private List<UserStory> modelo;
    private List<UserStory> modeloFiltrado;
    private ListaUserStoryView vista;
    public UserStoryFiltradoController(List<UserStory> modelo,
            ListaUserStoryView vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.modeloFiltrado = new ArrayList<>();
        this.modeloFiltrado.addAll(modelo);
        actualizarVista();
    }
    public boolean isEnabled() {
        return modelo != null && modelo.size()>0;
    }
    public void filtrarPor(UserStoryFilter filtro,String busqueda) {
        filtrarPor(filtro,busqueda,true);
    }
        
    public void filtrarPor(UserStoryFilter filtro,String busqueda,boolean isContenido) {
        modeloFiltrado.clear();
        for(UserStory us : modelo) {
            if (isContenido == filtro.match(us,busqueda)) {
                modeloFiltrado.add(us);
            }
        }
        
        actualizarVista();
    }
    private void actualizarVista() {
        if (vista != null) {
            vista.actualizarModelo(modeloFiltrado);
        }
    }
    
    

}
