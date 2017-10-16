package com.deadelvensoft.java.calculations;

//Kw/hp
//ftlb/nm
//HP at x rpm via torque

public class EnergyConvertor
{

	public static float ConvertKWToHP(float KW)
	{
		// Hard coded 0 to avoid division by 0 error
		if (KW == 0f) return 0;
		else return KW * GlobalVariables.KWToHPMultiplier;
	}

	public static float ConvertHPToKW(float HP)
	{
		// Hard coded 0 to avoid division by 0 error
		if (HP == 0) return 0;
		else return HP * GlobalVariables.HPToKWMultiplier;
	}
}
