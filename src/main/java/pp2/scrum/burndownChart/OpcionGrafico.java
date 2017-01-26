package pp2.scrum.burndownChart;

public enum OpcionGrafico {
    Estimado {
        @Override
        public Graficador getGraficador() {
            return new GraficoEstimado();
        }
    },
    Avance {
        @Override
        public Graficador getGraficador() {
            return new GraficoAvance();
        }
//    ESTETIPO SE COMPONE EN LA VISTA: NO EN EL CONTROL!!    
    },
    Comparativo {
        @Override
        public Graficador getGraficador() {
            // TODO Auto-generated method stub
            return null;
        }
    };

    abstract public Graficador getGraficador();
}
