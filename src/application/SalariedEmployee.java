package application;

public class SalariedEmployee extends Employee {
	private double weekSalary;

	public double getWeekSalary() {
		return weekSalary;
	}

	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weekSalary) {
		super(firstName, lastName, socialSecurityNumber);
		setWeekSalary(weekSalary);
	}

	public String toString() {
		return "salaried employee: " + super.toString() + " \n" + "weekly salary: " + "$" + getWeekSalary() + " \n"
				+ "payment amount: " + "$" + getPaymentAmount();
	}

	public double getPaymentAmount() {
		return getWeekSalary();
	}

	public void setWeekSalary(double weekSalary) {
		if (weekSalary >= 0) {
			this.weekSalary = weekSalary;
		} else {
			throw new IllegalArgumentException("weeklySalary");
		}

	}

}
