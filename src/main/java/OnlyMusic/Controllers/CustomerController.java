 package OnlyMusic.Controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import OnlyMusic.DataTransferObjects.CustomerDTO;
import OnlyMusic.Model.Customer;
import OnlyMusic.Services.CustomerService;


//Controller class to handle requests which interact with the Customer POJO
@Controller
public class CustomerController {
	
	//Inject CustomerDao object
	@Autowired	
	private CustomerService customerService;
	
	//Inject Customer object 
	@Autowired
	private Customer customer;
	
	//Inject passwordEncoder object
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Handler Method to handle add new a customer requests from client using the administratorDTO (data transfer object)
	@RequestMapping(value = "AddMember", method = RequestMethod.POST)
	public String addCustomer(CustomerDTO customerDTO, Principal principal, Model model) {
		
		//set customer object attribute values to those collected by the CustomerDTO (data transfer object), use password encoder to encode password 
		customer.setCustomerEmail(customerDTO.getEmail());
		customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
		customer.setCustomerAddress(customerDTO.getAddress());
		customer.setCustomerDOB(customerDTO.getDob());
		customer.setCustomerId();
		customer.setRole();
		
		
		//Capture logged in username
		String username = principal.getName();
		
		//Add logged in username to model
		model.addAttribute("username", username);
		
		/**
		 * Access the CustomerService objects method to save customer object into the database and 
		 * then redirect to login page if completed successfully or redirect to a error page if method fails to complete
		 */
		if(customerService.addCustomer(customer)==true) {
			return "loginPage";
		}
		else {
			return "unableToAddCustomer";
		}
	}
	
	//Handler method to list all customers in the view
	@RequestMapping(value = "/customerList", method = RequestMethod.GET)
	public String getCustomers(Principal principal,Model model) {
		
		//create customer list and populate from database
		List<Customer> customerList = customerService.getAllCustomers();
		
		//Capture logged in username
		String username = principal.getName();
		
		//add customer list as a model attribute 
		model.addAttribute("customers", customerList);
		
		//add logged in username as a model attribute 
		model.addAttribute("username", username);
		return "customer-list";
	}
	
	//Method to handle request for the delete customer page
	@RequestMapping(value = "DeleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(Principal principal, Model model) {
		
		//Cpature and store logged in username
		String username = principal.getName();
		
		//Add logged in username as a model attribute to render in jsp
		model.addAttribute("username", username);
		
		return "deleteCustomer";	
	}
	
	//handler method for submittted customer deletion requests
	@RequestMapping(value = "deleteCustomerDetails", method = RequestMethod.POST)
	public String deleteCustomerDetails(@RequestParam String email) {
		
		//Check whether the deletion completed correctly and then redirect to the appropriate page
		if(customerService.deleteCustomerByEmail(email) == true) {
			return "customerDeleted";
		}
		else {
			return "noCustomerFound";
		}
	}
	

	//Handler method to locate a customer by primary key,
	@RequestMapping(value = "findCustomer", method = RequestMethod.GET)
	public String findCustomer(Principal principal, Model model){
		
		//store logged in username
		String username = principal.getName();
		
		//add logged in username to model attribute
		model.addAttribute("username", username);
		return "findCustomer";
	}
	
	//Handler method to display located customer by primary key,
		@RequestMapping(value = "getCustomer", method = RequestMethod.POST)
		public String locateCustomer(Principal principal, @RequestParam String email, Model model ) {
			List<Customer>foundCustomer = new ArrayList<Customer>();
			//Create Customer object 
			Customer customer =  customerService.getCustomer(email);
			// add found customer to the list
			foundCustomer.add(customer);
			model.addAttribute("customers", foundCustomer);
			//Check if a customer has been located and redirect to the appropriate view page
			if(foundCustomer.size() > 0 && customer != null) {
			return "foundCustomer";
			}
			else {
				return "noCustomerFound";
			}
		}
	

}
