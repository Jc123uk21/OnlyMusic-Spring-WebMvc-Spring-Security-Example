package OnlyMusic.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import OnlyMusic.DAO.AdministratorDao;
import OnlyMusic.Model.Administrator;

public class AdministratorServiceImpl implements AdministratorService {
	
	//Inject an AdministratoDao object
	@Autowired
	AdministratorDao adminDao;

	//Call the administratorDoa objects method to add new administrator to database
	@Override
	public boolean addAdministrator(Administrator administrator) {
		return adminDao.insertAdministrator(administrator);

	}

	//Call the administratorDoa objects method to get a list of administrators held in the database
	@Override
	public List<Administrator> getAllAdministrators() {
		return adminDao.getAllAdministrators();
	}

	//Call the administratorDoa objects method to delete an administrator from the database
	@Override
	public boolean deleteAdministratorByEmail(String email) {
		return adminDao.deleteAdministrator(email);
	}

	//Use the administratorDoa objects method to find an administrator within the database
	@Override
	public Administrator getAdministrator(String email) {
		return adminDao.findAdministrator(email);
	}

}
