package OnlyMusic.Model;

import java.util.UUID;

public class Administrator {
	//Attribute variables for an administrator
		private String name;
		private long adminId;
		private String password;
		private long contactNumber;
		private String contactEmail;
		private String role;
		
		//Default constructor
		public Administrator() {
			this.adminId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		}
		
		

		/**
		 * Parameterized Constructor
		 */
		public Administrator(String name, String password, long contactNumber, String contactEmail,
				String role) {
			super();
			this.name = name;
			this.adminId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
			this.password = password;
			this.contactNumber = contactNumber;
			this.contactEmail = contactEmail;
			this.role = "admin";
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
			this.role = "admin";
		}



		/**
		 * Method to get the name attribute
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
		 * Automatically set an adminId
		 */
		public void autoSetAdminId() {
			this.adminId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;;
		}
		/**
		 * Method to get the adminId attribute
		 */
		public long getAdminId() {
			return adminId;
		}

		/**
		 * Method to set the adminId attribute
		 */
		public void setAdminId(long adminId) {
			this.adminId = adminId;
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
		 * Method to get the contactNumeber attribute
		 */
		public long getContactNumber() {
			return contactNumber;
		}

		/**
		 * Method to set the contactNumebr attribute
		 */
		public void setContactNumber(long contactNumber) {
			this.contactNumber = contactNumber;
		}

		/**
		 * Method to get the contactEmail attribute
		 */
		public String getContactEmail() {
			return contactEmail;
		}

		/**
		 * Method to set the contactEmail attribute
		 */
		public void setContactEmail(String contactEmail) {
			this.contactEmail = contactEmail;
		}


		/**
		 * toString method, gets a string representation of the object
		 */
		@Override
		public String toString() {
			return "Administrator [name=" + name + ", adminId=" + adminId + ", password=" + password
					+ ", contactNumber=" + contactNumber + ", contactEmail=" + contactEmail + ", role=" + role + "]";
		}

		
		

}
