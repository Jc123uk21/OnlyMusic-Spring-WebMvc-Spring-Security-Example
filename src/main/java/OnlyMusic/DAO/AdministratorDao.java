package OnlyMusic.DAO;

import java.util.List;

import OnlyMusic.Model.Administrator;

// Administrator Data access object interface

public interface AdministratorDao {
	//Insert Customer into database method
		public boolean insertAdministrator(Administrator administrator);
		// Delete a customer from the database
		public boolean deleteAdministrator(String email);
		//locate a customer within the database
		public Administrator findAdministrator(String email);
		//retrieve a list of all customers held within the database
		public List<Administrator> getAllAdministrators();

}
