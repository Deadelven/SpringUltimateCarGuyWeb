package com.deadelvensoft.java.datastorageobjects;

public class HPKWStorage
{
	public int		HP;
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
