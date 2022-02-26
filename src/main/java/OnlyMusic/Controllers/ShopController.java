package OnlyMusic.Controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import OnlyMusic.DataTransferObjects.AdministratorDTO;
import OnlyMusic.DataTransferObjects.CustomerDTO;


//Controller class to handle requests which interact with the Shop POJO

@Controller
public class ShopController {
	
	//Inject CustomerDTO object
	@Autowired
	private CustomerDTO customerDTO;
	//Inject AdministratorDTO object
	@Autowired
	private AdministratorDTO adminDTO;
	
	//handler method to handle mapping request to home page
	@RequestMapping("/")
	public String getHome() {
		//return view
		return "index";
	}
	
	//handle method to handle mapping request to registration page
	@RequestMapping("registerPage")
	public String getRegisterPage(Model model) {
		//add customer data transfer object to the view to collect user details 
		model.addAttribute("customer", customerDTO);
		//return the view
		return "registerPage";
	}
	
	//handle method to handle mapping request to admins registration page
		@RequestMapping("adminRegisterPage")
		public String getAdminRegisterPage(Principal principal, Model model) {
			
			//Capture logged in username
			String username = principal.getName();
			//add logged in username as a model attribute 
			model.addAttribute("username", username);
			//add Administrator data transfer object to the view to collect user details
			model.addAttribute("administrator", adminDTO);
			//return the view
			return "adminRegistration";
		}
		
	
	//handler to handle mapping requests to login page
	@GetMapping("login")
	public String getLoginPage() {
		//Return the login view
		return "loginPage";
	}
	
	//Handler method to retrieve the user home page
	@RequestMapping("/userHome")
	public String getUserHome(Principal principal, Model model) {
		//Capture logged in username
		String username = principal.getName();
		//add logged in username as a model attribute 
		model.addAttribute("username", username);
		//return the view
		return "regUserHome";
	}
	
	//Handler method to retrieve the access denied notification page
	@GetMapping("/getAccessDenied")
	public String getAccessDeniedPage() {
		//return the view
		return "accessDenied";
	}
}
