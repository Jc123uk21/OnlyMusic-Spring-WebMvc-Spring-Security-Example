package OnlyMusic.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import OnlyMusic.DataTransferObjects.AdministratorDTO;
import OnlyMusic.Model.Administrator;
import OnlyMusic.Services.AdministratorService;


//Controller class to handle requests which interact with Administrator POJO tasks
@Controller
public class AdministratorController {
	
	//Inject administrator service object
	@Autowired
	AdministratorService adminService;
	
	//Inject administrator object
	@Autowired
	Administrator admin;
	
	//Inject passwordEncoder object
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Handler Method to handle add new a administrator requests from client using the administratorDTO (data transfer object)
	@RequestMapping(value = "addAdministrator", method = RequestMethod.POST)
	public String addAdministrator(AdministratorDTO adminDTO,  Principal principal, Model model) {
		
		//set administrator object attribute values to those collected by the AdministratorDTO (data transfer object), use password encoder to encode password
		admin.setName(adminDTO.getName());
		admin.autoSetAdminId();
		admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
		admin.setContactNumber(adminDTO.getContactNumber());
		admin.setContactEmail(adminDTO.getContactEmail());
		admin.setRole();
		
		//Capture logged in username
		String username = principal.getName();
				
		//Add logged in username to model
		model.addAttribute("username", username);
		
		/**
		 * Access the CustomerService objects method to save customer object into the database and 
		 * then redirect to login page if completed successfully or redirect to a error page if method fails to complete
		 */
		if(adminService.addAdministrator(admin) == true) {
			return "adminAdded";
		}
		else {
			return "unableToAddAdmin";
		}
	}
	
	//Handler Method to answer requests for displaying a list of all registered administrator users
	@RequestMapping(value = "/getAdministratorList", method = RequestMethod.GET)
	public String getAdministrators(Model model) {
		
		//create administrator list and populate with the administrator details held within the database
		List<Administrator> administratorList = adminService.getAllAdministrators();
		
		//set model attribute to administrator list
		model.addAttribute("administrators", administratorList);
		return "administrator-list";
		}
	
	
	//Handler method for deleting an administrator by email
	@RequestMapping(value = "/deleteAdministrator")
	public String deleteAdministrator(String email) {
		//Check whether the deletion completed correctly and then redirect to the appropriate page	
		if(adminService.deleteAdministratorByEmail(email) == true) {
			return "adminDeleted";
			}
		else {
				return "unableToDelete";
			}	
			
		}
		
	
	//Handler method to locate a administrator by email
	@RequestMapping(value = "/findAdministrator")
	public String findAdministrator(String email, Model model) {
		//Set admin bean attributes using the service layer to obtain attributes from the database
		admin =  adminService.getAdministrator(email);
		//Check admin object is not null and redirect to appropriate page
		if(admin != null) {
		//Add the administrator to the model to return to the view
		model.addAttribute("administrator", admin);
		return "findAdministrator";
		}
		else {
			return "adminNotFound";
		}
	}
	
	//Handler Method to return delete admin page
	@RequestMapping(value = "deleteAdminUser", method = RequestMethod.GET)
	public String deleteAdminUser(Principal principal, Model model) {
		
		//Capture and store logged in username
		String username = principal.getName();
		
		//Add logged in username as a model attribute to render in jsp
		model.addAttribute("username", username);
			
		return "deleteAdminUser";	
		}

	
}
