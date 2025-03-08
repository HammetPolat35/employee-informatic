package application;



public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commisionRate;

	public double getGrossSales() {
		return grossSales;
	}

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commisionRate) {
		super(firstName, lastName, socialSecurityNumber);
		setGrossSales(grossSales);
		setCommisionRate(commisionRate);
	}

	public void setGrossSales(double grossSales) {
		if (grossSales >= 0) {
			this.grossSales = grossSales;
		} else {
			throw new IllegalArgumentException("grossSales");
		}
	}

	public String toString() {
		return "commission employee: " + super.toString() + " \n" + "gross sales: " + "$" + getGrossSales()
				+ " commision rate: " + getCommisionRate() + "\n" + "payment amount: " + "$" + getPaymentAmount();
	}

	public double getPaymentAmount() {
		return grossSales * commisionRate;
	}

	public double getCommisionRate() {
		return commisionRate;
	}

	public void setCommisionRate(double commisionRate) {
		if (commisionRate > 0 && commisionRate < 1) {
			this.commisionRate = commisionRate;
		} else {
			throw new IllegalArgumentException("commisionRate");
		}
	}
	
}
