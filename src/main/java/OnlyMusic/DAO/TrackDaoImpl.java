package OnlyMusic.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import OnlyMusic.Model.Track;
import OnlyMusic.RowMappers.TrackRowMapper;


@Repository("trackDao")
public class TrackDaoImpl implements TrackDao {
	
	//Inject a JDBC driver manager object
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
	//Inject Track object
		@Autowired
		private Track track;

	// Insert track into database	
	@Override
	public boolean insertTrack(Track track) {
		
		//SQL query to insert a track object into the tracks table in the database
		String slq = "insert into tracks(trackName, artist, releaseDate, trackPrice, trackId, audioFilePath, duration) values(?,?,?,?,?,?,?)";
		
		//Retrieve and Store POJO attributes to a array list of type object due to the different variable types retrieved 
		Object[] args = {track.getTrackName(), track.getArtist(), track.getReleaseDate(), track.getTrackPrice(),track.getTrackId(),
				track.getAudioFilePath(), track.getDuration()};
		//Create a variable of type int and set it to hold the value of number of rows added via the jdbc object
		int numRowsAdded = jdbcTemplate.update(slq, args);
		
		//Condition to return the outcome of whether a single row was added to the database table
		if(numRowsAdded == 1) {
			return true;
		}
		else {
			return false;
		}
		

	}

	// Delete track from database by track id
	@Override
	public boolean deleteTrack(long trackId) {
		
		//SQL query to delete a r=track from the tracks table  
		String sql = "DELETE FROM tracks WHERE trackId = ?";
		
		//Create a variable of type int and set it to hold the value of number of rows added via the jdbc object
		int numRowsDeleted = jdbcTemplate.update(sql, trackId);
		
		//Condition to return the outcome of whether a single row was deleted from the database table
		if(numRowsDeleted == 1) {
			return true;
			}
			else {
				return false;
			}
	}

	//Find a Track Method to locate a track by artist and track name within the database
	@Override
	public Track findTrack(String anArtist, String trackName) {
		
		//SQL query to find track by artist and track name within the database
		String sql = "SELECT * FROM tracks Where artist = ? AND trackName = ?";
		
		//Set track object to the result of the query and return it
		track = jdbcTemplate.queryForObject(sql, new TrackRowMapper(),anArtist, trackName);
			return track;	
	}

	//Method to retrieve a list of all users
	@Override
	public List<Track> getAllTracks() {
		//SQL query to get list of all tracks within the tracks table in the database
		String sql = "SELECT * FROM tracks";
		
		//Create list of the track object instances within the database
		List<Track> tracks = jdbcTemplate.query(sql, new TrackRowMapper());
		
		//return the list
		return tracks;
	}

}
