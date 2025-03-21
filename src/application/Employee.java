package application;

public abstract class Employee implements Payable {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;

	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		setFirstName(firstName);
		setLastName(lastName);
		setSocialSecurityNumber(socialSecurityNumber);
	}
	
	

	public String toString() {
		return getFirstName() + " " + getLastName() + "\n" + "social security number: " + getSocialSecurityNumber();

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

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

}