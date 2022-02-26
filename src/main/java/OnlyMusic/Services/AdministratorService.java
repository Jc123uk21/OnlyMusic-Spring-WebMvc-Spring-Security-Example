package OnlyMusic.Services;

import java.util.List;
import OnlyMusic.Model.Administrator;

public interface AdministratorService {
		//Add Administrator object to database 
		public boolean addAdministrator(Administrator administrator );
		//List all Administrator objects in database
		public List<Administrator> getAllAdministrators();
		//Delete a Administrator object from the database by Primary key
		public boolean deleteAdministratorByEmail(String email);
		//Get Administrator object by primary key
		public Administrator getAdministrator(String email);

}
