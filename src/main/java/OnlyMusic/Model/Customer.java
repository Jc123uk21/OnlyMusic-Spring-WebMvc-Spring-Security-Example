package OnlyMusic.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class Customer {
	/**
	 * variables to hold customer attributes
	 */
	private String customerEmail;
	private String password;
	private long customerId;
	private String customerAddress;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date customerDOB;
	private String role;
	ArrayList<Track>purchasedTracks = new ArrayList<>();
	
	/*
	 * Default Constructor
	 */
	public Customer() {
		this.customerId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}
	
	/**
	 * Parameterized Constructor
	 */
	public Customer(String anEmail, String aPassword, String anAddress, Date aDate) {
		this.customerEmail = anEmail;
		this.password = aPassword;
		this.customerAddress = anAddress;
		this.customerDOB = aDate;
		this.role = "customer";
		this.customerId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}

	/**
	 * Method to get the role attribute
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Method to set the role attribute
	 */
	public void setRole() {
		this.role = "customer";
	}

	/**
	 * Method to return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * Method to set the customerEmail 
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * Method to return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method to set the password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Method to return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * Method to set the customerId 
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * Method to set the customerId 
	 */
	public void setCustomerId() {
		this.customerId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}

	/**
	 * Method to return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * Method to set the customerAddress 
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * Method to return the customerDOB
	 */
	public Date getCustomerDOB() {
		return customerDOB;
	}

	/**
	 * Method to set the customerDOB 
	 */
	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}
	
	/**
	 * Method to get tracks form purchasedTrack list
	 */
	public ArrayList<Track> getOwnedTracks() {
		return purchasedTracks;
	}
	
	/**
	 * toString method, gets a string representation of the object
	 */
	@Override
	public String toString() {
		return "Customer [customerEmail=" + customerEmail + ", password=" + password + ", customerId=" + customerId
				+ ", customerAddress=" + customerAddress + ", customerDOB=" + customerDOB + ", role=" + role
				+ ", purchasedTracks=" + purchasedTracks + "]";
	}
	

	


}
