package com.ungs.pp2.scrPP2.Dominio.Interfaz;

import java.security.InvalidParameterException;

import com.ungs.pp2.scrPP2.Dominio.Request;
import com.ungs.pp2.scrPP2.Dominio.Resultado;

public interface IComando<T>
{
	void configurar(Request request) throws InvalidParameterException;
   Resultado Execute(T TipoController);
   
}
