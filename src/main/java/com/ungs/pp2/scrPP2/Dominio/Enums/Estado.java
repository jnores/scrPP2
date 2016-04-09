package com.ungs.pp2.scrPP2.Dominio.Enums;

public enum Estado 
{
	ToDo,
	Doing,
	Done;

	
	public static Estado getDefault() {
		return Estado.ToDo;
	}
	
	public Estado avanzar() throws RuntimeException
    {
		if ( (this.ordinal()+1) == Estado.values().length )
			throw new RuntimeException("No existe un estado posterior a Done."); 
		return Estado.values()[(this.ordinal()+1)];
    }
}
