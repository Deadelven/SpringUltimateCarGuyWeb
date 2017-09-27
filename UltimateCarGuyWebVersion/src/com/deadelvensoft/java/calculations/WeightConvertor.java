package com.deadelvensoft.java.calculations;

public class WeightConvertor
{
	// Convert input KG to LB
	public static float KGToLbConvertor(float KG)
	{
		// Hard coded 0 to avoid division by 0 error
		if (KG == 0) return 0;
		else return KG * GlobalVariables.KGToLBMultiplier;
	}

	// Convert input LB to KG
	public static float LBToKGConvertor(float LB)
	{
		// Hard coded 0 to avoid division by 0 error
		if (LB == 0) return 0;
		else return LB * GlobalVariables.LBToKGMultiplier;

	}
}