package application;

public class HourlyEmployee extends Employee {
	private double wage;
	private double hours;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);
		setWage(wage);
		setHours(hours);
	}

	public double getWage() {
		return wage;
	}

	public double getPaymentAmount() {
		return wage * hours;
	}

	public String toString() {
		return "hourly employee: " + super.toString() + "\n" + "hourly wage: " + "$" + wage + " hours worked: "
				+ getHours() + "\n" + "payment amount: " + "$" + getPaymentAmount();

	}

	public void setWage(double wage) {
		if (wage >= 0) {
			this.wage = wage;
		} else {
			throw new IllegalArgumentException("wage");
		}

	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		if (hours >= 0 && hours < 168) {
			this.hours = hours;
		} else {
			throw new IllegalArgumentException("hours");
		}
	}

}
