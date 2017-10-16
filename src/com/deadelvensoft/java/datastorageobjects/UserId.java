package com.deadelvensoft.java.datastorageobjects;

public class UserId
{
	int	ID;

	public UserId(int iD)
	{
		ID = iD;
	}

	public UserId()
	{
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	@Override
	public String toString()
	{
		return "UserId [ID=" + ID + "]";
	}

}
