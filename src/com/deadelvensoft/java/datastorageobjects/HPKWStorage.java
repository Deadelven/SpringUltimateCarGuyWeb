package com.deadelvensoft.java.datastorageobjects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class HPKWStorage
{

	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public int		HP;

	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public int		KW;
	
	
	public String	KWout;
	public String	HPout;

	public HPKWStorage()
	{
	}

	public HPKWStorage(int hP, int kW)
	{
		HP = hP;
		KW = kW;
	}

	public int getHP()
	{
		return HP;
	}

	public void setHP(int hP)
	{
		HP = hP;
	}

	public int getKW()
	{
		return KW;
	}

	public void setKW(int kW)
	{
		KW = kW;
	}

	public String getKWout()
	{
		return KWout;
	}

	public void setKWout(String kWout)
	{
		KWout = kWout;
	}

	public String getHPout()
	{
		return HPout;
	}

	public void setHPout(String hPout)
	{
		HPout = hPout;
	}

}
