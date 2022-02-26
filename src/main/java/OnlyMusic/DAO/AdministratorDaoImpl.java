package OnlyMusic.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import OnlyMusic.Model.Administrator;
import OnlyMusic.RowMappers.AdministratorRowMapper;

//Administrator data access object class to implement the objects interface

@Repository("administratorDao")
public class AdministratorDaoImpl implements AdministratorDao {
	
	//set up and inject a jdbc driver manager template object
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Inject a Administrator object
	@Autowired
	private Administrator administrator;
	
	//Method to insert Administrator object into administrator table within the database
	@Override
	public boolean insertAdministrator(Administrator administrator) {
		
		//SQL query to insert a administrator into the administrator table in the database
		String slq = "insert into administrator(name, adminId, password, contactNumber, contactEmail, role) values(?,?,?,?,?,?)";
		
		//Retrieve and Store POJO attributes to a array list of type object due to the different variable types retrieved 
		Object[] args = {administrator.getName(), administrator.getAdminId(), administrator.getPassword(), administrator.getContactNumber(),
				administrator.getContactEmail(), administrator.getRole()};
		
		//Create a variable of type int and set it to hold the value of number of rows added via the jdbc object
		int numOfRows = jdbcTemplate.update(slq, args);
		
		//SQL query to insert a administrator into the security's user table in the database
		String sql2 = "insert into users(username, password) values(?,?)";
		
		//Retrieve and Store POJO attributes to a array list of type object due to the different variable types retrieved
		Object[] args2 = {administrator.getContactEmail(), administrator.getPassword()};
		
		//Update the security's user table
		jdbcTemplate.update(sql2,args2);
		
		//SQL query to insert a administrator into the security's authorities table in the database 
		String sql3 = "insert into authorities(username, authority) values(?,?)";
		
		//Retrieve and Store POJO attributes to a array list of type object due to the different variable types retrieved
		Object[]args3 = {administrator.getContactEmail(), administrator.getRole()};
		
		//Update the security's authorities table
		jdbcTemplate.update(sql3,args3);
		
		//Return whether a single row was added to the to the customer table 
				if(numOfRows == 1) {
					return true;
				}
				else {
					return false;
				}
		
	}
	
	// Delete a Administrator from the database
	@Override
	public boolean deleteAdministrator(String email) {
		
		//SQL query to delete a administrator from the administrator table  
		String sql = "DELETE FROM administrator WHERE contactEmail = ?";
		
		//SQL query to delete a administrator from the security's user table 
		String sql2 = "DELETE FROM users WHERE username = ?";
		
		//SQL query to delete a administrator and their authority from the security's authorities table
		String sql3 ="DELETE FROM authorities WHERE username = ?";
		
		//Create a variable of type int and set it to hold the value of number of rows deleted from the administrator table via the jdbc object
		int numRowsDeleted =  jdbcTemplate.update(sql, email);
		
		//Update Authorities table first due to foreign key
	    jdbcTemplate.update(sql3,email);
	    
	    //Update security's user table
		jdbcTemplate.update(sql2,email);
		
		
		//Condition to return the outcome of whether a single row was deleted from the database table
		if(numRowsDeleted == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	//Find a administrator by key within the database
	@Override
	public Administrator findAdministrator(String email) {
		
		//SQL query to select all administrator's from table matching the param
		String sql = "SELECT * FROM administrator Where contactEmail = ?";
		
		//Set customer object to the result of the query and return it
		administrator = jdbcTemplate.queryForObject(sql, new AdministratorRowMapper(),email);
			return administrator;
	
	}

	//retrieve a list of all administrator's held within the administrator table in the database
	@Override
	public List<Administrator> getAllAdministrators() {
		
		//SQL query to get list of all administrator's within the administrator table in the database
		String sql = "SELECT * FROM administrator";
		
		//Create list of the administrator object instances within the administrator table in the database and return it
		List<Administrator> administrators = jdbcTemplate.query(sql, new AdministratorRowMapper());
			return administrators;
	}

}
