package com.deadelvensoft.java.calculations;

public class IOClass
{
	// IO and String formatting for Celcius and Farenheight
	public String IOConvertCelciusToFarenheight(Float c)
	{
		return c + " Celcius = " + TemperatureConvertor.ConvertToFarenheight(c) + " Farenheight";
	}

	public String IOConvertFarenheightToCelcius(Float f)
	{
		return f + " Farenheight = " + TemperatureConvertor.ConvertToCelcius(f) + " Celcius";
	}

	// IO and String formatting for KW and HP
	public static String IOConvertKWToHP(Float KW)
	{
		return KW + " Kilowats = " + EnergyConvertor.ConvertKWToHP(KW) + " Horsepower ";
	}

	public static String IOConvertHPToKW(Float HP)
	{
		return HP + " Horsepower = " + EnergyConvertor.ConvertHPToKW(HP) + " Kilowats ";
	}

	// IO and String formatting for Fuel Economy Calculator
	public static String IOLP100(float Fuel, float Distance)
	{
		return FuelEconomyCalculator.LP100KM(Fuel, Distance) + " Litres per 100 KM";
	}

	public static String IOMPG(float Fuel, float Distance)
	{
		return FuelEconomyCalculator.MPG(Fuel, Distance) + " MPG";
	}

	// IO and String formatting for Power to Weight
	public String IOHPperLitre(float Power, float Litre)
	{
		return PowerOverVolume.HPPerLitre(Power, Litre) + " HP per Litre";
	}

	public String IOKWPerTon(float KW, float KG)
	{
		return PowerToWeightCalculator.KWPerTon(KW, KG) + " HP per Litre";
	}

	// IO and String formatting for KG and LB Conversion
	public String IOKGToLB(float KG)
	{
		return WeightConvertor.KGToLbConvertor(KG) + " LB ~~";
	}

	public String IOLBToKG(float LB)
	{
		return WeightConvertor.LBToKGConvertor(LB) + " KG ~~";
	}

	// IO and String formatting for Quarter Mile time Calculator
	public String IOQuarterMileTime(float HP, float KG)
	{
		return QuarterMileCalculator.QuarterMileTime(HP, KG)
				+ " Estimated quarter mile time (Add 15% to account for weight of driver and wind resistance)";
	}

	// IO and String formatting for Rod to Stroke Ratio
	public String IOBoreToStrokeRatio(float Bore, float Stroke)
	{
		return RodToStrokeRatio.BoreToStrokeRatio(Bore, Stroke) + " Bore to Stroke";
	}

	// IO and String formatting for Volume Calculations
	public String IOCalculateCubeVolume(float L, float W, float H)
	{
		return VolumeCalculator.CalculateCubeVolume(L, W, H) + " CC";
	}

	public String IOCalculateCylinderVolume(float bore, float stroke)
	{
		return VolumeCalculator.CalculateCylinderVolume(bore, stroke) + " CC";
	}

	public String IOCalculateEngineVolume(float bore, float stroke, int NumberOfCyls)
	{
		return VolumeCalculator.CalculateEngineVolume(bore, stroke, NumberOfCyls) + " CC";
	}

	// IO and String formatting for Volume Convertor
	public String IOConvertLitresToGallons(float L)
	{
		return L + " Litres = " + VolumeConvertor.ConvertLitersToGallons(L) + " Gallons";
	}

	public String IOConvertGallonsToLitres(float G)
	{
		return G + " Gallons = " + VolumeConvertor.ConvertLitersToGallons(G) + " Litres";
	}

}
