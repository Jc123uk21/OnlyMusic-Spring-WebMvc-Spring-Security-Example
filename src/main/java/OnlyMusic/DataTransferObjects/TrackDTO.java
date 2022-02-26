package OnlyMusic.DataTransferObjects;

import java.sql.Date;
import java.util.UUID;



public class TrackDTO {
	
	//Class attribute variables
	private String trackName;
	private String artist;
	private Date releaseDate;
	private double trackPrice;
	private long trackId;
	private String audioFilePath;
	private double duration;
	
	
	/**
	 * Method to get the trackName attribute
	 */
	public String getTrackName() {
		return trackName;
	}
	/**
	 *  Method to set the trackName attribute
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
	 *  Method to set the artist attribute
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
	 *  Method to set the releaseDate attribute
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
	 *  Method to set the trackPrice attribute
	 */
	public void setTrackPrice(double trackPrice) {
		this.trackPrice = trackPrice;
	}
	
	/**
	 * Auto set trackId attribute to a random value
	 */
	public void autoSetTrackId() {
		trackId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}
	/**
	 * Method to get the trackId attribute
	 */
	public long getTrackId() {
		return trackId;
	}
	/**
	 *  Method to set the trackId attribute
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
	 *  Method to set the audioFilePath attribute
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
	 *  Method to set the duration attribute
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	/**
	 * toString method, gets a string representation of the object
	 */
	@Override
	public String toString() {
		return "TrackDTO [trackName=" + trackName + ", artist=" + artist + ", releaseDate=" + releaseDate
				+ ", trackPrice=" + trackPrice + ", trackId=" + trackId + ", audioFilePath=" + audioFilePath
				+ ", duration=" + duration + "]";
	}
	
	

}
