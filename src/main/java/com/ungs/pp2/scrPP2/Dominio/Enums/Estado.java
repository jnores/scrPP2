package com.ungs.pp2.scrPP2.Dominio.Enums;

public enum Estado 
{
	ToDo,
	Doing,
	Done;
	private static Estado[] valores = values();
	
	public static Estado getDefault() {
		return Estado.ToDo;
	}
	
	public Estado siguiente()
    {
        return Estado.valores[(this.ordinal()+1) % Estado.valores.length];
    }
	
	public Estado anterior()
    {
        return Estado.valores[(this.ordinal()-1 + Estado.valores.length) % Estado.valores.length];
    }
}
