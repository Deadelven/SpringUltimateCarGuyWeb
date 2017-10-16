package com.deadelvensoft.java.calculations;

public class RodToStrokeRatio
{

	public static float BoreToStrokeRatio(float Bore, float Stroke)
	{
		// Hard coded 0 to avoid division by 0 error
		if (Bore == 0 || Stroke == 0) return 0;

		else return Bore / Stroke;
	}
}