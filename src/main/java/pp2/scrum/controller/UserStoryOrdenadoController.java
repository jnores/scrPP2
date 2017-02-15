package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observer;

import pp2.scrum.listadoHistorias.UserStoryComparator;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.UserStory;

public class UserStoryOrdenadoController {

    private Backlog backlog;
    private List<UserStory> modeloOrdenado;
    private Comparator<UserStory> comparator;
    
    public UserStoryOrdenadoController(Backlog backlog) {
        this.backlog = backlog;
        comparator = UserStoryComparator.getDefault();
        modeloOrdenado = new ArrayList<>();
    }
    public boolean isEnabled() {
        return backlog.size()>0;
    }
    
    public void orderBy(UserStoryComparator tituloSort) {
        orderBy(tituloSort,true);
    }
        
    public void orderBy(UserStoryComparator comparator,boolean isAscendente) {
        if (isAscendente) { 
            this.comparator =  comparator;
        } else {
            this.comparator =  UserStoryComparator.decending(comparator);
        }
    }
    
    public List<UserStory> getData() {
        modeloOrdenado.clear();
        modeloOrdenado.addAll( backlog.getList() ); 
        Collections.sort(modeloOrdenado, comparator);
        return modeloOrdenado;
    }
    
    public void addObserver(Observer observer) {
        backlog.addObserver(observer);
    }

}
