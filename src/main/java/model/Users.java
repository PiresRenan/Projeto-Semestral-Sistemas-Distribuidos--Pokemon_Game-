package model;

public class Users {
	private String name, email, password;
	private int age, type;
	
	public Users(String name, String email, String password, int age, int type) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", email=" + email + ", password=" + password + ", age=" + age + ", type=" + type
				+ "]";
	}
}
