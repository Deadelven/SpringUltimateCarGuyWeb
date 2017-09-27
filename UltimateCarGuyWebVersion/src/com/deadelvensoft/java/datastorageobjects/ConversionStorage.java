package com.deadelvensoft.java.datastorageobjects;

public class ConversionStorage
{
	@Override
	public String toString()
	{
		return "ConversionStorage [ConversionType=" + ConversionType + "]";
	}

	public int	ConversionType;
	public int	KW			= 1;
	public int	FEconomy	= 2;

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
	/*
	 * public void SerConversionToKW() { ConversionType = 1; } public void
	 * SerConversionToKW() { ConversionType = 1; } public void
	 * SerConversionToKW() { ConversionType = 1; } public void
	 * SerConversionToKW() { ConversionType = 1; }
	 */
}
