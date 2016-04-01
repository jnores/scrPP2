package com.ungs.pp2.scrPP2.Dominio.Enums;

public enum Estado 
{
	ToDo,
	Doing,
	Done;
	//private static Estado[] valores = values();
	
	public static Estado getDefault() {
		return Estado.ToDo;
	}
	
	public Estado siguiente()
    {
        return Estado.values()[(this.ordinal()+1) % Estado.values().length];
    }
	
	public Estado anterior()
    {
        return Estado.values()[(this.ordinal()-1 + Estado.values().length) % Estado.values().length];
    }
}
