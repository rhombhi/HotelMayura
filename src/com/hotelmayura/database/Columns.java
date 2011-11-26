package com.hotelmayura.database;

public class Columns 
{
	public String name;
	public String type;
	public String constraint;
	
	public Columns(String name, String type, String constraint) 
	{
		this.name = name;
		this.type = type;
		this.constraint = constraint;
	}

	public Columns()
	{ }

	
}
