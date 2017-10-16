package com.deadelvensoft.java.datastorageobjects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class PWStorage
{
	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public int	KG;

	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public int	KW;

	public PWStorage(int kG, int kW)
	{

		KG = kG;
		KW = kW;
	}

	public PWStorage()
	{
	}

	public int getKG()
	{
		return KG;
	}

	public void setKG(int kG)
	{
		KG = kG;
	}

	public int getKW()
	{
		return KW;
	}

	public void setKW(int kW)
	{
		KW = kW;
	}

}
