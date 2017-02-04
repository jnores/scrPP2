package pp2.scrum.calendario;

import java.text.ParseException;
import java.util.Date;

import pp2.scrum.servicios.Service;

public abstract class CalendarioService extends Service {
    public static final String SERVICE_NAME = "calendario";

    public static final long DAY = 86400000;

    public CalendarioService() {
        super(SERVICE_NAME);
    }

    public abstract Date getFechaIntermedia(Date inicio, Date fin);

    public abstract int getDuracion(Date inicio, Date fin);

    public abstract Date agregarDias(Date inicio, long dias);

    public abstract Date getDate(String string) throws ParseException;

    public abstract Date getToday();

}