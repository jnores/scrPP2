package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import pp2.scrum.model.Backlog;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryFilter;

public class UserStoryFiltradoController {

    private Backlog backlog;
    private List<UserStory> modeloFiltrado;
    
    UserStoryFilter filtro;
    String txtBusqueda;
    boolean isContenido;
    
    public UserStoryFiltradoController(Backlog backlog) {
        this.backlog = backlog;
        this.modeloFiltrado = new ArrayList<>();
        
        filtro = UserStoryFilter.getDefault();
        txtBusqueda = "";
        isContenido = true;
    }
    public boolean isEnabled() {
        return backlog.size()>0;
    }
    public void filterBy(UserStoryFilter filtro,String busqueda) {
        filterBy(filtro,busqueda,true);
    }
        
    public void filterBy(UserStoryFilter filtro,String busqueda,boolean isContenido) {
        this.filtro = filtro;
        this.txtBusqueda = busqueda;
        this.isContenido = isContenido;
        
    }

    public List<UserStory> getData() {
        modeloFiltrado.clear();
        for ( UserStory us : backlog.getList() ) {
            if (isContenido == filtro.match(us,txtBusqueda)) {
                modeloFiltrado.add(us);
            }
        }
        return modeloFiltrado;
    }
    
    public void addObserver(Observer observer) {
        backlog.addObserver(observer);
    }
    

}
