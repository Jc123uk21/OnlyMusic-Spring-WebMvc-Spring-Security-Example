package OnlyMusic.Model;

import java.util.HashMap;
import java.util.UUID;

public class Shop {
	//Shop attribute variables
	private long storeId;
	private String name;
	private String email;
	private HashMap<Track, Customer> sales = new HashMap<Track, Customer>();
	
	/**
	 * Default constructor
	 */
	public Shop() {
		this.storeId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}

	/**
	 * Parameterized Constructor
	 */
	public Shop(String name, String email) {
		super();
		this.storeId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		this.name = name;
		this.email = email;
		
	}

	/**
	 * Method to get the storeId attribute
	 */
	public long getStoreId() {
		return storeId;
	}

	/**
	 * Method to set the storeId attribute
	 */
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	/**
	 *  Method to get the name attribute
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the name attribute
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  Method to get the email attribute
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method to set the email attribute
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Method to add track sale to the sales list
	 */	
	public void addSale(Track aTrack, Customer customer) {
		
	}

	/**
	 * toString method, gets a string representation of the object
	 */
	@Override
	public String toString() {
		return "Shop [storeId=" + storeId + ", name=" + name + ", email=" + email + ", sales="
				+ sales + "]";
	}
	
	

}
