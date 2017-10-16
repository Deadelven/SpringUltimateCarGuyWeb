package com.deadelvensoft.java.datastorageobjects;

public class DatabaseConversionStorage
{
	int		UserId;
	int		DatabaseID;
	String	Calc1;
	String	Calc2;
	String	Description;

	public DatabaseConversionStorage(int userId, String calc1, String calc2, String description)
	{
		UserId = userId;
		Calc1 = calc1;
		Calc2 = calc2;
		Description = description;
	}

	public DatabaseConversionStorage(int userId, int databaseID, String calc1, String calc2, String description)
	{
		super();
		UserId = userId;
		DatabaseID = databaseID;
		Calc1 = calc1;
		Calc2 = calc2;
		Description = description;
	}

	public DatabaseConversionStorage()
	{
	}

	@Override
	public String toString()
	{
		return "DatabaseConversionStorage [UserId=" + UserId + ", Calc1=" + Calc1 + ", Calc2=" + Calc2 + ", Description=" + Description + "]";
	}

	public int getUserId()
	{
		return UserId;
	}

	public void setUserId(int userId)
	{
		UserId = userId;
	}

	public int getDatabaseID()
	{
		return DatabaseID;
	}

	public void setDatabaseID(int databaseID)
	{
		DatabaseID = databaseID;
	}

	public String getCalc1()
	{
		return Calc1;
	}

	public void setCalc1(String calc1)
	{
		Calc1 = calc1;
	}

	public String getCalc2()
	{
		return Calc2;
	}

	public void setCalc2(String calc2)
	{
		Calc2 = calc2;
	}

	public String getDescription()
	{
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}

}
