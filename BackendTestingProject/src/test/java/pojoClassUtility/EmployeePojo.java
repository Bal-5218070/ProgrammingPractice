package pojoClassUtility;

public class EmployeePojo {
	
	    public String designation;
	    public String dob;
	    public String email;
	    public String empName;
	    public double experience;
	    public String mobileNo;
	    public String project;
	    public String role;
	    public String username;
	    public EmployeePojo() {
	    	//it is required for deserialization
	    }
	    
		public EmployeePojo(String designation, String dob, String email, String empName, double experience,
				String mobileNo, String project, String role, String username) {
			super();
			this.designation = designation;
			this.dob = dob;
			this.email = email;
			this.empName = empName;
			this.experience = experience;
			this.mobileNo = mobileNo;
			this.project = project;
			this.role = role;
			this.username = username;
		}
		/**
		 * @return the designation
		 */
		public String getDesignation() {
			return designation;
		}
		/**
		 * @param designation the designation to set
		 */
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		/**
		 * @return the dob
		 */
		public String getDob() {
			return dob;
		}
		/**
		 * @param dob the dob to set
		 */
		public void setDob(String dob) {
			this.dob = dob;
		}
		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * @return the empName
		 */
		public String getEmpName() {
			return empName;
		}
		/**
		 * @param empName the empName to set
		 */
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		/**
		 * @return the experience
		 */
		public double getExperience() {
			return experience;
		}
		/**
		 * @param experience the experience to set
		 */
		public void setExperience(double experience) {
			this.experience = experience;
		}
		/**
		 * @return the mobileNo
		 */
		public String getMobileNo() {
			return mobileNo;
		}
		/**
		 * @param mobileNo the mobileNo to set
		 */
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		/**
		 * @return the project
		 */
		public String getProject() {
			return project;
		}
		/**
		 * @param project the project to set
		 */
		public void setProject(String project) {
			this.project = project;
		}
		/**
		 * @return the role
		 */
		public String getRole() {
			return role;
		}
		/**
		 * @param role the role to set
		 */
		public void setRole(String role) {
			this.role = role;
		}
		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}
	    
	    
	    
	    
	    
	}


