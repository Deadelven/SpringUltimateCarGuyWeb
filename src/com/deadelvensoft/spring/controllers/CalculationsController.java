package com.deadelvensoft.spring.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.deadelvensoft.java.calculations.IOClass;
import com.deadelvensoft.java.datastorageobjects.ConversionStorage;
import com.deadelvensoft.java.datastorageobjects.DatabaseConversionStorage;
import com.deadelvensoft.java.datastorageobjects.DragStorage;
import com.deadelvensoft.java.datastorageobjects.EconomyStorage;
import com.deadelvensoft.java.datastorageobjects.HPKWStorage;
import com.deadelvensoft.java.datastorageobjects.PWStorage;
import com.deadelvensoft.java.datastorageobjects.VolumeStorage;

@Controller
@SessionAttributes("CalcStore")
public class CalculationsController
{

	// Passes Reqeust for address and returns path to specific jsp.
	@RequestMapping(value = "/c/energyKW")
	public String convertEnergyInput(Model model, HPKWStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToKW();
		model.addAttribute("CStorage", CStorage.getConversionType());
		return "/UcgWeb/ConversionPage";
	}

	@RequestMapping(value = "/c/economy")
	public String calculateFuelEconomy(Model model, EconomyStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToMPG();
		model.addAttribute("CStorage", CStorage.getConversionType());
		return "/UcgWeb/ConversionPage";
	}

	@RequestMapping(value = "/c/volume")
	public String calculateSendVolume(Model model, VolumeStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToVolume();
		model.addAttribute("CStorage", CStorage.getConversionType());
		return "/UcgWeb/ConversionPage";
	}

	@RequestMapping(value = "/c/drag")
	public String calculateDrag(Model model, DragStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToDrag();
		model.addAttribute("CStorage", CStorage.getConversionType());
		return "/UcgWeb/ConversionPage";
	}

	@RequestMapping(value = "/c/kwton")
	public String calculatekwton(Model model, PWStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToPW();
		model.addAttribute("CStorage", CStorage.getConversionType());
		return "/UcgWeb/ConversionPage";
	}

	// Takes in values via POST and the HPKWStorage Object and passed them into
	// a conversion class. Adds them to a Model and sends to output JSP.
	// SessionAttribute is (CalcStore)
	@RequestMapping(value = "/c/convertenergyKW", method = RequestMethod.POST)
	public String convertEnergy(Model model, @Valid HPKWStorage calcs, BindingResult result, ConversionStorage CStorage)
	{

		if (result.hasErrors())
		{
			CStorage.SetConversionToKW();
			model.addAttribute("CStorage", CStorage.getConversionType());
			System.out.println("Form does not validate");
			return "/UcgWeb/ConversionPage";
		}
		else
		{
			CStorage.SetConversionToKW();
			float HP = calcs.HP;
			float KW = calcs.KW;
			DatabaseConversionStorage DCS = new DatabaseConversionStorage();
			DCS.setCalc1(IOClass.IOConvertHPToKW(HP));
			DCS.setCalc2(IOClass.IOConvertKWToHP(KW));
			model.addAttribute("CalcStore", DCS);
			model.addAttribute("Calcs", calcs);
			model.addAttribute("CStorage", CStorage.getConversionType());

			return "/UcgWeb/output";
		}
	}

	// Calculating fuel economy
	@RequestMapping(value = "/c/calculateeconomy", method = RequestMethod.POST)
	public String convertEnergy(Model model, @Valid EconomyStorage calcs, BindingResult result, ConversionStorage CStorage)
	{
		if (result.hasErrors())
		{
			CStorage.SetConversionToMPG();
			model.addAttribute("CStorage", CStorage.getConversionType());
			System.out.println("Form does not validate");
			return "/UcgWeb/ConversionPage";
		}
		else
		{
			CStorage.SetConversionToMPG();
			float Distance = calcs.Distance;
			float Volume = calcs.Volume;
			DatabaseConversionStorage DCS = new DatabaseConversionStorage();
			DCS.setCalc1(IOClass.IOLP100(Volume, Distance));
			DCS.setCalc2(IOClass.IOMPG(Volume, Distance));
			model.addAttribute("CalcStore", DCS);
			model.addAttribute("Calcs", calcs);
			model.addAttribute("CStorage", CStorage.getConversionType());

			return "/UcgWeb/output";
		}
	}

	// Calculating Volume
	@RequestMapping(value = "/c/calculatevolume", method = RequestMethod.POST)
	public String calculateVolume(Model model, @Valid VolumeStorage calcs, BindingResult result, ConversionStorage CStorage)
	{
		if (result.hasErrors())
		{
			CStorage.SetConversionToVolume();
			model.addAttribute("CStorage", CStorage.getConversionType());
			System.out.println("Form does not validate");
			return "/UcgWeb/ConversionPage";
		}
		else
		{
			CStorage.SetConversionToVolume();
			float Bore = calcs.Bore;
			float Stroke = calcs.Stroke;
			int Cyls = calcs.Cyls;
			DatabaseConversionStorage DCS = new DatabaseConversionStorage();
			DCS.setCalc1(IOClass.IOCalculateCylinderVolume(Bore, Stroke));
			DCS.setCalc2(IOClass.IOCalculateEngineVolume(Bore, Stroke, Cyls));
			model.addAttribute("CalcStore", DCS);
			model.addAttribute("Calcs", calcs);
			model.addAttribute("CStorage", CStorage.getConversionType());

			return "/UcgWeb/output";
		}
	}

	// Calculating Drag Race Estimator
	@RequestMapping(value = "/c/calculatedrag", method = RequestMethod.POST)
	public String calculateDragTime(Model model, @Valid DragStorage calcs, BindingResult result, ConversionStorage CStorage)
	{
		if (result.hasErrors())
		{
			CStorage.SetConversionToDrag();
			model.addAttribute("CStorage", CStorage.getConversionType());
			System.out.println("Form does not validate");
			return "/UcgWeb/ConversionPage";
		}
		else
		{
			CStorage.SetConversionToDrag();
			int HP = calcs.HP;
			int KG = calcs.KG;
			DatabaseConversionStorage DCS = new DatabaseConversionStorage();
			DCS.setCalc1(IOClass.IOQuarterMileTime(HP, KG));
			model.addAttribute("CalcStore", DCS);
			model.addAttribute("Calcs", calcs);
			model.addAttribute("CStorage", CStorage.getConversionType());

			return "/UcgWeb/output";
		}
	}

	// Calculating Volume
	@RequestMapping(value = "/c/calculatepw", method = RequestMethod.POST)
	public String calculatePW(Model model, @Valid PWStorage calcs, BindingResult result, ConversionStorage CStorage)
	{
		if (result.hasErrors())
		{
			CStorage.SetConversionToPW();
			model.addAttribute("CStorage", CStorage.getConversionType());
			System.out.println("Form does not validate");
			return "/UcgWeb/ConversionPage";
		}
		else
		{
			CStorage.SetConversionToPW();
			int KW = calcs.KW;
			int KG = calcs.KG;
			DatabaseConversionStorage DCS = new DatabaseConversionStorage();
			DCS.setCalc1(IOClass.IOKWPerTon(KW, KG));
			model.addAttribute("CalcStore", DCS);
			model.addAttribute("Calcs", calcs);
			model.addAttribute("CStorage", CStorage.getConversionType());

			return "/UcgWeb/output";
		}
	}

}