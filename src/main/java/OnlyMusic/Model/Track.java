package OnlyMusic.Model;

import java.sql.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;


public class Track {
	
	//Class attribute variables
	private String trackName;
	private String artist;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date releaseDate;
	private double trackPrice;
	private long trackId;
	private String audioFilePath;
	private double duration;

	
	
	/**
	 * Default Constructor
	 */
	public Track() {
		this.trackId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
;
	}



	/**
	 * Parameterized Constructor
	 */
	public Track(String trackName, String artist, Date releaseDate, double trackPrice, String audioFilePath,
			double duration) {
		super();
		this.trackName = trackName;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.trackPrice = trackPrice;
		this.audioFilePath = audioFilePath;
		this.duration = duration;
		this.trackId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}



	/**
	 * Method to get the trackName attribute
	 */
	public String getTrackName() {
		return trackName;
	}



	/**
	 * Method to set the trackName attribute
	 */
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}



	/**
	 * Method to get the artist attribute
	 */
	public String getArtist() {
		return artist;
	}



	/**
	 * Method to set the artist attribute
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}



	/**
	 * Method to get the releaseDate attribute
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}



	/**
	 * Method to set the releaseDate attribute
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	/**
	 * Method to get the trackPrice attribute
	 */
	public double getTrackPrice() {
		return trackPrice;
	}



	/**
	 * Method to set the trackPrice attribute
	 */
	public void setTrackPrice(double trackPrice) {
		this.trackPrice = trackPrice;
	}



	/**
	 * Method to get the trackId attribute
	 */
	public long getTrackId() {
		return trackId;
	}


	/**
	 * Auto set trackID 
	 */
	public void autoSetTrackID() {
		this.trackId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}

	/**
	 * Method to set the trackId attribute
	 */
	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}



	/**
	 * Method to get the audioFilePath attribute
	 */
	public String getAudioFilePath() {
		return audioFilePath;
	}



	/**
	 * Method to set the audioFilePath attribute
	 */
	public void setAudioFilePath(String audioFilePath) {
		this.audioFilePath = audioFilePath;
	}



	/**
	 * Method to get the duration attribute
	 */
	public double getDuration() {
		return duration;
	}



	/**
	 * Method to set the duration attribute
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}



	/**
	 * toString method, gets a string representation of the object
	 */
	@Override
	public String toString() {
		return "Track [trackName=" + trackName + ", artist=" + artist + ", releaseDate=" + releaseDate + ", trackPrice="
				+ trackPrice + ", trackId=" + trackId + ", audioFilePath=" + audioFilePath + ", duration=" + duration
				+ "]";
	}
	
	
	
	
	


	
	
	

}
