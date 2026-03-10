package gameProject;

import java.util.HashMap;

public class User implements IValidate {

	private String userid;
	private String password;

	public User() {
	}

	HashMap<String, String> u = new HashMap<>();

	void addUser(String userid, String password) {
		// - this method is used to initialize user.
		this.userid = userid;
		this.password = password;
		System.out.println("added successfully");
	}

	@Override
	public boolean isAuthenticated(String userId, String userPass) {
		return this.userid.equals(userId) && this.password.equals(userPass);
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "User [userid: " + userid + "]";
	}

}
