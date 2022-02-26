package OnlyMusic.DAO;

import java.util.List;
import OnlyMusic.Model.Track;

public interface TrackDao {
	
	//Data access object interface for track model class 
	
	//Insert Track into database method
		public boolean insertTrack(Track track);
		// Delete a track from the database by id
		public boolean deleteTrack(long trackId);
		//locate a track within the database by artist and track name
		public Track findTrack(String anArtist, String trackName);
		//retrieve a list of all tracks held within the database
		public List<Track> getAllTracks();

}
