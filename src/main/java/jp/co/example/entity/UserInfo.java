package jp.co.example.entity;

public class UserInfo {
	private String userId;
	private String pass;

	public UserInfo() {

	}

	public UserInfo(String userId,String pass) {
		this.userId = userId;
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
