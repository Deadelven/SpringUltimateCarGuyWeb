package com.deadelvensoft.java.datastorageobjects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class DragStorage
{
	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public int	HP;

	@NotNull
	@Digits(integer = 99999, fraction = 2)
	public int	KG;

	public DragStorage(int hP, int kG)
	{
		HP = hP;
		KG = kG;
	}

	public DragStorage()
	{
	}

	public int getHP()
	{
		return HP;
	}

	public void setHP(int hP)
	{
		HP = hP;
	}

	public int getKG()
	{
		return KG;
	}

	public void setKG(int kG)
	{
		KG = kG;
	}

}
