package pp2.scrum.dominio.entidad;

import pp2.scrum.dominio.Resultado;

public interface MailGateway
{
   Resultado enviar(Mail mail);

}