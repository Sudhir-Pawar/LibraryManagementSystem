package bean;

public class Admin{
	private String adminID, username, password;

	public Admin(String adminID, String username, String password) {
		super();
		this.adminID = adminID;
		this.username = username;
		this.password = password;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", username=" + username + ", password=" + password + "]";
	}
		
	
	
}