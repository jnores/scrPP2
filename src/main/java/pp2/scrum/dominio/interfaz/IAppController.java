package pp2.scrum.dominio.interfaz;

import pp2.scrum.dominio.Resultado;

public interface IAppController
{
   Resultado Execute(IComando commando);
}
