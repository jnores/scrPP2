package pp2.mock.scrum.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pp2.scrum.calendario.Calendario;
import pp2.scrum.dao.ProyectoDAO;
import pp2.scrum.model.Backlog;
import pp2.scrum.model.CriterioAceptacion;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Miembro;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;

public class MockProyectoDAO extends ProyectoDAO {

    List<Proyecto> listaProyectos = new ArrayList<Proyecto>();

    public MockProyectoDAO() {
        listaProyectos.add(0, getProyecto());

    }

    @Override
    public List<Proyecto> getAll() {
        return listaProyectos;
    }

    @Override
    public Proyecto getById(long id) {
        return listaProyectos.get((int) id - 1);
    }

    @Override
    public long guardar(Proyecto proyecto) {
        long id = proyecto.getId();
        if (id < 1)
            id = listaProyectos.size();

        listaProyectos.add(new Proyecto(id, proyecto.getNombre(),
                proyecto.getBacklog(), proyecto.getMiembros(),
                proyecto.getIteraciones(), proyecto.getAsignaciones()));
        return id;
    }

    private Proyecto getProyecto() {
        Calendario calendario = new Calendario();
        // total 220 punto s en 21 dias
        // son poco mas de de 70 puntos por semana
        int diasTranscurridos = 7;

        List<Sprint> sprints = new ArrayList<>();
        Backlog productBacklog = new Backlog(), sprintBacklog = new Backlog();
        // -- Cargar product Backlog

        Tarea[] tareas7 = {
                new Tarea("Investigación componente de exportación a excel."),
                new Tarea("Anexar compontente a la aplicación."),
                new Tarea(
                        "Adaptar interfaz gráfica de historias de usuario para la exportación."),
                new Tarea("Testing."), new Tarea("Documentar.") };
        UserStory story7 = new UserStory(7,
                "Como Administrador necesito exportar las historias de usuario de un sprint para poder analizarlas.",
                "Se espera poder exportar la lista de historias de usuario de un sprint a diversos formatos. En una primera instancia a XLS.",
                40, new CriterioAceptacion(""), Arrays.asList(tareas7));

        Tarea[] tareas8 = {
                new Tarea("Investigar mecanismos de persistencia de datos."),
                new Tarea(
                        "agregar un mecanismo para obtener las userStoryes guardadas."),
                new Tarea("implementar la persistencia de la user story."),
                new Tarea("Testing.") };
        UserStory story8 = new UserStory(8,
                "Como Product owner necesito guardar un product backlog para que el equipo pueda planificar y desarrollar los sprints.",
                "Al momento de crear una nueva historia de usuario, la misma sera guardada de tal modo que al reiniciar la aplicacion, esta informacion estara disponible en la aplicación.",
                40, new CriterioAceptacion(""), Arrays.asList(tareas8));

        Tarea[] tareas9 = {
                new Tarea(
                        "Mecanismo para anexar el sistema de control de inputs de datos a los controles."),
                new Tarea("Documentar."), new Tarea("Testing."),
                new Tarea("Funciones para el control de inputs.") };
        UserStory story9 = new UserStory(9,
                "Como miembro del equipo de scrum, necesito contar con sugerencias, sobre como completar una user story, en particular sobre el formato común de las user stories, que pueda desactivarse o reactivarse a conveniencia, con el fin de actuar como recordatorio y reducir los errores de carga.",
                "En una primera instancia se aplicará para el alta de historias de usuario. Cuando el programador visualice la pantalla de carga de historias de usuario, el campo de texto informará al programador acerca del formato que el dato debe tener.\nEl mecanismo de control de entrada de datos se aplicará para la redacción de historias de usuario y será el siguiente;\n\"como\" ... (rol)......\"necesito\" .......(algo) ......\"con el fin de\" ...... (beneficio)",
                100, new CriterioAceptacion(""), Arrays.asList(tareas9));

        Tarea[] tareas10 = { new Tarea("Documentar."), new Tarea("Testing."),
                new Tarea(
                        "Agrupar las vistas en una sola aplicacion principal."),
                new Tarea(
                        "Crear Interfaz gráfica base para las opciones del asistente de módulos de la app."),
                new Tarea(
                        "Crear mecanismo de transición de pantallas tipo asistente."),
                new Tarea(
                        "Unificar la interfaz gráfica de los módulos para cada opción.") };
        UserStory story10 = new UserStory(10,
                "Como Administrador necesito visualizar una pantalla principal con menu, con el fin de mejorar y facilitar mi interacción con dicha aplicación.",
                "Detalle: Se va a visualizar una pantalla principal que contiene diferentes secciones o botones que refieran a los diferentes módulos del sistema: Proyectos, Product Backlog, Sprint Backlog,Burndownchart,Iteraciones.\nEl modulo Proyectos permite abrir, cerrar un proyecto, crear nuevo proyecto.",
                100, new CriterioAceptacion(""), Arrays.asList(tareas10));

        Tarea[] tareas11 = { new Tarea("implementar un Sigleton del Logger."),
                new Tarea("testear el logger."), new Tarea("Diseño.") };
        UserStory story11 = new UserStory(11,
                "Como Administrador necesito que el sistema loguee las acciones que se ejecutan para poder realizar un seguimiento de posibles conflictos.",
                "Se necesita que el sistema registre por consola (stdout) los cambios que se realizan en los datos y los estados de las entidades.",
                8, new CriterioAceptacion(""), Arrays.asList(tareas11));

        Tarea[] tareas12 = {
                new Tarea("Crear servicio externo que envia email"),
                new Tarea("Testing"),
                new Tarea(
                        "Crear interfaz a servicio externo que enviara Email"),
                new Tarea(
                        "Crear metodo que verifica el envio correcto de Email") };

        UserStory story12 = new UserStory(12,
                "Como Product Owner necesito estar notificado sobre historias finalizadas con el fin de tener controlado el avance del proyecto.",
                "El mail tiene el siguiente formato: From <remitente@mail.com> , To <productowner@mail.com>, Subject <Historia finalizada: #TituloDeHistoria>, Body <#Detalle ,#Criterios, #Autor, #Puntos >",
                40, new CriterioAceptacion(""), Arrays.asList(tareas12));

        Tarea[] tareas13 = {
                new Tarea("calcular el porcentaje de avance de un sprint."),
                new Tarea(
                        "Calcular el porcentaje de tiempo transcurrido de un sprint."),
                new Tarea(
                        "Controlar Que se genere un unico evento de retraso por sprint en cada ejecucion de la aplicacion."),
                new Tarea(
                        "Generar un evento reportando el retraso del desarrollo si el porcentaje de tiempo transcurrido del sprint superó el 50%  y el avance es menor a este porcentaje."),
                new Tarea("Documentar cambios efectuados.") };
        UserStory story13 = new UserStory(13,
                "Como Product Owner necesito que se le notifique al equipo el avance del desarrollo cuando, transcurrido la mitad del tiempo acordado, el avance sea inferior al % de tiempo transcurrido, para actuar en consecuencia.",
                "Se espera que se genere de forma automática una notificación para el equipo de desarrollo notificando el estado retrasado del proyecto solo cuando haya pasado la mitad de tiempo de una iteración y el avance sea inferior al % de tiempo transcurrido.\nEsta verificación se realizará automáticamente hasta que se reporte una demora. o se finalice el tiempo de la iteración.",
                100, new CriterioAceptacion(""), Arrays.asList(tareas13));

        Tarea[] tareas14 = {
                new Tarea(
                        "Definir el rol de un miembro al agregarlo al proyecto."),
                new Tarea(
                        "Agregar un mecanismo para cambiar el rol de un miembro luego de iniciado el proyecto."),
                new Tarea(
                        "Poder Consultar todos los miembros pertenecientes a un rol especifico."),
                new Tarea("poder consultar todos los roles disponibles."),
                new Tarea(
                        "Poder visualizar los roles de un miembro especifico."),
                new Tarea("Documentar cambios efectuados.") };

        UserStory story14 = new UserStory(14,
                "Como administrador necesito que la herramienta cuente con un sistema de gestión de roles para poder asignar obligaciones y permisos a los usuarios dependiendo del rol que ocupe en el proyecto",
                "Cuando se inicia un proyecto se podran definir los roles de quienes participan en el proyecto entre las siguientes 3 alternativas: Product owner, Team, Scrum master.\nDado que pueden existir proyectos que no tienen un product owner evidente, o que sus responsabilidades esten divididas en el equipo de desarrollo en mayor o menor medida, se podran definir varios Product Owners y scrumMasters en un proyecto.",
                100, new CriterioAceptacion(""), Arrays.asList(tareas14));

        Tarea[] tareas15 = { new Tarea("Arreglar interfaces existentes."),
                new Tarea("Documentar."), new Tarea("Testing."),
                new Tarea("Acoplar ventana de nueva user story.") };
        UserStory story15 = new UserStory(15,
                "Como Scrum Master necesito un asistente para crear un nuevo proyecto, con el fin de facilitar y agilizar el proceso de administración de dicho proyecto.",
                "Al desplezar el menu de Proyectos e ingresar a la solapa Nuevo Proyecto se despliega el asistente de creación de Proyecto. Las ventanas del asistente son del tipo modal, encadenadas una a otra mediante botones siguientes.",
                40, new CriterioAceptacion(""), Arrays.asList(tareas15));

        Tarea[] tareas16 = { new Tarea("Testing de los módulos."),
                new Tarea(
                        "Identificar tarea asociada al commit, y registrar el identificador del commit asociado a la misma."),
                new Tarea("Leer e interpretar archivo de commits."), new Tarea(
                        "Identificación de cambio de estado de la tarea asociada y actualización.") };
        UserStory story16 = new UserStory(16,
                "Como desarrollador necesito  contar con la posibilidad de vincular commits y tareas,  para obtener una manera sencilla de trazabilidad entre requerimientos e implementación.",
                "El sistema debe manejar un archivo con datos de commits, (identificador, fecha, autor y mensaje de cada commit), evaluar si el mensaje del commit cuenta con algún identificador de tarea, (#Tarea:id en formato alfanumérico), que permita vincular el commit, a alguna de las tareas registradas en el sistema y almacenar su identificador en dicha tarea. En caso de que no haya ningún indicador de a que tarea pertenece, el sistema debe ignorar el commit. Además, si al leer el mensaje, se encuentra indicado que la tarea asociada esta terminada, el sistema debe cambiar el estado de la tarea.\nDe igual manera, ya sea que se indique un estado \"Doing\" (como #Estado:string estado)o no se indique nada, se supondrá que el estado es \"Doing\" y la tarea debe reflejar dicho estado.",
                100, new CriterioAceptacion(""), Arrays.asList(tareas16));

        productBacklog.addUserStory(story7);
        productBacklog.addUserStory(story8);
        productBacklog.addUserStory(story9);
        productBacklog.addUserStory(story10);
        productBacklog.addUserStory(story11);
        productBacklog.addUserStory(story12);
        productBacklog.addUserStory(story13);
        productBacklog.addUserStory(story14);
        productBacklog.addUserStory(story15);
        productBacklog.addUserStory(story16);

        // -- Cargar Sprint Backlog

        Tarea[] tareas1 = {
                new Tarea(
                        "Crear GUI para visualizar la lista de users stories."),
                new Tarea("Configuracion Estructuras de carpetas."),
                new Tarea("Documentar."),
                new Tarea("Crear función para obtener la lista paginada."),
                new Tarea("Generar lista paginada de a 5 user story."),
                new Tarea("Realizar testing."),
                new Tarea("Ajustes pedidos de diseño.") };
        UserStory story1 = new UserStory(1,
                "Como usuario necesito visualizar de forma paginada la lista de user stories, con el fin de facilitarme su búsqueda. (Lazy Loading)",
                "Se muestran un máximo de 5 historias, las columnas de la tabla muestran los siguientes detalles de cada historia: Título, Descripción, Puntos de valor.\nEl desplazamiento por las diferentes páginas será posible hacia la siguiente y anterior, primera y última.",
                40, new CriterioAceptacion(""), Arrays.asList(tareas1));

        Tarea[] tareas2 = { new Tarea("Realizar testing."),
                new Tarea(
                        "Crear función para obtener el estado inicial de una tarea."),
                new Tarea(
                        "Crear GUI para visualizar los estados de una user story."),
                new Tarea("Crear modelo de datos."),
                new Tarea(
                        "Crear función para cambiar el estado de la user story al estado siguiente."),
                new Tarea("Documentar.") };
        UserStory story2 = new UserStory(2,
                "Como usuario necesito poder cambiar el estado de una tarea, con el fin de registrar el avance de una user story.",
                "", 40, new CriterioAceptacion(""), Arrays.asList(tareas2));

        Tarea[] tareas4 = { new Tarea("Realizar el testing."),
                new Tarea(
                        "Realizar una GUI que permita seleccionar y ver los burndown charts."),
                new Tarea(
                        "Desarrollo de los métodos para volcar los datos en un gráfico."),
                new Tarea(
                        "Realización de los métodos para recabar los puntos de historia por día."),
                new Tarea("Testing."), new Tarea("Documentar.") };
        UserStory story4 = new UserStory(4,
                "Como usuario requiero contar con burndown charts,  del Sprint o del proyecto, que reflejen, una estimación de los puntos de historia a realizar por día; los puntos de historia realizados hasta el momento; o la comparación entre estos dos gráficos; con el fin de evaluar visualmente el avance dentro de ese periodo.",
                "El usuario podrá seleccionar por medio de un menú, el período, es decir, si toma la duración de una iteración en particular o el proyecto entero; y el tipo de gráfico: estimado, de puntos de historia concretados, o comparativo. Los gráficos reflejarán puntos de historia en función del tiempo.",
                100, new CriterioAceptacion(""), Arrays.asList(tareas4));

        Tarea[] tareas5 = {
                new Tarea("Filtrar la lista de user stories por responsable."),
                new Tarea(
                        "Filtrar la lista de user stories por titulo con un textbox y un boton."),
                new Tarea("Filtrar por responsable y por titulo."),
                new Tarea("Testing."), new Tarea("Documentar.") };
        UserStory story5 = new UserStory(5,
                "Como usuario necesito poder filtrar el listado de user stories para mejorar el análisis y facilitar el seguimiento del proyecto.",
                "El filtrado se realiza mediante un campo de texto donde el usuario ingresa una palabra o parte de una frase y se aplica la búsqueda según el criterio elegido para el filtro (por historia, descripción o criterio) y, tambien, por responsable.",
                20, new CriterioAceptacion(""), Arrays.asList(tareas5));

        Tarea[] tareas6 = { new Tarea("Crear vista para una user story."),
                new Tarea(
                        "Crear vista scrolleable para lista de 3 user stories."),
                new Tarea(
                        "ordenar la lista scrollable por titulo con un boton."),
                new Tarea("diseñar."), new Tarea("Testing."), new Tarea(
                        "agregar mecanismo de generación de opciones de ordenamiento.") };
        UserStory story6 = new UserStory(6,
                "Como usuario necesito poder ordenar el listado de user stories para facilitar la gestion del proyecto.",
                "El ordenamiento se aplica por columna siempre que estén definidas para que sean ordenables (nro de historia,historia,esfuerzo estimado, valor de negocio y estado) de manera ascendente o descendente.",
                20, new CriterioAceptacion(""), Arrays.asList(tareas6));
        sprintBacklog.addUserStory(story1); // 40
        sprintBacklog.addUserStory(story2); // 40
        sprintBacklog.addUserStory(story4); // 100
        sprintBacklog.addUserStory(story5); // 20
        sprintBacklog.addUserStory(story6); // 20

        // -- Calculo fechas para simular
        Date today = calendario.getToday();
        Date inicioSprint = calendario.agregarDias(today,
                -diasTranscurridos);

        // -- Cargo la pizarra de estados y el registro de ultimo cambio.
        Map<Tarea, Date> logUltimoCambio = new HashMap<>();
        Map<Tarea, Estado> pizarraEstados = new HashMap<>();

        Estado estadoAux = Estado.getDefault();
        for (UserStory us : sprintBacklog.getList())
            for (Tarea t : us.getTareas())
                pizarraEstados.put(t, estadoAux);

        Date fechaAux;
        int i, j = 1;
        for (Tarea t : tareas2) {
            fechaAux = calendario.agregarDias(inicioSprint, j++);
            System.out.println("T2 : " + fechaAux);
            
            logUltimoCambio.put(t, fechaAux);
            pizarraEstados.put(t, Estado.Done);
        }
        i = 1;
        j = 1;
        fechaAux = calendario.agregarDias(inicioSprint, j++);
        for (Tarea t : tareas6) {
            System.out.println("T6 : " + fechaAux);

            logUltimoCambio.put(t, fechaAux);
            pizarraEstados.put(t, Estado.Done);
            if (i%4 == 0)
                fechaAux = calendario.agregarDias(inicioSprint, j++);
            i++;
        }
        i = 1;
        j = 3;
        fechaAux = calendario.agregarDias(inicioSprint, j++);
        for (Tarea t : tareas5) {
            System.out.println("T5 : " + fechaAux);

            logUltimoCambio.put(t, fechaAux);
            pizarraEstados.put(t, Estado.Done);
            if (i % 4 == 0) 
                fechaAux = calendario.agregarDias(inicioSprint, j++);
            i++;
        }
        // -- Creo y Cargo Sprint

        sprints.add(new Sprint(1, inicioSprint, 21, sprintBacklog,
                pizarraEstados, logUltimoCambio));
        Set<Miembro> miembros = new HashSet<>();
        miembros.add(new Miembro("Ivo"));
        miembros.add(new Miembro("Nores"));
        miembros.add(new Miembro("Roger"));
        miembros.add(new Miembro("Victoria"));

        return new Proyecto(1, "Test 1", productBacklog, miembros, sprints);
    }

}
