package pp2.scrum.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.controller.Mail;
import pp2.scrum.notificadorCambios.EnviadorMail;

public class EnviadorMailTest extends TestCase {

    // private NotificadorMail notificador;
    // mail:pp2mailsender
    // pass:mailmail
    private int port;
    private int timeOut;
    private String host;
    private String senderMail;
    private String senderPass;
    private EnviadorMail enviador;
    private Mail mail;

    public EnviadorMailTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(EnviadorMailTest.class);
    }

    public void setUp() {
        host = "127.0.0.1";
        port = 4444;
        senderMail = "pp2mailsender";
        senderPass = "mail"; // Pass: mailmail
        timeOut = 0;
        enviador = new EnviadorMail(port, host, senderMail, senderPass,
                timeOut);
    }

    public void testEnvioMail() {
        String destino = "julian.dirisio@gmail.com", tema = "Titulo mail 1",
                cuerpo = "Este mail es de prueba PP2";
        mail = new Mail(destino, tema, cuerpo);
        assertTrue(mail.getDestinoMail().equals(destino));
        assertTrue(mail.getTema().equals(tema));
        assertTrue(mail.getCuerpo().equals(cuerpo));
        enviador.enviar(mail);
    }

    public void testWorker() {

    }
}