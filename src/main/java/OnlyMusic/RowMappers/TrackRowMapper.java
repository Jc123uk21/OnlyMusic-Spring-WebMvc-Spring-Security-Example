package OnlyMusic.RowMappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import OnlyMusic.Model.Track;

/**
 * This Class is used by JDBC to map Track object attributes 
* */
public class TrackRowMapper implements RowMapper<Track>{

	@Override
	public Track mapRow(ResultSet rs, int rowNum) throws SQLException {
		// map rows of the track objects
		Track track = new Track();
		track.setTrackName(rs.getString("trackName"));
		track.setArtist(rs.getString("artist"));
		track.setReleaseDate(rs.getDate("releaseDate"));
		track.setTrackPrice(rs.getDouble("trackPrice"));
		track.setTrackId(rs.getLong("trackId"));
		track.setAudioFilePath(rs.getString("audioFilePath"));
		track.setDuration(rs.getDouble("duration"));
		
		return track;
	}

}
