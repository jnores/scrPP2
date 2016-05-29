package pp2.scrum.logCommit;

import java.util.ArrayList;

import junit.framework.TestCase;
import pp2.scrum.dominio.entidad.Tarea;
import pp2.scrum.logCommits.VinculadorCommitsTarea;

public class VinculadorCommitsTareaTest extends TestCase {

    public VinculadorCommitsTareaTest(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    public final void testVinculadorCommitsTarea() {
        ArrayList<Tarea> tareas=new ArrayList<Tarea> ();
        for(int i=1; i<10;i++){
            Tarea tarea=new Tarea();
            tarea.setId(i);
            tareas.add(tarea);
        }
        VinculadorCommitsTarea vinculos=new VinculadorCommitsTarea(tareas,"src/main/resources/file/GitLog.txt");
        for(Tarea t:tareas)
            System.out.println(t.getEstado()+" => "+ (t.getCommits().isEmpty()?"-":t.getCommits().get(0)));
    }

}
