package com.deadelvensoft.java.datastorageobjects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class VolumeStorage
{

	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public float	Bore;

	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public float	Stroke;

	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public int		Cyls;

	public String	CylVolume;
	public String	EngineVolume;

	public VolumeStorage(float bore, float stroke, int cyls)
	{
		Bore = bore;
		Stroke = stroke;
		Cyls = cyls;
	}

	public VolumeStorage()
	{
	}

	public float getBore()
	{
		return Bore;
	}

	public void setBore(float bore)
	{
		Bore = bore;
	}

	public float getStroke()
	{
		return Stroke;
	}

	public void setStroke(float stroke)
	{
		Stroke = stroke;
	}

	public int getCyls()
	{
		return Cyls;
	}

	public void setCyls(int cyls)
	{
		Cyls = cyls;
	}

}
