package com.ungs.pp2.scrPP2.Dominio.Interfaz;

import com.ungs.pp2.scrPP2.Dominio.Resultado;

public interface IComando<T>
{
   Resultado Execute(T TipoController);
}
