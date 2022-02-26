package OnlyMusic.DataTransferObjects;

import java.sql.Date;
import java.util.UUID;

public class CustomerDTO {
	/**
	 * variables to hold customer attributes
	 */
	private String email;
	private String password;
	private long id;
	private String address;
	private Date dob;
	private String role;
	
	
	
	/**
	 * Method to get the role attribute
	 */
	public String getRole() {
		return role;
	}
	/**
	 * Method to set the role attribute
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * Method to get the email attribute
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
	 * Method to get the password attribute
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Method to set the password attribute
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Method to get the id attribute
	 */
	public long getId() {
		return id;
	}
	/**
	 * Method to set the id attribute
	 */
	public void setId() {
		this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}
	/**
	 * Method to get the address attribute
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Method to set the address attribute
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Method to get the dob attribute
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * Method to set the dob attribute
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/**
	 * toString method, gets a string representation of the object
	 */
	@Override
	public String toString() {
		return "CustomerDTO [email=" + email + ", password=" + password + ", id=" + id + ", address=" + address
				+ ", dob=" + dob + "]";
	}
	
	

}
