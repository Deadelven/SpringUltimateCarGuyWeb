package com.deadelvensoft.java.datastorageobjects;

public class EconomyStorage
{
	public float	Distance;
	public float	Volume;

	public String	L100;
	public String	MPG;

	public EconomyStorage()
	{
	}

	public EconomyStorage(float distance, float volume)
	{
		Distance = distance;
		Volume = volume;
	}

	public float getDistance()
	{
		return Distance;
	}

	public void setDistance(float distance)
	{
		Distance = distance;
	}

	public float getVolume()
	{
		return Volume;
	}

	public void setVolume(float volume)
	{
		Volume = volume;
	}

}
