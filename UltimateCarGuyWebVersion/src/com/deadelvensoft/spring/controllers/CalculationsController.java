package com.deadelvensoft.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deadelvensoft.java.calculations.IOClass;
import com.deadelvensoft.java.datastorageobjects.ConversionStorage;
import com.deadelvensoft.java.datastorageobjects.EconomyStorage;
import com.deadelvensoft.java.datastorageobjects.HPKWStorage;

@Controller
public class CalculationsController
{
	// Passes Reqeust for address and returns path to specific jsp.
	@RequestMapping(value = "/energyKW")
	public String convertEnergyInput(Model model, HPKWStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToKW();
		model.addAttribute("CStorage", CStorage.getConversionType());
		return "/UcgWeb/ConversionPage";
	}

	@RequestMapping(value = "/economy")
	public String calculateFuelEconomy(Model model, EconomyStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToMPG();
		model.addAttribute("CStorage", CStorage.getConversionType());
		return "/UcgWeb/ConversionPage";
	}

	// Takes in values via POST and the HPKWStorage Object and passed them into
	// a conversion class. Adds them to a Model and sends to output JSP.
	@RequestMapping(value = "/convertenergyKW", method = RequestMethod.POST)
	public String convertEnergy(Model model, HPKWStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToKW();
		float HP = calcs.HP;
		float KW = calcs.KW;
		model.addAttribute("HPString", IOClass.IOConvertHPToKW(HP));
		model.addAttribute("KWString", IOClass.IOConvertKWToHP(KW));
		model.addAttribute("Calcs", calcs);
		model.addAttribute("CStorage", CStorage.getConversionType());
		return "/UcgWeb/output";
	}

	// Calculating fuel economy
	@RequestMapping(value = "/calculateeconomy", method = RequestMethod.POST)
	public String convertEnergy(Model model, EconomyStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToMPG();
		float Distance = calcs.Distance;
		float Volume = calcs.Volume;
		model.addAttribute("L100", IOClass.IOLP100(Volume, Distance));
		model.addAttribute("MPG", IOClass.IOMPG(Volume, Distance));
		model.addAttribute("Calcs", calcs);
		model.addAttribute("CStorage", CStorage.getConversionType());

		return "/UcgWeb/output";
	}

}