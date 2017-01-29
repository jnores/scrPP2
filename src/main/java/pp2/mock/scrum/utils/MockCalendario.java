package pp2.mock.scrum.utils;

import java.util.Date;

import pp2.scrm.calendario.Calendario;

public class MockCalendario extends Calendario {
    Date fecha;
    public MockCalendario() {
        super();
        fecha = new Date();
    }
    public void setFecha(Date newFecha) {
        this.fecha = newFecha;
    }
    
    @Override
    public Date getToday() {
       return this.fecha;
    }
}