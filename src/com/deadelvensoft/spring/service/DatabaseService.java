package com.deadelvensoft.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadelvensoft.java.datastorageobjects.CarMaitenance;
import com.deadelvensoft.java.datastorageobjects.CarStorage;
import com.deadelvensoft.java.datastorageobjects.DatabaseConversionStorage;
import com.deadelvensoft.spring.DAO.MainDAO;
import com.deadelvensoft.spring.DAO.Person;
import com.deadelvensoft.spring.DAO.UserObject;

@Service("databaseService")
public class DatabaseService
{
	private MainDAO	mainDao;

	@Autowired
	public void setMainDao(MainDAO mainDao)
	{
		this.mainDao = mainDao;
	}

	public List<Person> getCurrentPeople()
	{
		return mainDao.getPeople();
	}

	public List<UserObject> getCurrentUsers()
	{
		return mainDao.getUsers();
	}

	public void createPerson(Person person)
	{
		mainDao.AddPerson(person);

	}

	public String CheckUser(String Username)
	{
		if (mainDao.CheckUserPass(Username) == null) { return "null"; }
		return mainDao.CheckUserPass(Username);
	}

	public int CheckUserID(String Username)
	{
		if (mainDao.CheckUserPass(Username) == null) { return 0; }
		return mainDao.CheckUserPassID(Username);
	}

	public void CreateUser(UserObject user)
	{
		mainDao.addUserData(user.getUsername(), user.getPassword(), user.getDisplayName());

	}

	public void DeleteUser(int id)
	{
		mainDao.deleteUser(id);

	}

	public void SaveCalculation(DatabaseConversionStorage Calcs)
	{
		Calcs.toString();
		mainDao.addCalcStorage(Calcs.getUserId(), Calcs.getCalc1(), Calcs.getCalc2(), Calcs.getDescription());

	}

	public List<DatabaseConversionStorage> getCurrentStoredCalcs(int ID)
	{
		return mainDao.getStoredConversions(ID);
	}

	public void SaveCar(CarStorage car)
	{
		System.out.println(car);
		mainDao.addCarToDB(car);

	}

	public List<CarStorage> getCurrentStoredCars(int id)
	{
		return mainDao.getStoredCars(id);
	}

	public List<CarMaitenance> getCarMaitenance(int id)
	{
		return mainDao.getStoredCarMaitenance(id);
	}

	public List<CarStorage> getCar(int id)
	{
		System.out.println("getCar " + id);
		return mainDao.getStoredCar(id);
	}

	public void DeleteCalc(int ID)
	{
		mainDao.deleteCalculation(ID);

	}

	public void deleteMaitenance(int ID)
	{
		mainDao.deleteCarMaitenance(ID);

	}

	public void deleteCar(int ID)
	{
		mainDao.deleteCar(ID);

	}

	public void addCarMaitenance(CarMaitenance CM)
	{
		mainDao.addCarToMaitenance(CM);

	}

	public void UpdateCar(CarStorage car)
	{
		mainDao.UpdateCarStorage(car);
	}
}
