package com.deadelvensoft.java.calculations;

public class TemperatureConvertor
{

	// Convert Farenheight to celcius
	public static float ConvertToCelcius(float F)
	{
		// Hard coded 0 to avoid division by 0 error
		if (F == 0) return -17.7778f;
		else
		{
			return (((F - GlobalVariables.CToFAddition) * 5) / 9);
		}
	}

	public static float ConvertToFarenheight(float C)
	{
		// Hard coded 0 to avoid division by 0 error
		if (C == 0) return GlobalVariables.CToFAddition;
		else
		{
			return (C * GlobalVariables.CToFMultiplier) + GlobalVariables.CToFAddition;
		}
	}
}