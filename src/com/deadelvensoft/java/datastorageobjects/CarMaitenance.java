package com.deadelvensoft.java.datastorageobjects;

public class CarMaitenance
{
	int		dbID;
	int		carID;
	int		userID;
	String	Description;
	int		cost;
	int		odo;

	@Override
	public String toString()
	{
		return "CarMaitenance [dbID=" + dbID + ", carID=" + carID + ", userID=" + userID + ", Description=" + Description + ", cost=" + cost
				+ ", odo=" + odo + "]";
	}

	public CarMaitenance(int carID, int userID, String description, int cost, int odo)
	{
		this.carID = carID;
		this.userID = userID;
		Description = description;
		this.cost = cost;
		this.odo = odo;
	}

	public CarMaitenance()
	{

	}

	public CarMaitenance(int dbID, int carID, int userID, String description, int odo)
	{
		this.dbID = dbID;
		this.carID = carID;
		this.userID = userID;
		Description = description;
		this.odo = odo;
	}

	public CarMaitenance(int dbID, int carID, int userID, String description, int cost, int odo)
	{
		this.dbID = dbID;
		this.carID = carID;
		this.userID = userID;
		Description = description;
		this.cost = cost;
		this.odo = odo;
	}

	public int getDbID()
	{
		return dbID;
	}

	public void setDbID(int dbID)
	{
		this.dbID = dbID;
	}

	public int getCarID()
	{
		return carID;
	}

	public void setCarID(int carID)
	{
		this.carID = carID;
	}

	public int getUserID()
	{
		return userID;
	}

	public void setUserID(int userID)
	{
		this.userID = userID;
	}

	public String getDescription()
	{
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	public int getOdo()
	{
		return odo;
	}

	public void setOdo(int odo)
	{
		this.odo = odo;
	}

}
