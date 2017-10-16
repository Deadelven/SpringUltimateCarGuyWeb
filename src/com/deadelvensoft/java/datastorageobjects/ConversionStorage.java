package com.deadelvensoft.java.datastorageobjects;

public class ConversionStorage
{
	@Override
	public String toString()
	{
		return "ConversionStorage [ConversionType=" + ConversionType + "]";
	}

	public int	ConversionType;

	public ConversionStorage(int conversionType)
	{
		ConversionType = conversionType;
	}

	public ConversionStorage()
	{
	}

	public int getConversionType()
	{
		return ConversionType;
	}

	public void setConversionType(int conversionType)
	{
		ConversionType = conversionType;
	}

	public void SetConversionToKW()
	{
		ConversionType = 1;
	}

	public void SetConversionToMPG()
	{
		ConversionType = 2;
	}

	public void SetConversionToVolume()
	{
		ConversionType = 3;
	}

	public void SetConversionToDrag()
	{
		ConversionType = 4;
	}

	public void SetConversionToPW()
	{
		ConversionType = 5;
	}

	/*
	 * public void SerConversionToKW() { ConversionType = 1; } public void
	 * SerConversionToKW() { ConversionType = 1; } public void
	 * SerConversionToKW() { ConversionType = 1; } public void
	 * SerConversionToKW() { ConversionType = 1; }
	 */

}
