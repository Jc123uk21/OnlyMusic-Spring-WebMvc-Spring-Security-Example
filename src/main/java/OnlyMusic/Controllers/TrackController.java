package OnlyMusic.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import OnlyMusic.DataTransferObjects.TrackDTO;
import OnlyMusic.Model.Track;
import OnlyMusic.Services.TrackService;

//Controller class to handle requests which interact with the Shop POJO

@Controller
public class TrackController {
		
	//Inject track service object
	@Autowired
	TrackService trackService;
		
	//Inject track object
	@Autowired
	Track track;
	
	//Handler method to answer add new track requests
	@RequestMapping(value = "addTrack", method = RequestMethod.POST)
	public String addNewTrack(TrackDTO trackDTO, Principal principal , Model model) {
		track.setTrackName(trackDTO.getTrackName());
		track.setArtist(trackDTO.getArtist());
		track.setReleaseDate(trackDTO.getReleaseDate());
		track.setTrackPrice(trackDTO.getTrackPrice());
		track.setAudioFilePath(trackDTO.getAudioFilePath());
		track.setDuration(trackDTO.getDuration());
		track.autoSetTrackID();
		
		//retrieve and store logged in username
		String username = principal.getName();
		
		//add logged in username to model attribute to pass to the view
		model.addAttribute("username", username);
		
		/**
		 * Access the TrackService objects method to save customer object into the database and 
		 * then redirect to login page if completed successfully or redirect to a error page if method fails to complete
		 */
		if(trackService.insertTrack(track) == true) {
			return "trackAdded";
		}
		else {
			return "unableToAddTrack";
		}
	}
	
	//Handler method  to show all tracks
	@RequestMapping(value = "/getTrackList", method = RequestMethod.GET)
	public String getTracks(Principal principal , Model model) {
		
		//create customer list and populate from database
		List<Track> trackList = trackService.getAllTracks();
		
		//get and store the logged in username in string
		String username = principal.getName();
		
		//add model attribute tracks list
		model.addAttribute("tracks", trackList);
		
		//add logged in username to model attribute to pass to the view
		model.addAttribute("username", username);
	
		return "ListOfTracksPage";
	}
	
	//handler method return the addTrack page
	@GetMapping("AddTrack")
	public String getAddTrackPage(Principal principal,Model model) {
		
		//create new data transfer object
		TrackDTO trackDTO = new TrackDTO();
		
		//store logged in username
		String username = principal.getName();
		
		//Add logged in username as model attribute to pass to view
		model.addAttribute("username", username);
		
		//add data transfer object to the model to pass to the view
		model.addAttribute("track", trackDTO);
		//return view
		return "addTrack";
	}
	
	//Method to delete track by primary key
		@RequestMapping(value = "deleteTrack", method = RequestMethod.GET)
		public String deleteCustomer(Principal principal, Model model) {
			//Capature and store logged in username
			String username = principal.getName();
			//Add logged in username as a model attribute to render in view
			model.addAttribute("username", username);
			
			return "deleteTrack";	
		}
		
		//handler method for submitted track deletion requests
		@RequestMapping(value = "DeleteTrack", method = RequestMethod.POST)
		public String deleteTrack(@RequestParam long trackId, Principal principal,Model model) {
			
			//Capature and store logged in username
			String username = principal.getName();
			//Add logged in username as a model attribute to render in the view
			model.addAttribute("username", username);
			/**
			 * Access the TrackService objects method to delete customer object from the database and 
			 * then redirect to deletion complete page if completed successfully or redirect to a error page if method fails to complete
			 */
			if(trackService.deleteTrack(trackId)==true) {
				return "trackDeleted";
			}
			else {
				return "unableToDelete";
			}
			
			
		}

}
