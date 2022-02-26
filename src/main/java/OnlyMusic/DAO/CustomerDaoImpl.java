package OnlyMusic.DAO;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import OnlyMusic.Model.Customer;
import OnlyMusic.RowMappers.CustomerRowMapper;

//Administrator data access object class to implement the objects interface

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	
	
	//set up and inject a jdbc driver manager template object
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Inject a Customer object
	@Autowired
	private Customer customer;

	//Method to insert Customer object into database
	@Override
	public boolean insertCustomer(Customer customer) {
		
		//SQL query to insert a customer into the customer table in the database
		String slq = "insert into customer(customerEmail, password, customerId, customerAddress, customerDOB, role) values(?,?,?,?,?,?)";
		
		//Retrieve and Store POJO attributes to a array list of type object due to the different variable types retrieved 
		Object[] args = {customer.getCustomerEmail(), customer.getPassword(), customer.getCustomerId(), customer.getCustomerAddress(),
				customer.getCustomerDOB(),customer.getRole()};
		
		//Create a variable of type int and set it to hold the value of number of rows added via the jdbc object
		int numOfRows = jdbcTemplate.update(slq, args);
		
		//SQL query to insert a customer into the security's user table in the database
		String sql2 = "insert into users(username, password) values(?,?)";
		
		//Retrieve and Store POJO attributes to a array list of type object due to the different variable types retrieved 
		Object[] args2 = {customer.getCustomerEmail(),customer.getPassword()};
		//Update the security's user table
		jdbcTemplate.update(sql2,args2);
		
		//SQL query to insert a customer into the security's authorities table in the database 
		String sql3 = "insert into authorities(username, authority) values(?,?)";
		
		//Retrieve and Store POJO attributes to a array list of type object due to the different variable types retrieved
		Object[]args3 = {customer.getCustomerEmail(), customer.getRole()};
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
	
	

	// Delete a customer from the database
	@Override
	public boolean deleteCustomer(String email) {
		//SQL query to delete a customer from the customer table  
		String sql = "DELETE FROM customer WHERE customerEmail = ?";
		
		//SQL query to delete a customer from the security's user table  
		String sql2 = "DELETE FROM users WHERE username = ?";
		
		//SQL query to delete a customer and their authority from the security's authorities table  
		String sql3 ="DELETE FROM authorities WHERE username = ?";
		
		//Update Authorities table first due to foreign key
		jdbcTemplate.update(sql3,email);
		
		//Create a variable of type int and set it to hold the value of number of rows deleted from the customer table via the jdbc object
		int numRowsDeleted = jdbcTemplate.update(sql, email);
		
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

	//Find a customer within the database
	@Override
	public Customer findCustomer(String email) {
		
		//SQL query to select all customer's from table matching the param
		String sql = "SELECT * FROM customer Where customerEmail = ?";
		
		//Set customer object to the result of the query and return it
		customer = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(),email);
			return customer;
	}
	
	
	
	//retrieve a list of all customers held within the database
	@Override
	public List<Customer> getAllCustomers(){
		
		//SQL query to get list of all customers within the tracks table in the database
		String sql = "SELECT * FROM customer";
		
		//Create list of the customer object instances within the database and return it
		List<Customer> customers = jdbcTemplate.query(sql, new CustomerRowMapper());
			return customers;
	}
	
}
