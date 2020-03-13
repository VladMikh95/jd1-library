package by.htp.library.bean;

public class User {
	
	private String login;
	
	private String password;
	
	private String name;
	
	private String role;
	
	public User() {
		
	}
	
	public User(String login, String password, String name, String role) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.role = role;
	}

	@Override
	public String toString() {
		return "login=" + login + ", password=" + password + ", name=" + name + ", role=" + role;
	}
	
	
}
