package pp2.scrum.servicios;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.consulta.EnviadorMail;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.entidad.Mail;

public class EnviadorMailTest extends TestCase
{

//private NotificadorMail notificador;
   //mail:pp2mailsender
   //pass:mailmail
private int port;
private int timeOut;
private String host;
private String senderMail;
private String senderPass;
private EnviadorMail enviador;
private Mail mail;


public EnviadorMailTest( String testName )
{
    super( testName );
}

public static Test suite()
{
    return new TestSuite( EnviadorMailTest.class );
}

public void  setUp()
{
	host = "127.0.0.1";
    port = 4444;
    senderMail = "pp2mailsender";
    senderPass = "mail"; //Pass: mailmail
    timeOut = 0 ;
    enviador = new EnviadorMail(port, host, senderMail, senderPass, timeOut);
}


public void testEnvioMail()
{
	Resultado resultado;
	mail = new Mail("julian.dirisio@gmail.com", "Titulo mail 1", "Este mail es de prueba PP2");
	resultado = enviador.enviar(mail);
}
public void testWorker()
{

}
}