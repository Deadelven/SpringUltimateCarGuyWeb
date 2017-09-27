package com.deadelvensoft.java.calculations;

import com.deadelvensoft.java.calculations.GlobalVariables;

public class VolumeConvertor
{

	public static float ConvertLitersToGallons(float L)
	{
		// Hard coded 0 to avoid division by 0 error
		if (L == 0) return 0;

		else return L * GlobalVariables.LToGMultiplier;
	}

	public static float ConvertGallonsToLitres(float G)
	{
		// Hard coded 0 to avoid division by 0 error
		if (G == 0) return 0;

		else return G * GlobalVariables.GToLMultiplier;
	}
}