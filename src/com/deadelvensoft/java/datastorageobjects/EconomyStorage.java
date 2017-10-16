package com.deadelvensoft.java.datastorageobjects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class EconomyStorage
{
	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public float	Distance;

	@NotNull
	@Digits(integer = 99999, fraction = 2)
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
