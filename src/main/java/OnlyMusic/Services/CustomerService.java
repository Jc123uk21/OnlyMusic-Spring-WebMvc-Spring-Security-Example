package OnlyMusic.Services;

import java.util.List;

import OnlyMusic.Model.Customer;

public interface CustomerService {
	//Add Customer object to database 
	public boolean addCustomer(Customer customer);
	//List all Customer objects in database
	public List<Customer> getAllCustomers();
	//Delete a Customer object from the database by Primary key
	public boolean deleteCustomerByEmail(String email);
	//Get customer object by primary key
	public Customer getCustomer(String email);
	
	

}
