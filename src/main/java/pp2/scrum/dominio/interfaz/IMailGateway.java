package pp2.scrum.dominio.interfaz;

import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.entidad.Mail;

public interface IMailGateway
{
   Resultado enviar(Mail mail);

}