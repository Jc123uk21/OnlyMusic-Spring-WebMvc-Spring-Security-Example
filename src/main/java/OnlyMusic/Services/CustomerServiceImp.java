package OnlyMusic.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import OnlyMusic.DAO.CustomerDao;
import OnlyMusic.Model.Customer;

@Service
public class CustomerServiceImp implements CustomerService {
	
	//Inject an CustomerDao object
	@Autowired
	CustomerDao customerDao;

	//Call the customerDoa objects method to add new customer to database
	@Override
	public boolean addCustomer(Customer customer) {
		return customerDao.insertCustomer(customer);
	}

	//Call the customerDoa objects method to get a list of customers held in the database
	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	//Call the customerDoa objects method to delete a customer from the database
	@Override
	public boolean deleteCustomerByEmail(String email) {
		return customerDao.deleteCustomer(email);
	}
	

	//Use the customerDoa objects method to find a customer within the database
	@Override
	public Customer getCustomer(String email) {
		
		return customerDao.findCustomer(email);
	}

}
