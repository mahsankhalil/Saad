package com.mycompany.meven;

public class Employee {
	
	private String userName;
	private String passWord;
	//changed access level to String
	private String accessLevel;
	private String dob;
	private String firstName;
	private String lastName;
	private String managerEmail;
	private int id;
	
	public Employee(String userName, String passWord, String accessLevel, String dob, String firstName, String lastName,
			String managerEmail, int id) {
		
		this.userName = userName;
		this.passWord = passWord;
		this.accessLevel = accessLevel;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.managerEmail = managerEmail;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", passWord=" + passWord + ", accessLevel=" + accessLevel + ", dob="
				+ dob + ", firstName=" + firstName + ", lastName=" + lastName + ", managerEmail=" + managerEmail
				+ ", id=" + id + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(String userName, String passWord, String accessLevel, String dob, String firstName, String lastName,
			String managerEmail) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.accessLevel = accessLevel;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.managerEmail = managerEmail;
	}
	

}
