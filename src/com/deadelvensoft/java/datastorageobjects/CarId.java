package com.deadelvensoft.java.datastorageobjects;

public class CarId
{
	int	CarId;

	public CarId(int carId)
	{
		CarId = carId;
	}

	public CarId()
	{
	}

	public int getCarId()
	{
		return CarId;
	}

	public void setCarId(int carId)
	{
		CarId = carId;
	}

	@Override
	public String toString()
	{
		return "CarId [CarId=" + CarId + "]";
	}

}
