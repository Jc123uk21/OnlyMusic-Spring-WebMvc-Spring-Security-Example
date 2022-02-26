package OnlyMusic.DAO;

import java.util.List;

import OnlyMusic.Model.Customer;

//Customer Data access object interface

public interface CustomerDao {
	
	//Insert Customer into database method
	public boolean insertCustomer(Customer customer);
	// Delete a customer from the database
	public boolean deleteCustomer(String email);
	//locate a customer within the database
	public Customer findCustomer(String email);
	//retrieve a list of all customers held within the database
	public List<Customer> getAllCustomers();


}
