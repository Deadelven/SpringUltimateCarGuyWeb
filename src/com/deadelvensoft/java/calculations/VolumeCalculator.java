package com.deadelvensoft.java.calculations;

public class VolumeCalculator
{
	public static double CalculateCylinderVolume(float bore, float stroke)
	{
		// Hard coded 0 to avoid division by 0 error
		if (bore == 0 || stroke == 0) return 0;
		else
		{
			// Calculate radius
			double Radius = (bore / 2);
			// Calculate volume from radius x height(stroke)
			// Returns in CC
			return ((Math.PI * Math.pow(Radius, 2) * stroke) / 1000);
		}
	}

	public static double CalculateEngineVolume(float bore, float stroke, int NumberOfCyls)
	{
		// Hard coded 0 to avoid division by 0 error
		if (bore == 0 || stroke == 0 || NumberOfCyls == 0) return 0;
		else
		{
			// Calculate radius
			double Radius = (bore / 2);
			// Calculate volume from radius x height(stroke)
			// Returns in CC
			double Volume = ((Math.PI * Math.pow(Radius, 2) * stroke) / 1000);
			return Volume * NumberOfCyls;

		}
	}

	public static float CalculateCubeVolume(float L, float W, float H)
	{
		// Hard coded 0 to avoid division by 0 error
		if (L == 0 || W == 0 || H == 0) return 0;
		else
		{
			// Returns whatever input measurement is in M3
			return L * W * H;
		}
	}

}