package com.deadelvensoft.java.datastorageobjects;

public class CarStorage
{
	int		dbID;
	int		UserID;
	String	Make;
	String	Model;
	int		Year;
	int		Odometer;
	String	Description;
	int		LastOilChange;
	int		LastTyreChange;
	int		LastBreakChange;
	String	OtherMaitenance;

	public CarStorage(int userID, String make, String model, int year, int odometer, String description, int lastOilChange, int lastTyreChange,
			int lastBreakChange, String otherMaitenance)
	{
		UserID = userID;
		Make = make;
		Model = model;
		Year = year;
		Odometer = odometer;
		Description = description;
		LastOilChange = lastOilChange;
		LastTyreChange = lastTyreChange;
		LastBreakChange = lastBreakChange;
		OtherMaitenance = otherMaitenance;
	}

	public CarStorage(int DbID, int userID, String make, String model, int year, int odometer, String description, int lastOilChange,
			int lastTyreChange, int lastBreakChange, String otherMaitenance)
	{
		dbID = DbID;
		UserID = userID;
		Make = make;
		Model = model;
		Year = year;
		Odometer = odometer;
		Description = description;
		LastOilChange = lastOilChange;
		LastTyreChange = lastTyreChange;
		LastBreakChange = lastBreakChange;
		OtherMaitenance = otherMaitenance;
	}

	public CarStorage(int DbID)
	{
		System.out.println("Car DBID == " + DbID);
		this.dbID = DbID;
	}

	public CarStorage()
	{
	}

	@Override
	public String toString()
	{
		return "CarStorage [dbID=" + dbID + ", UserID=" + UserID + ", Make=" + Make + ", Model=" + Model + ", Year=" + Year + ", Odometer="
				+ Odometer + ", Description=" + Description + ", LastOilChange=" + LastOilChange + ", LastTyreChange=" + LastTyreChange
				+ ", LastBreakChange=" + LastBreakChange + ", OtherMaitenance=" + OtherMaitenance + "]";
	}

	public int getdBID()
	{
		return dbID;
	}

	public void setdBID(int id)
	{
		dbID = id;
	}

	public int getUserID()
	{
		return UserID;
	}

	public void setUserID(int userID)
	{
		UserID = userID;
	}

	public String getMake()
	{
		return Make;
	}

	public void setMake(String make)
	{
		Make = make;
	}

	public String getModel()
	{
		return Model;
	}

	public void setModel(String model)
	{
		Model = model;
	}

	public int getYear()
	{
		return Year;
	}

	public void setYear(int year)
	{
		Year = year;
	}

	public int getOdometer()
	{
		return Odometer;
	}

	public void setOdometer(int odometer)
	{
		Odometer = odometer;
	}

	public String getDescription()
	{
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}

	public int getLastOilChange()
	{
		return LastOilChange;
	}

	public void setLastOilChange(int lastOilChange)
	{
		LastOilChange = lastOilChange;
	}

	public int getLastTyreChange()
	{
		return LastTyreChange;
	}

	public void setLastTyreChange(int lastTyreChange)
	{
		LastTyreChange = lastTyreChange;
	}

	public int getLastBreakChange()
	{
		return LastBreakChange;
	}

	public void setLastBreakChange(int lastBreakChange)
	{
		LastBreakChange = lastBreakChange;
	}

	public String getOtherMaitenance()
	{
		return OtherMaitenance;
	}

	public void setOtherMaitenance(String otherMaitenance)
	{
		OtherMaitenance = otherMaitenance;
	}

}
