package pp2.scrum.dominio.interfaz;

import pp2.scrum.dominio.Resultado;

public interface IComando<T>
{
   Resultado Execute(T TipoController);
   
}
