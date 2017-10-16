package com.deadelvensoft.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.deadelvensoft.java.datastorageobjects.CarId;
import com.deadelvensoft.java.datastorageobjects.CarMaitenance;
import com.deadelvensoft.java.datastorageobjects.CarStorage;
import com.deadelvensoft.java.datastorageobjects.ConversionStorage;
import com.deadelvensoft.java.datastorageobjects.DatabaseConversionStorage;
import com.deadelvensoft.java.datastorageobjects.PWStorage;
import com.deadelvensoft.java.datastorageobjects.UserId;
import com.deadelvensoft.spring.DAO.Person;
import com.deadelvensoft.spring.DAO.UserObject;
import com.deadelvensoft.spring.service.DatabaseService;

@Controller
@SessionAttributes({ "UserDisplayName", "UserID" })
public class OffersController
{
	private DatabaseService	dbService;

	@Autowired
	public void setDbService(DatabaseService dbService)
	{
		this.dbService = dbService;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id)
	{
		System.out.println("ID is: " + id);
		return "/BaseWeb/Home";
	}

	@RequestMapping("/p/people")
	public String showPeople(Model model)
	{
		List<Person> people = dbService.getCurrentPeople();
		model.addAttribute("people", people);
		model.addAttribute("name", "Karkarof");
		return "/BaseWeb/people";
	}

	@RequestMapping("/addperson")
	public String addPerson()
	{
		return "/BaseWeb/addperson";
	}

	@RequestMapping("/p/deleteuserpage")
	public String deleteUser()
	{
		return "/protected/DeleteUser";
	}

	@RequestMapping("/p/dodeleteuser")
	public String doDeleteUser(Model model, UserObject userobject)
	{

		dbService.DeleteUser(userobject.getId());
		return "/BaseWeb/showusers";
	}

	@RequestMapping(value = "/doaddperson", method = RequestMethod.POST)
	public String doAddPerson(Model model, Person person, BindingResult result)
	{
		if (result.hasErrors())
		{
			System.out.println("Form does not Validate");
			return "/BaseWeb/addperson";
		}

		dbService.createPerson(person);
		return "/BaseWeb/personcreated";
	}

	// SessionAttribute is @SessionAttributes("UserDisplayName")
	@RequestMapping(value = "/c/dologin")
	public String doLogin(Model model)
	{
		String Displayname;
		if (dbService.CheckUser(CurrentUser()) == "null")
		{
			return "/BaseWeb/login";
		}
		else
		{
			Displayname = dbService.CheckUser(CurrentUser());
			model.addAttribute("UserDisplayName", Displayname);
			model.addAttribute("UserID", dbService.CheckUserID(CurrentUser()));
		}
		return "/UcgWeb/home";
	}

	@RequestMapping(value = "/c/doadduser", method = RequestMethod.POST)
	public String doAddUser(Model model, UserObject userobject)
	{
		dbService.CreateUser(userobject);
		System.out.println("UserInfo: " + userobject);
		return "/BaseWeb/HomeRedirect";
	}

	@RequestMapping("/adduser")
	public String addUser()
	{
		return "/BaseWeb/createuser";
	}

	@RequestMapping("/c/login")
	public String login()
	{
		return "/BaseWeb/login";
	}

	@RequestMapping("/p/profile")
	public String profile(Model model)
	{
		List<DatabaseConversionStorage> Calcs = dbService.getCurrentStoredCalcs(dbService.CheckUserID(CurrentUser()));
		for (DatabaseConversionStorage calc : Calcs)
		{
			System.out.println(calc);

		}
		List<CarStorage> Cars = dbService.getCurrentStoredCars(dbService.CheckUserID(CurrentUser()));
		for (DatabaseConversionStorage calc : Calcs)
		{
			System.out.println(calc);

		}
		model.addAttribute("UID", dbService.CheckUserID(CurrentUser()));
		model.addAttribute("SavedCars", Cars);
		model.addAttribute("SavedCalcs", Calcs);
		return "/protected/userprofile";
	}

	@RequestMapping("/p/logout")
	public String loginout(Model model, SessionStatus status)
	{
		status.setComplete();
		return "/BaseWeb/HomeRedirect";
	}

	@RequestMapping("/c/showusers")
	public String showUsers(Model model)
	{
		List<UserObject> users = dbService.getCurrentUsers();
		for (UserObject user : users)
		{
			System.out.println("UserInfo: " + user);

		}

		model.addAttribute("users", users);
		return "/BaseWeb/showusers";
	}

	// Save Calculation
	@RequestMapping(value = "/p/savecalc")
	public String SaveCalc(Model model, PWStorage calcs, ConversionStorage CStorage)
	{
		CStorage.SetConversionToKW();
		model.addAttribute("CStorage", CStorage.getConversionType());
		return "/protected/savecalc";
	}

	// Save Calculation to Database
	@RequestMapping(value = "/p/daosavecalc")
	public String daoSaveCalc(Model model, DatabaseConversionStorage CalcStore)
	{
		System.out.println(CalcStore);
		dbService.SaveCalculation(CalcStore);
		return "/BaseWeb/HomeRedirect";
	}

	// Create Car Mainpage
	@RequestMapping(value = "/p/createcar")
	public String createcar(Model model)
	{
		return "/protected/CreateCar";
	}

	// Save Calculation to Database
	@RequestMapping(value = "/p/daoCreateCar")
	public String daoSaveCalc(Model model, CarStorage car)
	{
		System.out.println(car);
		dbService.SaveCar(car);
		return "/BaseWeb/HomeRedirect";
	}

	public String CurrentUser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currentUserName = authentication.getName();
			return currentUserName;
		}
		else return "null";
	}

	@RequestMapping(value = "/p/dodeletecalculation")
	public String DeleteCalculation(Model model, DatabaseConversionStorage Storage)
	{
		System.out.println("Delete");
		dbService.DeleteCalc(Storage.getDatabaseID());
		return "/BaseWeb/HomeRedirect";
	}

	@RequestMapping(value = "/p/doeditcar")
	public String editCar(Model model, CarId Car, UserId Id)
	{
		System.out.println(Car);
		// List<CarStorage> CarList = dbService.getCar(Car.getdBID());
		// Car = CarList.get(Car.getdBID());
		List<CarStorage> CarSto = dbService.getCar(Car.getCarId());
		List<CarMaitenance> CarMai = dbService.getCarMaitenance(Car.getCarId());
		// dbService.getCarmMitenance(Car.getdBID());
		System.out.println("Doeditcar");
		System.out.println(CarSto);
		model.addAttribute("UserID", Id.getID());
		model.addAttribute("CarId", Car.getCarId());
		model.addAttribute("SavedCars", CarSto);
		model.addAttribute("CarMai", CarMai);
		return "/protected/editcar";
	}

	@RequestMapping(value = "/p/addmaitenance")
	public String Carmaitenance(Model model, CarId car, UserId Id)
	{
		System.out.println("userid " + Id.getID() + " CarID " + car.getCarId());
		model.addAttribute("UID", Id);
		model.addAttribute("CID", car);
		return "/protected/addmaitenance";
	}

	@RequestMapping(value = "/p/doaddmaitenance")
	public String editCarmaitenance(Model model, CarMaitenance CM)
	{
		dbService.addCarMaitenance(CM);
		return "/BaseWeb/HomeRedirect";
	}

	@RequestMapping(value = "/p/doDeleteMaitenance")
	public String deleteCarmaitenance(Model model, CarMaitenance CM)
	{
		dbService.deleteMaitenance(CM.getDbID());
		return "/BaseWeb/HomeRedirect";
	}

	@RequestMapping(value = "/p/doDeleteCar")
	public String deleteCar(Model model, CarId car)
	{
		System.out.println("DeleteCar" + car.getCarId());
		dbService.deleteCar(car.getCarId());
		return "/BaseWeb/HomeRedirect";
	}

	@RequestMapping(value = "/p/daoEditCar")
	public String deleteCar(Model model, CarStorage car, CarId id)
	{
		System.out.println(id);
		System.out.println(car);
		car.setdBID(id.getCarId());
		dbService.UpdateCar(car);
		return "/BaseWeb/HomeRedirect";
	}

	@RequestMapping(value = "/c/register")
	public String goRegister()
	{
		return "/BaseWeb/registration";
	}

	@RequestMapping(value = "/c/HomeRedirect")
	public String goHome()
	{
		return "/BaseWeb/HomeRedirect";
	}

}
