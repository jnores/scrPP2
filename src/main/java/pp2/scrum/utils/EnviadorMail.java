package pp2.scrum.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import pp2.scrum.controller.Mail;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.Resultado;

/**
 * @author rub
 *
 */
public class EnviadorMail implements MailGateway {
    private int port;
    private String host;
    private String senderMail;
    private String senderPassMail;
    private int timeOut;

    public EnviadorMail(int port, String host, String senderMail,
            String SenderPassMail, int timeOut) {
        this.port = port;
        this.host = host;
        this.senderMail = senderMail;
        this.senderPassMail = SenderPassMail;
        this.timeOut = timeOut;
    }

    @Override
    public Resultado enviar(Mail mail) {
        Resultado resultado = new Resultado();
        try {

            Socket socket = new Socket(host, port);
            DataOutputStream mensaje = new DataOutputStream(
                    socket.getOutputStream());
            DataInputStream respuesta = new DataInputStream(
                    socket.getInputStream());
            mensaje.writeUTF(senderMail);
            mensaje.flush();

            mensaje.writeUTF(senderPassMail);
            mensaje.flush();

            mensaje.writeUTF(mail.getDestinoMail());
            mensaje.flush();

            mensaje.writeUTF(mail.getTema());
            mensaje.flush();

            mensaje.writeUTF(mail.getCuerpo());
            mensaje.flush();

            // Esperando respuesta
            boolean done = false;
            int i = 0;
            while (!done && i < timeOut) {
                try {
                    Thread.sleep(1000);
                    byte messageType = respuesta.readByte();
                    resultado.AgregarError(String.valueOf((int) messageType),
                            respuesta.readUTF());
                    done = true;
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                i++;
            }
            if (!resultado.HayErrores()) {
                resultado.AgregarError("3",
                        "Sin respuesta del servicio externo de Mails");
            }
            respuesta.close();
            mensaje.close();

            socket.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            resultado.AgregarError("4",
                    "Error al conectar al servicio de Mail");
        }
        return resultado;
    }

}
