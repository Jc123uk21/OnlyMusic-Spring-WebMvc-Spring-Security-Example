package OnlyMusic.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import OnlyMusic.DAO.TrackDao;
import OnlyMusic.Model.Track;

public class TrackServiceImpl implements TrackService {
	
	//Inject an TrackDao object
	@Autowired
	private TrackDao trackDao;

	//Call the trackDoa object's method to add new track to database
	@Override
	public boolean insertTrack(Track track) {
		// insert track into database via DAO layer
		return trackDao.insertTrack(track);

	}

	//Call the trackDoa object's method to delete a track from the database
	@Override
	public boolean deleteTrack(long trackId) {
		return trackDao.deleteTrack(trackId);
	}

	//Use the trackDoa objects method to find a track within the database
	@Override
	public Track findTrack(String anArtist, String trackName) {
		// Locate track by artist and track name within the database via the DAO layer
		return trackDao.findTrack(anArtist, trackName);
	}

	//Call the customerDoa objects method to get a list of customers held in the database
	@Override
	public List<Track> getAllTracks() {
		return trackDao.getAllTracks();
	}

}
