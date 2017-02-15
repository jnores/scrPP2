package pp2.scrum.listadoHistorias;

import pp2.scrum.model.UserStory;

/**
 * @author yoshknight
 *
 */
public enum UserStoryFilter  {
    TITULO {
        @Override
        public boolean match(UserStory userStory, String busqueda) {
            return userStory.getTitulo().toLowerCase().contains(busqueda.toLowerCase());
        }

        @Override
        public String toString() {
            return "Título";
        }
    },
    DETALLE {
        @Override
        public boolean match(UserStory userStory, String busqueda) {
            return userStory.getDetalle().toLowerCase().contains(busqueda.toLowerCase());
        }
        
        @Override
        public String toString() {
            return "Detalle";
        }
    };
    
    public abstract boolean match(UserStory userStory, String busqueda);

    public static UserStoryFilter getDefault() {
        return UserStoryFilter.TITULO;
    }
    
}
