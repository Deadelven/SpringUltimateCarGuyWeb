package com.deadelvensoft.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.deadelvensoft.java.datastorageobjects.CarMaitenance;
import com.deadelvensoft.java.datastorageobjects.CarStorage;
import com.deadelvensoft.java.datastorageobjects.DatabaseConversionStorage;

@Component("mainDao")
public class MainDAO
{

	private NamedParameterJdbcTemplate	jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc)
	{
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public void updatePerson(Person person)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(person);
		jdbc.update("update clients set name =:name,cash= :money,description =:description where id = :id", params);
		System.out.println("Person Updated");
	}

	public List<Person> getPeople()
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		return jdbc.query("select * from clients", params, new RowMapper<Person>()
		{
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setMoney(rs.getInt("cash"));
				person.setDescription(rs.getString("description"));
				System.out.println("ID: " + person.getId() + "  Name: " + person.getName() + " Cash: " + person.getMoney() + " Description: "
						+ person.getDescription());
				return person;
			}
		});
	}

	public boolean AddPerson(Person person)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(person);

		return jdbc.update("insert into clients (name, cash, description) values (:name,:money,:description)", params) == 1;
	}

	public boolean addTransaction(Transaction trans)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(trans);
		System.out.println("transaction added");
		return jdbc.update("insert into transactions (seller, buyer, amount, description) values (:person2Id,:person1Id,:amount,:description)",
				params) == 1;
	}

	public Person getPerson(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject("select * from clients where id = :id", params, new RowMapper<Person>()
		{
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setMoney(rs.getInt("cash"));
				person.setDescription(rs.getString("description"));
				System.out.println("ID: " + person.getId() + "  Name: " + person.getName() + " Cash: " + person.getMoney() + " Description: "
						+ person.getDescription());
				return person;
			}
		});
	}

	public void deletePerson(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		jdbc.update("delete from clients where id = :id", params);
	}

	public void deleteUser(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		jdbc.update("delete from users where id = :id", params);
	}

	public boolean transaction(int personid1, int personid2, int amt, String description)
	{
		// Retreive People from database
		Person person1 = getPerson(personid1);
		Person person2 = getPerson(personid2);
		Transaction trans = new Transaction(personid1, personid2, amt, description);

		if (person1.getMoney() - amt > 0)
		{
			System.out.println("Enough money present. Transcation Continues");
			int money1 = person1.getMoney();
			person1.setMoney(money1 -= amt);
			int money2 = person2.getMoney();
			person2.setMoney(money2 += amt);

			updatePerson(person1);
			System.out.println("Person1 Updated");

			updatePerson(person2);
			System.out.println("Person2 Updated");

			addTransaction(trans);

		}
		else System.out.println("Insufficcent Funds");

		return false;

	}

	public String CheckUserPass(String Username)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("Username", Username);
		System.out.println("Username = " + Username);
		String DisplayName = "";

		UserAccess user = jdbc.queryForObject("select * from users where UserName = :Username", params, new RowMapper<UserAccess>()
		{
			@Override
			public UserAccess mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				UserAccess person = new UserAccess();
				person.setId(rs.getInt("id"));
				person.setDisplayName(rs.getString("UserDisplayName"));
				System.out.println("ID: " + person.getId() + " Display Name: " + person.getDisplayName());
				return person;
			}
		});
		DisplayName = user.getDisplayName();
		return DisplayName;
	}

	public int CheckUserPassID(String Username)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("Username", Username);
		System.out.println("Username = " + Username);

		int ID;

		UserAccess user = jdbc.queryForObject("select * from users where UserName = :Username", params, new RowMapper<UserAccess>()
		{
			@Override
			public UserAccess mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				UserAccess person = new UserAccess();
				person.setId(rs.getInt("id"));
				person.setDisplayName(rs.getString("UserDisplayName"));
				System.out.println("ID: " + person.getId() + " Display Name: " + person.getDisplayName());
				return person;
			}
		});
		ID = user.getId();
		System.out.println(ID);
		return ID;
	}

	public boolean addUserData(String UserName, String Password, String UserDisplayName)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("UserName", UserName);
		params.addValue("Password", Password);
		params.addValue("UserDisplayName", UserDisplayName);
		List<UserObject> Users = jdbc.query("select * from users where UserName =:UserName", params, new RowMapper<UserObject>()
		{
			@Override
			public UserObject mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				UserObject person = new UserObject();
				person.setId(rs.getInt("id"));
				person.setUsername(rs.getString("UserName"));
				person.setPassword(rs.getString("Password"));
				person.setDisplayName(rs.getString("UserDisplayName"));
				System.out.println("ID: " + person.getId() + "  UserName: " + person.getUsername() + " Password: " + person.getPassword()
						+ " UserDisplayName: " + person.getDisplayName());
				return person;
			}
		});
		{
			if (Users.size() >= 1)
			{
				System.out.println("Registration Failed, Duplicate Username");
				return false;
			}
			else
			{
				params.addValue("Authority", "user");
				System.out.println("User Added " + UserName + Password + UserDisplayName);
				jdbc.update("insert into authorities (username,authority) values (:UserName, :Authority)", params);
				return jdbc.update("insert into users (UserName,Password,UserDisplayName) values (:UserName,:Password,:UserDisplayName)", params) == 1;
			}
		}
	}

	public List<UserObject> getUsers()
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		return jdbc.query("select * from users", params, new RowMapper<UserObject>()
		{
			@Override
			public UserObject mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				UserObject person = new UserObject();
				person.setId(rs.getInt("id"));
				person.setUsername(rs.getString("UserName"));
				person.setPassword(rs.getString("Password"));
				person.setDisplayName(rs.getString("UserDisplayName"));
				System.out.println("ID: " + person.getId() + "  UserName: " + person.getUsername() + " Password: " + person.getPassword()
						+ " UserDisplayName: " + person.getDisplayName());
				return person;
			}
		});
	}

	public List<DatabaseConversionStorage> getStoredConversions(int ID)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", ID);
		return jdbc.query("select * from StoredCalcs where UserId = :id", params, new RowMapper<DatabaseConversionStorage>()
		{
			@Override
			public DatabaseConversionStorage mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				DatabaseConversionStorage calcs = new DatabaseConversionStorage();
				calcs.setDatabaseID(rs.getInt("id"));
				calcs.setUserId(rs.getInt("UserId"));
				calcs.setCalc1(rs.getString("Calc1"));
				calcs.setCalc2(rs.getString("Calc2"));
				calcs.setDescription(rs.getString("Description"));
				return calcs;
			}
		});
	}

	public boolean addCalcStorage(int ID, String Calc1, String Calc2, String Description)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", ID);
		params.addValue("C1", Calc1);
		params.addValue("C2", Calc2);
		System.out.println(Calc2);
		params.addValue("Desc", Description);
		System.out.println("Calc added " + ID + Calc1 + Calc2 + Description);
		return jdbc.update("insert into StoredCalcs (UserId,Calc1,Calc2,Description) values (:id,:C1,:C2,:Desc)", params) == 1;

	}

	public boolean addCarToDB(CarStorage car)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID", car.getUserID());
		params.addValue("Make", car.getMake());
		params.addValue("Model", car.getModel());
		params.addValue("Year", car.getYear());
		params.addValue("Odometer", car.getOdometer());
		params.addValue("Description", car.getDescription());
		params.addValue("LastOilChange", car.getLastOilChange());
		params.addValue("LastTyreChange", car.getLastTyreChange());
		params.addValue("Brakes", car.getLastBreakChange());
		params.addValue("OtherMaitenanceItems", car.getOtherMaitenance());

		return jdbc
				.update("insert into VCarLog (UID , Make , Model , Year , Odometer , Description , LastOilChange , LastTyreChange , Brakes , OtherMaitenanceItems) values (:ID,:Make,:Model,:Year,:Odometer,:Description,:LastOilChange,:LastTyreChange,:Brakes,:OtherMaitenanceItems)",
						params) == 1;

	}

	public boolean UpdateCarStorage(CarStorage car)
	{
		System.out.println(car);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("DBID", car.getdBID());
		params.addValue("Odometer", car.getOdometer());
		params.addValue("Description", car.getDescription());
		params.addValue("LastOilChange", car.getLastOilChange());
		params.addValue("LastTyreChange", car.getLastTyreChange());
		params.addValue("Brakes", car.getLastBreakChange());
		params.addValue("OtherMaitenanceItems", car.getOtherMaitenance());

		return jdbc
				.update("update VCarLog set Odometer = :Odometer,Description= :Description,LastOilChange =:LastOilChange,LastTyreChange=:LastTyreChange,Brakes=:Brakes,OtherMaitenanceItems=:OtherMaitenanceItems where idVirtualCar = :DBID",
						params) == 1;
	}

	public List<CarStorage> getStoredCars(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.query("select * from VCarLog where UID = :id", params, new RowMapper<CarStorage>()
		{
			@Override
			public CarStorage mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				CarStorage Car = new CarStorage();
				Car.setdBID(rs.getInt("idVirtualCar"));
				Car.setMake(rs.getString("Make"));
				Car.setModel(rs.getString("Model"));
				Car.setYear(rs.getInt("Year"));
				Car.setOdometer(rs.getInt("Odometer"));
				Car.setDescription(rs.getString("Description"));
				Car.setLastOilChange(rs.getInt("LastOilChange"));
				Car.setLastTyreChange(rs.getInt("LastTyreChange"));
				Car.setLastBreakChange(rs.getInt("Brakes"));
				Car.setOtherMaitenance(rs.getString("OtherMaitenanceItems"));

				System.out.println(Car);
				return Car;
			}
		});
	}

	public List<CarStorage> getStoredCar(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		System.out.println("Get Car from ID");
		return jdbc.query("select * from vcarlog where idVirtualCar = :id", params, new RowMapper<CarStorage>()
		{
			@Override
			public CarStorage mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				CarStorage Car = new CarStorage();

				Car.setdBID(rs.getInt("idVirtualCar"));
				Car.setMake(rs.getString("Make"));
				Car.setModel(rs.getString("Model"));
				Car.setYear(rs.getInt("Year"));
				Car.setOdometer(rs.getInt("Odometer"));
				Car.setDescription(rs.getString("Description"));
				Car.setLastOilChange(rs.getInt("LastOilChange"));
				Car.setLastTyreChange(rs.getInt("LastTyreChange"));
				Car.setLastBreakChange(rs.getInt("Brakes"));
				Car.setOtherMaitenance(rs.getString("OtherMaitenanceItems"));

				System.out.println("Car == : " + Car);
				System.out.println("Car: ");
				return Car;
			}
		});
	}

	public List<CarMaitenance> getStoredCarMaitenance(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.query("select * from carlog where carID = :id", params, new RowMapper<CarMaitenance>()
		{
			@Override
			public CarMaitenance mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				CarMaitenance Car = new CarMaitenance();
				Car.setDbID(rs.getInt("idcarlog"));
				Car.setCarID(rs.getInt("carid"));
				Car.setUserID(rs.getInt("userid"));
				Car.setDescription(rs.getString("description"));
				Car.setCost(rs.getInt("cost"));
				Car.setOdo(rs.getInt("odo"));
				return Car;
			}
		});
	}

	public boolean addCarToMaitenance(CarMaitenance car)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		System.out.println(car);
		params.addValue("CID", car.getCarID());
		params.addValue("UID", car.getUserID());
		params.addValue("DE", car.getDescription());
		params.addValue("CO", car.getCost());
		params.addValue("ODO", car.getOdo());

		return jdbc.update("insert into carlog (carid , userid , description , cost , odo) values (:CID,:UID,:DE,:CO,:ODO)", params) == 1;
	}

	public void deleteMaitenance(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		jdbc.update("delete from carlog where idcarlog = :id", params);
	}

	public void deleteCar(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		jdbc.update("delete from vcarlog where idVirtualCar = :id", params);
		jdbc.update("delete from carlog where carid = :id", params);
	}

	public void deleteCarMaitenance(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		jdbc.update("delete from carlog where idcarlog = :id", params);
	}

	public void deleteCalculation(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		jdbc.update("delete from storedcalcs where id = :id", params);
	}

}
