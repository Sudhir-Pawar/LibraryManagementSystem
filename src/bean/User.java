package bean;

public class User {
	private String userId, userName, department,year,division,contactNo;

	
	public User(String userId) {
		super();
		this.userId = userId;
	}

	public User(String userId, String userName, String department, String year, String division, String contactNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.department = department;
		this.year = year;
		this.division = division;
		this.contactNo = contactNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User [userId="+userId+" userName="+userName+" department="+department+" year="+year+" division="+division+" contactNo="+contactNo+"]";
	}
	
}
